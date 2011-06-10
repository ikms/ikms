/**
 * @(#)HtmlUtils.java
 */
package net.sf.immc.util.html;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2009/12/22
 */
public class HtmlUtils {

    /**
     * 适合于 HTML 中的表单区域，非TextArea控件 将字符串格式化成HTML代码，只转换特殊字符
     * 
     * @param str
     *            要格式化的字符串
     * @return 格式化后的字符串
     */
    public static String toHtmlInput(String str) {
        if (str == null)
            return "";
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        str = str.replaceAll("\r", "");
        str = str.replaceAll("\n", "");
        return str;
    }

    /**
     * 适合于 HTML 中的表单区域，TextArea控件
     * 
     * @param str
     *            要格式化的字符串
     * @return 格式化后的字符串
     */
    public static String toTextareaInput(String str) {
        if (str == null)
            return "";
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        return str;
    }

    /**
     * 将字符串格式化成HTML代码输出,适合于 HTML 中的显示输出 除普通特殊字符外，还对空格、制表符和换行进行转换
     * 
     * @param str
     *            要格式化的字符串
     * @return 格式化后的字符串
     */
    public static String toHtml(String str) {
        if (str == null)
            return "";
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        str = str.replaceAll("\r\n", "\n");
        str = str.replaceAll("\n", "<br/>");
        str = str.replaceAll("\t", " &nbsp;&nbsp;&nbsp;");
        str = str.replaceAll("  ", " &nbsp;");
        return str;
    }
    
    /**
     * 将字符串中的\n字符格式化为HTML代码Br标签
     * 
     * @param str
     * 		要格式化的字符串
     * @return 格式化后的字符串
     * @vetsion 0.1, 2010/01/27
     */
    public static String replaceBr(String str) {
		if (str != null) {
			str = str.replaceAll("\n", "<BR>");
		}
		return str;
	}
    /**
     * 正则表达式查找字符串中的src值。img标签为小写
     * 
     * @param str
     *            匹配src而不匹配SRC的待处理字符串
     * @return IMG标签中src值的列表
     */
    public static List<String> regExGetImgSrc(String str) {
        if (str == null) {
            return null;
        }
        List<String> srcList = new ArrayList<String>();
        // str = str.replaceAll(" ", "%20");
        // Pattern p = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)");
        Pattern p = Pattern.compile("<img.*?src=\"(.*?)\"");
        Matcher m = p.matcher(str);
        while (m.find()) {
            srcList.add(m.group(1)/* .replaceAll("%20", " ") */);
        }
        return srcList;

    }
    /**
     * 正则表达式去除字符串中除了htmlTag标签之外的的HTML标签，。
     * 
     * @param str
     *            待去除html标签的字符串
     * @param htmlTags
     *            排除的html标签关键字，多个关键字用|分割。例如：IMG|BR|P
     * @return 处理后的字符串
     */
    public static String regExNoHTML(String str, String htmlTags) {
        if (str == null) {
            return str;
        }
        Pattern p = Pattern.compile("<(?!/?(" + htmlTags + "))[^>]*>");
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }
    /**
     * 正则表达式去除字符串中所有的HTML标签
     * 
     * @param str
     *            待处理的字符串
     * @return 返回无HTML标签的字符串
     */
    public static String regExNoHTML(String str) {
        if (str == null) {
            return str;
        }
        Pattern p = Pattern.compile("<.+?>");
        Matcher m = p.matcher(str);
        return m.replaceAll("");
    }
}
