
$("#login").click(function(){
	    var username = $("#username").val();
	    var password = $("#password").val();
	    var vrifyCode = $("#vrifyCode").val()
     	$.ajax({
			url:"/imgvrifyControllerDefaultKaptcha",
			type:"post",
			data:{username:username, password:password,vrifyCode:vrifyCode},
			success:function(data){
				if(data.code==200){
					location.href="/index";
				}else{
					$(".passcode").click();
					$(".msg").text(data.msg);
					$("#msgDiv").css("display","block");
				}
			},
			error:function(e){
				console.log("发生错误,稍后重试！");
			}
		});
});

$("#username").focus(function(){
	$("#msgDiv").css("display","none");
});
$("#password").focus(function(){
	$("#msgDiv").css("display","none");
});
$("#vrifyCode").focus(function(){
	$("#msgDiv").css("display","none");
});
