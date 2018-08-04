
var poll_option = 'poll option';
var minoptions = 'Add at least two poll options...';
var search = 'Search';
var no_answer_selected = 'No answer selected.';
var already_voted = 'Error: You already voted on this poll';
var closed_vote = 'The Vote Is Over';

// 페이지 갱신 시 타이틀에 포커스
document.addEventListener("DOMContentLoaded", function(event) {
    $('#newq').focus();
});

$(document).ready(function () {
	
	setInterval(function(){ refreshResults(); },1000);
	
	var aid = 2;
	
	//answer class 마지막 부분 focus시 poll option 한줄 더 추가
	$('body').on('focus', '.answer:last', function() {
		aid++;
		$('.poll-answers').append($('<div><span class="count">'+(aid+1)+'.</span> <input name="item" placeholder="'+poll_option+'..." /></div>').addClass('answer').hide().fadeIn(1000));
    });
    
    $('#newaction').on('click', function(event) {
    	event.preventDefault();
    	if ($('#newq').val() == '') {
	    	$('#newq').addClass('has-error');
	    	return;
    	}
    	if ($('#a0').val() == '' || $('#a1').val() == '') {
    		$('#a0, #a1').each(function() {
    			if ($(this).val() == '') {
    				$(this).attr("placeholder", translate_minoptions);
    				$(this).parent().css('border-bottom', '1px solid #DE3F1C');
    			}
    		});
	    	return;
    	}
    	$('#newpoll').submit();
    });
    
	$('#newq').on('click', function() {
		$('#newq').removeClass('has-error');
	});
	
	$('#a0').on('click', function() {
		$(this).parent().css('border-bottom', '1px solid #DDD');
	});
    
	$('.checkvote').on('click', function() {
		if ($('#pollma').attr('content') == 0) {
			$('.checkvote').each(function() {
				$(this).prop('checked', false);
			});

			$(this).prop('checked', true);
		}
	});

	$('#advanced').on('click', function() {
		$('.poll-advanced').toggle('slow');
	});

    $('#sharelink').on('click', function() {
    	SelectText('sharelink');
    });
    
    $('#showresult').on('click', function() {
    	refreshResults();
    	displayResults();
    });
    
    
    var hash = window.location.hash;
    if (hash == "#r") {
	    displayResults();
    }
    
    $('body').on('click', '#refresh', function() {
    	refreshResults(1);
    });


	$('#table-scroll-right').click(function() {
		var leftPos = $('#main-table-wrap').scrollLeft();
		$('#main-table-wrap').animate({scrollLeft: leftPos + 900}, 'slow');
	});

	$('#table-scroll-left').click(function() {
		var leftPos = $('#main-table-wrap').scrollLeft();
		$('#main-table-wrap').animate({scrollLeft: leftPos - 900}, 'slow');
	});
	

	//poll page에서 votebutton 클릭 시
	$('#votebutton').on('click',function() {
		var poll_id = $("#pollid").val();
		var oid = '';
		var selected = 0;
		
		$('.checkvote').each(function() {
			if ($(this).prop('checked') == true) {
				selected++;
				oid = $(this).attr("name");
			}
		});
		
		
		if (selected == 0) {
	    	$('#voteresponse').html(no_answer_selected).addClass("error");
	    	return;
		}
		
		$("#votebutton").attr("disabled", true);
		
		var sendData = {"poll_id":poll_id,"id":oid};
		
		$.ajax({
			url : "vote",
			method : "post",
			data : JSON.stringify(sendData),
			dataType:"json",
			contentType : "application/json;charset=UTF-8",
			success :function(resp){
				if(resp==1){
					$('#voteresponse').html(already_voted).addClass("error");
					return;
				}else if(resp==2){
					$('#voteresponse').html(closed_vote).addClass("error");
					return;
				}else{
					displayResults();
				}
		
			}
		});
	});
		
	
});

