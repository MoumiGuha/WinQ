/*

JavaScript: Things to keep in mind:
    1. Event-based actions
    2. functions
    3. data
*/

var qdata;
var score=0;
const positiveMarks=5;
const negativeMarks=-1;

//This function will get triggered when the document (or the DOM) is ready.
$(document).ready(function () {

    //Get list of subjects
    getAllSubjects();

    

    //After clicking playQuiz button, I am posting request to generate quiz
    $('.playQuiz').click(function () {
        generateQuiz();
    });

    //After clicking beginTest button, I am posting request to get quiz
    $('.beginTest').click(function () {
        var qid = fetchParamFromUrl();
        window.location = 'quiz.html?id=' + qid;
    });
    
    getQuiz();
    
    
    var pos = 1;
    $('#next input').click(function(){  
        checkOption();
        console.log(score);
        displayNextQuestion(pos);
            pos++;
    });
    
    $('.finishTest input').click(function() {
        window.location = 'score.html?score=' + score;
        
    });
    
    displayScore();
});

function displayScore() {
    var score = fetchParamFromUrl();
    var disScore = `${score}`
    $('.score').html(disScore);
}

function checkOption() {
    var option = $('.options input:checked').attr('data-correct');
    
    if(option == undefined) {
        //Nothing will happen
    }
    else if(option=="true") {
        score += positiveMarks;
    }else if(option=="false")
        score += negativeMarks;
}

function fetchParamFromUrl() {
    var s = location.href;
    return s.substring(s.indexOf("=") + 1);
}

function getQuiz() {

    var quizId = fetchParamFromUrl();

    var url = 'http://localhost:8080/quiz?id=' + quizId;

    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            console.log(data);
            qdata = data;
            
            displayNextQuestion(0);
            
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function displayNextQuestion(index) {
    
    if(qdata.questionResponses[index] == undefined) {
        $('#next input').hide();
        return;
    }
    
    var question = qdata.questionResponses[index].question;

    //Displaying questions to html
    $('.Q').html(question);

    var optionList = qdata.questionResponses[index].optionResponses;

    $('.options').empty();
    //Displaying options to html
    $.each(optionList, function (i, option) {

        var opt = `<input type="radio" name="optionradio" value="${option.id}" data-correct="${option.isCorrect}">  ${option.value}<br><br>`;

        $('.options').append(opt);
        /*console.log(opt);*/
    });
}

function generateQuiz() {

    var url = 'http://localhost:8080/quiz';

    var name = makeQuizName();
    var subjectIdList = getcheckedSubjectIds();

    var requestData = {
        name: name,
        subjectIds: subjectIdList
    }

    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(requestData),
        success: function (data) {
            console.log(data);
            window.location = 'instruction.html?id=' + data.id;
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function getcheckedSubjectIds() {

    var checkedSubjectIdList = [];

    $.each($('.subjects input:checked'), function (i, data) {
        checkedSubjectIdList.push(data.value);
    });

    return checkedSubjectIdList;
}

function getAllSubjects() {

    //AJAX Call to Get data from backend.

    // $.ajax({key : value, key : value, key : value, key : value, key : value});
    var url = "http://localhost:8080/subject/all";

    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            /*console.log(data);*/

            for (var i = 0; i < data.length; i++) {
                var subjects = `<div class = "subject"><input type="checkbox" name="${data[i].name}" value="${data[i].id}"><span>${data[i].name}</span></div>`;

                $('.subjects').append(subjects);

                /*console.log(subjects);*/
            }

        },
        error: function (data) {
            console.log(data);
        }
    });

}

function postRequestExample() {

    //Create User Example
    var url = "http://localhost:7000/users/greet";

    var requestData = {
        name: "Vivek",
        email: "abc@def.com",
        password: "1234"
    };

    $.ajax({
        url: url,
        type: 'POST',
        data: requestData,
        success: function (data) {

        },
        error: function (data) {

        }
    });

}

function makeQuizName() {
    var text = "quiz-";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for (var i = 0; i < 5; i++) {

        var index = Math.floor(Math.random() * possible.length);
        text += possible.charAt(index);
    }
    return text;
}
