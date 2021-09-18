package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class CompanyVO {
	private String cno;
	private String cpw;
	private String cname;
	private String ctype;
	private String cinfo;	
	private String ctel;
	private String caddr;
	private String cdate;
	private String cdate_s;
	private String cdate_e;	
	private String period_s;
	private String period_e;	
	private String cimage;
	private String cprice;
	private String csite;
	private String cpark;
	
	private String comUploadfile; // Table에 저장된 경로 및 파일명 처리를 위한 필드
	private MultipartFile comUploadfilef; // form 의 Image 정보를 전달받기 위한 필드
	
	String[] comCheck;
}
