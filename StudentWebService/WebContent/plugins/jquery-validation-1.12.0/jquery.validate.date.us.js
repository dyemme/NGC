/**
  * Additional validation code for jquery validate
  * 
  * Return true, if the value is a valid US date, also making this formal check mm/dd/yyyy.
  *
  * Usage in rules
  * rules:{myDate:"dateUS"}
  *
  * @example jQuery.validator.methods.date("01/01/1900")
  * @result true
  *
  * @example jQuery.validator.methods.date("13/01/1990")
  * @result false
  *
  * @example jQuery.validator.methods.date("01.01.1900")
  * @result false
  *
  * @example <input name="pippo" class="dateUS" />
  * @desc Declares an optional input element whose value must be a valid date.
  *
  * @name jQuery.validator.methods.dateUS
  * @type Boolean
  * @cat Plugins/Validate/Methods
  *
  * Attribution: http://christierney.com/2011/06/30/jquery-validate-better-date-method/
  */
 
jQuery.validator.addMethod(
    "dateUS",
    function(value, element) {
        var check = false;
        var re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
        if( re.test(value)){
            var adata = value.split('/');
            var mm = parseInt(adata[0],10);
            var dd = parseInt(adata[1],10);
            var yyyy = parseInt(adata[2],10);
            var xdata = new Date(yyyy,mm-1,dd);
            if ( ( xdata.getFullYear() == yyyy ) && ( xdata.getMonth () == mm - 1 ) && ( xdata.getDate() == dd ) )
                check = true;
            else
                check = false;
        } else
            check = false;
        return this.optional(element) || check;
    },
    "Please enter a date in the format mm/dd/yyyy"
);

/**
  * Additional validation code for jquery validate
  * 
  * Return true, if the value is a valid 24 hour time
  *
  * Usage in rules
  * rules:{myDateTime:"time24"}
  *
  */
jQuery.validator.addMethod(
	"time24",
	function (value, element) {
		return this.optional(element) || /^(([0-1]?[0-9])|([2][0-3])):([0-5]?[0-9])(:([0-5]?[0-9]))?$/i.test(value);
	}, "Please enter a valid time.");