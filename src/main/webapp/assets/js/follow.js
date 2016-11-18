
function loadFollowRiskModal(str){
    var data = str.split(":")
    var modal = $('#FollowAddModal')
    modal.find('.modal-title').html('追踪<span class="text-primary">' + data[0] + '</span>风险')
    modal.find('.modal-body input#showfollowed-id').val(data[0])
    modal.find('.modal-body input#showRisk-id').val(data[1])
    modal.find('.modal-body input#showRisk-name').val(data[2])
    modal.find('.modal-body input#showRisk-content').val(data[3])
    modal.find('.modal-body input#showRisk-possibility').val(data[4])
    modal.find('.modal-body input#showRisk-level').val(data[5])
    modal.find('.modal-body input#showRisk-gate').val(data[6])
    modal.find('.modal-body input#showRisk-description').val(data[7])
    modal.find('.modal-body input#showRisk-begin').val(data[8])
    modal.find('.modal-body input#showRisk-end').val(data[9]) ;
    
    if(data[9]==""){
    	modal.find('.modal-body input#showRisk-possibility').attr("readOnly",false) ;
    	modal.find('.modal-body input#showRisk-level').attr("readOnly",false) ;
    	modal.find('.modal-body input#showRisk-gate').attr("readOnly",false) ;
    	modal.find('.modal-body input#showRisk-description').attr("readOnly",false) ;
    	modal.find('.modal-body input#showRisk-end').attr("readOnly",false) ;
    }else{
    	modal.find('.modal-body input').each(function(){
    		$(this).attr("readOnly",true) ;
    	})
    }
//    var html = modal.find('.modal-body from').html() ;
//    modal.find('.modal-body from').html(html+'<div class="form-group"><label for="showRisk-end" class="control-label">是否结束:</label><input type="text" class="form-control"  id="showRisk-end"></div>') ;
}
$('#follow-btn').on('click',function(){
	var id = $("#showfollowed-id").val() ;
    var riskId= $("#showRisk-id").val() ;
    var riskName= $("#showRisk-name").val() ;
    var riskPossibility= $("#showRisk-possibility").val();
    var riskLevel= $("#showRisk-level").val();
    var riskGate= $("#showRisk-gate").val();
    var riskBegin= $("#showRisk-begin").val();
    var riskEnd= $("#showRisk-end").val();
    var riskContent= $("#showRisk-content").val();
    var riskDescription = $("#showRisk-description").val();
        $.ajax({
            url:"followRisk.aj",
            type:"post",
            data:{
                id:id ,
                riskId:riskId ,
                name:riskName ,
                possibility:riskPossibility,
                level:riskLevel ,
                gate:riskGate ,
                begin:riskBegin ,
                end:riskEnd ,
                content:riskContent ,
                description:riskDescription
            },
            success:function () {
            	alert("追踪成功");
                window.location.reload();
              
            },
            error:function () {
            	alert("追踪失败");
            }
        })
})
