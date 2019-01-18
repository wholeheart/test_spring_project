
function loadData(data){
	$("#dataList").empty();
	var renderItem = function(item,index){
	var tr = $("<tr>",{"class":""});
	$("<td>",{"class":"nb-td-check"})
        .append($("<input>",{"type":"checkbox","class":"nb-th-cb","name":"cb",
            "value":data.ent_id}))
        .appendTo(tr);
	tr.append($("<td>",{"text":item.usr_id}))
                .append($("<td>",{"text":item.usr_name}))
                .append($("<td>",{"text":item.usr_telphone}))
                .append($("<td>",{"text":item.usr_email}))
                .append($("<td>",{"text":item.usr_gender}))
                .append($("<td>",{"text":item.usr_age}))
                .append($("<td>",{"text":item.usr_address}));
                var optd = $("<td>");
	            $("<a>",{"text":"修改","class":"nb-btn nb-btn-red"}).click(function(){
	            	location.href="userinfo.html?usr_id="+item.usr_id;
	            }).appendTo(optd);
	            tr.append(optd);
	            $("#dataList").append(tr);
	};
	for(var i=0;i<data.data.data.length;i++){
        renderItem(data.data.data[i],i);
    }
}

$.ajax({
    url:"/user/list",
    type:"post",
    data:{},
    success:function(data){
        if(data.data.code==201){
            loadData(data);
        }else{
			
        }
    },
    error:function(e){
        console.log("发生错误,稍后重试！");
    }
});