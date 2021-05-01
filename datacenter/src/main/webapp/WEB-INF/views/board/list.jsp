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
<%-- <link rel="apple-touch-icon-precomposed" href="">
<link rel="apple-touch-icon" href="">
<link rel="stylesheet" href="${rootPath }/resources/css/reset.css" />
<link rel="stylesheet" href="${rootPath }/resources/css/style.css" /> --%>
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
 		$("#btnWrite").click(function(){
 			//페이지 주소 변경(이동)
 			location.href="${path}/datacenter/board/write";
 		});
 	}); 
 
 </script>
</head>

 <style>
      	 /* table {
		    width: 100%;
		    border: 1px solid #444444;
		  }
		  th, td {
		    border: 1px solid #444444;
  		} */
  		@charset "utf-8";

/* 전체 옵션 */
* {
        margin: 0 auto;
        padding: 0;
        font-family: 'Malgun gothic','Sans-Serif','Arial';
}
a {
        text-decoration: none;
        color:#333;
}
ul li {
        list-style:none;
}

/* 공통 */
.fl {
        float:left;
}
.tc {
        text-align:center;
}

/* 게시판 목록 */
#board_area {
        width: 900px;
        position: relative;
}
.list-table {
        margin-top: 40px;
}
.list-table thead th{
        height:40px;
        border-top:2px solid #09C;
        border-bottom:1px solid #CCC;
        font-weight: bold;
        font-size: 17px;
}
.list-table tbody td{
        text-align:center;
        padding:10px 0;
        border-bottom:1px solid #CCC; height:20px;
        font-size: 14px;
        color:#333;
}
#btnWrite {
        position: absolute;
        margin-top:20px;
        right: 0;
        color:#333;
}

ul li {list-style-type: none; float: left; margin-left: 20px;}
</style>
<body>
      
      <h5>게시글 목록</h5>
      <button type="button" id="btnWrite" >글쓰기</button>  <!-- onclick="location='write'" -->
      
      <table class ="list-table" style="border:1px solid black;" width="600px">
      	<tbody>
      	<tr>
      		<th>번호</th>
      		<th>제목</th>
      		<th>이름</th>
      		<th>작성일</th>
      		<!-- <th>조회수</th> -->
      	</tr>
       	<c:forEach var="row" items="${list }" varStatus="seq">
      	<tr>
      		<td>${seq.count }</td>
      		<td><a href="${path}/datacenter/board/view?bno=${row.bno }">${row.title }</a></td>
      		<a href="${path}/datacenter/board/comment?bno=${row.bno }"></a>
      		<td>${row.writer }</td>
      		<td>
				<fmt:formatDate value="${row.regdate }" pattern="yyyy-MM-dd HH:mm:ss"/>      		
      		</td>
      		<%-- <td>${row.viewcnt }</td> --%>
     	</tr>
     	</c:forEach>
     	</tbody>  
      </table>
    </div>    
  </div>
</body>
</html>