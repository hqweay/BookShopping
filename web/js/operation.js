	function addBookType(input){
  		var value = document.getElementById("add").value;
  		$.ajax({
  			url:"/book-type/add",
  			type:"get",
  			data:{"bookClass":value},
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
	
	
function nextPage(obj){
	var page = obj.value;
	if(page>0){
		$.ajax({
			url:"/customer/next-page",
			type:"get",
			data:{"page":page}, //把当前第几页传给服务器
			success:function(result){
				//寻找table的子input元素
				var table = $("#table").find("input");   //写死了 30个input
				var spans = $("#table").find("span");    //10个span
				var index = 0;
				for(var i = 0; i<table.length&&index<result.length; i++){
					//alert(table.length);
					table[i].value = result[index].Customer_name;
					i++
					table[i].value = result[index].Customer_phone;
					i++;
					table[i].value = result[index].Customer_address_id;
					
					spans[index].innerHTML = result[index].Customer_id;
					//为了方便后台只查了十条   这里防止标越界
					index++;
				}
				
				$("#nextPage").val(parseInt(page)+1);
				$("#lastPage").val(parseInt(page)+1);
				
			}
		});
	}
}
	  function lastPage(obj){
		 
		  var page = obj.value;
		  if(page>=2){
			  $.ajax({
				  url:"/customer/last-page",
				  data:{"page":page},
				  type:"get",
				  success:function(result){
					  var table = $("#table").find("input");   //写死了 30个input
						var spans = $("#table").find("span");    //10个span
						var index = 0;
						for(var i = 0; i<table.length&&index<result.length; i++){
							//alert(table.length);
							table[i].value = result[index].Customer_name;
							i++
							table[i].value = result[index].Customer_phone;
							i++;
							table[i].value = result[index].Customer_address_id;
							
							spans[index].innerHTML = result[index].Customer_id;
							//为了方便后台只查了十条   这里防止标越界
							index++;
						}
						
						$("#nextPage").val(parseInt(page)-1);
						$("#lastPage").val(parseInt(page)-1);
				  }
			  });
		  }
	  }
	  
	  
	 $(function(){
		 //删除customer
		 $(".delete").click(function(){
			     var tr = $(this).parents("tr");
			     var id = $(this).parents("tr").find("span").text();
			     alert(id);
			     $.ajax({
			    	 url:"/customer/delete",
			     	 data:{"id":id},
			     	 type:"get",
			     	 success:function(result){
			     		 if(result.errorMsg){
			     			 alert(result.errorMsg);
			     		 }else{
			     			 alert(result.successMsg);
			     			 tr.remove();  //成功后移除   不要重新刷新    如果刷新了整个页面  使用ajax就没意义了
			     		 }
			     	 }
			     });
		 });
		 
		 //修改customer
		 $(".modify").click(function(){
		     var tr = $(this).parents("tr");
		     var id = $(this).parents("tr").find("span").text();
		     var inputs = tr.find("input");   // 数组对象
		     var customerName = inputs[0].value;
		     var customerNumber = inputs[1].value;
		     var customerAddress = inputs[2].value;
		     
		     $.ajax({
		    	 url:"/customer/modify",
		     	 data:{"id":id,"customerName":customerName,"customerAddress":customerAddress,"customerNumber":customerNumber},
		     	 type:"get",
		     	 success:function(result){
		     		 if(result.errorMsg){
		     			 alert(result.errorMsg);
		     		 }else{
		     			 alert(result.successMsg);
		     		 }
		     	 }
		     });
	 });
	 }) 
	 
	 //单选的js
	 function getRadioValue(){
		 var radios =  $(".radio");
		 for(var i = 0; i<radios.length; i++){
			 if(radios[i].checked){
				 return radios[i].value;
			 }
		 }
	   }
	 //查询成功回掉函数    json数组传到这里来了
	 function searchCallBack(result){
		 $("#tbody").hide();
		 $("#nextPage").hide();    
		 $("#lastPage").hide();
		 var table = $("#table");
		 var a = $(".container");
		 var tbody = document.createElement("tbody");
		 tbody.setAttribute("class", "tbody_add");
		 for(var i = 0; i<result.length; i++){
			 var tr = document.createElement("tr");
			 var tdID =document.createElement("td");
			 tdID.innerHTML = result[i].customer_id;
			 var tdName=document.createElement("td");
			 tdName.innerHTML = result[i].customer_name;
			 var tdNum=document.createElement("td");
			 tdNum.innerHTML = result[i].customer_phone;
			 var tdAddress=document.createElement("td");
			 tdAddress.innerHTML = result[i].customer_address_id;
			 tr.append(tdID,tdName,tdNum,tdAddress);
			 tbody.append(tr);
		 }
		 
		 table.append(tbody);
		// table.append(tr);
		// a.append(tr);
		// $("#table").append(tr);
		 //alert(tdName.innerHTML);
	 }
	 //查询的js 
	 $(function(){
		 var interval;
		 var lastValue = $("#search").val();
		 $("#search").focus(function(){
			 interval =  window.setInterval(function(){
				 var searchValue = $("#search").val();
				 if(searchValue!=""&&lastValue!=searchValue){ 
					 var method = getRadioValue();
					 lastValue = searchValue;
					 $(".tbody_add").remove();
					 $.ajax({
						 type:"get",
						 url:"/customer/search",
						 data:{"method":method,"searchValue":searchValue},
						 success: function(result){     //result这里好像直接传不进去 外套一层匿名函数
							 searchCallBack(result)
						 }
					 });
				 }else if(searchValue==""){
					 $("#tbody").show();
					 $("#nextPage").show();
					 $("#lastPage").show();
				 }
			 },1000);
		 });
		 //清除定时器
		 $("#search").blur(function(){
			 clearInterval(interval);
		 });
	 })
	 
	 

   