<%-- 
    Document   : header
    Created on : Apr 1, 2016, 12:25:20 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Troc Students | Site de petites annonces gratuites | trocstudents.fr</title>
	
    <!-- ///// FONTS GOOGLE  ///// -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>

    <!-- ///// FONTS AWESOME  ///// -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css">

    <!-- ///// CSS OWL CAROUSEL ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/carousel.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/theme.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/transitions.css" />

    <!-- ///// CSS REVOLUTION SLIDER  ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/settings.css" />

    <!-- ///// CSS IMAGE ZOOM  ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/glasscase.css" />

    <!-- ///// CSS BOOTSTRAP ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

    <!-- ///// CSS PRINCIPAL ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/responsive.css" />
    
    <!-- ///// LIEN FAVICON  ///// -->
    <link rel="apple-touch-icon-precomposed" href="images/apple-touch-icon-precomposed.png">
    <link rel="shortcut icon" type="image/ico" href="images/favicon.ico"/>
    
    <!-- ///// LINKS CSS/JS MAP.JSP  ///// -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/easyLocator.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js" type="text/javascript"></script>
       
    <!-- ///// CSS ZOOM SMOOTHPRODUCTS ///// -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/smoothproducts.css">
    <script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
    <%--<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap-3.1.1.min.js" type="text/javascript"></script>--%>
  </head>
  <body>
      <script src="${pageContext.servletContext.contextPath}/resources/js/feutilitaire.js" type="text/javascript"></script>
      <%--<script src="${pageContext.servletContext.contextPath}/resources/js/smoothproducts.js" type="text/javascript"></script>--%>
      <script>
          var path = '${pageContext.servletContext.contextPath}'; // n'enlève pas ceci variable globale javascript pour toutes les pages
          // ne pas enlever ceci c'est pour utiliser bootstra js dans toutes les pages
          // si on met le lien directement et ben le menu de connection ne s'affiche plus dans certaine page
          // fait gafe au ajout que j'ai fait ici si tu en enlève t'a des erreurs dans ta console du navigateur
          $(function(){
               $(document.body).append($('<script>', {
                        src: 'resources/js/bootstrap-3.1.1.min.js'
                        
                }));
                
                /*$(document.body).append($('<script>', {
                        src: 'resources/jquery-1.10.2.js'
                        
                }));*/
        
               $(document.body).append($('<script>', {
                        src: 'resources/js/easyLocator.js'
                        
                }));
                
                 $(document.body).append($('<script>', {
                        src: 'resources/js/smoothproducts.js'
                        
                }));
               getDataCategories();
          });
     
      </script>
  </body>