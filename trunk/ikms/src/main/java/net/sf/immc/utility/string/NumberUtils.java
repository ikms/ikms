/**
 * @(#)NumberUtils.java
 */
package net.sf.immc.utility.string;

/**
 * 数字相关操作方法
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2007-2010
 * @version 0.1, 2010/01/22
 */
public class NumberUtils {
    
    /**
     * 将规范float类型的数据，保留2位小数
     * 
     * @param param
     * 			待转换的浮点数
     * @return 两位小数的浮点数
     * @version 0.1，2009/01/26
     */
    public static float getFormatTwoPoint(float param){
    	param += 0.001;
    	java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
    	return Float.parseFloat(df.format(param));
    }
    
    /**
     * 将规范double类型的数据，保留2位小数
     * 
     * @param param
     * 			待转换的double型数据
     * @return 两位小数的double数
     * @version 0.1，2009/01/26
     */
    public static double getFormatTwoPoint(double param){
    	param += 0.001;
    	java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");
    	return Double.parseDouble(df.format(param));
    }
}
