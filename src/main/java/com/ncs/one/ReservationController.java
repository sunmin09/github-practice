package com.ncs.one;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import service.ReservationService;
import vo.PmemberVO;
import vo.ReservationVO;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService service;
	
	//예약현황 리스트
	@RequestMapping(value = "/rlist")
	public ModelAndView rlist(ModelAndView mv) {

	List<ReservationVO> list = service.selectList();
	if (list != null) {
		mv.addObject("Banana", list);
	}else {
		mv.addObject("message", "~~ 출력할 자료가 한건도 없습니다 ~~") ;
	}
	mv.setViewName("reservation/reservationList");
	return mv;
	} //rlist
	
	
	//예약확인 -> 수정
	//매개변수에 회원VO 추가 
	@RequestMapping(value = "/rdetail")
	public ModelAndView mdetail(HttpServletRequest request, ModelAndView mv, 
			ReservationVO vo) {

		HttpSession session = request.getSession(false);
		if (session!=null && session.getAttribute("loginID") !=null) {
			vo.setId ((String)session.getAttribute("loginID"));

			if  (request.getParameter("id")!=null) vo.setId(request.getParameter("id"));

			vo=service.selectOne(vo);
			if (vo!=null) {
				mv.addObject("Apple", vo);
			}else {
				mv.addObject("message","~~ 정보를 찾을 수 없습니다, 로그인 후 이용하세요 ~~");
				mv.setViewName("pmember/loginForm");
			}
		}else {
			// 로그인 정보 없음
			mv.addObject("message","~~ 로그인 정보 없습니다, 로그인 후 이용하세요 ~~");
			mv.setViewName("pmember/loginForm");
		}
		return mv;
	} //rdetail
	
	
	// ** 예약접수 메인 폼
	@RequestMapping(value = "/rmainf")
	public ModelAndView rmainf(ModelAndView mv) {
		mv.setViewName("reservation/mainForm");
		return mv;
	} //rmainf
	
	
	// ** 예약하기
	// 요청명, 클래스명 수정하기
	@RequestMapping(value = "/rmain")
	public ModelAndView rmain(HttpServletRequest request, ModelAndView mv, ReservationVO vo) throws IOException  {
			
		if (service.insert(vo) > 0) {
				// 예약 성공 -> 예약확인 유도
			mv.addObject("message", "~~ 예약완료 완료, 로그인 하세요 ~~");
			mv.setViewName("reservation/reservationConf");
		}else {
				// 예약 실패 -> 재예약 유도
			mv.addObject("message", "~~ 예약접수 오류, 다시 하세요 ~~");
			mv.setViewName("reservation/mainForm");
		}
		return mv;
	} //rmain
	
	
	// ** 예약일/회차 선택 폼
	@RequestMapping(value = "/rpdatef")
	public ModelAndView rpdatef(ModelAndView mv) {
		mv.setViewName("reservation/step1");
		return mv;
	} //rpdatef
	
	
	// ** 예약수정
	// 예약확인창 요청명 수정
	@RequestMapping(value = "/rupdate")
	public ModelAndView rupdate(HttpServletRequest request, ModelAndView mv, 
						ReservationVO vo, RedirectAttributes rttr) throws IOException {
		
		if (service.update(vo) > 0) {
				// Update 성공 -> 예약확인창
			rttr.addFlashAttribute("message", "~~ 예약정보 수정 성공 ~~");
			mv.setViewName("redirect:rconf");
		}else {
				// Update 실패 -> 재수정 할 수 있도록 유도
			rttr.addFlashAttribute("message", "~~ 정보수정 오류, 다시 하세요 ~~");
			mv.setViewName("redirect:rdetail?id="+vo.getId()+"&jcode=U");
		}
		return mv;
	} //rupdate
		
	
	// ** 예약취소
	// 매게변수에 회원VO 추가
	// 예약확인창 변수명 수정
	@RequestMapping(value = "/rdelete")
	public ModelAndView mdelete(HttpServletRequest request, ModelAndView mv, 
			ReservationVO vo, RedirectAttributes rttr) {
			
			// => 삭제 대상 -> vo 에 set
		HttpSession session = request.getSession(false);
		String loginID = (String)session.getAttribute("loginID");

		if (session!=null && loginID!=null) {
				// ** 삭제 가능 => message, home.jsp
				// => 삭제대상 확인, session 삭제여부 확인 
			vo.setId(loginID);
				
			if (service.delete(vo) > 0) {
					// 삭제성공
				session.invalidate();  // session 삭제 
				rttr.addFlashAttribute("message", "~~ 예약취소 성공 !!  ~~");
				mv.setViewName("redirect:rconf");
			}else { // 삭제실패
				rttr.addFlashAttribute("message", "~~ 예약취소 오류 !!  다시 하세요 ~~");
				mv.setViewName("redirect:rdetail?id="+vo.getId());
			}
		}else {
				// 탈퇴 불가능 => message, loginForm.jsp 
			mv.addObject("message", "~~ 예약취소 불가능 !!  로그인후 하세요 ~~");
			mv.setViewName("member/loginForm"); //회원테이블에 맞게 수정
		}
		return mv;
	} //rdelete


}//class
