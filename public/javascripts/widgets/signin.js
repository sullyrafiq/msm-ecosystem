/**
 * Created by sully.rafiq on 27/03/2014.
 */

(function() {

// Localize jQuery variable
    var jQuery;

    /******** Load jQuery if not present *********/
    if (window.jQuery === undefined || window.jQuery.fn.jquery !== '1.4.2') {
        var script_tag = document.createElement('script');
        script_tag.setAttribute("type","text/javascript");
        script_tag.setAttribute("src",
            "http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js");
        if (script_tag.readyState) {
            script_tag.onreadystatechange = function () { // For old versions of IE
                if (this.readyState == 'complete' || this.readyState == 'loaded') {
                    scriptLoadHandler();
                }
            };
        } else { // Other browsers
            script_tag.onload = scriptLoadHandler;
        }
        // Try to find the head, otherwise default to the documentElement
        (document.getElementsByTagName("head")[0] || document.documentElement).appendChild(script_tag);
    } else {
        // The jQuery version on the window is the one we want to use
        jQuery = window.jQuery;
        main();
    }

    /******** Called once jQuery has loaded ******/
    function scriptLoadHandler() {
        // Restore $ and window.jQuery to their previous values and store the
        // new jQuery in our local jQuery variable
        jQuery = window.jQuery.noConflict(true);
        // Call our main function
        main();
    }

    /******** Our main function ********/
    function main() {
        jQuery(document).ready(function($) {
            loadCss();
            loadHtml();
        });
    }

    function loadCss() {
        var css_link = $("<link>", {
            rel: "stylesheet",
            type: "text/css",
            href: "http://localhost:9000/assets/stylesheets/main.css"
        });
        css_link.appendTo('head');
    }

    function loadHtml() {
        $.ajax({
            contentType:'application/json',
            dataType:'jsonp',
            type: 'GET',
            url: "http://localhost:9000/sign-in"

        }).done(function(data) {
            $('div.msm-bar').html(data.html);
            addHandlerForLogin();
        });
    }

    function addHandlerForLogin() {
        $("input[type=submit]").on("click", function(e) {
            e.preventDefault();

            var email = $("input[type=email]").val();
            var password = $("input[type=password]").val();

            $.ajax({
                contentType:'application/json',
                dataType:'jsonp',
                type: 'GET',
                url: "http://localhost:9000/ajax-login?email=" + email + "&password=" + password

            }).done(function(data) {
                loadHtml();
            });
        })
    }

})(); // We call our anonymous function immediately