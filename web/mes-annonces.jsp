<%-- 
    Document   : mes-annonces
    Created on : Apr 1, 2016, 1:50:30 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/> 
    </head>

    <body>  
        <jsp:include page="menu.jsp"/>

        <!-- ///// CONTENT MES ANNONCES ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="divbAide">

                            <div class="center ctAide">
                                <div class="lineSpcregl fontB">MES ANNONCES</div> 
                                <HR>

                                <p class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-heart"></i> Modifier mes annonces</a></p><br/>

                                <p>Pour modifier des annonces, cliquez sur le lien « Modifier l'annonce » et vous serez redirigé vers la page de modification de cette annonce.
                                    Si l'annonce n'est plus active sur le site, elle disparaîtra automatiquement de votre sélection.
                                </p>
                                <p><span class="ColorBlues">Attention :</span> si vous supprimez vos cookies, vous perdrez toutes vos annonces sauvegardées.</p>

                            </div>    	
                        </div>

                    </div>



                    <!-- ////////// MES ANNONCES ////////// -->

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="common_heading">
                            <h2>Mes annonces</h2>
                        </div>
                        <div class="row">
                            <div class="featered_products">
                                <div role="tabpanel">


                                    <!-- Tab panes -->
                                    <div class="tab-content">

                                        <div role="tabpanel" class="tab-pane active" id="homeft">

                                            <div id=" " class="cc_one1">

                                                <div class="weekly_featured888"><!-- debut d'une ligne-->
                                                    <div class="single_weekly_featured">
                                                        <div class="row">

                                                            <div class="col-md-5 col-sm-5 col-xs-5"><!-- pour l'image-->
                                                                <div class="weekly_hover">
                                                                    <a class="fa fa-search" href="" data-toggle="modal" data-target="#myModal09"></a>
                                                                </div>
                                                                <div class="image_weekly_change">
                                                                    <div class="single_weekly_img">
                                                                        <div class="weekly_overlay"></div>
                                                                        <img src="resources/imagesAnnonces/image-offre5a.jpg" alt="" class="imgOffer"/><!--images/feature4.jpg-->

                                                                    </div>
                                                                    <div class="single_weekly_img_hover">
                                                                        <div class="weekly_overlay"></div>                       
                                                                        <img src="resources/imagesAnnonces/image-offre5a.jpg" alt="" class="imgOffer"/>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                                                <div class="featured_info">
                                                                    <a href="#">Banquette convertible </a>
                                                                    <p>Publiée le 30/04/2016 18:38:49</p>
                                                                    <span class="amount">150.0&euro;</span><!-- €-->
                                                                </div>
                                                                <div class="sidebar_cart">
                                                                    <a href="modify-annonce.jsp">Modifier cette annonce</a>  <!--product.jsp-->
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- fin d'une ligne -->
                                            </div>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--==| Feature End |==-->

                </div>
            </div>

        </section>
        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 

    </body>

</html>