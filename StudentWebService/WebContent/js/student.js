var urlParam='http://localhost:9131/StudentWebService/StudentWebService?wsdl'; 
var namespaceURLParam = 'http://service.student.demo.com/';
$(document).ready(function(){
	;
});
function soapGetStudentByName(){
	document.studentPortal.finalResult.value = "";
	var studentName = document.studentPortal.studentName.value;	
$.soap({
    url: urlParam,
    method: 'getStudentByName',       
    data: {
        studentName: studentName        
    },    
    success: function (soapResponse) {       
    	var responseXml = soapResponse.toString();
    	$(responseXml)
        .find('students')
        .each(function(){	            
           var temp = [$(this).find('firstName').text(),$(this).find('lastName').text(),$(this).find('middleName').text(),$(this).find('studentID').text()];
           document.studentPortal.finalResult.value += temp +'\n';     
        });    	
    },
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});

}

function soapGetByUserId(){       
	document.studentPortal.finalResult.value = "";
	var studentIDParam = document.studentPortal.studentId.value;
	$.soap({
	    url: urlParam,
	    method: 'getStudent',       
	    data: {
	        studentID: studentIDParam        
	    },    
	    success: function (soapResponse) {	       
	    	var responseXml = soapResponse.toString();
	    	$(responseXml)
	        .find('Student')
	        .each(function(){	            
	            document.studentPortal.firstName.value =$(this).find('firstName').text();
	         	document.studentPortal.lastName.value = $(this).find('lastName').text();
	         	document.studentPortal.middleName.value = $(this).find('middleName').text();
	         	document.studentPortal.studentID.value = $(this).find('studentID').text();
	        });
	    },
	    namespaceURL: namespaceURLParam,
	    error: function (SOAPResponse) {
	        // show error
	    }
	});
}
function soapDeleteByUserId(){        			
	document.studentPortal.finalResult.value = "";
 	var studentIDParam = document.studentPortal.studentId.value;
 	$.soap({
	    url: urlParam,
	    method: 'deleteStudent',       
	    data: {
	        studentID: studentIDParam        
	    },    
	    success: function (soapResponse) {	       
	    	var responseXml = soapResponse.toString();
	    	// document.studentPortal.finalResult.value = responseXml;
	    	$(responseXml)        
	        .each(function(){	            
	        	document.studentPortal.finalResult.value =$(this).find('result').text();	         	
	        });
	    },
	    namespaceURL: namespaceURLParam,
	    error: function (SOAPResponse) {
	        // show error
	    }
	});
}
function addSoapStudent(){
	document.studentPortal.finalResult.value = "";
	var firstNameParam = document.studentPortal.firstName.value;
 	var lastNameParam = document.studentPortal.lastName.value;
 	var middleNameParam = document.studentPortal.middleName.value; 	
$.soap({
    url: urlParam,
    method: 'addStudentToDB',       
    data: {  
    	 studentFName:firstNameParam , studentLName:lastNameParam, studentMName:middleNameParam               
    },    
    success: function (soapResponse) {
    	var responseXml = soapResponse.toString();
    	// document.studentPortal.finalResult.value = responseXml;
    	$(responseXml)        
        .each(function(){	            
        	document.studentPortal.finalResult.value =$(this).find('result').text();	         	
        });
    },
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});
}
function updateStudent(){
	document.studentPortal.finalResult.value = "";
	var firstNameParam = document.studentPortal.firstName.value;
 	var lastNameParam = document.studentPortal.lastName.value;
 	var middleNameParam = document.studentPortal.middleName.value; 
 	var studentIDParam = document.studentPortal.studentID.value; 
$.soap({
    url: urlParam,
    method: 'updateStudent',       
    data: {  
    	 studentFName:firstNameParam , studentLName:lastNameParam, studentMName:middleNameParam,studentID:studentIDParam              
    },    
    success: function (soapResponse) {
    	var responseXml = soapResponse.toString();
    	// document.studentPortal.finalResult.value = responseXml;
    	$(responseXml)        
        .each(function(){	            
        	document.studentPortal.finalResult.value =$(this).find('result').text();	         	
        });
    },
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});
}
