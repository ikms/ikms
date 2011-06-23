/*
 * @(#)ShowcaseController.java
 * Copyright (C) 2003-2011 ikms.sourceforge.net All rights reserved
 */

package net.sf.ssi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-6-23 上午09:42:47
 *
 */
@Controller
@RequestMapping("/showcase")
public class ShowcaseController {

	private static final Logger logger = LoggerFactory.getLogger(ShowcaseController.class);
	
	@RequestMapping(value="/demo",method=RequestMethod.GET)
    public String getDemo(@RequestParam("id") String pramId,Model model){
		model.addAttribute("pramId",pramId);
		logger.info("=="+pramId+"==");
    	return "showcase/demo";
    }
	@RequestMapping(value="/demo2/{pramId}",method=RequestMethod.GET)
	public String getDemo2(@PathVariable String pramId, Model model){
		model.addAttribute("pramId",pramId);
		logger.info("=="+pramId+"==");
		return "showcase/demo";
	}
}
