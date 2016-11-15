
/**
 * 鍒濆鍖栭�璇炬ā鎬佹
 */
// function loadChooseModal() {
//     $('#FollowAddModal').on('show.bs.modal', function (event) {
//         var button = $(event.relatedTarget) // Button that triggered the modal
//         var riskId = button.data('risk-id')// Extract. from data-* attributes
//         var riskName = button.data('risk-name')
//         var riskContent = button.data('risk-content')
//         var riskPossibility = button.data('risk-possibility')
//         var riskLevel = button.data('risk-level')
//         var riskGate = button.data('risk-gate')
//         var riskCreator = button.data('risk-creator')
//         var riskFollower = button.data('risk-follower')
//
//         alert(riskName);
//         var modal = $(this)
//         modal.find('.modal-title').html('璺熻釜 <span class="text-primary">' + " " + '</span> 椋庨櫓')
//         modal.find('.modal-body input#showRisk-id').val(riskId)
//         modal.find('.modal-body input#showRisk-name').val(riskName)
//         modal.find('.modal-body input#showRisk-content').val(riskContent)
//         modal.find('.modal-body input#showRisk-possibility').val(riskPossibility)
//         modal.find('.modal-body input#showRisk-level').val(riskLevel)
//         modal.find('.modal-body input#showRisk-gate').val(riskGate)
//         modal.find('.modal-body input#showRisk-creator').val(riskCreator)
//         modal.find('.modal-body input#showRisk-follower').val(riskFollower)
//
//         // $('#follow-btn')[0].onclick = function () {
//         //     $.ajax({
//         //         url:"/chooseCourse",
//         //         type:"post",
//         //         data:{
//         //             courseId:courseId,
//         //             department:courseDepartment
//         //         },
//         //         success:function (data) {
//         //             if(data){
//         //                 alert("閫夎鎴愬姛");
//         //                 window.location.reload();
//         //             }else {
//         //                 alert("閫夎澶辫触------");
//         //             }
//         //         },
//         //         error:function () {
//         //             alert("閫夎澶辫触-------------");
//         //         }
//         //     })
//         // }
//     })
// }

/**
 * 鍒濆鍖栭�璇炬ā鎬佹
 */
function loadDropModal() {
    $('#FollowAddModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var riskId = button.data('risk-id') // Extract info from data-* attributes
        var riskCreator

        var modal = $(this)
        modal.find('.modal-title').html('纭畾閫�� <span class="text-primary">' + courseName + '</span> 璇剧▼锛�)

        $('#follow-btn')[0].onclick = function () {
            $.ajax({
                url:"getRisk.aj",
                type:"post",
                data:{
                    risk_id:riskId,
                },
                success:function (data) {
                        alert("鎴愬姛杩借釜");
                        window.location.reload();
                },
                error:function () {
                    alert("杩借釜澶辫触");
                }
            })
        }
    })
}

/**
 * 鍒濆鍖栨坊鍔犻闄╂�妗�
 */
function loadAddModal() {
    $('#addRiskModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal


        var modal = $(this)
        modal.find('.modal-title').html('娣诲姞椋庨櫓')

        $('#comfirm-add-btn')[0].onclick = function () {
            var riskId = 0
            var riskName= $("#risk-name").val()
            var riskContent= $("#risk-content").val()
            var riskPossibility= $("#risk-possibility").val()
            var riskLevel= $("#risk-level").val()
            var riskGate= $("#risk-gate").val()


            $.ajax({
                url:"addRisk.aj",
                type:"post",
                data:{
                    riskId:riskId,
                    riskName:riskName,
                    riskContent:riskContent,
                    riskPossibility:riskPossibility,
                    riskLevel:riskLevel,
                    riskGate:riskGate
                },
                success:function() {
                    window.location.reload();
                },
                error:function () {
                    alert("閫�澶辫触");
                }
            })
        }
    })
}


// function deleteRiskModal(){
//     $('#deleteRiskModal').on('show.bs.modal', function (event) {
//         var button = $(event.relatedTarget) // Button that triggered the modal
//         var modal = $(this)
//         modal.find('.modal-title').html('鍒犻櫎椋庨櫓')
//
//         $('#comfirm-delete-btn')[0].onclick = function () {
//             var riskId = 0
//             var riskName= $("#risk-name").val()
//             var riskContent= $("#risk-content").val()
//             var riskPossibility= $("#risk-possibility").val()
//             var riskLevel= $("#risk-level").val()
//             var riskGate= $("#risk-gate").val()
//             alert(riskName);
//
//             $.ajax({
//                 url:"/deleteRisk",
//                 type:"post",
//                 data:{
//                     riskId:riskId,
//                     riskName:riskName,
//                     riskContent:riskContent,
//                     riskPossibility:riskPossibility,
//                     riskLevel:riskLevel,
//                     riskGate:riskGate
//                 },
//                 success:function() {
//                     window.location.reload();
//                 },
//                 error:function () {
//                     alert("閫�澶辫触");
//                 }
//             })
//         }
//     })
// }

