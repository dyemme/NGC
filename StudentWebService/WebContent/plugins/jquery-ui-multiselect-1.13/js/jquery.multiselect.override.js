/** Constants for all selected or none selected. */
var SELECT_ALL = "all";
var SELECT_NONE = "none";

/**
 * The function sets the display text for the state multi-select control.
 * 
 * @param numChecked number of checked elements
 * @param numTotal total elements
 * @param checkedItems all checked elements
 * @param fullNameCount number of states to show full state names
 * @param abbrvCount number of states to show abbreviation. 
 * @returns a string
 */
function setStateSelectedText(numChecked, numTotal, checkedItems, fullNameCount, abbrvCount) {
	if (numChecked > abbrvCount) {
		return numChecked + " selected";
	}
	var text = "";
	if (numChecked > fullNameCount) {
		for (var i = 0; i< numChecked; i++) {
			text += checkedItems[i].value + ", ";					
		}
	} 
	else{
		for (var i = 0; i< numChecked; i++) {
			text += checkedItems[i].getAttribute("title") + ", ";
		}
	}	
	return text.substr(0, text.length - 2);
}

/**
* The function sets the display text for the planning zone multi-select control.
* 
* @param numChecked number of checked elements
* @param numTotal total elements
* @param checkedItems all checked elements
* @param fullNameCount number of states to show full planning zone names
* @returns a string
*/
function setPlanningZoneSelectedText(numChecked, numTotal, checkedItems, fullNameCount) {
	if (numChecked > fullNameCount) {
		return numChecked + " selected";
	}
	var text = "";
	for (var i = 0; i< numChecked; i++) {
		text += checkedItems[i].getAttribute("title") + ", ";
	}
	return text.substr(0, text.length - 2);
}

/**
 * This function splits a <UL>/<LI> control into multiple columns.
 * 
 * @param widget the <UL>/<LI> control. 
 * @param column number of columns
 */
function setSelectWidgetColumn(widget, column) {
	widget.css({"-moz-column-count": column, "column-count": column});
	widget.attr('style', widget.attr('style') + '; ' + '-webkit-column-count:' + column + ' !important');	
}

/**
 * This method populates a multi-select control.
 * 
 * @param selectControlID ID of the multi-select control.
 * @param values values to set
 * @param addOption a boolean, true to add the option, and false otherwise.  Use this for dynamically created options.
 */
function setMultiSelectValues(selectControlID, values, addOption) {
	$(selectControlID).multiselect("uncheckAll");
	if (values != null && values.length >= 0 && values[0] != SELECT_NONE) {
		if (values[0] == SELECT_ALL) {
			$(selectControlID).multiselect("checkAll");
		}
		else {			
			if (addOption) {
				for (var i = 0; i< values.length; i++) {
					var data = values[i].split("|");
					var opt = $('<option />', {
						value: data[0],
						text: data[1]
					});
					opt.attr('title', data[1]);
					opt.attr('selected','selected');
					opt.appendTo($(selectControlID));
				}
			}
			else {
				$(selectControlID).val(values);
			}			
		}
	}
	$(selectControlID).multiselect("refresh");
}