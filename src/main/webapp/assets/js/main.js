var dataX = null ;
var dataY1 = null ;
var dataY2 = null ;


$(function(){
	loadCourses() ;
	loadChartData() ;
});
$('#sjxz-btn').on('click',function(){
	loadChartData() ;
})
function loadChartData(){
	var kssj = $('#kssj').val() ;
	var jssj = $('#jssj').val() ;
	$.ajax({
		url:'getChartData.aj',
		type:'post',
		dataType:'json',
		data:{
			begin:kssj,
			end:jssj
		},
		success:function(data){
			console.log(data);
			dataX = new Array() ;
			dataY1 = new Array() ;
			dataY2 = new Array() ;
			for(var i=0;i<data.length;i++){
				dataX[i] = (data[i]['riskName']) ;
				dataY1[i]=(data[i]['time1']) ;
				dataY2[i]=(data[i]['time2']) ;
			}
			
			console.log(dataX);
			console.log(dataY1);
			console.log(dataY2);
			loadChart() ;
		}
	})
}
function loadChart(){
	var chart = {
		      type: 'column'
		   };
 var title = {
    text: '风险统计图'   
 };
 var subtitle = {
    text: '风险评估系统'  
 };
 var xAxis = {
    categories: dataX,
    crosshair: true
 };
 var yAxis = {
    min: 0,
    title: {
       text: '次数 '         
    }      
 };
 var tooltip = {
    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
       '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
    footerFormat: '</table>',
    shared: true,
    useHTML: true
 };
 var plotOptions = {
    column: {
       pointPadding: 0.2,
       borderWidth: 0
    }
 };  
 var credits = {
    enabled: false
 };
 
 var series= [{
      name: '识别',
          data: dataY1
      }, {
          name: '演变',
          data: dataY2
      }];     
    
		   var json = {};   
		   json.chart = chart; 
		   json.title = title;   
		   json.subtitle = subtitle; 
		   json.tooltip = tooltip;
		   json.xAxis = xAxis;
		   json.yAxis = yAxis;  
		   json.series = series;
		   json.plotOptions = plotOptions;  
		   json.credits = credits;
		   $('#container').highcharts(json);
}

//初始化风险列表
function loadCourses() {
    $.ajax({
        url:"getAllRisks.aj",
        type:"post",
        dataType:"json" ,
        success:function (data) {
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