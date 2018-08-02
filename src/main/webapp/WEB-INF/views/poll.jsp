<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<link rel="stylesheet" href="./resources/css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/js/functions.js"></script>
<script>
$(function(){
	
	
	$('input[id=priv]').click(function(){

		var ischecked = $('input:checkbox[id=priv]').is(':checked')
			if(ischecked){
				$('#private_type').val('Y');
				alert($('#private_type').val());
			}else{
				$('#private_type').val('N');
			}
	});
	
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote People</title>
</head>
<body>

<!-------------------------------- header ---------------------------------->
	<header>
			<div class="container container-full">
				<a id="logo" href="./"><img src="./resources/image/pie-chart-small.png" height="30" style="vertical-align: middle; margin-right: 8px;" role="banner" /><span>strawpoll</span></a>
			</div>
	</header>

<section class="content" id="pollvote" data-admin="1">
    <div class="container container-small box">
		<div class="poll-wrapper">
			<div class="box-content">
				<div class="center">
					<h1 itemprop="name">${pInfo.title}</h1>
				</div>

				<div class="hint">Choose one answer:</div>
				<meta id="pollid" property="gk:hash" content="c3kfpsf1" />
				<meta id="pollma" property="gk:ma" content="0" />
				<meta id="pollembed" property="gk:embed" content="0" />
				<div class="poll-options voteanswers">
				
				
					
				<c:forEach items="${pItem}" var="item" varStatus="status">
					<div class="radio">
	                    <input type="radio" name="check${item.id}" id="check${status.count}" class="styled check checkvote">
	                    <label for="check${status.count}">${item.item}</label>
	                </div>
				</c:forEach>
				
					

				</div>
				<div class="poll-action">
					<button class="action wide" id="votebutton">Vote</button>
					
					<div class="button secondary" id="showresult">View Results</div>
					
					<div id="voteresponse"></div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ---------------------------------------------------------------------- -->
        
<div class="content" id="share">
    <div class="container container-small box center">
    	<div class="box-content">
			<div class="row">
				<div class="column full shortlink share">
					Share this link:
				</div>
			</div>
			<div class="row">
				<div class="column full center">
					<div class="sharelinkbox">
						<a href="/${poll_id}" id="sharelink" onclick="return false;">http://localhost:12376/app/${poll_id}</a>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</div>

<!-- ----------------------------------------- -->
<section class="content" id="result" style="display: none;">
	<div class="container container-small box">
		<div class="box-content">
			<div class="row clearfix">
				<div class="column two-thirds">
					
					<h2>ㅈㅂㄷㅂㅈ</h2>

					<ul id="resultbars" class="resultbars">
					
					
									
					
						<li>
							<div class="resultstring clearfix">
								<span class="float-right"><span id="resultpercent0">0</span> % <span class="small">(<span id="pollresult0">0</span> votes)</span></span>
								<span class="float-left" title="ㅂㅈㄷㅂㅈ">ㅂㅈㄷㅂㅈ</span>
							</div>
							<div class="resultbar-wrapper">
								<div id="resultbar0" class="resultbar" style="width: 0.00%; background-color: #3EB991;"></div>
							</div>
						</li>
					
									
					
						<li>
							<div class="resultstring clearfix">
								<span class="float-right"><span id="resultpercent1">0</span> % <span class="small">(<span id="pollresult1">0</span> votes)</span></span>
								<span class="float-left" title="ㅂㅈㄷ">ㅂㅈㄷ</span>
							</div>
							<div class="resultbar-wrapper">
								<div id="resultbar1" class="resultbar" style="width: 10.00%; background-color: #FF7563;"></div>
							</div>
						</li>
					
									
					
						<li>
							<div class="resultstring clearfix">
								<span class="float-right"><span id="resultpercent2">0</span> % <span class="small">(<span id="pollresult2">0</span> votes)</span></span>
								<span class="float-left" title="ㅈㅂ">ㅈㅂ</span>
							</div>
							<div class="resultbar-wrapper">
								<div id="resultbar2" class="resultbar" style="width: 0.00%; background-color: #AA66CC;"></div>
							</div>
						</li>
					
					</ul>
					<p class="bold font-xlarge"><span id="total_votes">0</span> total votes.</p>
				</div>
				
				<div class="column one-third center piechart">
					<canvas id="pieChart" height="260" width="260"></canvas>
				</div>
			</div>
			<div class="row">
				<div class="column full center">
					<button class="action refresh vote" id="refresh">Refresh results</button>
				</div>
			</div>
			
		</div>
	</div>
	

</section>
        

</body>
</html>