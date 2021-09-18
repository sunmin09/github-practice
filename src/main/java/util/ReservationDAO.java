package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.ReservationVO;

@Repository
public class ReservationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NS = "one.mapper.ReservationMapper.";
	
	// ** selectList
	public List<ReservationVO> selectList() {
		return sqlSession.selectList(NS+"selectList");
	} //selectList

	// ** selectOne
	public ReservationVO selectOne(ReservationVO vo) {
		return sqlSession.selectOne(NS+"selectOne", vo);
	} //selectOne
	
	// ** 예약접수 : insert
	public int insert(ReservationVO vo) {
		return sqlSession.insert(NS+"insert", vo);
	} //insert
	
	// ** 예약정보수정 : update
	// => pkey 일반적으로 수정하지 않음.
	public int update(ReservationVO vo) {
		return sqlSession.update(NS+"update", vo);
	} //update

	// ** 예약취소 : delete
	public int delete(ReservationVO vo) {
		return sqlSession.delete(NS+"delete",vo);
	} //delete

}//class
