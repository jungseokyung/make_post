<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Data Center</title>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta name="format-detection" content="telephone=no">
<meta http-equiv="x-rim-auto-match" content="none">
<meta name="Generator" content="">
<meta name="naver-site-verification" content="4ce26d1f866371ed9750101df8155baa22037201"/>
<meta name="keywords" content="" />
<meta name="Description" content="" />
<script src="${rootPath }/resources/js/jquery-2.2.4.min.js"></script>
<script>
/*   $(function(){
    var pop = $(".pop");
    pop.on("click",function(){
      $(this).fadeOut(200);
    });
  });
 */	
 	$(document).ready(function(){
 		/* $("#btnSave").click(function(){
 			if(confirm("저장하시겠습니까?")){
 				document.form1.action="${path}/datacenter/board/insert";
 				document.form1.submit();//어디로 submit?
 			}
 		});
 		*/
 		//$(document).ready(function(){
 		$("#btnCancel").click(function(){
 			if(confirm("취소하시겠습니까?")){
 				document.form1.action="${path}/datacenter/";
 				//document.form1.submit();//어디로 submit?
 			}
 		});//취소버튼
	
 	 	$("#btnSave").click(function(){
 			
 			var title = $('#title').val();
 			var content = $('#content').val();
 			var writer = $('#writer').val();
 			
 			//하나라도 공백이 있을시,
 			if (title=="" || content=="" || writer=="" ){
	 			if (title == ""){
	 				alert("제목을 입력하세요");
	 				document.form1.title.focus();
	 				return;	
	 			}
	 			if (content == ""){
	 				alert("내용을 입력하세요");
	 				document.form1.content.focus();
	 				return;	
	 			}
	 			if (writer == ""){
	 				alert("이름을 입력하세요");
	 				document.form1.writer.focus();
	 				return;	
	 			}
 			}//큰 if문
 			
 			else {
 				if(confirm("저장하시겠습니까?")){
 	 				document.form1.action="${path}/datacenter/board/insert";
 	 				document.form1.submit();//어디로 submit?
 	 				alert(title);
 	 				alert(content);
 	 				alert(writer);
 	 			}	
 			}
		
 			//document.form1.action = "${path}/board/update"
 			//폼에 입력한 데이터를 서버로 전송
 			/* document.form1.submit();
 			alert(document.form1); */
 		});//저장버튼
 	});//document_ready 
 
 </script>
</head>

 <style>
      	 table {
		    width: 100%;
		    border: 1px solid #444444;
		  }
		  th, td {
		    border: 1px solid #444444;
  		}
</style>
<body>
      
      <h5>게시글 작성</h5>
      <form name="form1" action="${path }/datacenter/board/insert" method="post" >
      <%-- <div>작성일자write : <fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd HH:mm:ss" />
      </div>
      <div> 조회수 : ${dto.viewcnt}</div> <!-- ${dto.viewcnt} --> --%>
      <div> 제목
      <input name="title" id="title" size="80"  placeholder="제목을 입력해주세요."> <!--${dto.title }  -->
      </div>
      <div>내용
      	<textarea name="content" id="content" rows="10" cols="80" placeholder="내용을 입력해주세요."></textarea><!--${dto.content }  -->  
      </div>
      <div> 이름
	      <input name="writer" id="writer" size="80"  placeholder="이름을 입력해주세요."> <!--${dto.title }  -->
      </div>
      <div style="width:650px; text-align: center;">
     	 <!--게시물번호를 hidden으로 처리  -->
      <%-- 	<input type="hidden" name="bno" value="${bno}"> --%> <!--${dto.bno}  -->
      	<button type="button" id="btnSave">확인</button>
      	<button type="reset" id="btnCancel">취소</button>
      </div>
      </form>
    </div>    
  </div>
</body>
</html>