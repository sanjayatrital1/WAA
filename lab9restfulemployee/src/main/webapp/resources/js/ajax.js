$(document).ready(function() {
    $('#submitbtn').click(function (event) {
        event.preventDefault();

        var sendToSend = JSON.stringify($('#employeeForm').serializeFormJSON());

        $.ajax({
            url:'http://localhost:8080/add',
            type: 'POST',
            data:sendToSend,
            contentType: 'application/json',   // Sends
            dataType: "json",           // Accepts
            success: function(employee){
                $('#formInput').html("");
                $("#formInput").append( '<H3 align="center"> New Employee Information <H3>');
                $('#formInput').append("<H4 align='center'>First Name:  " + employee.firstName + "</h4>"  );
                $('#formInput').append("<H4 align='center'>Last Name: " + employee.lastName  + "</h4>" );
                $('#formInput').append("<H4 align='center'>Email: " + employee.email  + "</h4>");
                $("#formInput").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
                $('#formInput').show();
                $('#errors').hide();
            },

            error: function(XMLHttpRequest,  textStatus,  exception ){

                if (XMLHttpRequest.responseJSON.errorType == "ValidationError") {

                    var errorList = XMLHttpRequest.responseJSON.fieldErrors;
                    let errorMsg = "<p>";
                    $.each(errorList,  function(i,error) {
                        errorMsg = errorMsg+error.message;
                    });
                    errorMsg+= "</p>"
                    $('#errors').append(errorMsg);
                }
                else {
                    alert(XMLHttpRequest.responseJSON.message);
                }
            }

        });
    });

});

toggle_visibility = function(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block')
        e.style.display = 'none';
    else
        e.style.display = 'block';
}

make_hidden = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'none';
}

make_visible = function(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
}

resetForm = function(id) {
    var e = document.getElementById(id);
    $(e)[0].reset();

}

// Translate form to array
// Then put in JSON format
function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
        jsonObject[this.name] = this.value;
    });
    return jsonObject;

};