
function loadData(data){
	var tr = $("<tr>",{"class":""});
	$("<td>",{"class":"nb-td-check"})
        .append($("<input>",{"type":"checkbox","class":"nb-th-cb","name":"cb",
            "value":data.ent_id}))
        .appendTo(tr);
	tr.append($("<td>",{"text":item.ent_id}))
                .append($("<td>",{"text":item.ent_name}))
                .append($("<td>",{"text":item.ent_corparation}))
                .append($("<td>",{"text":item.ent_address}))
                .append($("<td>",{"text":item.ent_workseniority}))
                .append($("<td>",{"text":item.ent_product}))
                .append($("<td>",{"text":item.ent_contact}))
                .append($("<td>",{"text":item.ent_mobile}))
                .append($("<td>",{"class":"businessType"+index}))
                .append(addReleaseSelectTD(item))
                .append(addIsdisplayedSelectTD(item))
                .append(addIsvipSelectTD(item))
                .append($("<td>",{"text":spin_formatDate(item.ent_createtime)}));
}

$.ajax({
    url:"/user/list",
    type:"post",
    data:{},
    success:function(data){
        if(data.code==200){
            alert(data);
        }else{

        }
    },
    error:function(e){
        console.log("发生错误,稍后重试！");
    }
});