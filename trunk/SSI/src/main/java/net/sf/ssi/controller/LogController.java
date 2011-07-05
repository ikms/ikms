/**
 * @(#)LogController.java
 * Copyright ikms.sf.net 2003-2011
 */
package net.sf.ssi.controller;

import javax.inject.Inject;

import net.sf.ikms.util.CommonUtils;
import net.sf.ikms.util.date.DateConst;
import net.sf.ikms.util.date.DateUtils;
import net.sf.ssi.domain.Account;
import net.sf.ssi.domain.Log;
import net.sf.ssi.service.ILogService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志管理Controller
 * @author <b>oxidy</b>,Copyright &#169;2003
 * @version 1.0
 * @date 2011-7-5
 */
@Controller
@RequestMapping("/log")
public class LogController {

	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@Inject
	public ILogService<Log> logService;
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestParam String createDate,@RequestParam String logTitle,@RequestParam String logContent){
		Account account = new Account();
		account.setAccountNum(1);
		Log log = new Log();
		log.setLogId(CommonUtils.getGUID());
		log.setCreateDate(DateUtils.convertStringToDate(createDate, DateConst.standard_simple_format));
		log.setLogTitle(logTitle);
		log.setLogContent(logContent);
		log.setAccount(account);
		logService.save(log);
//		model.addAttribute("title","添加日志信息");
		return "redirect:/log/query.html";
	}
}
