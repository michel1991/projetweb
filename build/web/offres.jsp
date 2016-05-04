<%-- 
    Document   : deposer-annonce
    Created on : Apr 1, 2016, 1:23:08 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/> 
    </head>

    <body>  
        <jsp:include page="menu.jsp"/>

        <!-- ///// BARRE DE RECHERCHE ///// -->
        <jsp:include page="search-bar.jsp"/> 


        <!-- ///// ESPACE BLANC DIV ///// -->
        <div class="classWhite"></div>



        <!-- ///// CONTENT OFFRES ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">

                    <div class="col-md-3 col-sm-3 col-xs-12">
                        <div class="home_three_sidebar">

                            <div class="sidebar_sale">

                                <div class="categories">  
                                    <div class="categories_title"> 
                                        <div class="anav-left"><i class="fa fa-bars"></i></div> 
                                        <span>A LA UNE</span> 
                                    </div>
                                </div>  

                                <div class="weekly_featured">
                                    <div class="single_weekly_featured">
                                        <div class="row">
                                            <div class="col-md-5 col-sm-5 col-xs-5">                                                
                                                <div class="">
                                                    <div class="">
                                                        <div class="weekly_overlay"></div>
                                                        <img src="images/1013424_07_1.jpg" alt="" />
                                                    </div>                                         
                                                </div>                             
                                            </div>                                       
                                            <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                                <div class="featured_info">
                                                    <a href="${sessionScope.idUserFrontEnd==null?'ControllerServletFrontEnd?action=accueil':'ControllerCentralDepotAnnoceFE'}">Crée ton annonce!</a><!--product-left-sidebar.html-->
                                                    <p><a href="${sessionScope.idUserFrontEnd==null?'ControllerServletFrontEnd?action=accueil':'ControllerCentralDepotAnnoceFE'}" class="ColorBlues">Restez connecté sur TrocStudents.com</a></p>
                                                </div>
                                                <div class="sidebar_cart">
                                                    <a href="${sessionScope.idUserFrontEnd==null?'ControllerServletFrontEnd?action=accueil':'ControllerCentralDepotAnnoceFE'}">Voir ici</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="weekly_featured">
                                    <div class="single_weekly_featured">
                                        <div class="row">
                                            <div class="col-md-5 col-sm-5 col-xs-5">                                                
                                                <div class="image_weekly_change">
                                                    <div class="">
                                                        <div class="weekly_overlay"></div>
                                                        <img src="images/1010681-4.jpg" alt="" />
                                                    </div>                                         
                                                </div>                             
                                            </div>
                                            <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                                <div class="featured_info">
                                                    <a href="${pageContext.servletContext.contextPath}/ControllerServletFrontEnd?action=accueil">Inscris-toi!</a>
                                                    <p><a href="${pageContext.servletContext.contextPath}/ControllerServletFrontEnd?action=accueil" class="ColorBlues">Sauvegarde tes annonces favorites.</a></p>
                                                </div>
                                                <div class="sidebar_cart">
                                                    <a href="${pageContext.servletContext.contextPath}/ControllerServletFrontEnd?action=accueil">Voir ici</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="sidebar_latest_p">
                                <h2>A LA UNE</h2> 							
                                <div id="carousel-example-generic-sb-lp" class="carousel slide" data-ride="carousel">

                                    <ol class="carousel-indicators">
                                        <li data-target="#carousel-example-generic-sb-lp" data-slide-to="0" class="active"></li>
                                        <li data-target="#carousel-example-generic-sb-lp" data-slide-to="1"></li>
                                        <li data-target="#carousel-example-generic-sb-lp" data-slide-to="2"></li>
                                    </ol>
                                    <div class="carousel-inner" role="listbox">

                                        <!-- CODE POUR LES ANNONCES A LA UNE -->
                                        <c:set var="photosUnes" value="${requestScope['photosAnnoncesAlaUne']}" scope="page"/>

                                        <c:forEach var="alaune" items="${requestScope['annonceALaUnes']}"  varStatus="vsUne">

                                            <c:set var="photoUne" value="${photosUnes[vsUne.index]}" />
                                            <div class="${vsUne.index==1?'item active':'item'} ">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">

                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="resources/imagesAnnonces/${photoUne.nomLocalisation}" alt="" />
                                                        </div>

                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="resources/imagesAnnonces/${photoUne.nomLocalisation}" alt="" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href="ControllerCentralDescriptionAn?action=desc&flatI=${alaune.id}"></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href="ControllerCentralDescriptionAn?action=desc&flatI=${alaune.id}"></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="ControllerCentralDescriptionAn?action=desc&flatI=${alaune.id}">${alaune.titre}</a>
                                                        <p></p><!--Alpes-Maritimes-->
                                                        <span class="amount">${alaune.cout}&euro;</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>



                                    </div>
                                </div>
                            </div>
                            <br/>

                            <div class="banner-top">
                                <div class="banner-inner-content">
                                    <div class="bg-overlay"> </div>
                                    <img src="images/banner2-fashion2.jpg" alt="" />
                                    <div class="text-banner text-banner-3">
                                        <div class="banner-texthome">
                                            <h3>RUBRIQUE</h3>
                                            <h2>MAISON</h2> 
                                            <a href="#" class="btn-shop">Vendez !</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>  
                    <!--==| Home three sidebar start |==-->

                    <!-- ////////// ANNONCES ////////// -->
                    <div class="col-md-9 col-sm-9 col-xs-12">
                        <!--==| Feature Start |==-->
                        <section class="featured_area">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div style="padding-top:1px;" class="common_heading">
                                        <div class="divcssTabtt1"><h4><i class="fa fa-search-plus" aria-hidden="true"></i> Annonces: ${requestScope.action} </h4></div>
                                        <div class="bgdCGrays divcssTabtt2"><h4> TOUTES(${requestScope.nbreAnnonce})</h4></div>
                                    </div>


                                    <!--==| espace blanc div |==-->
                                    <div class="classWhite"></div>


                                    <div class="row">
                                        <div class="featered_products">
                                            <div role="tabpanel">
                                                <!-- Tab panes -->
                                                <div class="tab-content">

                                                    <div role="tabpanel" class="tab-pane active" id="homeft">

                                                        <c:set var="photosTab" value="${requestScope['photos']}" scope="page"/>

                                                        <div id=" " class="cc_one1">
                                                            <c:forEach var="annonce" items="${requestScope['annonces']}"  varStatus="vs">
                                                                <div class="weekly_featured888"><!-- debut d'une ligne-->
                                                                    <div class="single_weekly_featured">
                                                                        <div class="row">

                                                                            <div class="col-md-5 col-sm-5 col-xs-5"><!-- pour l'image-->
                                                                                <div class="image_weekly_change">
                                                                                    <div class="">
                                                                                        <div class="weekly_overlay"></div>
                                                                                        <c:set var="photo" value="${photosTab[vs.index]}" />
                                                                                        <img src="resources/imagesAnnonces/${photo.nomLocalisation}" alt="" class="imgOffer"/><!--images/feature4.jpg-->
                                                                                        <%--<c:forEach var="photo" items="${requestScope['photos']}"  varStatus="vs">
                                                                                            <img src="${photo.nomLocalisation}" alt="" class="imgOffer"/>
                                                                                          
                                                                                        </c:forEach>--%>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                                                                <div class="featured_info">
                                                                                    <a href="#">${annonce.titre} </a>
                                                                                    <p>Publiée le <fmt:formatDate value="${annonce.dateCreation}" pattern="dd/MM/yyyy HH:mm:ss"/></p>
                                                                                    <span class="amount">${annonce.cout}&euro;</span><!-- €-->
                                                                                </div>
                                                                                <div class="sidebar_cart">
                                                                                    <a href="ControllerCentralDescriptionAn?action=desc&flatI=${annonce.id}">Voir ici</a>  <!--product.jsp-->
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div><!-- fin d'une ligne -->
                                                            </c:forEach>

                                                            <!-- GESTION DE LA PAGINATION --> 
                                                            <c:if test="${requestScope['annonces']!=null && requestScope.pagination>0}">
                                                                <ul class="pagination">
                                                                    <c:forEach var="compte"  begin="0" end="${requestScope.pagination-1}">
                                                                        <%--<li><a href="ControllerCentralAnnonce?action=take&key=${compte}&about=Offres">${compte+1}</a></li>--%>
                                                                        <%--<li><a href="ControllerCentralAnnonce?action=Offres&key=${compte}">${compte+1}</a></li>--%>

                                                                        <!-- chefou ceci mais faut y aller mettre ça dans la boucle c'est pas cool-->
                                                                        <c:url value="ControllerCentralAnnonce" var="servletAnnonceUrl">
                                                                            <c:param name="titreA"   value="${requestScope.titreA}" />
                                                                            <c:param name="cateId"    value="${requestScope.cateId}" />
                                                                            <c:param name="ecoleId" value="${requestScope.ecoleId}" />
                                                                            <c:param name="other" value="${requestScope.other}" />

                                                                            <c:param name="findT" value="${requestScope.findT}" />
                                                                            <c:param name="urgent" value="${requestScope.urgent}" />

                                                                            <c:param name="action" value="${requestScope.whichAction}" />
                                                                            <c:param name="key" value="${compte}" />
                                                                            <c:param name="nomEcole" value="${requestScope.nomEcole}" />
                                                                        </c:url>
                                                                        <li><a href="<c:out value="${servletAnnonceUrl}" />">${compte+1}</a></li>

                                                                        <%--<li><a href="ControllerCentralAnnonce?action=${requestScope.whichAction}&key=${compte}">${compte+1}</a></li>--%>

                                                                    </c:forEach>

                                                                </ul> 
                                                            </c:if>
                                                            <!-- GESTION DE LA PAGINATION -->
                                                        </div>

                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!--==| Feature End |==-->

                        <section class="latest_from_blog_area">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="common_heading">
                                        <h2>Derniers posts Blog</h2>
                                    </div>
                                    <div class="latest_from_blog">
                                        <div class="row">
                                            <div class="col-md-4 col-sm-4 col-xs-12">
                                                <div class="single_latest_f_blog">
                                                    <div class="f_blog_img">
                                                        <a href=""><img src="images/blog1_2.jpg" alt="" /></a>
                                                        <div class="nd-content text-center">
                                                            <div class="nd-content_inner">
                                                                <div class="nd-content_inner1">
                                                                    <div class="nd-title">
                                                                        <a href="article1.jsp">LIRE PLUS</a>
                                                                    </div>
                                                                </div>
                                                            </div>                  
                                                        </div>              
                                                    </div>
                                                    <div class="f_blog_heading">
                                                        <a href="blog-right-sidebar.html">La boutique Troc Students!</a>
                                                    </div>
                                                    <div class="f_blog_menu">
                                                        <ul>
                                                            <li><a href=""><i class="fa fa-pencil-square-o"></i>Par Mvouma Michel</a></li>
                                                            <li><a href=""><i class="fa fa-calendar"></i>18 Avr 2016</a></li>
                                                        </ul>
                                                    </div>
                                                    <p>Améliorez la visibilité de votre école et de vos annonces, bénéficiez d'une page vitrine sur trocstudents.fr pour présenter votre école...</p>
                                                    <div class="f_blog_read_more">
                                                        <a href="article1.jsp">Lire plus ></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-4 col-xs-12">
                                                <div class="single_latest_f_blog">
                                                    <div class="f_blog_img">
                                                        <a href=""><img src="images/blog3_1.jpg" alt="" /></a>
                                                        <div class="nd-content text-center">
                                                            <div class="nd-content_inner">
                                                                <div class="nd-content_inner1">
                                                                    <div class="nd-title">
                                                                        <a href="blog-right-sidebar.html">LIRE PLUS</a>
                                                                    </div>
                                                                </div>
                                                            </div>                  
                                                        </div>              
                                                    </div>
                                                    <div class="f_blog_heading">
                                                        <a href="article2.jsp">Un Troc multi-service</a>
                                                    </div>
                                                    <div class="f_blog_menu">
                                                        <ul>
                                                            <li><a href=""><i class="fa fa-pencil-square-o"></i>Par Begyn Mélissa</a></li>
                                                            <li><a href=""><i class="fa fa-calendar"></i>16 Avr 2016</a></li>
                                                        </ul>
                                                    </div>
                                                    <p>TrocStudent : 10 services que vous pouvez trouver sur le site de petites annonces très intéressantes. Des cours de musiques au jardinage...</p>
                                                    <div class="f_blog_read_more">
                                                        <a href="article3.jsp">Lire plus ></a>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-4 col-xs-12">
                                                <div class="single_latest_f_blog">
                                                    <div class="f_blog_img">
                                                        <a href=""><img src="images/blog2.jpg" alt="" /></a>
                                                        <div class="nd-content text-center">
                                                            <div class="nd-content_inner">
                                                                <div class="nd-content_inner1">
                                                                    <div class="nd-title">
                                                                        <a href="blog-right-sidebar.html">Lire plus</a>
                                                                    </div>
                                                                </div>
                                                            </div>                  
                                                        </div>              
                                                    </div>
                                                    <div class="f_blog_heading">
                                                        <a href="blog-right-sidebar.html">Les annonces qui font rêver</a>
                                                    </div>
                                                    <div class="f_blog_menu">
                                                        <ul>
                                                            <li><a href=""><i class="fa fa-pencil-square-o"></i>Par Melou Michou</a></li>
                                                            <li><a href=""><i class="fa fa-calendar"></i>15 Avr 2016</a></li>
                                                        </ul>
                                                    </div>
                                                    <p>Envie de passer vos vacances au bord d'une piscine? TrocStudents peut vous aider à trouver votre futur logement. Suivez...</p>
                                                    <div class="f_blog_read_more">
                                                        <a href="blog-right-sidebar.html">Lire plus ></a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>

                        <div class="brand_area">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="brands">
                                        <h2>NOS PARTENAIRES</h2>
                                        <div id="brand-carousel">

                                            <div class="item"><a href=""><img src="images/brand1.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand2.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand3.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand4.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand5.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand6.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand1.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand2.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand3.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand4.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand5.png" alt="Owl Image"></a></div>
                                            <div class="item"><a href=""><img src="images/brand6.png" alt="Owl Image"></a></div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--==| FIN |==-->


                    </div>
                </div>
            </div>
        </section>
        <!--==| Home three wrapper END |==-->



        <!--==| espace blanc div |==-->
        <div class="classWhite"></div>


        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 

    </body>

</html>