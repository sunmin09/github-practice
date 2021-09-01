// ** 예약일/회차선택
  $('#rpdate').click(function() {
		$.ajax({
			type:'Get',
			url: 'rpdatef',
			success:function(resultPage) {
				$('#resultArea1').html(resultPage);
			},
			error:function() {
				$('#resultArea1').html("~~ rpdatef Error ~~");
			}
		}); //ajax
  }); //rpdatef_click	

// => AjaxJoin 
  $('#ajoin').click(function() {
  // ** Ajax에서 input Data (Value) 처리방법
  // 1) Form 의 serialize()
  // => input Tag 의 name 과 id 가 같아야 함.	
  // => 직렬화 : multipart 타입은 제외 시켜야 함.	
  
	//var formData = $('#myForm').serialize();  
	// => 처리하지 못하는 값(예-> file Type) 은 스스로 제외시킴 
	//var formData = $('#myForm:not(#rid)').serialize();
	// => rid 만 제외시키는 경우 (보류:적용안됨)
		
  // 2) 객체화	
  // => 특정 변수 (객체형) 에 담기		
  // => 특별한 자료형(fileType: UpLoadFilef) 적용안됨.		
/*	var formData = {
		id:$('#id').val(),
		password:$('#password').val(),
		name:$('#name').val(),
		lev:$('#lev').val(),
		birthd:$('#birthd').val(),
		point:$('#point').val(),
		weight:$('#weight').val(),
		rid:$('#rid').val()
	} 		
*/	
// 3) FormData() 객체 1
// => IE10부터 부분적으로 지원되며, 크롬이나 사파리, 파이어폭스같은 최신 브라우져에서는 문제 없이 동작
// => append 메서드 이용
// => 모든 자료형의 특성에 맞게 적용가능
//    이미지등의 file 업로드 가능한 폼데이터 처리 지원 객체	
/*	var formData = new FormData();
	formData.append('id',$('#id').val());
	formData.append('password',$('#password').val());
	formData.append('name',$('#name').val());
	formData.append('lev',$('#lev').val());
	formData.append('birthd',$('#birthd').val());
	formData.append('point',$('#point').val());
	formData.append('weight',$('#weight').val());
	formData.append('rid',$('#rid').val());
	
	// => Ajax 의  FormData 는  이미지를 선택하지 않으면 append시 오류 발생
	//    하기 때문에 이를 확인 후 append 하도록 함
	//    이때 append 를 하지 않으면  서버의 vo.uploadfilef 에는 null 값이 전달됨.
	if ($('#uploadfilef')[0].files[0] != null)
			formData.append('uploadfilef',$('#uploadfilef')[0].files[0]);
*/
	// ** 관련속성	
	// => enctype: 'multipart/form-data', // 생략 가능
	// => processData:false, // false로 선언시 formData를 string으로 변환하지 않음
	// => contentType:false, // false로 선언시 content-type 헤더가 multipart/form-data로 전송되게 함

// 4) FormData() 객체 2 : all append ...	
// => 특별한 자료형(fileType: UpLoad) 취급가능.
// 4.1) 생성시에 인자로 form 사용 _JS	
// 	var formData = new FormData(document.getElementById('myForm')); 
// 4.2) 생성시에 인자로 form 사용 _JQ
	//var formData = new FormData($('#myForm')); -> Error 인식안됨	
	var formData = new FormData($('#myForm')[0]);

	alert("join Test formData 4.2 #myForm => "+formData);
	$.ajax({
		type:'Post',
		url: 'join',
/*		=> FormData 객체로 fileUpload 시 enctype, processData, contentType 추가
		enctype: 'multipart/form-data', // 생략가능 */
		processData:false,
		contentType:false,   
		data: formData,
		success:function(resultPage) {
			$('#resultArea1').html(resultPage);
		},
		error:function() {
			$('#resultArea1').html("~~ AjaxJoinF Error ~~");
		}
	}); //ajax
  }); //ajoinf_click	
	
}); //ready

// ** Ajax 의  input Tag 의  Data (Value) 처리방법
// 1) Form 의 serialize()
// => input Tag 의 name 과 id 가 같아야 함.	
// => 직렬화 : multipart 타입은 제외 시켜야 함.	

// var formData = $('#myForm').serialize();


// 2) 객체화	
// => 특정 변수 (객체형) 에 담기
//	     {...}
	
// 3) FormData() 객체 1 : append ...
// => FormData는 Ajax를 통해 이미지등이 업로드가 가능하도록 지원하는 폼 데이터 객체	
// => 자료 특성에 맞게 적용 가능  : fileType (UpLoad) 가능
	
// 4) FormData() 객체 2 : all append ...	

/* => 아래는 필요 없게됨
		id:$('#id').val(),
		password:$('#password').val(),
		name:$('#name').val(),
		lev:$('#lev').val(),
		birthd:$('#birthd').val(),
		point:$('#point').val(),
		weight:$('#weight').val(),
		rid:$('#rid').val()
		//uploadfilef:''  => Server Error : typeMismatch  
*/


