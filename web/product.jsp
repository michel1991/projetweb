<%-- 
    Document   : product
    Created on : Apr 1, 2016, 1:34:49 AM
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
        

        <!-- ///// CONTENT PRODUCT ///// -->
        <div class="header_bottom_area blog_page">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="bredcumb">
                            <ul>
                                <!--<li><a href="index.jsp">Accueil</a> / </li>
                                <li><a href="index.jsp">Alpes-Maritimes</a> / </li>
                                <li><a href="index.jsp">Chaussures</a> / </li>
                                <li class="active"><a href="index.jsp">Converses montantes (neuves)</a></li>-->
                                <li><a href="#">${requestScope.annonce.typeAnnonce.libelle}</a> / </li>
                                <li><a href="#">${requestScope.annonce.categorie.libelle}</a> / </li>
                                <li><a href="#">${requestScope.annonce.titre}</a> / </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        
        <section class="content_wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                       
                        <!-- ///// ESPACE BLANC DIV ///// -->
                        <div class="classWhite"></div>
        
                        
                        <div class="shop_left_detaial">
                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-xs-12 inlineBk">		   
                                    <div class="center margBtt05">
                                        <div class="page divPageproduct">
                                            <div class="sp-loading">
                                                <!--<img src="images/sp-loading.gif" alt=""> -->
                                            </div>
                                            <div class="sp-wrap">
                                                <!--<a href="images/image-offre1.jpg"><img src="images/image-offre1.jpg" alt=""></a>
                                                <a href="images/image-offre2.jpg"><img src="images/image-offre2.jpg" alt=""></a>
                                                <a href="images/image-offre3.jpg"><img src="images/image-offre3.jpg" alt=""></a>--> 
                                                
                                                <c:forEach var="photo" items="${requestScope['photos']}"  varStatus="vs">
                                                    <c:if test="${photo.nomLocalisation!=null}">
                                                        
                                                        <!-- CE QUIL NEST PAS BON : NE CHARGE QU'UNE IMAGE (voir FullDataIntoBase ligne 665 -->
                                                        <a href="resources/imagesAnnonces/${photo.nomLocalisation}"><img src="resources/imagesAnnonces/${photo.nomLocalisation}" alt=""/></a>
                                                        
                                                        <!-- CE QUIL FAUT OBTENIR : PLUSIEURS PHOTOS -->
                                                        <!--<a href="images/image-offre2a.jpg"><img src="images/image-offre2a.jpg" alt=""></a>--> 
                                                        <!--<a href="images/image-offre2b.jpg"><img src="images/image-offre2b.jpg" alt=""></a>--> 
                                                        
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- INFORMATIONS SUPP -->
                                    <div class="center margBtt05">
                                        <div class="publPdct"><span>Publiée par <a href=""><i class="fa fa-user"></i>
                                                    ${requestScope.annonce.utilisateur.login}<!--MelGD11-->
                                             </a></span></div>

                                        <div class="modal_icon divMdIcon">
                                            <span class="shareShop"><i class="fa fa-eur"></i> Prix</span>
                                        </div>
                                        <div class="modal_icon tabModalI">
                                            <span class="shareShop"> ${requestScope.annonce.cout} €</span>
                                        </div><br/>		   

                                        <div class="modal_icon divMdIcon">
                                            <span class="shareShop"><i class="fa fa-map-marker"></i> &Eacute;cole</span><!--Ville-->
                                        </div>
                                        <div class="modal_icon tabModalI">
                                            <span class="shareShop">${requestScope.ecole.nom}</span><!--Cagnes-sur-Mer 06800-->
                                        </div><br/>

                                        <div class="modal_icon divMdIcon">
                                            <span class="shareShop"><i class="fa fa-info-circle"></i> Publication</span>
                                        </div>
                                        <div class="modal_icon tabModalI">
                                            <span class="shareShop">Mise en ligne le <fmt:formatDate value="${annonce.dateCreation}" pattern="dd/MM/yyyy à HH:mm:ss"/></span>
                                        </div><br/>
                                    </div>


                                </div>

                                <div class="col-md-6 col-sm-6 col-xs-12 inlineBk">
                                    <div class="nod_text">
                                        <h1><a href="">${requestScope.annonce.titre}</a></h1><!--Converses montantes (neuves)-->
                                        <span>${requestScope.annonce.cout} €</span>
                                        <p>
                                            ${requestScope.annonce.description}
                                        </p>	
                                        <!--<p>bonjour, je vends mes CONVERSES "Chuck Taylor all star Canvas", motif imprimé drapeau des USA, taille 44, elles sont neuves donc en parfait état et 100% authentique puisse que je les ai acheté chez converse.com. Vente car probleme de taille. Elles sont à venir chercher ou envoi par la poste (frais de port à rajouter). PRIX 65 euros, PS: les converses vous seront remise avec sa boite original.</p>-->	

                                        <div class="center margBtt05">
                                            <c:if test="${annonce.marquerPhoneAnnce==true}"><!-- implementer cette fonctionnalité -->
                                                 <div class="divaddCartsl inlineBk">
                                                    <a href="#" class="bgdCBlues addCartsl"><i class="fa fa-phone"></i> Voir le numéro</a>
                                                    <input type="hidden" value="${annonce.id}"/>
                                                </div>
                                            </c:if>
                                           

                                            <div class="divaddCartsl inlineBk"><!-- pourrais lancer gmail -->
                                                <a href="#" class="bgdCGrays addCartsl"><i class="fa fa-envelope-o"></i>Envoyer un mail </a>
                                            </div>
                                        </div>

                                        <div class="center margBtt05">

                                            <div class="modal_icon vignttCool">
                                                <span class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-heart"></i> Sauvegarder l'annonce</a></span>
                                            </div>
                                            <div class="modal_icon vignttCool">
                                                <span class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-exclamation-triangle"></i> Signaler un problème</a></span>
                                            </div>

                                            <div class="product_meta">
                                                <div class="cats">
                                                    <p class="inlineBk">Tags: <a href="">Buttoned , </a><a href="">Floral , </a><a href="">Print</a></p>

                                                    <div class="modal_icon modEdvi">
                                                        <span class="shareShop"><a href="" class="ColorBlues"><i class="fa fa-share-alt"></i> Partager l'annonce</a></span>
                                                    </div>
                                                    <div class="modal_icon modEdvi">
                                                        <ul>
                                                            <li><a class="fa fa-facebook" href="" class="ColorBlues"></a></li>
                                                            <li><a class="fa fa-twitter" href="" class="ColorBlues"></a></li>
                                                            <li><a class="fa fa-google-plus" href="" class="ColorBlues"></a></li>
                                                            <li><a class="fa fa-rss" href="" class="ColorBlues"></a></li>
                                                            <li><a class="fa fa-linkedin" href="" class="ColorBlues"></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!--==| Latest product start |==-->
                        <section class="latest_product_area">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="common_heading">
                                        <h2>Related products</h2>
                                    </div>
                                    <div class="latest_product">
                                        <div id="latest-product-caro">

                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature1.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature1.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Sunglasses</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature2.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature2.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Hats</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature3.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature3.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women Shirt</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">

                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature4.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature4.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Shoe</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature5.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature5.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Hats</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature6.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature6.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women jacket</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature7.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature7.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Shoe</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature8.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature8.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women T-Shirt</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature9.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature9.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women Shirt</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature10.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature10.jpg" alt="" class="whFeaturePdct"/>
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women T-shirt</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature11.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature11.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Women wear</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature12.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/feature12.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Man Shirt</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="item">
                                                <div class="single_featured_product">
                                                    <div class="image_feature_change">
                                                        <div class="featured_img">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/image-offre1.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                        <div class="single_feature_img_hover">
                                                            <div class="image-overlay"></div>
                                                            <img src="images/image-offre1.jpg" alt="" class="whFeaturePdct" />
                                                        </div>
                                                    </div>
                                                    <div class="heart-icon">
                                                        <a class="fa fa-heart" href=""></a> 
                                                    </div>
                                                    <div class="search-icon">
                                                        <a class="fa fa-search" href=""></a> 
                                                    </div>
                                                    <div class="featured_info">
                                                        <a href="product-without-sidebar.html">Hats</a>
                                                        <div class="rating">
                                                            <ul>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star" href=""></a></li>
                                                                <li><a class="fa fa-star-o" href=""></a></li>
                                                            </ul>
                                                        </div>
                                                        <span class="amount">$200.00</span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                        <!--==| Latest product END |==-->
                    </div>
                </div>
            </div>
        </section>
        <!--==| Shop main wrapper END |==-->

        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>
        
        <jsp:include page="links-js.jsp"/> 
        
    </body>

</html>