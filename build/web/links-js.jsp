<%-- 
    Document   : links-js
    Created on : Apr 1, 2016, 1:33:51 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!--==| jQuery |==-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/modernizr-2.6.2.min.js" type="text/javascript"></script>

    <!--==| Revolution slider js|==-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.themepunch.plugins.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/rev-settings.js" type="text/javascript"></script>

    <!--==| Owl Carousel js|==-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/owl.carousel.min.js" type="text/javascript"></script>

    <!--==| Bootstrap jQuery |==-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/owl.bootstrap.min.js" type="text/javascript"></script>

    <!--==| Theme jQuery |==-->
    <script src="${pageContext.servletContext.contextPath}/resources/js/main.js" type="text/javascript"></script>

    <!--==| Dropdown menu "Se connecter" |==-->
    <script type="text/javascript">
        $(document).ready(function(){
        //Handles menu drop down
        $('.dropdown-menu').find('form').click(function (e) {
            e.stopPropagation();
        });
    });
    </script>

    <script type="text/javascript">
            $(document).ready(function(e){
            $('.search-panel .dropdown-menu').find('a').click(function(e) {
                        e.preventDefault();
                        var param = $(this).attr("href").replace("#","");
                        var concept = $(this).text();
                        $('.search-panel span#search_concept').text(concept);
                        $('.input-group #search_param').val(param);
                });
        });
    </script>


    <!-- PRODUCT.JSP -->
    <script src="${pageContext.servletContext.contextPath}/resources/js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/smoothproducts.min.js" type="text/javascript"></script>

    <script type="text/javascript">
    /* wait for images to load */
    $(window).load(function() {
            $('.sp-wrap').smoothproducts();
    });
    </script>

    <!-- ///// LINKS CSS/JS MAP.JSP  ///// -->
    <script src="${pageContext.servletContext.contextPath}/resources/js/easyLocator.js" type="text/javascript"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/js/markerclusterer.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js" type="text/javascript"></script>
    <script>      
                var data = [{
                    title: 'Universit&eacute; Paris-Dauphine',
                    description: 'pretty girls',
                    image: 'images/picture-school.png', 
                    link: 'page-accueil.jsp',
                    iconMarker: 'images/pins-maps.png',
                    lat: 48.8700464,
                    lng: 2.2733470
                 },
                 {
                    title: 'Universit&eacute; Valrose Nice',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt',
                    image: 'images/picture-school.png', 
                    link: 'page-accueil.jsp', 
                    iconMarker: 'images/pins-maps.png',
                    lat: 43.7153914,
                    lng: 7.2614853
                 },
                 {
                    title: 'Universit&eacute; Arles',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt',
                    image: 'images/picture-school.png', 
                    link: 'page-accueil.jsp',  
                    iconMarker: 'images/pins-maps.png',
                    lat: 43.6766470,
                    lng: 4.6277769
                 },
                          {
                    title: 'Universit&eacute; de Bordeaux',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt',
                    image: 'images/picture-school.png', 
                    link: 'page-accueil.jsp',   
                    iconMarker: 'images/pins-maps.png',
                    lat: 44.8370298,
                    lng: -0.5780251
                 },
                 {
                    title: 'Universit&eacute; Toulouse',
                    description: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt',
                    image: 'http://lorempixel.com/400/200/sports/3/', 
                    link: 'page-accueil.jsp',   
                    iconMarker: 'images/pins-maps.png',
                    lat: 43.5785488,
                    lng: 1.4024108
                 }
              ];
              $( document ).ready(function() {
                $('#locatorList').easyLocator({
                   myLocations: data
                });
              });
    </script>