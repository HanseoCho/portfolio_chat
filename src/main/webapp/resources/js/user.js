    $(function(){
    	function idCheck(){
    		var result = true;
    		$.ajax({type:"get",async:false,url:"/chat/user/".concat($("#regId").val())})
    		.done(function(data){
    			if(data == "비중복"){
    				result = true;
    			}
    			else if(data == "중복"){
    				result = false;
    			}
    			else {
    				alert("오룹라생 오루코드 "+data);
    				return false;
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
        /* USER */
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