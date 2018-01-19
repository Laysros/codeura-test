! function(a) {
	"use strict";
	var b = {
		carousel: function() {
			a(".carousel.slide").carousel({
				cycle: !0
			})
		},
		matchHeight: function() {
			a("article.post.type-post, .widget_instagram_feed img").matchHeight({
				property: "min-height"
			})
		},
		uisearch: function() {
			try {
				! function(a) {
					new UISearch(document.getElementById("sb-search"))
				}(jQuery)
			} catch (a) {}
		},
		owlcarousel: function() {
			try {
				! function(a) {
					a(".post-slider").owlCarousel({
						items: 6,
						autoplay: !0,
						loop: !0,
						margin: 10,
						responsive: {
							320: {
								items: 1,
								margin: 0
							},
							480: {
								items: 2,
								margin: 0
							},
							636: {
								items: 3
							},
							768: {
								items: 4
							},
							1024: {
								items: 4
							},
							1200: {
								items: 6
							}
						}
					})
				}(jQuery)
			} catch (a) {}
		},
		slick: function() {
			a(".slider-for").slick({
				slidesToShow: 1,
				slidesToScroll: 1,
				infinite: !0,
				dots: !1,
				arrows: !1,
				fade: !0,
				asNavFor: ".slider-nav"
			}), a(".slider-nav").slick({
				slidesToShow: 5,
				slidesToScroll: 1,
				infinite: !0,
				asNavFor: ".slider-for",
				dots: !1,
				arrows: !1,
				margin: 5,
				focusOnSelect: !0
			})
		}
	};
	a(document).ready(function() {
		a(".count").filter(function() {
			return a(this).text().length > 2
		}).addClass("red"), a(".background-bg").css("background-image", function() {
			return "url(" + a(this).data("image-src") + ")"
		}), a('input[type="checkbox"]').on("change", function() {
			a('input[type="checkbox"]').not(this).prop("checked", !1)
		}), b.carousel(), b.matchHeight(), b.uisearch(), b.owlcarousel(), b.slick()
	}), a(window).width() < 767 && a(".menu-item-has-children>a").on("click", function(b) {
		b.preventDefault(), b.stopPropagation(), a(this).parent().siblings().removeClass("open"), a(this).parent().toggleClass("open")
	})
}(jQuery), jQuery("#submit").on("click", function(a) {
	a.preventDefault();
	jQuery("#name").val(), jQuery("#email").val(), jQuery("#subject").val(), jQuery("#message").val();
	jQuery.post("email.php", jQuery(".wpcf7-form").serialize(), function(a) {
		"sent" == a && $(".contact-message").html('<i class="fa fa-check contact-success"></i><div>Your message has been sent.</div>').fadeIn()
	})
});