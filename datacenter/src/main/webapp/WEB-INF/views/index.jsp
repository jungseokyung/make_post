<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="apple-touch-icon-precomposed" href="">
<link rel="apple-touch-icon" href="">
<link rel="stylesheet" href="${rootPath }/resources/css/reset.css" />
<link rel="stylesheet" href="${rootPath }/resources/css/style.css" />
<script src="${rootPath }/resources/js/jquery-2.2.4.min.js"></script>
<script>
  $(function(){
    var pop = $(".pop");
    pop.on("click",function(){
      $(this).fadeOut(200);
    });
  });
</script>
</head>
<body>
    <div id="wrap">
        <div class="inner submitPop">
      <div class="form_ti">
        <img src ="${rootPath }/resources/img/logo_title.gif" class="">
      </div>
      
      <div class="form_cont_info">
          <ul class="form_info">
            <img src="${rootPath }/resources/img/info_img.jpg">
            <li class="form_txt" >
              <strong>U-PRIVACY SAFER CLOUD</strong>는 클라우드 환경에서 개인정보 유출을 차단하고자 하는 홈페이지 및 웹게시판 내에서 개인정보를 필터링함으로써 개인정보 유출을 방지하는 최적의 솔루션입니다.
            </li>
            <li>
                <dl>
                 <dt>제품 개요</dt>
                 <dd>- 홈페이지, 웹게시판 등을 통해서 게시판과 첨부파일에 의해 개인정보가 유출되지 않도록  실시간으로 차단<br>
                    - 개인정보 종합분석을 통한 체계적이고 자동화된 제품 <br>
                    - 개인정보 노출사고 대응 체계를 구축</dd>
                </dl>
            </li>
            <li>
              <dl>
                 <dt>제품 특징</dt>
                 <dd>- 다양한 패턴 필터링 : 주민번호, 신용카드번호, 여권번호, 운전면허번호, 핸드폰  일반전화, 건강 보험, 이메일 주소, 통장계좌 등 다양한 개인정보 유형 필터링<br>
                    - 각종 파일포맷 검사 : 첨부파일( doc, xls, ppt, docx, xlsx, pptx, Open Document Format(odt, ods, odp, odg, odf) 한글, PDF, 압축 파일 (zip,tar) 등) 내 개인  정보 탐지 및 차단, HTML, HTM, XML, TEXT, DAT 등의 기본 파일 내 개인 정보 탐지 및 차단 <br>
                    - 성능향상 : 파일 정보 캐싱 기능으로 성능 향상 (핵심기술 지적재산권 보유)</dd>
                </dl>
            </li>
            <li>
              <dl>
                 <dt>서비스 제품 신청하기</dt>
                <dd id="serviceConfirm">
                    <div class="form_fee">
                        <div class="card-header">BASIC</div>
                        <div class="card-body">Number of Call : 300 per Minutes<br>
                        Number of System : 1 System<br>
                        Dashboard Service : No<br>
                        XXX KRW / Month
                        <button type="button" class="btn btn-lg btn-block btn-primary" >신청하기</button>
                        </div>
                    </div>
                    <div class="form_fee">
                        <div class="card-header">STANDARD</div>
                        <div class="card-body">Number of Call : 1000 per Minutes<br>
                        Number of System : 1 System<br>
                        Dashboard Service : No<br>
                        XXX KRW / Month
                        <button type="button" class="btn btn-lg btn-block btn-primary" >신청하기</button>
                        </div>
                    </div>
                    <div class="form_fee">
                        <div class="card-header">PREMIUM</div>
                        <div class="card-body">Number of Call : 3000 per Minutes<br>
                        Number of System : Unlimit<br>
                        Dashboard Service : Yes<br>
                        XXX KRW / Month
                        <button type="button" class="btn btn-lg btn-block btn-primary" >신청하기</button>
                        </div>
                    </div>
                </dd>
              </dl>
            </li>            
          </ul>       
      </div>
      
    </div>    
  </div>
</body>
</html>