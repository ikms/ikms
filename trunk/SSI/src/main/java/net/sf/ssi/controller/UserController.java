package net.sf.ssi.controller;

import net.sf.ssi.domain.User;
import net.sf.ssi.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		User user = userService.getInfoByKey(userId);
		System.out.println(user.getUserName());
		return "userInfo";
	}
	@RequestMapping(value="/getInfo3/{userId}")
	public String getInfo3(@PathVariable String userId, Model model){
		User user = userService.getInfoByKey(userId);
		model.addAttribute("user",user);
		return "userInfofromdb";
	}
	@RequestMapping(value="/regUser")
	public String regUser(Model model){
		model.addAttribute("title","用户注册");
		return "regUser";
	}
	@RequestMapping(value="/signup",method = RequestMethod.POST)
	public String signup(@ModelAttribute("user") User user, Model model){
		//user.setUserId();
		//model.addAttribute("title","用户注册");
		return "regUser";
	}
	
	@Autowired
	public IUserService<User> userService;

	public IUserService<User> getUserService() {
		return userService;
	}
	public void setUserService(IUserService<User> userService) {
		this.userService = userService;
	}
}
