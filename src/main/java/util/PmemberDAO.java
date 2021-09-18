package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import criTest.SearchCriteria;
import vo.PmemberVO;

@Repository
public class PmemberDAO {
	
	@Autowired
	private SqlSession sqlSession;	
	private static final String NS = "one.mapper.PmemberMapper.";
	
	

	
	
	
	
	
	// ** ID 중복 확인
	public int idCheck(PmemberVO vo) {
		return sqlSession.selectOne(NS+"idCheck", vo);
	}
	
	
	
	// ** 패스워드 확인
	public int passCheck(PmemberVO vo) {
		int result = sqlSession.selectOne(NS+"passCheck", vo);
		return result;
	}
	

	
	// ** ID 찾기 ------------------------------
	public PmemberVO pFindId(PmemberVO vo) {
		return sqlSession.selectOne(NS+"pFindId", vo);
	}
	
	// ** Password 찾기
	public PmemberVO pFindPw(PmemberVO vo) {
		return sqlSession.selectOne(NS+"pFindPw", vo);
	} // --------------------------------------
	
	
	// ** SearchPageList -----------------------
	public int searchRowsCount(SearchCriteria cri) {
		return sqlSession.selectOne(NS+"searchRowsCount", cri);
	} //searchRowsCount
	
	public List<PmemberVO> searchList(SearchCriteria cri) {
		return sqlSession.selectList(NS+"searchList", cri);
	} //searchList ------------------------------
	
	
	// ** selectList
	public List<PmemberVO> selectList() {
		return sqlSession.selectList(NS+"selectList");
	}
	
	// ** selectOne
	public PmemberVO selectOne(PmemberVO vo) {
		return sqlSession.selectOne(NS+"selectOne", vo);
	}
	
	// ** Join : insert
	public int insert(PmemberVO vo) {
		return sqlSession.insert(NS+"insert", vo);
	}
	
	// ** update
	// => pkey 일반적으로 수정하지 않음.
	public int update(PmemberVO vo) {
		return sqlSession.update(NS+"update", vo);
	}
	
	// ** delete
	public int delete(PmemberVO vo) {
		return sqlSession.delete(NS+"delete", vo);
	}
	
} //class