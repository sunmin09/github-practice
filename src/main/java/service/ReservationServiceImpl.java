package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.ReservationDAO;
import vo.ReservationVO;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	ReservationDAO dao;
	
	@Override
	public List<ReservationVO> selectList() {
		return dao.selectList();
	} //selectList()
	@Override
	public ReservationVO selectOne(ReservationVO vo) {
		return dao.selectOne(vo);
	} //selectOne
	
	@Override
	public int insert(ReservationVO vo) {
		return dao.insert(vo);
	}//insert
	@Override
	public int update(ReservationVO vo) {
		return dao.update(vo);
	} //update
	@Override
	public int delete(ReservationVO vo) {
		return dao.delete(vo);
	} //delete

}//class
