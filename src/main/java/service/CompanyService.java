package service;

import java.util.List;

import criTest.SearchCriteria;
import vo.CompanyVO;

public interface CompanyService {
	
	List<CompanyVO> checkList(CompanyVO vo);
	public int searchRowsCount(SearchCriteria cri);
	public List<CompanyVO> searchList(SearchCriteria cri);
	
	List<CompanyVO> selectList(); //selectList()
	CompanyVO selectOne(CompanyVO vo); //selectOne
	int insert(CompanyVO vo); //insert
	int update(CompanyVO vo); //update
	int delete(CompanyVO vo); //delete

}