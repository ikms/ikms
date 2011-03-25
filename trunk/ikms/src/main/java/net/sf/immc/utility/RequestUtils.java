/**
 * @(#)RequestUtils.java
 * Copyright ikms.sf.net 2003-2011
 */
package net.sf.immc.utility;

import javax.servlet.http.HttpServletRequest;

/**
 * Dependencies: Servlet/JSP API.
 * 
 * @author <b>oxidy</b>,Copyright &#169;2003-2011
 * @version 0.1,2011-2-26
 */
public class RequestUtils {
	/**
     * Get the base path of this request.
     *
     * @param request -
     *            HttpServletRequest
     * @return String - the base path, eg: http://www.abc.com:8000/someApp/
     */
    public static String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
            + "/";
        return basePath;
    }
    /**
     * Get the current page's full path of this request. 获取当前页的完整访问 URL 路径.
     *
     * @author BeanSoft
     * @date 2005-08-01
     * @param request -
     *            HttpServletRequest
     * @return String - the full url path, eg:
     *         http://www.abc.com:8000/someApp/index.jsp?param=abc
     */
    public static String getFullRequestURL(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String qString = request.getQueryString();
        if (qString != null) {
            url.append('?');
            url.append(qString);
        }
        return url.toString();
    }
    /**
     * Get the current page's full path of this request. 获取当前页的完整访问 URI 路径.
     *
     * @author BeanSoft
     * @date 2005-08-01
     * @param request -
     *            HttpServletRequest
     * @return String - the full uri path, eg: /someApp/index.jsp?param=abc
     */
    public static String getFullRequestURI(HttpServletRequest request) {
        StringBuffer url = new StringBuffer(request.getRequestURI());
        String qString = request.getQueryString();
        if (qString != null) {
            url.append('?');
            url.append(qString);
        }
        return url.toString();
    }

}
