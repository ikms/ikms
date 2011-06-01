package net.sf.ssi.controller;

import net.sf.ssi.domain.User;
import net.sf.ssi.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author zhangyj
 * @version 0.1, 2011-5-25 上午10:28:37
 *
 */
@Controller
@RequestMapping("/usercenter")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/getInfo",method=RequestMethod.GET)
    public String getInfo(@RequestParam("userId") String id,Model model){
		model.addAttribute("user",id);
		logger.info("=="+id+"==");
    	return "userInfo";
    }
	@RequestMapping(value="/getInfo2/{userId}")
	public String getInfo2(@PathVariable String userId, Model model){
		model.addAttribute("user",userId);
		User user = userService.getInfo(userId);
		return "userInfo";
	}
	
	@Autowired
	IUserService<User> userService;
}
