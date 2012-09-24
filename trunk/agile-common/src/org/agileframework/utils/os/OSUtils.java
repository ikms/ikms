/*
 * @(#)OSUtils.java
 * Copyright (C) 2003-2011 ikms.github.com All rights reserved
 */

package org.agileframework.utils.os;

/**
 * 操作系统及环境变量等 相关操作公共类<br/>
 * (Windows,Linux,Mac OS X,Unix,Solaris)
 * 
 * @author <b>oxidy</b>, Copyright &#169; 2003
 * @since 03 September 2011
 * 
 */
public class OSUtils {

	/**
	 * 获取系统信息
	 * 
	 * <ul>
	 * 	<li><b>键</b>
	 * 		 - 相关值的描述 </li>
	 *  <li><b>java.version</b>
	 *  	 - Java 运行时环境版本 </li>
	 *  <li><b>java.vendor</b>
	 *  	 - Java 运行时环境供应商 </li>
	 *  <li><b>java.vendor.url</b>
	 *  	 - Java 供应商的 URL </li>
	 *  <li><b>java.home</b>
	 *  	 - Java 安装目录 </li>
	 *  <li><b>java.vm.specification.version</b>
	 *  	 - Java 虚拟机规范版本 </li>
	 *  <li><b>java.vm.specification.vendor</b>
	 *  	 - Java 虚拟机规范供应商 </li>
	 *  <li><b>java.vm.specification.name</b>
	 *  	 - Java 虚拟机规范名称 </li>
	 *  <li><b>java.vm.version</b>
	 *  	 - Java 虚拟机实现版本 </li>
	 *  <li><b>java.vm.vendor</b>
	 *  	 - Java 虚拟机实现供应商 </li>
	 *  <li><b>java.vm.name</b>
	 *  	 - Java 虚拟机实现名称 </li>
	 *  <li><b>java.specification.version</b>
	 *  	 - Java 运行时环境规范版本 </li>
	 *  <li><b>java.specification.vendor</b>
	 *  	 - Java 运行时环境规范供应商 </li>
	 *  <li><b>java.specification.name</b>
	 *  	 - Java 运行时环境规范名称 </li>
	 *  <li><b>java.class.version</b>
	 *  	 - Java 类格式版本号 </li>
	 *  <li><b>java.class.path</b>
	 *  	 - Java 类路径 </li>
	 *  <li><b>java.library.path</b>
	 *  	 - 加载库时搜索的路径列表 </li>
	 *  <li><b>java.io.tmpdir</b>
	 *  	 - 默认的临时文件路径 </li>
	 *  <li><b>java.compiler</b>
	 *  	 - 要使用的 JIT 编译器的名称 </li>
	 *  <li><b>java.ext.dirs</b>
	 *  	 - 一个或多个扩展目录的路径 </li>
	 *  <li><b>os.name</b>
	 *  	 - 操作系统的名称 </li>
	 *  <li><b>os.arch</b>
	 *  	 - 操作系统的架构 </li>
	 *  <li><b>os.version</b>
	 *  	 - 操作系统的版本 </li>
	 *  <li><b>file.separator</b>
	 *  	 - 文件分隔符（在 UNIX 系统中是“/”） </li>
	 *  <li><b>path.separator</b>
	 *  	 - 路径分隔符（在 UNIX 系统中是“:”） </li>
	 *  <li><b>line.separator</b>
	 *  	 - 行分隔符（在 UNIX 系统中是“/n”） </li>
	 *  <li><b>user.name</b>
	 *  	 - 用户的账户名称 </li>
	 *  <li><b>user.home</b>
	 *  	 - 用户的主目录 </li>
	 *  <li><b>user.dir</b>
	 *  	 - 用户的当前工作目录 </li>
	 * </ul>
	 * 
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		return System.getProperty(key);
	}

}
