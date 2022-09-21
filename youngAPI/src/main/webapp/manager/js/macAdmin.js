	var token = $("#_csrf").attr("content");
	var header = $("#_csrf_header").attr("content");
	
	$(function() {
	    $(document).ajaxSend(function(e, xhr, options) {
	        xhr.setRequestHeader(header, token);
	    });
	});


function noticeDelete(numMac)

{
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/noticeBoardDeleted/'+numMac,
		method:'get',
		cache:false,
		data:$('#del').serialize(),
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allNoticeBoard";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
}(jQuery);


function userDelete(numMac)

{
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/userDeleted/'+numMac,
		method:'get',
		cache:false,
		data:$('#del').serialize(),
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allUser";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
}(jQuery);



function freeBoardDelete(numMac)

{
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/freeBoardDeleted/'+numMac,
		method:'get',
		cache:false,
		data:$('#del').serialize(),
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allFreeBoard";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
}(jQuery);

function adsBoardDelete(numMac)

{
	if(!confirm('해당 게시물 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/adsBoardDeleted/'+numMac,
		method:'get',
		cache:false,
		data:$('#del').serialize(),
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allAdsBoard";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
}(jQuery);



function save() {
		var form = $('#input_form')[0]
		var data = new FormData(form);
		$.ajax({
			url : '/admin/save',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
			method : 'post',
			cache : false,
			data : data,
			dataType : 'json',
			success : function(res) {
				
				if(res.saved){
					alert('저장성공');	
					location.href="/admin";
				};
			},
			error : function(xhr, status, err) {
				alert('Error:' + err);
			}
		});
		return false;
	}(jQuery);

	
	function commentDelete(numMac)

    {
	if(!confirm('해당 댓글을 삭제하시겠어요?')) return;
	$.ajax({
		url:'/admin/commentDeleted/'+numMac,
		method:'get',
		cache:false,
		data:$('#del').serialize(),
		dataType:'json',
		success:function(res){
			alert(res.result ? '삭제 성공':'삭제 실패');
			location.href="/admin/allComment";
		},
		error:function(xhr,status, err){
			alert('에러:'+err);
		}
	});
	return false;
}(jQuery);



