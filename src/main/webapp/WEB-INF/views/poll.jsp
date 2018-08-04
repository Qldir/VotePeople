<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<link rel="stylesheet" href="./resources/css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/js/functions.js"></script>

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
					<h1 itemprop="name">${pInfo.title} </h1>
				</div>

				<div class="hint">Choose one answer:</div>
				<input type="hidden" id="pollid" value="${poll_id}"/>
			<!-- 	<meta id="pollid" property="gk:hash" content="c3kfpsf1" /> -->
				<meta id="pollma" property="gk:ma" content="0" />
				<meta id="pollembed" property="gk:embed" content="0" />
				<div class="poll-options voteanswers">
				
				
					
				<c:forEach items="${pItem}" var="item" varStatus="status">
					<div class="radio">
	                    <input type="radio" name="${item.id}" id="check${status.count}" class="styled check checkvote">
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
						<a href="/${poll_id}" id="sharelink" onclick="return false;">${url}</a>
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
					
					<h2>${pInfo.title}</h2>

					<ul id="resultbars" class="resultbars">
					
					</ul>
					<p class="bold font-xlarge"><span id="total_votes"></span> total votes.</p>
				</div>
				
				<div class="column one-third center piechart">
					<canvas id="pieChart" height="260" width="260"></canvas>
				</div>
			</div>
			
		</div>
	</div>
	

</section>
        

</body>
</html>