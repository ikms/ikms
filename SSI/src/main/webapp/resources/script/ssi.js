/**
 * 隐藏与显示切换
 * 
 * @param Id
 */
function cssDisplay(Id) {
	var typeId = $("#" + Id);
	var display = typeId.css("display");
	if (display == "block" || display == "") {
		typeId.css("display", "none");
	} else {
		typeId.css("display", "block");
	}
};
function toURI(uri){
	window.location.href=uri;
};