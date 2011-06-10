/**
 * @(#)StringUtils.java
 */
package net.sf.immc.util.string;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.immc.util.UtilityConstKeys;

/**
 * String字符串相关操作方法，同时扩展了org.apache.commons.lang.StringUtils所有方法
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1,2010/12/28
 */
public class StringUtils extends org.apache.commons.lang.StringUtils  {
	//private final static Logger log = Logger.getLogger(StringUtils.class);
    /**
     * StringUtils.isBlank为true则返回toStr。否则返回str
     * @param str
     * @param toStr
     * @return
     * @author Oxidy
     * @version 0.1,2010-10-24
     */
    public static String isBlankToStr(String str,String toStr) {
        if (isBlank(str)) {
            str = toStr;
        }
        return str;
    }
    /**
     * StringUtils.isBlank为true则返回""。否则返回str
     * @param str
     * @return
     * @author Oxidy
     * @version 0.1,2010-10-24
     */
    public static String isBlankToStr(String str) {
        return isBlankToStr(str, "");
    }
	/**
     * 判断一个字符串是否为数字。
     * 
     * @param str
     *            要判断的字符串。
     * @return true 是数字，false 非数字
     * @version 0.1,2010/01/21
     */
    public static boolean isNumber(String str) {
        if (str.trim().equals(""))
            return false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) { return false; }
        return true;
    }

    /**
     * 判断一个字符串是否为全是字母
     * 
     * @param str
     *            要判断的字符串
     * @return true 是字母串 false 不是字母串
     * @version 0.1,2010/01/21
     */
    public static boolean isLetter(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        Matcher isStr = pattern.matcher(str);
        if (!isStr.matches()) {
            return false;
        } else
            return true;
    }
    
    /**
     * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
     * 
     * @param str
     * 			要判断的字符串
     * @return true 为空或者长度为0
     * @version 0.1,2010/01/21
     */
