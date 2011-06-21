/*
 * @(#)CommonController.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 公共Controller
 * 
 * @author zhangyj
 * @version 1.0
 * @date 2011-6-21 下午02:39:20
 * 
 */
@Controller
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	public String toPage(@PathVariable String pageName) {
		logger.info("正在跳转到页面,请稍后......");
		return pageName;
	}
}
