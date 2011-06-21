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
	
	@Inject
	public IUserService<User> userService;
	
	@RequestMapping(value="/getInfo",method=RequestMethod.GET)
    public String getInfo(@RequestParam("userId") String id,Model model){
		model.addAttribute("user",id);
		logger.info("=="+id+"==");
    	return "userInfo";
    }
	@RequestMapping(value="/getInfo2/{userId}")
	public String getInfo2(@PathVariable String userId, Model model){
		model.addAttribute("user",userId);
		User arguser = new User();
		arguser.setUserId(userId);
		User user = userService.findByKey(arguser);
		System.out.println(user.getNickName());
		return "userInfo";
	}
	@RequestMapping(value="/getInfo3/{userId}")
	public String getInfo3(@PathVariable String userId, Model model){
		User arguser = new User();
		arguser.setUserId(userId);
		User user = userService.findByKey(arguser);
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
		user.setCreateDate(DateUtils.getCurrDate());
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
