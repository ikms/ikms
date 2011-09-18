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
/**
 * 跳转到指定页面
 * @param uri
 */
function toURI(uri){
	window.location.href=uri;
};
/**
 * 进入Method页面
 * @param uri
 * @param model
 * @param id
 */
function toMethod(uri,model,method){
	window.location.href=uri+"/"+model+"/"+method+".html";
};
/**
 * 查看详细信息
 * @param uri
 * @param model
 * @param id
 */
function toView(uri,model,id){
	window.location.href=uri+"/"+model+"/toView/"+id+".html";
};
/**
 * 进入编辑信息页面
 * @param uri
 * @param model
 * @param id
 */
function toEdit(uri,model,id){
	window.location.href=uri+"/"+model+"/toEdit/"+id+".html";
};
/**
 * 删除信息
 * @param uri
 * @param model
 * @param id
 */
function toDelete(uri,model,id){
	window.location.href=uri+"/"+model+"/toDelete/"+id+".html";
};