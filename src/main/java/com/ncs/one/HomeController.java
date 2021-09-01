package com.ncs.one;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! The client locale is {}.", locale);
		// ** Logger Message Test
		// 1. {} 활용
		logger.info("Test 1 Logger Message : {}.","안녕하세요 ~~");
		String name="홍길동";
		int age=100;
		logger.info("Test 2 name={} , age={}",name,age);
		// 2. 직접 출력
		logger.info("Test 3 name="+name+", age="+age);
		// 3. 로깅레벨 조정 Test (log4j.xml 의)
		// => root Tag 에서 출력 level 조정 (system 오류 level조정) 
		//	    <root> <priority value 값 >
		// => <logger name="com.ncs.green"> 에서 출력 level 조정
		//      <level value="DEBUG" />
		// => 이 두곳의 값을 warn (default) , error, debug, trace
		logger.warn("Test 4 로깅레벨 warn => "+name);
		logger.error("Test 4 로깅레벨 error => "+name);
		logger.debug("Test 4 로깅레벨 debug => "+name);
		logger.trace("Test 4 로깅레벨 trace => "+name);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	} //home
	
	// ** Reservation Main Form	
		@RequestMapping(value = "/rmainf")
		public ModelAndView rmainf(ModelAndView mv) {
			mv.setViewName("reservation/mainForm");
			return mv;
		} //rmainf
	
} //class
