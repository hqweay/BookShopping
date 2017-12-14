	function addBookType(input){
  		var value = document.getElementById("add").value;
  		$.ajax({
  			url:"/book-type/add",
  			type:"get",
  			data:{"bookClass":value},
  			success:function(result){
  				alert(result.success);
				if(result.errorMsg){
					alert(result.errorMsg);
					return;
				}else{
					alert("添加成功");
					window.location.href = "/test/book-type";
				}
			}
  		});
  	}
	
	function bookTypeModify(temp){
		var value = temp.parentNode.previousSibling.previousSibling.value;
		var id = temp.parentNode.previousSibling.previousSibling.id;
		$.ajax({
  			url:"/book-type/modify",
  			type:"get",
  			data:{"bookClass":value,"bookId":id},
  			success:function(result){
				if(result.errorMsg){
					alert(result.errorMsg);
					return;
				}else{
					alert(result.successMsg);
					window.location.href = "/test/book-type";
				}
			}
  		});
	}
	
	function deleteBookType(temp){
		var value = temp.parentNode.previousSibling.previousSibling.value;
		var id = temp.parentNode.previousSibling.previousSibling.id;
		$.ajax({
  			url:"/book-type/delete",
  			type:"get",
  			data:{"bookId":id},
  			success:function(result){
				if(result.errorMsg){
					alert(result.errorMsg);
					return;
				}else{
					alert(result.successMsg);
					window.location.href = "/test/book-type";
				}
			}
  		});
	}