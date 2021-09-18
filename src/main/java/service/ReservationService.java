package service;

import java.util.List;

import vo.ReservationVO;

public interface ReservationService {
	
	List<ReservationVO> selectList(); //selectList()
	ReservationVO selectOne(ReservationVO vo); //selectOne
	int insert(ReservationVO vo); //insert
	int update(ReservationVO vo); //update
	int delete(ReservationVO vo); //delete

}//class
