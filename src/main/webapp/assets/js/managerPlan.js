$(function(){
	$(".tab-pane").each(function(){
		if($(this).attr('id')=="createPlanPlan"){
		}else{
			loadPlanDetail($(this).attr("data-pid"),$(this).attr('data-paneIndex')) ;
		}
	})
	$(".tab-content ul#planList a:first").tab('show') ;
	$("#sjxz-btn").click() ;
});
function loadPlanDetail(pid,paneId){
	$.ajax({
		url:"getPlanDetail.aj" ,
		type:"post" ,
		data:{
			pid:pid
		},
		dataType:"html" ,
		success : function(html) {
			$('.tab-pane').eq(paneId).html(html) ;
		}
	})
}
//删除风险
function loadDeleteRiskModal(str){
		var data = str.split(":");
		var modal = $('#deleteRiskModal') ;
		modal.find('.modal-title').html('从计划<span id="deletedPlanId" class="text-primary">'+data[4]+'</span>中删除风险<span id="deletedRiskId" class="text-primary">' + data[0] + '</span>') ;
		modal.find('.modal-body #delete-risk-name').val(data[1]) ;
		modal.find('.modal-body #delete-risk-name').readOnly=true  ;
		modal.find('.modal-body #delete-risk-content').val(data[2]) ;
		modal.find('.modal-body #delete-risk-content').readOnly=true  ;
}
$('#comfirm-delete-btn').on('click',function(){
	var rid = $('#deletedRiskId').text();
	var pid = $('#deletedPlanId').text();
	$.ajax({
		url:"deleteRiskFromPlan.aj",
		type:"post" ,
		data:{
			rid:rid ,
			pid:pid
		},
		success:function() {
			alert("删除成功");
			window.location.reload();
		},
		error:function () {
			alert("删除失败");
		}
		})
})

//指派风险
function loadAssignRiskModal(str){
		var data = str.split(":");
		var modal = $('#assignRiskModal') ;
		modal.find('.modal-title').html('从计划<span id="updatedPlanId" class="text-primary">'+data[4]+'</span>中更新风险<span id="updatedRiskId" class="text-primary">' + data[0] + '</span>') ;
		modal.find('.modal-body #assign-risk-name').val(data[1]) ;
		modal.find('.modal-body #assign-risk-name').readOnly=true  ;
		modal.find('.modal-body #assign-risk-content').val(data[2]) ;
		modal.find('.modal-body #assign-risk-content').readOnly=true  ;
	
}
$('#comfirm-assign-btn').on('click',function(){
	var usernames = "" ;
	$('input[name="follower"]:checked').each(function(){
		
		var name = $(this).val() ;
		usernames += (name+',') ;
		$(this).checked = false ;
	})
	var id = $('#assignedRiskId').text() ;
	$.ajax({
		url:"assignRisk.aj" ,
		type:"post" ,
		data:{
			followers:usernames ,
			riskId:id
		},
		success:function() {
			alert("指派成功");
			window.location.reload();
		},
		error:function () {
			alert("指派失败");
		}
	})
})
//更新风险
function loadUpdateModel(str){
	var data=str.split(":") ;
	var model = $("#updateRiskModal") ;
	model.find('.modal-title').html('更新计划<span id="updatedPlanId" class="text-primary">'+data[4]+'</span>中风险<span id="updatedRiskId" class="text-primary">' + data[0] + '</span>') ;
	model.find('.modal-body #update-risk-name').val(data[1]) ;
	model.find('.modal-body #update-risk-creator').val(data[2]) ;
	model.find('.modal-body #update-risk-creator').readOnly=true  ;
	model.find('.modal-body #update-risk-content').val(data[3]) ;
}
$("#comfirm-update-btn").on('click',function(){
	var pid = $("#updatedPlanId").text() ;
	var rid = $('#updatedRiskId').text() ;
	var riskName = $("#update-risk-name").val() ;
	var riskContent = $("#update-risk-content").val() ;
	$.ajax({
		url:"updateRiskInPlan.aj" ,
		type:"post",
		data:{
			pid:pid ,
			rid:rid ,
			riskName:riskName ,
			riskContent:riskContent
		},
		success:function(){
			alert("更新成功");
			window.location.reload();
		},
		error:function(){
			alert("更新失败");
		}
	})
})
// 添加风险
function loadAddModal(pid) {
	var model = $("#addRiskModal") ;
    model.find('.modal-title').html('计划<span id="addedRiskPlanId">'+pid+'</span>添加风险')

}
$('#comfirm-add-btn').on('click',function(){
    var riskName= $("#risk-name").val()
    var riskContent= $("#risk-content").val()
    var riskCreator= $("#risk-creator").val()
    var planId = $("#addedRiskPlanId").text() 

    $.ajax({
        url:"addRiskForPlan.aj",
        type:"post",
        data:{
        	planId:planId ,
            riskName:riskName,
            riskContent:riskContent,
            riskCreator:riskCreator
        },
        success:function() {
            window.location.reload();
        },
        error:function () {
            alert("添加失败");
        }
    })
})
$("#create-plan-btn").on('click',function(){
	var planName = $.trim($("#createdPlanName").val()) ;
	if(planName=="")
		alert("请输入计划名称") ;
	else{
		$.ajax({
			url:"addPlan.aj" ,
			type:"post",
			data:{
				planName:planName
			},
			success:function(){
				window.location.reload() ;
			},
			error:function () {
	            alert("添加失败");
	        }
		})
	}
})
$("#sjxz-btn").on('click',function(){
	var kssj = $("#kssj").val() ;
	var jssj = $("#jssj").val() ;
	$.ajax({
		url:"getRecognizedRiskList.aj" ,
		type:"post" ,
		data:{
			beginTime:kssj ,
			endTime:jssj
		},
		dataType:"html" ,
		success:function(html){
			$("#recognizedRiskTable tbody").html(html) ;
		},
		error:function(){
			alert("后台错误")
		}
	}) ;
	$.ajax({
		url:"getComeTrueRiskList.aj" ,
		type:"post" ,
		data:{
			beginTime:kssj ,
			endTime:jssj
		},
		dataType:"html" ,
		success:function(html){
			$("#comeTrueRiskTable tbody").html(html) ;
		},
		error:function(){
			alert("后台错误")
		}
	})
})
$("#recognizedRiskImport").on('click',function(){
	var riskIds = "" ;
	$('#recognizedRiskTable').find('td').find('input').each(function(){
		if($(this).prop("checked")){
			
			riskIds += ($(this).val()+":");
		}
	})
	var pid = $('.tab-content ul').children(".active").attr("data-pid") ;
	$.ajax({
		url:"addRisksIntoPlan.aj",
		type:"post" ,
		data:{
			pid:pid ,
			rids:riskIds
		},
		success:function(){
			 window.location.reload();
		},
		error:function(){
			alert("后台错误") ;
		}
	
	})
})
$("#comeTrueRiskImport").on('click',function(){
	var riskIds = "" ;
	$('#comeTrueRiskTable').find('td').find('input').each(function(){
		if($(this).prop("checked")){
			riskIds += ($(this).val()+":");
		}
	})
	var pid = $('.tab-content ul').children(".active").attr("data-pid") ;
	$.ajax({
		url:"addRisksIntoPlan.aj",
		type:"post" ,
		data:{
			pid:pid ,
			rids:riskIds
		},
		success:function(){
			 window.location.reload();
		},
		error:function(){
			alert("后台错误") ;
		}
	
	})
})
