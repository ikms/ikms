package net.sf.ssi.controller;

import java.util.List;

import javax.inject.Inject;

import net.sf.ikms.util.CommonUtils;
import net.sf.ikms.util.date.DateUtils;
import net.sf.ssi.domain.User;
import net.sf.ssi.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@Inject
	public IUserService<User> userService;
	
	@RequestMapping(value="/getInfo3/{userId}")
	public String getInfo3(@PathVariable String userId, Model model){
		User arguser = new User();
		arguser.setUserId(userId);
		User user = userService.loadByKey(arguser);
		logger.info(userId);
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
		user.setUserId(CommonUtils.getGUID());
		user.setNickName(user.getNickName());
		user.setCreateDate(DateUtils.getCurrentDateDate());
		userService.save(user);
		model.addAttribute("title","用户注册");
		return "redirect:query.html";
	}
	
	@RequestMapping(value="/query")
	public String query(Model model){
		List<User> userList = userService.find(null);
		model.addAttribute("userList",userList);
		return "query";
	}
}
