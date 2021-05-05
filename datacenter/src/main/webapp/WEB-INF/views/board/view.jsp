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
<!-- <meta http-equiv="X-UA-Compatible" content="IE=Edge" /> -->
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
	 $("#btnDelete").click(function(){
			if(confirm("삭제하시겠습니까?")){
				document.form1.action="${path}/datacenter/board/delete";
				document.form1.submit();
			}
		});
	 	$(document).ready(function(){
	 		
	 	});//삭제버튼	
	 		
 	 	$("#btnUpdate").click(function(){
 	 		if(confirm("수정하시겠습니까?")){
				document.form1.action="${path}/datacenter/board/update";
				document.form1.submit();
			}
 			var title = $('#title').val();
 			var content = $('#content').val();
 			var writer = $('#writer').val();
 			
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
 			/* document.form1.action = "${path}/datacenter/board/update"
 			//폼에 입력한 데이터를 서버로 전송
 			document.form1.submit(); */
 		});//수정버튼
 		
 		//댓글 등록 버튼
		$("#btnSave").click(function(){
 			
 			var user_id = $('#user_id').val();
 			var comment = $('#comment').val();
 			var writer = $('#writer').val(); 
 			var bno=$('#bno').val();
 			
 			//하나라도 공백이 있을시,
 			if (user_id=="" || comment=="" || writer=="" ){/*   */
	 			if (user_id == ""){
	 				alert("제목을 입력하세요");
	 				document.form2.user_id.focus();
	 				return;	
	 			}
	 			if (comment == ""){
	 				alert("내용을 입력하세요");
	 				document.form2.comment.focus();
	 				return;	
	 			}
	 			if (writer == ""){
	 				alert("이름을 입력하세요");
	 				document.form2.writer.focus();
	 				return;	
	 			}
 			}//큰 if문
 			
 			else {
 				if(confirm("등록하시겠습니까?")){
 	 				document.form2.action="${path}/datacenter/board/createComment";
 	 				document.form2.submit();//어디로 submit?
 	 				alert("bno : " +bno); 
					alert(user_id);
 	 				alert(comment);
 	 				alert(writer);
 	 			}	
 			}
		
 		/* 	document.form2.action = "${path}/board/update"
 			//폼에 입력한 데이터를 서버로 전송
 			document.form2.submit();
 			alert(document.form2); */
 		});//저장버튼
 	});
 
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
      
      <h5>게시글 상세보기</h5>
      <form name="form1" method="post">
      <div>작성일자! : <fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd HH:mm:ss" />
      </div>
      <div> 조회수 : ${dto.viewcnt}</div> <!-- ${dto.viewcnt} -->
      <div> 제목
      <input name="title" id="title" size="80" value="${dto.title }" placeholder="제목을 입력해주세요."> <!--${dto.title }  -->
      </div>
      <div>내용
      	<textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요.">${dto.content }</textarea>  
      </div>
      <div> 이름
	      <input name="writer" id="writer" size="80" value="${dto.writer }" placeholder="이름을 입력해주세요."> <!--${dto.title }  -->
      </div>
      <div style="width:650px; text-align: center;">
     	 <!--게시물번호를 hidden으로 처리  -->
      	<input type="hidden" name="bno" value="${dto.bno}" > <!--${dto.bno} 이부분 상관 없는듯 -->
      	<button type="button" id="btnUpdate">수정</button>
      	<button type="button" id="btnDelete">삭제</button>
      </div>
      </form>
    </div>    
  </div>
  <!-- 댓글출력 -->
  <div id=listComment>
  	<ol class="replyList">
  		<c:forEach items="${replyList }" var="replyList">
  			<li>
  			<p>
  			작성자 : ${replyList.writer }<br />
  			작성 날짜 : : <fmt:formatDate value="${replyList.regdate }" pattern="yyyy-MM-dd HH:mm:ss" />
			</p>
			
			<p>내용 : ${replyList.comment }</p>  			
  			</li>
  		</c:forEach>
  	</ol>
  </div>	
  <!--댓글 입력  -->
  <%-- <h5>댓글 입력</h5>
      <form name="form2"  method="post" action="${path }/datacenter/board/createComment"> 
      <div>내용
      	<textarea name="comment" id="comment" rows="1" cols="80" placeholder="댓글을 입력해주세요."></textarea><!--${dto.content }  -->  
      </div>
      <div> 이름
	      <input name="writer" id="writer" size="80"  placeholder="이름을 입력해주세요."> ${dto.bno} 
      </div>
      <div style="width:650px; text-align: center;">
      <div> 아이디
      <input name="user_id" id="user_id" size="80"  placeholder="아이디을 입력해주세요."> <!--${dto.title }  -->
   	  </div>
      <div style="width:650px; text-align: center;">
     	 <!--게시물번호를 hidden으로 처리  -->
        <input type="hidden" name="cno" value="${cno}"> <!--${dto.bno}  -->
        <input type="hidden" name="bno" value="${dto.bno}">  <!--${dto.bno}  -->
        <c:set var="bno" value="${bno }"</c:set>
        <c:out value="${bno }" </c:out>
        <td><a href="${path}/datacenter/board/view?bno=${row.bno }"></a></td>
      	<button type="button" id="btnSave">등록</button>
      	<button type="reset" id="btnCancel">취소</button>
      </div>
      </form> --%>
    </div>    
  </div>
  
</body>
<%@ include file="comment.jsp" %>
</html>