package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.ReservationDAO;
import vo.ReservationVO;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDAO dao;
	
	@Override
	public int insert(ReservationVO vo) {
		return dao.insert(vo);
	}//insert

}//class
