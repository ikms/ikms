package net.sf.ssi.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import net.sf.ikms.util.CommonUtils;
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
		System.out.println(user.getUserName());
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
		user.setNickName(user.getUserName());
		user.setUserSource("reg");
		Date dateTime = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = format.format(dateTime);
		ParsePosition pos = new ParsePosition(0);
//		Date dateTime = format.parse(dateString, pos);
		user.setCreateDate(format.parse(dateString, pos));
		userService.save(user);
		model.addAttribute("title","用户注册");
		return "redirect:query.html";
	}
	@RequestMapping(value="/query")
	public String query(Model model){
		//User user = new User();
		//user.setUserId("1");
		List<User> userList = userService.find(null);
		model.addAttribute("userList",userList);
		return "query";
	}
//
//	public IUserService<User> getUserService() {
//		return userService;
//	}
//	public void setUserService(IUserService<User> userService) {
//		this.userService = userService;
//	}
}