function loadCourses() {
    $.ajax({
        url:"getAllRisks.aj",
        type:"post",
        data:{

        },

        success:function (data) {
            console.log(data);
            var courseList = $("#risk-list");
            for (var i = 0; i < data.length; i++){
                var riskId = data[i]['riskId'];
                var riskName = data[i]['riskName'];
                var riskCreator = data[i]['riskCreator'];
                var riskContent = data[i]['riskContent'];
                var riskFollower = data[i]['riskFollower'];
                var riskLevel = data[i]['riskLevel'];
                var riskPossibility = data[i]['riskPossibility'];
                var riskGate = data[i]['riskGate'];
                var riskCreatedTime=data[i]['riskCreatedTime'];

                var content = '<tr>' +
                    '<th scope="row">' + riskId + '</th>' +
                    '<td>' + riskName + '</td>' +
                    '<td>' + riskCreator + '</td>' +
                    '<td>' + riskCreatedTime + '</td>' ;

                content += '<td><a onclick="loadChooseRiskModal(this.id)" href="#" data-toggle="modal" data-target="#FollowAddModal" id=' + riskId + ':' + riskName + ':' + riskCreator + ':' + riskCreatedTime + ':' + riskContent + ':' + riskFollower + ':' + riskLevel + ':' + riskPossibility + ':' + riskGate +'>璺熻釜</a></td>';
                content += '<td><a onclick="loadDeleteRiskModal(this.id)" href="#" data-toggle="modal" data-target="#deleteRiskModal" id=' + riskId +'>鍒犻櫎</a></td>';


                content += '</tr>';
                courseList.append(content);

            }
            courseList.append('<tr> <td colspan="6"><a class="btn btn-default" href="#" data-toggle="modal" data-target="#addRiskModal">娣诲姞椋庨櫓</a></td></tr>') ;
        }

    });


}

function loadChooseRiskModal(str){
    var data = str.split(":")
    var modal = $('#FollowAddModal')
    modal.find('.modal-title').html('璺熻釜 <span class="text-primary">' + data[0] + '</span> 椋庨櫓')
    modal.find('.modal-body input#showRisk-id').val(data[0])
    modal.find('.modal-body input#showRisk-name').val(data[1])
    modal.find('.modal-body input#showRisk-content').val(data[4])
    modal.find('.modal-body input#showRisk-possibility').val(data[7])
    modal.find('.modal-body input#showRisk-level').val(data[6])
    modal.find('.modal-body input#showRisk-gate').val(data[8])
    modal.find('.modal-body input#showRisk-creator').val(data[2])
    modal.find('.modal-body input#showRisk-follower').val(data[5])
}

function loadDeleteRiskModal(str){
    $('#deleteRiskSpan').text(str)
}

function deleteRisk(){
    $('#comfirm-delete-btn')[0].onclick = function () {
        var riskId = $('#deleteRiskSpan').text()

        $.ajax({
            url:"deleteRisk.aj",
            type:"post",
            data:{
                risk_id:riskId
            },
            success:function() {
//                alert("鍒犻櫎鎴愬姛");
                window.location.reload();
            },
            error:function () {
                alert("鍒犻櫎澶辫触");
            }
        })
    }
}

function followRisk() {

    $('#follow-btn')[0].onclick = function () {
        var riskId= $("#showRisk-id").val()
        var riskName= $("#showRisk-name").val()
        var riskPossibility= $("#showRisk-possibility").val()
        var riskLevel= $("#showRisk-level").val()
        var riskGate= $("#showRisk-gate").val()
        var riskCreator= $("#showRisk-creator").val()
        var riskFollower= $("#showRisk-follower").val()
        var riskContent= $("#showRisk-content").val()
            $.ajax({
                url:"followRisk.aj",
                type:"post",
                data:{
                    id:riskId ,
                    name:riskName ,
                    possibility:riskPossibility,
                    level:riskLevel ,
                    gate:riskGate ,
                    creator:riskCreator ,
                    follower:riskFollower ,
                    content:riskContent 
                },
                success:function (data) {
                    if(data){
//                        alert("杩借釜鎴愬姛");
                        window.location.reload();
                    }else {
                        alert("杩借釜澶辫触");
                    }
                },
                error:function () {
                    alert(riskId);
                }
            })
        }


}



function getMyCourses() {
    $.ajax({
        url:"getMyCourses.aj",
        type:"post",
        success:function (data) {
            var courseList = $("#course-list");
            for (var i = 0; i < data.length; i++){
                var courseId = data[i]['courseId'];
                var courseName = data[i]['courseName'];
                var courseTeacher = data[i]['teacherName'];
                var coursePlace = data[i]['coursePlace'];
                var courseCredits = data[i]['coursePoint'];
                var courseDepartment;
                if(courseId > 3000){
                    courseDepartment = "C";
                }else if(courseId > 2000){
                    courseDepartment = "B";
                }else {
                    courseDepartment = "A";
                }
                var content = '<tr>' +
                    '<th scope="row">' + courseId + '</th>' +
                    '<td>' + courseName + '</td>' +
                    '<td>' + courseTeacher + '</td>' +
                    '<td>' + coursePlace + '</td>' +
                    '<td>' + courseCredits + '</td>' +
                    '<td>' + courseDepartment + '</td>';
                content += '<td><a href="#" data-toggle="modal" data-target="#dropCourseModal" data-course-id="' + courseId + '" data-course-name="' + courseName + '" data-course-place="' + coursePlace + '" data-course-teacher="' + courseTeacher + '" data-course-credits="' + courseCredits + '" data-course-department="' + courseDepartment + '">閫�</a></td>';
                content += '</tr>';
                courseList.append(content);
            }
        }
    });
}

function getAllStudents() {
    $.ajax({
        url:"getAllStudents.aj",
        type:"post",
        success:function (data) {
            var studentList = $("#student-list");
            for (var i = 0; i < data.length; i++){
                var content = '<tr>' +
                    '<th scope="row">' + data[i]['studentId'] + '</th>' +
                    '<td>' + data[i]['studentName'] + '</td>' +
                    '<td>' + data[i]['studentSex'] + '</td>' +
                    '<td>' + data[i]['studentDepartment'] + '</td>' +
                    '</tr>';
                studentList.append(content);
            }
        }
    });
}