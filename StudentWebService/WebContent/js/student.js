$(document).ready(function(){
	;
});
function getByUserId(){        		
	var url="http://localhost:9131/StudentWebService/StudentWebService"; 
 	var studentID = document.studentPortal.studentId.value;
	 	var pl = new SOAPClientParameters();
	 	pl.add("studentID", studentID);
	SOAPClient.invoke(url, "getStudent", pl, true, getStudent_callBack);
}
function getStudent_callBack(student)
{
    if(student == null)
        alert("No user found.\r\n\r\nEnter a userID and repeat search.");
    else
      {
    	document.studentPortal.finalResult.value = JSON.stringify(student);      
      }
} 
function getByUserName(){        		
	var url="http://localhost:9131/StudentWebService/StudentWebService"; 
 	var studentName = document.studentPortal.studentName.value;
	 	var pl = new SOAPClientParameters();
	 	pl.add("studentName", studentName);
	SOAPClient.invoke(url, "getStudentByName", pl, true, getStudentByName_callBack);
}
function getStudentByName_callBack(students)
{	
	console.log(students);					   
    if(students == null)
        alert("No user found.\r\n\r\nEnter a username and repeat search.");
    else
      {
      	document.studentPortal.finalResult.value = JSON.stringify(students);
      }
}
function deleteByUserId(){        		
	var url="http://localhost:9131/StudentWebService/StudentWebService"; 
 	var studentID = document.studentPortal.studentId.value;
	 	var pl = new SOAPClientParameters();	 	
	 	pl.add("studentID", studentID);
	SOAPClient.invoke(url, "deleteStudent", pl, true, deleteStudent_callBack);
}
function deleteStudent_callBack(result)
{
    if(result == null)
        alert("No user found.\r\n\r\nEnter a userID and repeat search.");
    else
      {
    	document.studentPortal.finalResult.value = JSON.stringify(result);      
      }
} 
function addStudent(){        		
	var url="http://localhost:9131/StudentWebService/StudentWebService"; 
 	var firstName = document.studentPortal.firstName.value;
 	var lastName = document.studentPortal.lastName.value;
 	var middleName = document.studentPortal.middleName.value;
 	alert(firstName+middleName+lastName);
	 	var pl = new SOAPClientParameters();
	 	var Student = {"studentId":"", "firstName":firstName , "lastName":lastName, "middleName":middleName  };
	 	pl.add("student", Student);
	SOAPClient.invoke(url, "addStudent", pl, true, addStudent_callBack);
}
function addStudent_callBack(result)
{
    if(result == null)
        alert("No user found.\r\n\r\nEnter a userID and repeat search.");
    else
      {
    	document.studentPortal.finalResult.value = JSON.stringify(result);      
      }
} 



function soap() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open('POST', 'https://somesoapurl.com/', true);

    // build SOAP request
    var sr =
        '<?xml version="1.0" encoding="utf-8"?>' +
        '<soapenv:Envelope ' + 
            'xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" ' +
            'xmlns:api="http://127.0.0.1/Integrics/Enswitch/API" ' +
            'xmlns:xsd="http://www.w3.org/2001/XMLSchema" ' +
            'xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">' +
            '<soapenv:Body>' +
                '<api:some_api_call soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">' +
                    '<student_id xsi:type="xsd:string">login_username</student_id>' +
                    '<first_name xsi:type="xsd:string">password</first_name>' +
                '</api:some_api_call>' +
            '</soapenv:Body>' +
        '</soapenv:Envelope>';

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4) {
            if (xmlhttp.status == 200) {

                alert('done use firebug to see response');
            }
        }
    }
    // Send the POST request
    xmlhttp.setRequestHeader('Content-Type', 'text/xml');
    xmlhttp.send(sr);
    // send request
    // ...
}
    