/**
 * @(#)TestClass.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */
package net.sf.immc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * @author <b>Oxidy</b>, Copyright &#169; 2010
 * @version 0.1,2011-3-24
 */
public class TestClass {
    
    public final static java.sql.Timestamp string2Time(String dateString) throws java.text.ParseException {
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS", Locale.ENGLISH);// 设定格式
        // dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
        dateFormat.setLenient(false);
        java.util.Date timeDate = dateFormat.parse(dateString);// util类型
        java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
        return dateTime;
    }

    public static void main(String[] args) throws Exception {

    }
}