//    public static boolean isEmpty(String str) {
//        return (str == null || str.length() == 0);
//    }
	
    /**
     * 如字符串str为空或NULL,则将字符串str替换成message输出,否则输出原字符串str
     * 
     * @param str
     *            要判断的字符串
     * @param message
     *            要替换的message信息
     * @return 如果不为空或NULL，则返回str； 如果为空或NULL，则返回message
     * @deprecated use {@link #isBlankToStr(String, String)} instead
     * @version 0.1, 2010/01/05
     * @version 0.2, 2011/03/24
     */
    public static String emptyOrNullToMessage(String str, String message) { 
        if (str == null || str.trim().length() <= 0) {
            return message;
        } else {
            return str;
        }
    }
    
    /**
     * 如字符串str为空,则将字符串str替换成message输出,否则输出原字符串str
     * 
     * @param str
     *            要判断的字符串
     * @param message
     *            要替换的message信息
     * @return 如果不为空，则返回str； 如果为空，则返回message
     * @version 0.1, 2010/01/05
     */
    public static String isEmptyToMessage(String str, String message) {
        if (str.trim().length() <= 0) {
            return message;
        } else {
            return str;
        }
    }
    
    /**
     * 如字符串str为NULL,则将字符串str替换成message输出,否则输出原字符串str
     * 
     * @param str
     *            要判断的字符串
     * @param message
     *            要替换的message信息
     * @return 如果不为NULL，则返回str； 如果为NULL，则返回message
     * @version 0.1, 2010/01/05
     */
    public static String isNullToMessage(String str, String message) {
        if (str == null) {
            return message;
        } else {
            return str;
        }
    }
    
    /**
     * 获取字符的子串，如果原字符串长度大于子串，那么后边将加上字符串"..."
     * 
     * @param inputStr
     *            传入的字符串
     * @param beginIndex
     *            开始的位置，从0开始
     * @param length
     *            子串的长度
     * @return 字串
     */
    public static String subStringWith3Point(String inputStr, int beginIndex, int length) {
        int strLength = inputStr.length();
        if (beginIndex >= strLength) {
            return "";
        }
        if (beginIndex + length >= strLength) {
            return inputStr.substring(beginIndex);
        }
        return inputStr.substring(beginIndex, beginIndex + length - 1) + "...";
    }
    
    /**
     * 转换字符串的内码.
     * 
     * @param inputStr
     *            输入的字符串
     * @param sourceEncoding
     *            源字符集名称
     * @param targetEncoding
     *            目标字符集名称
     * @return 转换结果, 如果有错误发生, 则返回原来的值
     */
    public static String changeEncoding(String inputStr, String sourceEncoding, String targetEncoding) {
        if (inputStr == null || inputStr.equals("")) {
            return inputStr;
        }

        try {
            byte[] bytes = inputStr.getBytes(sourceEncoding);
            return new String(bytes, targetEncoding);
        } catch (Exception ex) {
        }
        return inputStr;
    }
    
    /**
     * 将字符串str中的 反斜杠\ 全部替换成 斜杠/
     * 
     * @param str
     * 			将要替换的字符串(例如：aa\bb)
     * @return 替换后返回的字符串(aa/bb)
     * @author zhangyj
     * @version 0.1,2010/01/26
     */
    public static String convertBackSlashToSlash(String str){
		return str.replaceAll("\\\\", "/");
    }
    
    /**
     * 将字符串str中的 斜杠/ 全部替换成 反斜杠\
     * 
     * @param str
     * 			将要替换的字符串(例如：aa/bb)
     * @return 替换后返回的字符串(aa\bb)
     * @author zhangyj
     * @version 0.1,2010/01/26
     */
    public static String convertSlashToBackSlash(String str){
		return str.replaceAll("/", "\\\\");
    }
    
    /**
	 * 将字符串str中的 <B>中文逗号(，)</B> 替换为 <B>英文逗号(,)</b>
	 *  
	 * @param str
	 * 			待处理的字符串
	 * @return 处理后的字符串
	 * @version 0.1, 2010/01/27
	 */
	public static String replaceComma(String str) {
		if (str != null) {
			str = str.replaceAll("，", ",");
		}
		return str;
	}
	/**
	 * 将字符串str中的<B>中文标点符号</B>转换为<B>英文标点符号</B>
	 * @param str
	 * 		待处理的字符串
	 * @return
	 * 		处理后的字符串
	 * @version 0.1,2010/01/27
	 */
	public static String zhCNToenUS(String str){
		if (str !=null) {
			str = str.replaceAll("、", ",");
			str = str.replaceAll("，", ",");
			str = str.replaceAll("。", ".");
			str = str.replaceAll("？", "?");
			str = str.replaceAll("！", "!");
			str = str.replaceAll("；", ";");
			str = str.replaceAll("“", "\"");
			str = str.replaceAll("”", "\"");
			str = str.replaceAll("：", ":");
			str = str.replaceAll("（", "(");
			str = str.replaceAll("）", ")");
			str = str.replaceAll("‘", "\'");
			str = str.replaceAll("’", "\'");
		}
		return str;
	}
	
    /**
     * 将byte[]转化为String,默认使用GBK编码格式转换，编码格式应该与页面编码格式相同。
     * 
     * @param param
     *            byte[]
     * @param encoding
     *            String
     * @return String
     * @author zhangyj
     * @version v0.1 2009-12-09 <BR/>
     *          v0.2 2009-12-15 修正param==null时出错的问题
     */
    public static String convertByteArrayToString(byte[] param,String encoding) {

        String returnstring = null;
        if (param == null) {
            return returnstring = "";
        } else {
            if (isBlank(encoding)) {//判断默认编码格式
                encoding = UtilityConstKeys.GBK;
            }
            ByteArrayInputStream in = new ByteArrayInputStream(param);
            int len = in.available();
            byte[] buffin = new byte[len];
            try {
                in.read(buffin);
                in.close();
                returnstring = new String(buffin, 0, len, encoding);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnstring;
    }
    /**
     * 将String转化为byte[]
     * 
     * @param param
     *            String
     * @return byte[]
     * @author zhangyj
     * @version v0.1 2009-12-09
     */
    public static byte[] convertStringToByteArray(String param) {
        return param.getBytes();
    }
}
