var urlParam='http://localhost:9131/StudentWebService/StudentWebService?wsdl'; 
var namespaceURLParam = 'http://service.student.demo.com/';
$(document).ready(function(){
	$("#st_xErrMsg").click(function(){
		st_dismissErrMsg();
	});	
	$("#st_xScsMsg").click(function(){
		st_dismissScsMsg();
	});	
});
/**
 * Dismisses the error message.
 */
function st_dismissErrMsg() {	
	$("#st_errBdy").html("");
	$("#st_errMsg").css("display","none");	
}
/**
 * Dismisses the success message.
 */
function st_dismissScsMsg() {
	resetFormFields();
	$("#st_scsBdy").html("");
	$("#st_scsMsg").css("display","none");	
}
/**
 * Displays success information.
 *
 * @param msg - a message describing success
 */
function st_displayScsMsg(msg) {
	$("#st_scsBdy").html(msg);
	$("#st_scsMsg").css("display","block");
}
function resetFormFields(){
	clearEditFormFields();
	cleanAddFormfields();
}
/**
 * Reset the form fields 
 * 
 */
function clearEditFormFields(){
	document.studentPortal.firstName.value ="";
 	document.studentPortal.lastName.value = "";
 	document.studentPortal.middleName.value = "";
 	document.studentPortal.studentID.value = "";
}
function cleanAddFormfields(){
	 document.studentPortalAdd.firstName.value="";
	 document.studentPortalAdd.lastName.value="";
	 document.studentPortalAdd.middleName.value="";
}
function soapGetStudentByName(){
	clearEditFormFields();
	var studentName = document.studentPortal.studentName.value;	
	// clear student list
	while(document.studentPortal.studentList.options.length > 0){
		document.studentPortal.studentList.remove(0);
	}
	var o = document.createElement("OPTION");
	document.studentPortal.studentList.options.add(o);
    o.value = 0;
    o.innerHTML = "--Please select student--";
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
        	var temp = [$(this).find('studentID').text()+": "+$(this).find('firstName').text()+" "+$(this).find('middleName').text()+" "+$(this).find('lastName').text()];
        	var o = document.createElement("OPTION");
        	document.studentPortal.studentList.options.add(o);
            o.value = $(this).find('studentID').text();
            o.innerHTML = temp;
             
        });    	
    },    
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});
}
function soapGetByUserValue(valueIn){
	clearEditFormFields();
	$.soap({
	    url: urlParam,
	    method: 'getStudent',       
	    data: {
	        studentID: valueIn        
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
function selectStudent(sel){
	var value = sel.value;	
	soapGetByUserValue(value)
}
function soapGetByUserId(){
	clearEditFormFields();
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
 	var studentIDParam = document.studentPortal.studentID.value;
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
	        	st_displayScsMsg($(this).find('result').text());
	        });
	    },
	    namespaceURL: namespaceURLParam,
	    error: function (SOAPResponse) {
	        // show error
	    }
	});
}
function addSoapStudent(){	
	var firstNameParam = document.studentPortalAdd.firstName.value;
 	var lastNameParam = document.studentPortalAdd.lastName.value;
 	var middleNameParam = document.studentPortalAdd.middleName.value; 	
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
        	
        	st_displayScsMsg($(this).find('result').text());
        });
    },
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});
}
function updateStudent(){	
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
        	st_displayScsMsg($(this).find('result').text());
        });
    },
    namespaceURL: namespaceURLParam,
    error: function (SOAPResponse) {
        // show error
    }
});
}