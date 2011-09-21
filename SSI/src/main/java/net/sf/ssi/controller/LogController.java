/**
 * @(#)LogController.java
 * Copyright ikms.sf.net 2003-2011
 */
package net.sf.ssi.controller;

import java.util.List;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//	@ResponseBody
	public String add(@RequestParam String createDate, @RequestParam String logTitle, @RequestParam String logContent) {
		Account account = new Account();
		account.setAccountNum(1);
		Log log = new Log();
		log.setLogId(CommonUtils.getGUID());
		log.setCreateTime(DateUtils.convertStringToDate(createDate, DateConst.standard_simple_format));
		log.setLogTitle(logTitle);
		log.setLogContent(logContent);
		log.setAccount(account);
		logService.save(log);
		//		model.addAttribute("title","添加日志信息");
		logger.info("LogController.add()");
		//		return "redirect:log/query.html";
		return "redirect:/log/query.html";

	}

	@RequestMapping(value = "/toAdd")
	public String toAdd(Model model) {
		return "log/addLog";
	}

	@RequestMapping(value = "/query")
	public String query(Model model) {
		List<Log> logs = logService.find(null);
		model.addAttribute("logs", logs);
		return "log/query";
	}
	@RequestMapping(value = "/toView/{Id}", method = RequestMethod.GET)
	public String toView(@PathVariable("Id") String Id, Model model) {
		Log log = new Log();
		log.setLogId(Id);
		log = logService.loadByKey(log);
		model.addAttribute("log", log);
		return "log/toView";
	}
	@RequestMapping(value = "/toEdit/{Id}", method = RequestMethod.GET)
	public String toEdit(@PathVariable("Id") String Id, Model model) {
		return "";
	}
	@RequestMapping(value = "/toDelete/{Id}")
	public String toDelete(@PathVariable("Id") String Id) {
		return "";
	}
}
