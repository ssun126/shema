$(document).ready(function(){
	main.init();
});
var main = {
	init: function() {
		this.style();
		this.event();
		this.setMultiLang();
		this.resize();
	},
	style: function() {
	},
	event: function() {
	},
	resize:function(){
	},
	setMultiLang : function() {
    	var data = {};
        if (navigator.appName == "Netscape") {
        	data.LANG = navigator.language;
        } else {
        	data.LANG = navigator.userLanguage;
        }

        if (data.LANG.toUpperCase() == "KO" || data.LANG.toUpperCase() == "KO-KR") {
        	data.LANG = "kr";
        } else {
        	data.LANG = "en";
        }

        sessionStorage.setItem("LANGUAGE", data.LANG);

    	$.ajax({
    		url : '/multiLanguage/setLocalStorage',
    		type : "post",
    		success : function(data) {
        		localStorage.setItem("MULTI_LANGUAGE_DATA", JSON.stringify(data));
        		Schema.require("lang").init();
        		setTimeout(main.getMessage(), 500);
    		},
    		error : function() {
    			main.setMessage("");
    		}
    	});
	},
	getMessage: function(){
		var msg = window.location.search.substr(1);
		// msg = decodeURI(msg);
		main.setMessage(schemaCommon.lang(msg));
	},
	setMessage: function(msg){
		if(msg == ""){
			$(".main-errormsg").css('display','none');
		}else{
			$(".main-errormsg").html(msg);
		}
	}
}

