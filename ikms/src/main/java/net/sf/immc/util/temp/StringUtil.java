package net.sf.immc.util.temp;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;


/**
 * StringUtil, 字符串工具类, 一些方便的字符串工具方法.
 *
 * Dependencies: Servlet/JSP API.
 *
 * @author 刘长炯
 * @version 1.3 2009-03-8
 */
public class StringUtil {

    /**
     * 格式化小数保持最少和最多小数点.
     * 
     * @param num
     * @param minFractionDigits
     * @param maxFractionDigits
     * @return
     */
    public static String formatFraction(double num, int minFractionDigits, int maxFractionDigits) {
        // 输出固定小数点位数
        java.text.NumberFormat nb = java.text.NumberFormat.getInstance();
        nb.setMaximumFractionDigits(maxFractionDigits);
        nb.setMinimumFractionDigits(minFractionDigits);
        nb.setGroupingUsed(false);
        String rate = nb.format(num);
        return rate;
    }
    /**
     * 从请求中获取当前页码数.
     * @param request
     * @return 页码数, 不小于1
     */
    public static int getCurrentPage(HttpServletRequest request) {
        String pname = "cp";
        // 获取页码数
        if (request.getParameter(pname) != null && !"".equals(request.getParameter(pname))) {
            return Integer.parseInt(request.getParameter(pname));
        } else {
            return 1;
        }
    }
    /**
     * 将给定时间移动相对月份.
     * @param beginDate 起始日期
     * @param amount 数量
     * @return 结果日期
     */
    public static Date moveMonth(Date beginDate, int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }
    /**
     * 将给定字符串时间移动相对月份.
     * @param year 年字符串
     * @param month 月
     * @param amount 数量
     * @return int[ 年, 月 ]
     */
    public static int[] moveMonth(String year, String month, int amount) {
        Date d = moveMonth(parseDate(year + "/" + month, "yyyy/MM"), amount);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return new int[] { cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) };
    }
    /**
     * 解析日期.
     * @param input 输入字符串
     * @param pattern 类型
     * @return Date 对象
     */
    public static Date parseDate(String input, String pattern) {
        if (isEmpty(input)) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(input);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 格式化日期为字符串.
     * @param date 日期字符串
     * @param pattern 类型
     * @return 结果字符串
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern == null) {
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }
    /**
     * Same function as javascript's escape().
     * @param src
     * @return
     */
    public static String escape(String src) {
        int i;
        char j;
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j) || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }
    /**
     * Same function as javascript's unsecape().
     * @param src
     * @return
     */
    public static String unescape(String src) {
        StringBuffer tmp = new StringBuffer();
        tmp.ensureCapacity(src.length());
        int lastPos = 0, pos = 0;
        char ch;
        while (lastPos < src.length()) {
            pos = src.indexOf("%", lastPos);
            if (pos == lastPos) {
                if (src.charAt(pos + 1) == 'u') {
                    ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
                    tmp.append(ch);
                    lastPos = pos + 6;
                } else {
                    ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
                    tmp.append(ch);
                    lastPos = pos + 3;
                }
            } else {
                if (pos == -1) {
                    tmp.append(src.substring(lastPos));
                    lastPos = src.length();
                } else {
                    tmp.append(src.substring(lastPos, pos));
                    lastPos = pos;
                }
            }
        }
        return tmp.toString();
    }
    /**
     * 获取类路径中的资源文件的物理文件路径.
     * NOTE: 仅在 Win32 平台下测试通过开发.
     * @date 2005.10.16
     * @param resourcePath 资源路径
     * @return 配置文件路径
     */
    public static String getRealFilePath(String resourcePath) {
        java.net.URL inputURL = StringUtil.class.getResource(resourcePath);
        String filePath = inputURL.getFile();
        // 2007-02-08  Fixed by K.D. to solve the space char problem, also with some
        // other special chars in path problem
        try {
            filePath = java.net.URLDecoder.decode(filePath, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // For windows platform, the filePath will like this:
        // /E:/Push/web/WEB-INF/classes/studio/beansoft/smtp/MailSender.ini
        // So must remove the first /
        //        if(OS.isWindows() && filePath.startsWith("/")) {
        //            filePath = filePath.substring(1);
        //        }
        return filePath;
    }
    /**
     * 将字符串转换为 int.
     *
     * @param input
     *            输入的字串
     * @date 2005-07-29
     * @return 结果数字
     */
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }
    /**
     * 将字符串转换为 long.
     *
     * @param input
     *            输入的字串
     * @return 结果数字
     */
    public static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {}
        return 0;
    }
    /**
     * 将字符串转换为 long.
     *
     * @param input
     *            输入的字串
     * @return 结果数字
     */
    public static double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {}
        return 0;
    }
    /**
     * 格式化日期到日时分秒时间格式的显示. d日 HH:mm:ss
     *
     * @return - String 格式化后的时间
     */
    public static String formatDateToDHMSString(java.util.Date date) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("d日 HH:mm:ss");
        return dateFormat.format(date);
    }
    /**
     * 格式化日期到时分秒时间格式的显示.
     *
     * @return - String 格式化后的时间
     */
    public static String formatDateToHMSString(java.util.Date date) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("HH:mm:ss");
        return dateFormat.format(date);
    }
    /**
     * 将时分秒时间格式的字符串转换为日期.
     *
     * @param input
     * @return
     */
    public static Date parseHMSStringToDate(String input) {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("HH:mm:ss");
        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 格式化日期到 Mysql 数据库日期格式字符串的显示.
     *
     * @return - String 格式化后的时间
     */
    public static String formatDateToMysqlString(java.util.Date date) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    /**
     * 将 Mysql 数据库日期格式字符串转换为日期.
     *
     * @param input
     * @return
     */
    public static Date parseStringToMysqlDate(String input) {
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 返回时间字符串, 可读形式的, M月d日 HH:mm 格式. 2004-09-22, LiuChangjiong
     *
     * @return - String 格式化后的时间
     */
    public static String formatDateToMMddHHmm(java.util.Date date) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("M月d日 HH:mm");
        return dateFormat.format(date);
    }
    /**
     * 返回时间字符串, 可读形式的, yy年M月d日HH:mm 格式. 2004-10-04, LiuChangjiong
     *
     * @return - String 格式化后的时间
     */
    public static String formatDateToyyMMddHHmm(java.util.Date date) {
        if (date == null) {
            return "";
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yy年M月d日HH:mm");
        return dateFormat.format(date);
    }
    /**
     * 返回 HTTP 请求的 Referer, 如果没有, 就返回默认页面值.
     *
     * 仅用于移动博客开发页面命名风格: // Added at 2004-10-12 // 如果前一页面的地址包含 _action.jsp ,
     * 为了避免链接出错, 就返回默认页面
     *
     * 2006-08-02 增加从 url 参数 referer 的判断 
     * 
     * @param request -
     *            HttpServletRequest 对象
     * @param defaultPage -
     *            String, 默认页面
     * @return String - Referfer
     */
    public static String getReferer(HttpServletRequest request, String defaultPage) {
        String referer = request.getHeader("Referer");// 前一页面的地址, 提交结束后返回此页面
        // 获取URL中的referer参数
        String refererParam = request.getParameter("referer");
        if (!isEmpty(refererParam)) {
            referer = refererParam;
        }
        // Added at 2004-10-12
        // 如果前一页面的地址包含 _action.jsp , 为了避免链接出错, 就返回默认页面
        if (isEmpty(referer) || referer.indexOf("_action.jsp") != -1) {
            referer = defaultPage;
        }
        return referer;
    }
    /**
     * 生成一个 18 位的 yyyyMMddHHmmss.SSS 格式的日期字符串.
     *
     * @param date
     *            Date
     * @return String
     */
    public static String genTimeStampString(Date date) {
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyyMMddHHmmss.SSS");
        return df.format(date);
    }
    /**
     * Write the HTML base tag to support servlet forward calling relative path
     * changed problems.
     *
     * Base is used to ensure that your document's relative links are associated
     * with the proper document path. The href specifies the document's
     * reference URL for associating relative URLs with the proper document
     * path. This element may only be used within the HEAD tag. Example: <BASE
     * HREF="http://www.sample.com/hello.htm">
     *
     * @param pageContext
     *            the PageContext of the jsp page object
     */
    public static void writeHtmlBase(PageContext pageContext) {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        StringBuffer buf = new StringBuffer("<base href=\"");
        buf.append(request.getScheme());
        buf.append("://");
        buf.append(request.getServerName());
        buf.append(":");
        buf.append(request.getServerPort());
        buf.append(request.getRequestURI());
        buf.append("\">");
        JspWriter out = pageContext.getOut();
        try {
            out.write(buf.toString());
        } catch (java.io.IOException e) {}
    }
    
    // ------------------------------------ 字符串处理方法
    // ----------------------------------------------
    /**
     * 将字符串 source 中的 oldStr 替换为 newStr, 并以大小写敏感方式进行查找
     *
     * @param source
     *            需要替换的源字符串
     * @param oldStr
     *            需要被替换的老字符串
     * @param newStr
     *            替换为的新字符串
     */
    public static String replace(String source, String oldStr, String newStr) {
        return replace(source, oldStr, newStr, true);
    }
    /**
     * 将字符串 source 中的 oldStr 替换为 newStr, matchCase 为是否设置大小写敏感查找
     *
     * @param source
     *            需要替换的源字符串
     * @param oldStr
     *            需要被替换的老字符串
     * @param newStr
     *            替换为的新字符串
     * @param matchCase
     *            是否需要按照大小写敏感方式查找
     */
    public static String replace(String source, String oldStr, String newStr, boolean matchCase) {
        if (source == null) {
            return null;
        }
        // 首先检查旧字符串是否存在, 不存在就不进行替换
        if (source.toLowerCase().indexOf(oldStr.toLowerCase()) == -1) {
            return source;
        }
        int findStartPos = 0;
        int a = 0;
        while (a > -1) {
            int b = 0;
            String str1, str2, str3, str4, strA, strB;
            str1 = source;
            str2 = str1.toLowerCase();
            str3 = oldStr;
            str4 = str3.toLowerCase();
            if (matchCase) {
                strA = str1;
                strB = str3;
            } else {
                strA = str2;
                strB = str4;
            }
            a = strA.indexOf(strB, findStartPos);
            if (a > -1) {
                b = oldStr.length();
                findStartPos = a + b;
                StringBuffer bbuf = new StringBuffer(source);
                source = bbuf.replace(a, a + b, newStr) + "";
                // 新的查找开始点位于替换后的字符串的结尾
                findStartPos = findStartPos + newStr.length() - b;
            }
        }
        return source;
    }
    /**
     * 清除字符串结尾的空格.
     *
     * @param input
     *            String 输入的字符串
     * @return 转换结果
     */
    public static String trimTailSpaces(String input) {
        if (isEmpty(input)) {
            return "";
        }
        String trimedString = input.trim();
        if (trimedString.length() == input.length()) {
            return input;
        }
        return input.substring(0, input.indexOf(trimedString) + trimedString.length());
    }
    /**
     * Change the null string value to "", if not null, then return it self, use
     * this to avoid display a null string to "null".
     *
     * @param input
     *            the string to clear
     * @return the result
     */
    public static String clearNull(String input) {
        return isEmpty(input) ? "" : input;
    }
    /**
     * Return the limited length string of the input string (added at:April 10,
     * 2004).
     *
     * @param input
     *            String
     * @param maxLength
     *            int
     * @return String processed result
     */
    public static String limitStringLength(String input, int maxLength) {
        if (isEmpty(input))
            return "";
        if (input.length() <= maxLength) {
            return input;
        } else {
            return input.substring(0, maxLength - 3) + "...";
        }
    }
    /**
     * 将字符串转换为一个 JavaScript 的 alert 调用. eg: htmlAlert("What?"); returns
     * &lt;SCRIPT language="JavaScript"&gt;alert("What?")&lt;/SCRIPT&gt;
     *
     * @param message
     *            需要显示的信息
     * @return 转换结果
     */
    public static String scriptAlert(String message) {
        return "<SCRIPT language=\"JavaScript\">alert(\"" + message + "\");</SCRIPT>";
    }
    /**
     * 将字符串转换为一个 JavaScript 的 document.location 改变调用. eg: htmlAlert("a.jsp");
     * returns &lt;SCRIPT
     * language="JavaScript"&gt;document.location="a.jsp";&lt;/SCRIPT&gt;
     *
     * @param url
     *            需要显示的 URL 字符串
     * @return 转换结果
     */
    public static String scriptRedirect(String url) {
        return "<SCRIPT language=\"JavaScript\">document.location=\"" + url + "\";</SCRIPT>";
    }
    /**
     * 返回脚本语句 &lt;SCRIPT language="JavaScript"&gt;history.back();&lt;/SCRIPT&gt;
     *
     * @return 脚本语句
     */
    public static String scriptHistoryBack() {
        return "<SCRIPT language=\"JavaScript\">history.back();</SCRIPT>";
    }
    /**
     * 滤除帖子中的危险 HTML 代码, 主要是脚本代码, 滚动字幕代码以及脚本事件处理代码
     *
     * @param content
     *            需要滤除的字符串
     * @return 过滤的结果
     */
    public static String replaceHtmlCode(String content) {
        if (isEmpty(content)) {
            return "";
        }
        // 需要滤除的脚本事件关键字
        String[] eventKeywords = { "onmouseover", "onmouseout", "onmousedown", "onmouseup", "onmousemove", "onclick",
                "ondblclick", "onkeypress", "onkeydown", "onkeyup", "ondragstart", "onerrorupdate", "onhelp",
                "onreadystatechange", "onrowenter", "onrowexit", "onselectstart", "onload", "onunload",
                "onbeforeunload", "onblur", "onerror", "onfocus", "onresize", "onscroll", "oncontextmenu" };
        content = replace(content, "<script", "&ltscript", false);
        content = replace(content, "</script", "&lt/script", false);
        content = replace(content, "<marquee", "&ltmarquee", false);
        content = replace(content, "</marquee", "&lt/marquee", false);
        // FIXME 加这个过滤换行到 BR 的功能会把原始 HTML 代码搞乱 2006-07-30
        //        content = replace(content, "\r\n", "<BR>");
        // 滤除脚本事件代码
        for (int i = 0; i < eventKeywords.length; i++) {
            content = replace(content, eventKeywords[i], "_" + eventKeywords[i], false); // 添加一个"_", 使事件代码无效
        }
        return content;
    }
    /**
     * 滤除 HTML 代码 为文本代码.
     */
    public static String replaceHtmlToText(String input) {
        if (isEmpty(input)) {
            return "";
        }
        return setBr(setTag(input));
    }
    /**
     * 滤除 HTML 标记.
     * 因为 XML 中转义字符依然有效, 因此把特殊字符过滤成中文的全角字符.
     * @author beansoft
     * @param s 输入的字串
     * @return 过滤后的字串
     */
    public static String setTag(String s) {
        int j = s.length();
        StringBuffer stringbuffer = new StringBuffer(j + 500);
        char ch;
        for (int i = 0; i < j; i++) {
            ch = s.charAt(i);
            if (ch == '<') {
                stringbuffer.append("&lt");
                //                stringbuffer.append("〈");
            } else if (ch == '>') {
                stringbuffer.append("&gt");
                //                stringbuffer.append("〉");
            } else if (ch == '&') {
                stringbuffer.append("&amp");
                //                stringbuffer.append("〃");
            } else if (ch == '%') {
                stringbuffer.append("%%");
                //                stringbuffer.append("※");
            } else {
                stringbuffer.append(ch);
            }
        }
        return stringbuffer.toString();
    }
    /** 滤除 BR 代码 */
    public static String setBr(String s) {
        int j = s.length();
        StringBuffer stringbuffer = new StringBuffer(j + 500);
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) == '\n' || s.charAt(i) == '\r') {
                continue;
            }
            stringbuffer.append(s.charAt(i));
        }
        return stringbuffer.toString();
    }
    /** 滤除空格 */
    public static String setNbsp(String s) {
        int j = s.length();
        StringBuffer stringbuffer = new StringBuffer(j + 500);
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) == ' ') {
                stringbuffer.append("&nbsp;");
            } else {
                stringbuffer.append(s.charAt(i) + "");
            }
        }
        return stringbuffer.toString();
    }
    /**
     * 判断字符串是否全是数字字符或者点号.
     *
     * @param input
     *            输入的字符串
     * @return 判断结果, true 为全数字, false 为还有非数字字符
     */
    public static boolean isNumeric(String input) {
        if (isEmpty(input)) {
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            if (!Character.isDigit(charAt) && (charAt != '.')) {
                return false;
            }
        }
        return true;
    }
    /**
     * 转换由表单读取的数据的内码(从 ISO8859 转换到 gb2312).
     *
     * @param input
     *            输入的字符串
     * @return 转换结果, 如果有错误发生, 则返回原来的值
     */
    public static String toChi(String input) {
        try {
            byte[] bytes = input.getBytes("ISO8859-1");
            return new String(bytes, "GBK");
        } catch (Exception ex) {}
        return input;
    }
    /**
     * 转换由表单读取的数据的内码到 ISO(从 GBK 转换到ISO8859-1).
     *
     * @param input
     *            输入的字符串
     * @return 转换结果, 如果有错误发生, 则返回原来的值
     */
    public static String toISO(String input) {
        return changeEncoding(input, "GBK", "ISO8859-1");
    }
    /**
     * 转换字符串的内码.
     *
     * @param input
     *            输入的字符串
     * @param sourceEncoding
     *            源字符集名称
     * @param targetEncoding
     *            目标字符集名称
     * @return 转换结果, 如果有错误发生, 则返回原来的值
     */
    public static String changeEncoding(String input, String sourceEncoding, String targetEncoding) {
        if (input == null || input.equals("")) {
            return input;
        }
        try {
            byte[] bytes = input.getBytes(sourceEncoding);
            return new String(bytes, targetEncoding);
        } catch (Exception ex) {}
        return input;
    }
    /**
     * 将单个的 ' 换成 ''; SQL 规则:如果单引号中的字符串包含一个嵌入的引号,可以使用两个单引号表示嵌入的单引号.
     */
    public static String replaceSql(String input) {
        return replace(input, "'", "''");
    }
    /**
     * 对给定字符进行 URL 编码
     */
    public static String encode(String value) {
        if (isEmpty(value)) {
            return "";
        }
        try {
            value = java.net.URLEncoder.encode(value, "GB2312");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
    /**
     * 对给定字符进行 URL 解码
     *
     * @param value
     *            解码前的字符串
     * @return 解码后的字符串
     */
    public static String decode(String value) {
        if (isEmpty(value)) {
            return "";
        }
        try {
            return java.net.URLDecoder.decode(value, "GB2312");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
    /**
     * 判断字符串是否未空, 如果为 null 或者长度为0, 均返回 true.
     */
    public static boolean isEmpty(String input) {
        return (input == null || input.length() == 0);
    }
    /**
     * 获得输入字符串的字节长度(即二进制字节数), 用于发送短信时判断是否超出长度.
     *
     * @param input
     *            输入字符串
     * @return 字符串的字节长度(不是 Unicode 长度)
     */
    public static int getBytesLength(String input) {
        if (input == null) {
            return 0;
        }
        int bytesLength = input.getBytes().length;
        //System.out.println("bytes length is:" + bytesLength);
        return bytesLength;
    }
    /**
     * 检验字符串是否未空, 如果是, 则返回给定的出错信息.
     *
     * @param input
     *            输入的字符串
     * @param errorMsg
     *            出错信息
     * @return 空串返回出错信息
     */
    public static String isEmpty(String input, String errorMsg) {
        if (isEmpty(input)) {
            return errorMsg;
        }
        return "";
    }
    /**
     * 得到文件的扩展名.
     *
     * @param fileName
     *            需要处理的文件的名字.
     * @return the extension portion of the file's name.
     */
    public static String getExtension(String fileName) {
        if (fileName != null) {
            int i = fileName.lastIndexOf('.');
            if (i > 0 && i < fileName.length() - 1) {
                return fileName.substring(i + 1).toLowerCase();
            }
        }
        return "";
    }
    /**
     * 得到文件的前缀名.
     * @date 2005-10-18
     *
     * @param fileName
     *            需要处理的文件的名字.
     * @return the prefix portion of the file's name.
     */
    public static String getPrefix(String fileName) {
        if (fileName != null) {
            fileName = fileName.replace('\\', '/');
            if (fileName.lastIndexOf("/") > 0) {
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
            }
            int i = fileName.lastIndexOf('.');
            if (i > 0 && i < fileName.length() - 1) {
                return fileName.substring(0, i);
            }
        }
        return "";
    }
    /**
     * 得到文件的短路径, 不保护目录.
     * @date 2005-10-18
     *
     * @param fileName
     *            需要处理的文件的名字.
     * @return the short version of the file's name.
     */
    public static String getShortFileName(String fileName) {
        if (fileName != null) {
            String oldFileName = new String(fileName);
            fileName = fileName.replace('\\', '/');
            // Handle dir
            if (fileName.endsWith("/")) {
                int idx = fileName.indexOf('/');
                if (idx == -1 || idx == fileName.length() - 1) {
                    return oldFileName;
                } else {
                    return oldFileName.substring(idx + 1, fileName.length() - 1);
                }
            }
            if (fileName.lastIndexOf("/") > 0) {
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.length());
            }
            return fileName;
        }
        return "";
    }
    /**
     * 获取表单参数并做默认转码, 从 ISO8859-1 转换到 GBK.
     *
     * @author BeanSoft
     * @date 2005-08-01
     *
     * @param request
     *            HttpServletRequest 对象
     * @param fieldName
     *            参数名
     * @return 取得的表单值
     */
    public static String getParameter(HttpServletRequest request, String fieldName) {
        //        // 判断编码是否已经指定
        //        String encoding = request.getCharacterEncoding();
        //
        //        if("GBK".equalsIgnoreCase(encoding) || "GB2312".equalsIgnoreCase(encoding)) {
        //            return request.getParameter(fieldName);
        //        }
        //
        //        return request(request, fieldName);
        // 2005-08-01 临时修改
        //        try {
        //            request.setCharacterEncoding("UTF-8");
        //        } catch (UnsupportedEncodingException e) {
        //            // TODO auto generated try-catch
        //            e.printStackTrace();
        //        }
        return request.getParameter(fieldName);
    }
    // ------------------------------------ JSP 参数处理方法
    /**
     * 根据 Cookie 名称得到请求中的 Cookie 值, 需要事先给 _request 一个初始值; 如果 Cookie 值是 null, 则返回 ""
     */
    public static String getCookieValue(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "";
        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(name)) {
                // 需要对 Cookie 中的汉字进行 URL 反编码, 适用版本: Tomcat 4.0
                return decode(cookie.getValue());
                // 不需要反编码, 适用版本: JSWDK 1.0.1
                //return cookie.getValue();
            }
        }
        // A cookie may not return a null value, may return a ""
        return "";
    }
    // 返回指定表单名的数组
    public String[] getParameterValues(HttpServletRequest request, String name) {
        // POST 方法的参数没有编码错误
        //if (request.getMethod().equalsIgnoreCase("POST")) {
        // 文件上传模式
        //if(isUploadMode) {
        //    return request.getParameterValues(name);
        //}
        // -- For Tomcat 4.0
        //return request.getParameterValues(name);
        // -- For JSWDK 1.0.1
        /*
         * String values[] = _request.getParameterValues(name); if(values !=
         * null) { for(int i = 0; i < values.length; i++) { values[i] =
         * toChi(values[i]); } } return values;
         */
        //}
        //else {
        // 将通过 GET 方式发送的中文字符解码(但是必须使用 java.net.URLEncoder 进行中文字符参数的编码)
        // 解码时需使用内码转换, 也可使用反编码, 即: return decode(_request.getParameter(name));
        // 问题: decode() 仅适用于 JDK 1.3 + Tomcat 4.0
        String encoding = request.getCharacterEncoding();
        if ("GBK".equalsIgnoreCase(encoding) || "GB2312".equalsIgnoreCase(encoding)) {
            return request.getParameterValues(name);
        }
        String values[] = request.getParameterValues(name);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                values[i] = toChi(values[i]);
            }
        }
        return values;
        //}
    }
    /**
     * 删除指定的 Web 应用程序目录下所上传的文件
     *
     * @param application
     *            JSP/Servlet 的 ServletContext
     * @param filePath
     *            相对文件路径
     */
    public static void deleteFile(ServletContext application, String filePath) {
        if (!isEmpty(filePath)) {
            String physicalFilePath = application.getRealPath(filePath);
            if (!isEmpty(physicalFilePath)) {
                java.io.File file = new java.io.File(physicalFilePath);
                file.delete();
            }
        }
    }
    /**
     * 在指定的 Web 应用程序目录下以指定路径创建文件
     *
     * @param application
     *            JSP/Servlet 的 ServletContext
     * @param filePath
     *            相对文件路径
     */
    public static boolean createFile(ServletContext application, String filePath) {
        if (!isEmpty(filePath)) {
            String physicalFilePath = application.getRealPath(filePath);
            if (!isEmpty(physicalFilePath)) {
                java.io.File file = new java.io.File(physicalFilePath);
                try {
                    // 创建文件
                    return file.createNewFile();
                } catch (IOException e) {
                    System.err.println("Unable to create file " + filePath);
                }
            }
        }
        return false;
    }
    /**
     * 在指定的 Web 应用程序目录下以指定路径创建目录.
     *
     * @param application
     *            JSP/Servlet 的 ServletContext
     * @param filePath
     *            相对文件路径
     */
    public static boolean createDir(ServletContext application, String filePath) {
        if (!isEmpty(filePath)) {
            String physicalFilePath = application.getRealPath(filePath);
            if (!isEmpty(physicalFilePath)) {
                try {
                    // 创建目录
                    java.io.File dir = new java.io.File(application.getRealPath(filePath));
                    return dir.mkdirs();
                } catch (Exception e) {
                    System.err.println("Unable to create directory " + filePath);
                }
            }
        }
        return false;
    }
    /**
     * 检查指定的 Web 应用程序目录下的文件是否存在.
     *
     * @param application
     *            JSP/Servlet 的 ServletContext
     * @param filePath
     *            相对文件路径
     * @return boolean - 文件是否存在
     */
    public static boolean checkFileExists(ServletContext application, String filePath) {
        if (!isEmpty(filePath)) {
            String physicalFilePath = application.getRealPath(filePath);
            if (!isEmpty(physicalFilePath)) {
                java.io.File file = new java.io.File(physicalFilePath);
                return file.exists();
            }
        }
        return false;
    }
    /**
     * 获取文件图标名.
     * Date: 2005-10
     * @param application JSP/Servlet 的 ServletContext
     * @param iconDirPath 图标文件夹的路径
     * @param fileName 需要处理的文件名
     * @return 图标文件相对路径
     */
    public static String getFileIcon(ServletContext application, String iconDirPath, String fileName) {
        String ext = getExtension(fileName);
        String filePath = iconDirPath + ext + ".gif";
        //        return filePath;
        if (checkFileExists(application, filePath)) {
            return filePath;
        }
        return iconDirPath + "file.gif";
    }
    /**
     * Gets the absolute pathname of the class or resource file containing the
     * specified class or resource name, as prescribed by the current classpath.
     *
     * @param resourceName
     *            Name of the class or resource name.
     * @return the absolute pathname of the given resource
     */
    public static String getPath(String resourceName) {
        if (!resourceName.startsWith("/")) {
            resourceName = "/" + resourceName;
        }
        //resourceName = resourceName.replace('.', '/');
        java.net.URL classUrl = new StringUtil().getClass().getResource(resourceName);
        if (classUrl != null) {
            //System.out.println("\nClass '" + className +
            //"' found in \n'" + classUrl.getFile() + "'");
            //System.out.println("\n资源 '" + resourceName +
            //"' 在文件 \n'" + classUrl.getFile() + "' 中找到.");
            return classUrl.getFile();
        }
        //System.out.println("\nClass '" + className +
        //"' not found in \n'" +
        //System.getProperty("java.class.path") + "'");
        //System.out.println("\n资源 '" + resourceName +
        //"' 没有在类路径 \n'" +
        //System.getProperty("java.class.path") + "' 中找到");
        return null;
    }

    /**
     * 将日期转换为中文表示方式的字符串(格式为 yyyy年MM月dd日 HH:mm:ss).
     */
    public static String dateToChineseString(Date date) {
        if (date == null) {
            return "";
        }

        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm:ss");

        return dateFormat.format(date);
    }

    /**
     * 将日期转换为 14 位的字符串(格式为yyyyMMddHHmmss).
     */
    public static String dateTo14String(Date date) {
        if (date == null) {
            return null;
        }

        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
                "yyyyMMddHHmmss");

        return dateFormat.format(date);
    }

    /**
     * 将 14 位的字符串(格式为yyyyMMddHHmmss)转换为日期.
     */
    public static Date string14ToDate(String input) {
        if (isEmpty(input)) {
            return null;
        }
        if (input.length() != 14) {
            return null;
        }
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return dateFormat.parse(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // -----------------------------------------------------------
    // ---------- 字符串和数字转换工具方法, 2004.03.27 添加 --------
    //------------------------------------------------------------
    public static byte getByte(HttpServletRequest httpservletrequest, String s) {
        if (httpservletrequest.getParameter(s) == null || httpservletrequest.getParameter(s).equals("")) {
            return 0;
        }
        return Byte.parseByte(httpservletrequest.getParameter(s));
    }
    /**
     * 获取 boolean 参数从ServletRequest中.
     * @param request
     * @param name
     * @return
     */
    public static boolean getBoolean(HttpServletRequest request, String name) {
        return Boolean.valueOf(request.getParameter(name));
    }
    /**
     *从请求对象中读取参数返回为整数.
     *
     */
    public static int getInt(HttpServletRequest httpservletrequest, String s) {
        if (httpservletrequest.getParameter(s) == null || httpservletrequest.getParameter(s).equals("")) {
            return 0;
        }
        return parseInt(httpservletrequest.getParameter(s));
    }
    public static long getLong(HttpServletRequest httpservletrequest, String s) {
        if (httpservletrequest.getParameter(s) == null || httpservletrequest.getParameter(s).equals("")) {
            return 0L;
        }
        return parseLong(httpservletrequest.getParameter(s));
    }
    public static double getDouble(HttpServletRequest httpservletrequest, String s) {
        if (httpservletrequest.getParameter(s) == null || httpservletrequest.getParameter(s).equals("")) {
            return 0;
        }
        return parseDouble(httpservletrequest.getParameter(s));
    }
    /**
     * 将 TEXT 文本转换为 HTML 代码, 已便于网页正确的显示出来.
     *
     * @param input
     *            输入的文本字符串
     * @return 转换后的 HTML 代码
     */
    public static String textToHtml(String input) {
        if (isEmpty(input)) {
            return "";
        }
        input = replace(input, "<", "&#60;");
        input = replace(input, ">", "&#62;");
        input = replace(input, "\n", "<br>\n");
        input = replace(input, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        input = replace(input, "  ", "&nbsp;&nbsp;");
        return input;
    }
    public static String toQuoteMark(String s) {
        s = replaceString(s, "'", "&#39;");
        s = replaceString(s, "\"", "&#34;");
        s = replaceString(s, "\r\n", "\n");
        return s;
    }
    public static String replaceChar(String s, char c, char c1) {
        if (s == null) {
            return "";
        }
        return s.replace(c, c1);
    }
    public static String replaceString(String s, String s1, String s2) {
        if (s == null || s1 == null || s2 == null) {
            return "";
        }
        return s.replaceAll(s1, s2);
    }
    public static String toHtml(String s) {
        s = replaceString(s, "<", "&#60;");
        s = replaceString(s, ">", "&#62;");
        return s;
    }
    public static String toBR(String s) {
        s = replaceString(s, "\n", "<br>\n");
        s = replaceString(s, "\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
        s = replaceString(s, "  ", "&nbsp;&nbsp;");
        return s;
    }
    public static String toSQL(String s) {
        s = replaceString(s, "\r\n", "\n");
        return s;
    }
    public static String replaceEnter(String s) throws NullPointerException {
        return s.replaceAll("\n", "<br>");
    }
    public static String replacebr(String s) throws NullPointerException {
        return s.replaceAll("<br>", "\n");
    }
    public static String replaceQuote(String s) throws NullPointerException {
        return s.replaceAll("'", "''");
    }
    // Test only.
    public static void main(String[] args) throws Exception {
        System.out.println(formatFraction(0.693431014112044, 1, 3));
        //System.out.println(textToHtml("1<2\r\n<b>Bold</b>"));
        //System.out.println(scriptAlert("oh!"));
        //System.out.println(scriptRedirect("http://localhost/"));
        //    System.out.println(StringUtil.getPath("/databaseconfig.properties"));
        //        java.io.File file = new java.io.File("e:\\Moblog\\abcd\\");
        //
        //        file.mkdir();
        //        Date time = (parseHMSStringToDate("12:23:00"));
        //        System.out.println(time.toLocaleString());
        //        Date nowTime = parseHMSStringToDate(formatDateToHMSString(new Date()));
        //        System.out.println(nowTime.toLocaleString());
        //        GregorianCalendar cal = new GregorianCalendar();
        //        cal.setTime(new Date());
        //        cal.add(cal.YEAR, -cal.get(cal.YEAR) + 1970);
        //        cal.add(cal.MONTH, -cal.get(cal.MONTH));
        //        cal.add(cal.DATE, -cal.get(cal.DATE) + 1);
        //
        //        System.out.println(cal.getTime().toLocaleString());
    }
}