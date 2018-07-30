<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>

<link rel="stylesheet" href="./resources/css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="./resources/js/functions.js"></script>
<script>

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fucking vote page</title>
</head>
<body>

<!-------------------------------- header ---------------------------------->
	<header>
			<div class="container container-full">
				<a id="logo" href="./"><img src="./resources/image/pie-chart-small.png" height="30" style="vertical-align: middle; margin-right: 8px;" alt="strawpoll.com logo" role="banner" /><span>strawpoll</span></a>
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
                    <form id="newpoll" action="/new" method="post">
                    <h2 class="center">New Poll</h2>
                    <div class="box-title">
                        <div class="input-wrapper">
                            <input id="newq" name="question" class="title" type="text" placeholder="Type your question here..." />
                        </div>
                    </div>
                    <div class="box-content">
                        <div class="poll-answers">
                            <div class="answer"><span class="count">1.</span> <input id="a0" name="a0" value="" placeholder="poll option..."/></div>
                            <div class="answer"><span class="count">2.</span> <input id="a1" name="a1" placeholder="poll option..."/></div>
                            <div class="answer"><span class="count">3.</span> <input name="a2" placeholder="poll option..."/></div>
                        </div>

                        <div class="poll-options">
                            <div class="checkbox checkbox-danger">
                                <input type="checkbox" id="priv" name="priv" class="styled">
                                <label for="priv">
                                    Private (only via direct link)
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
                        
                        
                            <li class="clearfix">
                                <div class="float-left image">
                                    <img src="./resources/image/pie-chart-small.png" width="50" />
                                    <span class="hover">17776</span>
                                </div>
                                <div class="float-right text">
                                    <h5><a href="/cxseg31f" title ="manakah yang Anda dukung ?">manakah yang Anda dukung ?</a></h5> 
                                    <div class="font-medium font-gray">Created on 07/27/2018 at 10:37:24</div>
                                </div>
                            </li>
                        

                        </ul>
                    </div>
                    <div class="column half">
                        <h2>New Polls</h2>
                        <ul class="polllist">
                              
                            <li class="clearfix">
                                <div class="float-left image">
                                    <img src="./resources/image/pie-chart-small.png" width="50" />
                                    <span class="hover">3</span>
                                </div>
                                <div class="float-right text">
                                    <h5><a href="/565k5gz4" title ="Pilih pengurus plant 3 paling">Pilih pengurus plant 3 paling</a></h5> 
                                    <div class="font-medium font-gray">Created on 07/30/2018 at 06:33:06</div>
                                </div>
                            </li>   
                         
                        
                        </ul>
                    </div>
                </div>
            </div>
        </section>

  
        

</body>
</html>