(function ($) {
    "use strict";
	
	$(document).ready(function() {
		
		$("#owl-feature").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

		});

		$("#owl-new-products").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

		});

		$("#owl-feature-two").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
			
		});

		$("#owl-np-two").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]
			
		});

		$("#owl-feature-three").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

		});

		$("#owl-np-three").owlCarousel({

		  autoPlay: false, //Set AutoPlay to 3 seconds

		  items : 4,
		  itemsDesktop : [1199,3],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

		});
	  
	  
	  
	    $("#brand-carousel").owlCarousel({
 
		  autoPlay: 5000, //Set AutoPlay to 3 seconds
	 
		  items : 6,
		  itemsDesktop : [1199,6],
		  itemsDesktopSmall : [979,6],
		  itemsTablet : [768,6],
		  itemsTabletSmall : [480,4],
		  itemsMobile : [479,3],
		  pagination : false
 
		});
	  
		$("#latest-product-caro").owlCarousel({

		  autoPlay: 10000, //Set AutoPlay to 3 seconds

		  items : 5,
		  margin : 15,
		  itemsDesktop : [1199,4],
		  itemsDesktopSmall : [979,3],
		  itemsTablet : [768,3],
		  itemsTabletSmall : [480,2],
		  itemsMobile : [479,1],
		  pagination : false,
		  navigation : true,
		  navigationText : ["<i class='fa fa-angle-left'></i>","<i class='fa fa-angle-right'></i>"]

		});
		  
		//Cat Nav
		$('.holder00').on('click', function(){
			$('.cat_csub00').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder01').on('click', function(){
			$('.cat_csub01').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder02').on('click', function(){
			$('.cat_csub_sub02').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder03').on('click', function(){
			$('.cat_csub_sub03').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder04').on('click', function(){
			$('.cat_csub_sub04').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder05').on('click', function(){
			$('.cat_csub05').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder06').on('click', function(){
			$('.cat_csub_sub06').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});
		$('.holder07').on('click', function(){
			$('.cat_csub_sub07').toggleClass('displa_none');
			$(this).toggleClass('minus_btn');
		});

		// Checkout shipping
		$('#cc_different_shipping').on('click', function(){
			$('.different_shipping_true').slideToggle(800);
		});
		  
		  
		// TOGGLE MOBILE MENU
		$('.ofm li.m_nav').on('click', function() {
			$(".mobi-menu").slideToggle("slow");
			$(this).find(".mobi-menu").slideToggle("slow");
		}
		);
		$('#cssmenu li.has-sub>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');
			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp();
			} else {
				element.addClass('open');
				element.children('ul').slideDown();
				element.siblings('li').children('ul').slideUp();
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp();
			}
		});
		$('#cssmenu>ul>li.has-sub>a').append('<span class="holder"></span>');
		(function getColor() {
			var r, g, b;
			var textColor = $('#cssmenu').css('color');
			textColor = textColor.slice(4);
			r = textColor.slice(0, textColor.indexOf(','));
			textColor = textColor.slice(textColor.indexOf(' ') + 1);
			g = textColor.slice(0, textColor.indexOf(','));
			textColor = textColor.slice(textColor.indexOf(' ') + 1);
			b = textColor.slice(0, textColor.indexOf(')'));
			var l = rgbToHsl(r, g, b);
			if (l > 0.7) {
				$('#cssmenu>ul>li>a').css('text-shadow', '0 1px 1px rgba(0, 0, 0, .35)');
				$('#cssmenu>ul>li>a>span').css('border-color', 'rgba(0, 0, 0, .35)');
			} else {
				$('#cssmenu>ul>li>a').css('text-shadow', '0 1px 0 rgba(255, 255, 255, .35)');
				$('#cssmenu>ul>li>a>span').css('border-color', 'rgba(255, 255, 255, .35)');
			}
		})();

		function rgbToHsl(r, g, b) {
			r /= 255, g /= 255, b /= 255;
			var max = Math.max(r, g, b),
				min = Math.min(r, g, b);
			var h, s, l = (max + min) / 2;
			if (max == min) {
				h = s = 0;
			} else {
				var d = max - min;
				s = l > 0.5 ? d / (2 - max - min) : d / (max + min);
				switch (max) {
					case r:
						h = (g - b) / d + (g < b ? 6 : 0);
						break;
					case g:
						h = (b - r) / d + 2;
						break;
					case b:
						h = (r - g) / d + 4;
						break;
				}
				h /= 6;
			}
			return l;
		}
	   
	});
	
	
	
})(jQuery);