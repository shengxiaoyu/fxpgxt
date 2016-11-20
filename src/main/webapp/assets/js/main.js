$(function(){
	loadCourses() ;
});

//初始化风险列表
function loadCourses() {
    $.ajax({
        url:"getAllRisks.aj",
        type:"post",
        dataType:"json" ,
        success:function (data) {
            console.log(data);
            var courseList = $("#risk-list");
            for (var i = 0; i < data.length; i++){
                var riskId = data[i]['id'];
                var riskName = data[i]['name'];
                var riskCreator = data[i]['creator'];
                var riskContent = data[i]['content'];

                var content = '<tr>' +
                    '<th scope="row">' + riskId + '</th>' +
                    '<td>' + riskName + '</td>' +
                    '<td>' + riskCreator + '</td>' +
                    '<td>' + riskContent + '</td>' ;

                content += '<td><a onclick="loadAssignRiskModal(this.id)" href="#" data-toggle="modal" data-target="#assignRiskModal" id=' + riskId + ':' + riskName + ':' + riskCreator  + ':' + riskContent+'>指派</a></td>';
             

                content += '</tr>';
                courseList.append(content);

            }
            courseList.append('<tr> <td colspan="6"><a class="btn btn-default" href="#" data-toggle="modal" data-target="#addRiskModal">添加风险</a></td></tr>') ;
        }

    });
}


//指派风险
function loadAssignRiskModal(str){
		var data = str.split(":");
		var modal = $('#assignRiskModal') ;
		modal.find('.modal-title').html('指派风险<span id="assignedRiskId" class="text-primary">' + data[0] + '</span>') ;
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


// 添加风险
function loadAddModal() {
    $('#addRiskModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal

        var modal = $(this)
        modal.find('.modal-title').html('添加风险')

        
    })
}
$('#comfirm-add-btn').on('click',function(){
    var riskName= $("#risk-name").val()
    var riskContent= $("#risk-content").val()
    var riskCreator= $("#risk-creator").val()


    $.ajax({
        url:"addRisk.aj",
        type:"post",
        data:{
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