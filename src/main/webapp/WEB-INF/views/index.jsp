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
	$('input[id=endt]').click(function(){

		var ischecked = $('input:checkbox[id=endt]').is(':checked')
			if(ischecked){
				$('#endf').append('<span id="endff">End time <input type="datetime-local" name="end_time" value="${day}T${time}" min="${day}T${time}" max="2099-12-31T00:00"/></span>');
			}else{
				$('#endff').remove();
			}
	});
	
	
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

<!-------------------------------- title ----------------------------------->
		<section class="bg-content">
            <div class="container">
                <div class="center"><h1>Create Your <span class="redBold">Straw Poll</span></h1></div>
            </div>
        </section>

<!-------------------------- poll content ----------------------------->
        <section class="content">
            <div class="container container-small box box-orange">
                <div class="poll-wrapper">
                    <form id="newpoll" action="new" method="post">
                    <h2 class="center">New Poll</h2>
                    <div class="box-title">
                        <div class="input-wrapper">
                            <input id="newq" name="title" class="title" type="text" placeholder="Type your question here..." />
                        </div>
                    </div>
                    <div class="box-content">
                        <div class="poll-answers">
                            <div class="answer"><span class="count">1.</span> <input id="a0" name="item" placeholder="poll option..."/></div>
                            <div class="answer"><span class="count">2.</span> <input id="a1" name="item" placeholder="poll option..."/></div>
                            <div class="answer"><span class="count">3.</span> <input name="item" placeholder="poll option..."/></div>
                        </div>
                        
                        <div class="poll-options" id="endf">
                        </div>

                        <div class="poll-options">
                            <div class="checkbox checkbox-danger">
                            	<input type="hidden" id="private_type" name="private_type" value="N"/>
                                <input type="checkbox" id="priv" name="priv" class="styled">
                                <label for="priv">
                                    Private (only direct link)
                                </label>
                            </div>
                            
                            <div class="checkbox">
                                <input type="checkbox" id="endt" name="endt" class="styled">
                                <label for="endt">
                                    End Time
                                </label>
                            </div>
                            
                            
                        </div>
          

                        <div class="poll-action">
                            <div><button class="action" id="newaction">Create Poll</button> <!--div class="button secondary" id="advanced">Advanced</div--></div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </section>
<!-- ---------------------------------------------------------------------- -->
        

        <section class="content">
            <div class="container container-small box">
                <div class="row box-content">
                    <div class="column half">
                        <h2>Trending Polls</h2>
                        <ul class="polllist">
                        
                        <c:forEach var="tranding" items="${trendingPoll}">
                            <li class="clearfix">
                                <div class="float-left image">
                                    <img src="./resources/image/pie-chart-small.png" width="50" />
                                    <span class="hover">${tranding.all_vote_count}</span>
                                </div>
                                <div class="float-right text">
                                    <h5><a href="./${tranding.poll_id}" title ="${tranding.title}">${tranding.title}</a></h5> 
                                    <div class="font-medium font-gray">Created on ${tranding.end_time}</div>
                                </div>
                            </li>
                        </c:forEach>
                        

                        </ul>
                    </div>
                    <div class="column half">
                        <h2>New Polls</h2>
                        <ul class="polllist">
                              
                        <c:forEach var="newpoll" items="${newPolls}">
                            <li class="clearfix">
                                <div class="float-left image">
                                    <img src="./resources/image/pie-chart-small.png" width="50" />
                                    <span class="hover">${newpoll.all_vote_count}</span>
                                </div>
                                <div class="float-right text">
                                    <h5><a href="./${newpoll.poll_id}" title ="${newpoll.title}">${newpoll.title}</a></h5> 
                                    <div class="font-medium font-gray">Created on ${newpoll.end_time}</div>
                                </div>
                            </li>   
                        </c:forEach>
                         
                        
                        </ul>
                    </div>
                </div>
            </div>
        </section>

  
        

</body>
</html>