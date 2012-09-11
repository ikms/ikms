document.writeln("<script src=\"common\/base64.js\" ><\/script>\n");
/**
 * Base64加密
 */
function base64Encode(str){
	return Base64.encode(str);
}
/**
 * Base64解密
 */
function base64Decode(str){
	return Base64.decode(str);
}