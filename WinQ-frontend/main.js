/*

JavaScript: Things to keep in mind:
    1. Event-based actions
    2. functions
    3. data
*/

//This function will get triggered when the document (or the DOM) is ready.
$(document).ready(function () {

    //Get list of subjects
    var subjectList = getAllSubjects();
    populateSubjectsOnPage(subjectList);
    //I am using jQuery very heavily... So please excuse me. You can google for javascript alternatives for jQuery code.
    
    //On button click, go to another page
    $('.playQuiz input').click(function(){
        
        window.location = 'instruction.html';
    });
});



function getAllSubjects() {

    //AJAX Call to Get data from backend.

    // $.ajax({key : value, key : value, key : value, key : value, key : value});
    var url = "https://uat-api.synapsefi.com/v3.1/institutions";
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            console.log(data);

            for (var i = 0; i <= 4; i++) {
                var bankCheckbox = '<div class = "subjects"><input type="checkbox" name="' + data.banks[i].bank_name + '" value="' + data.banks[i].bank_name + '"><span>' + data.banks[i].bank_name + '</span></div>';
                
                $('.options').append(bankCheckbox);
                
                console.log(bankCheckbox);
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

function populateSubjectsOnPage(subjectList) {


}
