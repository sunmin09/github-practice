package com.ncs.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService service;
	
	// ** Reservation PickDate Form
	@RequestMapping(value = "/rpdatef")
	public ModelAndView rpdatef(ModelAndView mv) {
		mv.setViewName("reservation/rpDatef");
		return mv;
	} //rpdatef
	
	

}//class
