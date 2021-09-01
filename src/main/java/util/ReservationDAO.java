package util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ReservationVO;

@Repository
public class ReservationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NS = "one.mapper.ReservationMapper.";
	
	// ** rpDatef : insert
	public int insert(ReservationVO vo) {
		return sqlSession.insert(NS+"insert", vo);
	} //insert

}//class
