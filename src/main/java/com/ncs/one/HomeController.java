  
package com.ncs.one;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.PmemberService;

@Controller
public class HomeController {
	//@Autowired
	//PmemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} //home
	
	@RequestMapping(value = "/bcrypt")
	public ModelAndView bcrypt(ModelAndView mv) {
		// PasswordEncoder (Interface) -> BCryptpasswordEncoder 구현 클래스 
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password="12345!";
		
		String digest1 = passwordEncoder.encode(password);
		System.out.println("** digest1 => "+digest1);
		System.out.println("** matches1 => "+passwordEncoder.matches(password, digest1));
		mv.setViewName("redirect:home");
		return mv;
	}//crypt

	// ** Access_denied-handler (403 오류 화면 출력하기)
	@RequestMapping(value = "/accessError")
	public ModelAndView accessError(ModelAndView mv) {
		mv.setViewName("errorPage/exception_403");
		return mv;
	}//error
	

		//@RequestMapping(value = "/idCheck")
	   // @ResponseBody
	    //public int idCheck(@RequestParam("id") String id){
	    //    logger.info("userIdCheck 진입");
	    //    logger.info("전달받은 id:"+id);
	     //   int result = service.idCheck(id);
	    //   logger.info("확인 결과:"+result);
	    //    return result;
	   // }
}
