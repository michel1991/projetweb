<%-- 
    Document   : template
    Created on : 01 avril 2016, 00:17:17
    Author     : mel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Troc Students | Site de petites annonces gratuites | trocstudents.fr</title>
        <meta name="description" content="Troc Students" >
        <meta name="author" content="Troc Students">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/intro/assets/css/bootstrap.min.css"" />

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/intro/assets/css/font-awesome.min.css" />

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/intro/assets/css/style.css" />


        <!-- ///// LIEN FAVICON  ///// -->
        <link rel="apple-touch-icon-precomposed" href="images/apple-touch-icon-precomposed.png">
        <link rel="shortcut icon" type="image/ico" href="images/favicon.ico"/>


    </head>
    <body>

        <section id="about" class="section-style" data-background-image="resources/intro/images/background/about-us.jpg">
            <div class="pattern height-resize"> 
                <div class="container">
                    <h3 class="section-name">
                        <img src="resources/intro/images/team/logo.png" style="width:300px;">
                    </h3>
                    <h2 class="section-title">
                        Vivez l'expérience
                    </h2>
                    <p class="section-description">
                        Cher Mr Buffa. Vivez l'expérience Troc Students, un projet de création web développé par Begyn Mélissa et Mvouma Michel. 
                    </p>

                    <div class="team-container center-block center" style="text-align:center !important;display:block !important;margin-left:auto !important; margin-right:auto !important;">
                        <div class="row center center-block" style="text-align:center !important;display:block !important;margin-left:auto !important; margin-right:auto !important;">
                            <div class="center ctAide" style="text-align:center !important;display:block !important;margin-left:auto !important; margin-right:auto !important;">

                                <div class="col-sm-4 center">
                                    <div class="team-member">
                                        <figure>
                                            <img src="resources/intro/images/team/team-member-2a.png" alt="Team Member">
                                            <figcaption>
                                                <p class="member-name">Begyn Mélissa</p>
                                                <p class="designation">
                                                    Développeur / Web designer
                                                </p>

                                            </figcaption>
                                        </figure>
                                        <div class="social-btn-container">
                                            <div class="team-socail-btn">

                                            </div>
                                        </div>
                                    </div>
                                </div>


                                <div class="col-sm-4 center">
                                    <div class="team-member">
                                        <figure>
                                            <img src="resources/intro/images/team/logo22.png" alt="Team Member">                                             
                                        </figure>                              
                                    </div>
                                </div>



                                <div class="col-sm-4 center">
                                    <div class="team-member">
                                        <figure>
                                            <img src="resources/intro/images/team/team-member-1a.png" alt="Team Member">
                                            <figcaption>
                                                <p class="member-name">
                                                    Mvouma Michel
                                                </p>
                                                <p class="designation">
                                                    Développeur informatique										
                                                </p>

                                            </figcaption>
                                        </figure>
                                        <div class="social-btn-container">
                                            <div class="team-socail-btn">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>


                    <div class="next-section">
                        <a href="page-accueil.jsp">ENTREZ</a>
                    </div>

                </div>
            </div>


        </section> 

        <script src="${pageContext.servletContext.contextPath}/resources/intro/assets/js/jquery-2.1.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/intro/assets/js/modernizr-2.8.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/intro/assets/js/plugins.js" type="text/javascript"></script>

        <script src="${pageContext.servletContext.contextPath}/resources/intro/assets/js/functions.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/intro/assets/js/jquery.ajaxchimp.min.js" type="text/javascript"></script>



    </body>
</html>
