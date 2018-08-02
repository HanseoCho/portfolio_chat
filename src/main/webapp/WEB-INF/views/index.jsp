<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function(){
    	function idCheck(){
    		var result = true;
    		$.ajax({type:"get",async:false,url:"/chat/user/".concat($("#regId").val())})
    		.done(function(data){
    			if(data == "비중복"){
    				result = true;
    			}
    			else{
    				result = false;
    			}
    		})
    		return result;
    	}
    	function nullCheck(){
    		for(var i=0;i<$(".regNotnull").length;i++){
    			if(i==0){
        			if($(".regNotnull").eq(i).val().length <3){
        				alert("아이디를 3글자 이상 입력해주세요")
        				return false;
        			}
    			}
    			else if(i==1){
        			if($(".regNotnull").eq(i).val().length <6){
        				alert("패스워드를 6글자 이상 입력해주세요")
        				return false;
        			}
    			}
    			else if(i==2){
    				if($(".regNotnull").eq(i).val().length == 0){
        				alert("이름을 입력해주세요");
        				return false;
        			}
        			else{
						return true;
        			}
    			}
    		}
    	}
    	
        $("#regCall").on("click",function(){
            $("#reg_form").css("display","block");
            $("#reg_back").css("display","block");
        });
        $("#regCancle").on("click",function(){
            $("#reg_form").css("display","none");
            $("#reg_back").css("display","none");
        })
        /* 회원가입 */
        //아이디 중복확인 아이디쓰고 다른곳 클릭시 메소드돌아감, 응답은 중복, 비중복
        $("#regId").on("blur",function(){
        	if(idCheck() == true){
        		alert("사용 가능한 아이디 입니다.")
        	}
        	else{
        		alert("아이디가 중복입니다.\n다른 아이디를 사용해주세요")
        	}

        })
        
        $("form[name=regForm]").on("submit",function(){
         	if(nullCheck()==false){
         		return false;
         	}
         	
         	if(idCheck()==false){
        		alert("아이디가 중복입니다.");
        		return false;
        	} 
         	
         	var queryString = $("form[name=regForm]").serialize();
        	console.log(queryString);
			$.ajax({url:"/chat/user",type:"POST",data:queryString})
			.done(function(data){
				if(data == "가입성공"){
					alert("회원가입을 축하합니다~");
				}
				else{
					alert("회원가입실패 다시 확인해주세요");
				}
			}); 
			return faslse;
        });
        
        /*---------- */
    });
</script>
</head>
<body>
    <header class="bcen text_center">
        <h3>구챗에 오신걸 환영합니다</h3><hr>
        <h5>가나다라마바사얍</h5>
        <form>
            ID :<input type="text" placeholder="id.."><br>
            PW :<input type="text" placeholder="pw.."><br/>
            <input type="submit" value="로그인" style="margin-top: 10px">
            <input type="button" value="회원가입" id="regCall" class="ml10" style="margin-top: 10px;">
        </form>
    </header>
    <section id="reg_form" class="fl fl_col text_ct text_center" style="background-color: beige;position: fixed;width: 500px; height:250px;left: 30%;top: 100px;border: 2px solid black; z-index: 2;">
            <h4> 회원가입 </h4><hr>
            <form name="regForm" id="regForm">
                <div class="fl fl_gr1 fl_row ml10 mt3 reg_he"><st class="w50p">ID :</st><input type="text" placeholder="id를 입력해주세요" name="regId" id="regId" class="reg_in_wi reg_he regNotnull" ></div>
                <div class="fl fl_gr1 fl_row ml10 mt3"><st class="w50p reg_he">PW :</st><input type="text" placeholder="pw를 입력해주세요" name="regPw" id="regPw" class="reg_in_wi reg_he regNotnull" ></div>
                <div class="fl fl_gr1 fl_row ml10 mt3"><st class="w50p reg_he">이름 :</st><input type="text" placeholder="이름을 입력해주세요" name="regName" id="regName" class="reg_in_wi reg_he regNotnull" ></div>
                <div class="fl fl_gr2 fl_row ml10 mt3"><st class="w50p reg_he">소개 :</st><textarea style="width: 300px;" name="regInfo" id="regInfo"></textarea></div>
                <div class="fl fl_gr1 fl_row mt5"><input type="submit" value="회원가입" id="regSub" class="reg_btn ml20"><input type="button" value="취소" id="regCancle" class="reg_btn ml20"></div>
            </form>	
    </section>   
    <div id="reg_back" style="display: none;width: 100%;height: 100%; position: absolute;left: 0;top: 0;background-color: aliceblue; opacity: 0.5; z-index: 1;">
    </div>
    <section class="bcen">
        <h3 class="mt20 text_center">로그인후 이용가능합니다(세션이없을시)</h3>
        <div>
            
        </div>        
    </section>
</body>
</body>
</html>