function SelectText(element) {
    var doc = document
        , text = doc.getElementById(element)
        , range, selection
    ;    
    if (doc.body.createTextRange) {
        range = document.body.createTextRange();
        range.moveToElementText(text);
        range.select();
    } else if (window.getSelection) {
        selection = window.getSelection();        
        range = document.createRange();
        range.selectNodeContents(text);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}

function htmldecode(s){
    window.HTML_ESC_MAP = {
    "nbsp":" ","iexcl":"¡","cent":"¢","pound":"£","curren":"¤","yen":"¥","brvbar":"¦","sect":"§","uml":"¨","copy":"©","ordf":"ª","laquo":"«","not":"¬","reg":"®","macr":"¯","deg":"°","plusmn":"±","sup2":"²","sup3":"³","acute":"´","micro":"µ","para":"¶","middot":"·","cedil":"¸","sup1":"¹","ordm":"º","raquo":"»","frac14":"¼","frac12":"½","frac34":"¾","iquest":"¿","Agrave":"À","Aacute":"Á","Acirc":"Â","Atilde":"Ã","Auml":"Ä","Aring":"Å","AElig":"Æ","Ccedil":"Ç","Egrave":"È","Eacute":"É","Ecirc":"Ê","Euml":"Ë","Igrave":"Ì","Iacute":"Í","Icirc":"Î","Iuml":"Ï","ETH":"Ð","Ntilde":"Ñ","Ograve":"Ò","Oacute":"Ó","Ocirc":"Ô","Otilde":"Õ","Ouml":"Ö","times":"×","Oslash":"Ø","Ugrave":"Ù","Uacute":"Ú","Ucirc":"Û","Uuml":"Ü","Yacute":"Ý","THORN":"Þ","szlig":"ß","agrave":"à","aacute":"á","acirc":"â","atilde":"ã","auml":"ä","aring":"å","aelig":"æ","ccedil":"ç","egrave":"è","eacute":"é","ecirc":"ê","euml":"ë","igrave":"ì","iacute":"í","icirc":"î","iuml":"ï","eth":"ð","ntilde":"ñ","ograve":"ò","oacute":"ó","ocirc":"ô","otilde":"õ","ouml":"ö","divide":"÷","oslash":"ø","ugrave":"ù","uacute":"ú","ucirc":"û","uuml":"ü","yacute":"ý","thorn":"þ","yuml":"ÿ","fnof":"ƒ","Alpha":"Α","Beta":"Β","Gamma":"Γ","Delta":"Δ","Epsilon":"Ε","Zeta":"Ζ","Eta":"Η","Theta":"Θ","Iota":"Ι","Kappa":"Κ","Lambda":"Λ","Mu":"Μ","Nu":"Ν","Xi":"Ξ","Omicron":"Ο","Pi":"Π","Rho":"Ρ","Sigma":"Σ","Tau":"Τ","Upsilon":"Υ","Phi":"Φ","Chi":"Χ","Psi":"Ψ","Omega":"Ω","alpha":"α","beta":"β","gamma":"γ","delta":"δ","epsilon":"ε","zeta":"ζ","eta":"η","theta":"θ","iota":"ι","kappa":"κ","lambda":"λ","mu":"μ","nu":"ν","xi":"ξ","omicron":"ο","pi":"π","rho":"ρ","sigmaf":"ς","sigma":"σ","tau":"τ","upsilon":"υ","phi":"φ","chi":"χ","psi":"ψ","omega":"ω","thetasym":"ϑ","upsih":"ϒ","piv":"ϖ","bull":"•","hellip":"…","prime":"′","Prime":"″","oline":"‾","frasl":"⁄","weierp":"℘","image":"ℑ","real":"ℜ","trade":"™","alefsym":"ℵ","larr":"←","uarr":"↑","rarr":"→","darr":"↓","harr":"↔","crarr":"↵","lArr":"⇐","uArr":"⇑","rArr":"⇒","dArr":"⇓","hArr":"⇔","forall":"∀","part":"∂","exist":"∃","empty":"∅","nabla":"∇","isin":"∈","notin":"∉","ni":"∋","prod":"∏","sum":"∑","minus":"−","lowast":"∗","radic":"√","prop":"∝","infin":"∞","ang":"∠","and":"∧","or":"∨","cap":"∩","cup":"∪","int":"∫","there4":"∴","sim":"∼","cong":"≅","asymp":"≈","ne":"≠","equiv":"≡","le":"≤","ge":"≥","sub":"⊂","sup":"⊃","nsub":"⊄","sube":"⊆","supe":"⊇","oplus":"⊕","otimes":"⊗","perp":"⊥","sdot":"⋅","lceil":"⌈","rceil":"⌉","lfloor":"⌊","rfloor":"⌋","lang":"〈","rang":"〉","loz":"◊","spades":"♠","clubs":"♣","hearts":"♥","diams":"♦","\"":"quot","amp":"&","lt":"<","gt":">","OElig":"Œ","oelig":"œ","Scaron":"Š","scaron":"š","Yuml":"Ÿ","circ":"ˆ","tilde":"˜","ndash":"–","mdash":"—","lsquo":"‘","rsquo":"’","sbquo":"‚","ldquo":"“","rdquo":"”","bdquo":"„","dagger":"†","Dagger":"‡","permil":"‰","lsaquo":"‹","rsaquo":"›","euro":"€"};
    if(!window.HTML_ESC_MAP_EXP)
        window.HTML_ESC_MAP_EXP = new RegExp("&("+Object.keys(HTML_ESC_MAP).join("|")+");","g");
    return s?s.replace(window.HTML_ESC_MAP_EXP,function(x){
        return HTML_ESC_MAP[x.substring(1,x.length-1)]||x;
    }):s;
}

function escapeHtml(unsafe) {
    return unsafe
         .replace(/&/g, "&amp;")
         .replace(/</g, "&lt;")
         .replace(/>/g, "&gt;")
         .replace(/"/g, "&quot;")
         .replace(/'/g, "&#039;");
 }

 function refreshVotes() {
	var cid = $("#title").data("slug");

	$.post("/refresh-votes", { cid: cid }).done(function(data) {
		$('#intro-upvote-count').html(data.intro_upvotes);
		$('#intro-downvote-count').html(data.intro_downvotes);
	});
}
    
function refreshResults() {
	var poll_id = $("#pollid").val();

	var pie_colors = ['#3EB991', '#FF7563', '#AA66CC', '#FFBB33', '#FF8800', '#33B5E5', '#AA66CC'];

	$("#refresh").attr("disabled", true);

	var sendData = {"poll_id":poll_id};
	$.ajax({
		url : "voteResult",
		method : "post",
		data : JSON.stringify(sendData),
		dataType:"json",
		contentType : "application/json;charset=UTF-8",
		success :function(poll){
			
			var j=0;
			var resultbars_content ='';
			for(i in poll.data){
				if(j>6){
					j=0;
				}
				var percent = 0;
				if (poll.total_votes > 0) { 
					percent = Math.round((poll.data[i].vote_count / poll.total_votes * 100) * 100) / 100;
				}
				
				if ($(document).width() > 1000) {
					if (poll.data[i].item.length > 11) {
						poll.data[i].item = poll.data[i].item.substring(0, 11)+'...';
					}
				} else {
					if (poll.data[i].item.length > 12) {
						poll.data[i].item = poll.data[i].item.substring(0, 12)+'...';
					}
				}
				
				poll.data[i].short_name = poll.data[i].item;
				
				if (poll.data[i].short_name.length > 47) {
					poll.data[i].short_name = poll.data[i].short_name.substring(0, 47)+'...';
				}
				
				resultbars_content += '<li><div class="resultstring clearfix"><span class="float-right font-medium">'+ percent +' % <span class="">('+ poll.data[i].vote_count +' votes)</span></span><span class="float-left" title="'+escapeHtml(poll.data[i].item)+'">'+ escapeHtml(poll.data[i].short_name) +'</span></div>'
				 +'<div class="resultbar-wrapper"><div class="resultbar" style="width: '+ percent +'%; background-color: '+ pie_colors[i] +';"></div></div></li>';
				
				j++;
			}
			
			$('#resultbars').html(resultbars_content);
			$('#total_votes').html(poll.total_votes);
			
			
		}
		
    });
}

function displayResults() {

	$('#result').fadeIn(1000);
    $('html,body').animate({scrollTop: $("#share").offset().top},'slow');

}