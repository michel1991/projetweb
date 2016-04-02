<%-- 
    Document   : page-accueil
    Created on : Apr 1, 2016, 12:40:39 AM
    Author     : mel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ///// BARRE DE RECHERCHE ///// -->
<jsp:include page="search-bar.jsp"/> 

<!-- ///// SLIDER ///// -->
<jsp:include page="slider.jsp"/> 


 <!-- ///// PAGE ACCUEIL ///// -->
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
                                        <div class="weekly_hover">
                                            <a class="fa fa-search" href="" data-toggle="modal" data-target="#myModal09"></a>
                                        </div>
                                        <div class="image_weekly_change">
                                            <div class="single_weekly_img">
                                                <div class="weekly_overlay"></div>
                                                <a href="product.jsp"><img src="images/1013424_07_1.jpg" alt="" /></a>
                                            </div>
                                            <div class="single_weekly_img_hover">
                                                <div class="weekly_overlay"></div>
                                               <a href="product.jsp"><img src="images/1008627-4_1.jpg" alt="" /></a>
                                            </div>
                                        </div>
                                        <div id="myModal09" class="modal fade" role="dialog">
                                            <div class="modal-dialog">
                                                <!-- ///////////////////////////// MODAL POPUP DE RESERVATION ///////////////////////////// -->
                                                <!-- ///////////////////////////// MODAL POPUP DE RESERVATION ///////////////////////////// -->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="product_lightbox">
                                                            <div class="row">
                                                                <div class="col-md-5 col-sm-5 col-xs-12">
                                                                    <div class="nod_text">
                                                                        <h3><a href="">Split Side Pink Crepe</a></h3>
                                                                        <span>£20.00</span>
                                                                        <p>Capicola chuck tongue, anim consequat leberkas laborum ut enim bacon. Ribeye hamburger pastrami nisi ad consectetur dolor exercitation pork belly officia brisket pariatur mollit nulla turkey. Est dolore nulla cupidatat pork chop. Sausage officia pastrami chicken.</p>

                                                                        <div class="mod_size_silect">
                                                                            <select class="form-control">
                                                                                <option>Medium</option>
                                                                                <option>Small</option>
                                                                                <option>Large</option>
                                                                            </select>
                                                                        </div>
                                                                        <div class="mod_color_silect">
                                                                            <select class="form-control">
                                                                                <option>Red</option>
                                                                                <option>Pink</option>
                                                                                <option>Black</option>
                                                                                <option>Blue</option>
                                                                                <option>Green</option>
                                                                            </select>
                                                                        </div>
                                                                        <div class="modal_icon">
                                                                            <ul>
                                                                                <li><a class="fa fa-facebook" href=""></a></li>
                                                                                <li><a class="fa fa-twitter" href=""></a></li>
                                                                                <li><a class="fa fa-google-plus" href=""></a></li>
                                                                                <li><a class="fa fa-rss" href=""></a></li>
                                                                                <li><a class="fa fa-linkedin" href=""></a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-7 col-sm-7 col-xs-12">
                                                                    <div class="p_modal_img">
                                                                        <img src="images/1014256_front.jpg" alt="" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- ///////////////////////////// MODAL POPUP DE RESERVATION ///////////////////////////// -->
                                                <!-- ///////////////////////////// MODAL POPUP DE RESERVATION ///////////////////////////// -->
                                            </div>
                                        </div>
                                        <!-- Modal END -->
                                    </div>
                                    <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                        <div class="featured_info">
                                            <a href="product.jsp">Crée ton annonce!</a>
                                            <p><a href="product.jsp" class="ColorBlues">Restez connecté sur TrocStudents.com</a></p>
                                        </div>
                                        <div class="sidebar_cart">
                                            <a href="">Voir ici</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="weekly_featured">
                            <div class="single_weekly_featured">
                                <div class="row">
                                    <div class="col-md-5 col-sm-5 col-xs-5">
                                        <div class="weekly_hover">
                                            <a class="fa fa-search" href="" data-toggle="modal" data-target="#myModal10"></a>
                                        </div>
                                        <div class="image_weekly_change">
                                            <div class="single_weekly_img">
                                                <div class="weekly_overlay"></div>
                                                <a href="product.jsp"><img src="images/1010681-4.jpg" alt="" /></a>
                                            </div>
                                            <div class="single_weekly_img_hover">
                                                <div class="weekly_overlay"></div>
                                                <a href="product.jsp"><img src="images/1009859_2_1.jpg" alt="" /></a>
                                            </div>
                                        </div>
                                        <!-- Modal Start -->
                                        <div id="myModal10" class="modal fade" role="dialog">
                                            <div class="modal-dialog">


                                            </div>
                                        </div>
                                        <!-- MODELE DE FIN -->

                                    </div>
                                    <div class="col-md-7 col-sm-7 col-xs-7 no_col_padding">
                                        <div class="featured_info">
                                            <a href="product.jsp">Inscris-toi!</a>
                                            <p><a href="product.jsp" class="ColorBlues">Sauvegarde tes annonces favorites.</a></p>
                                        </div>
                                        <div class="sidebar_cart">
                                            <a href="">Voir ici</a>
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
                                <div class="item active">
                                    <div class="single_featured_product">
                                        <div class="image_feature_change">
                                            <div class="featured_img">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature10.jpg" alt="" /></a>
                                            </div>
                                            <div class="single_feature_img_hover">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature9.jpg" alt="" /></a>
                                            </div>
                                        </div>
                                        <div class="featured_info">
                                            <a href="product.jsp">Ensemble bonnet gants mitaines</a>
                                            <p>Alpes-Maritimes</p>
                                            <span class="amount">120 €</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="single_featured_product">
                                        <div class="image_feature_change">
                                            <div class="featured_img">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature7.jpg" alt="" /></a>
                                            </div>
                                            <div class="single_feature_img_hover">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature11.jpg" alt="" /></a>
                                            </div>
                                        </div>
                                        <div class="heart-icon">
                                            <a class="fa fa-search" href=""></a> 
                                        </div>

                                        <div class="featured_info">
                                            <a href="product.jsp">Ensemble bonnet gants mitaines</a>
                                            <p>Alpes-Maritimes</p>
                                            <span class="amount">120 €</span>
                                        </div>
                                    </div>
                                </div>
                                <div class="item">
                                    <div class="single_featured_product">
                                        <div class="image_feature_change">
                                            <div class="featured_img">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                            </div>
                                            <div class="single_feature_img_hover">
                                                <div class=""></div>
                                                <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                            </div>
                                        </div>
 
                                        <div class="featured_info">
                                            <a href="product.jsp">Ensemble bonnet gants mitaines</a>
                                            <p>Alpes-Maritimes</p>
                                            <span class="amount">120 €</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  


            <!-- ////////// ANNONCES ////////// -->
            <div class="col-md-9 col-sm-9 col-xs-12">
                <!--==| Feature Start |==-->
                <section class="featured_area">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="common_heading">
                                <h2>Annonces</h2>
                            </div>
                            <div class="row">
                                <div class="featered_products">
                                    <div role="tabpanel">

                                        <!-- Nav tabs -->
                                        <ul class="nav nav-tabs"   role="tablist">

                                            <li role="presentation" class="active"><a href="#homeft" style="font-size:10px;" role="tab" data-toggle="tab">TOUTES (1 471)</a></li>

                                            <li role="presentation"><a href="#profileft" role="tab" style="font-size:10px;" data-toggle="tab">Etudiants (568)</a></li>

                                            <li role="presentation"><a href="#messagesft" role="tab" style="font-size:10px;" data-toggle="tab">Profesionnels (327)</a></li>

                                        </ul>

                                        <!-- Tab panes -->
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active" id="homeft">
                                                <div id="owl-feature" class="cc_one1">
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Modal Start -->
                                                <div id="homthreet1" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet2" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet3" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet4" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet5" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet6" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet7" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">

                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet8" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="profileft">

                                                <div id="owl-feature-two" class="cc_one1">
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet10"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet14"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                                <!-- Modal Start -->
                                                <div id="homthreet9" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet10" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet11" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet12" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet13" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet14" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet15" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                            </div>
                                            <div role="tabpanel" class="tab-pane" id="messagesft">
                                                <div id="owl-feature-three" class="cc_one1">
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet17"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet18"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet19"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet20"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>
                                                            <div class="search-icon">
                                                                <a class="fa fa-search" href="" data-toggle="modal" data-target="#homthreet22"></a> 
                                                            </div>
                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="item">
                                                        <div class="single_featured_product">
                                                            <div class="image_feature_change">
                                                                <div class="featured_img">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature6.jpg" alt="" /></a>
                                                                </div>
                                                                <div class="single_feature_img_hover">
                                                                    <div class=""></div>
                                                                    <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                </div>
                                                            </div>
                                                            <div class="heart-icon">
                                                                <a class="fa fa-search" href=""></a> 
                                                            </div>

                                                            <div class="featured_info">
                                                                <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                <p>Orange / Vaucluse</p>
                                                                <span class="amount">8 €</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Modal Start -->
                                                <div id="homthreet16" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet17" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet18" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet19" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">


                                                    </div>
                                                </div>
                                                <!-- Modal END -->
                                                <!-- Modal Start -->
                                                <div id="homthreet20" class="modal fade" role="dialog">
                                                    <div class="modal-dialog">

                                                        <!-- Modal Start -->
                                                        <div id="homthreet21" class="modal fade" role="dialog">
                                                            <div class="modal-dialog">


                                                                <!-- Modal Start -->
                                                                <div id="homthreet22" class="modal fade" role="dialog">
                                                                    <div class="modal-dialog">

                                                                    </div>
                                                                </div>
                                                                <!-- Modal END -->
                                                                <!-- Modal Start -->
                                                                <div id="homthreet23" class="modal fade" role="dialog">
                                                                    <div class="modal-dialog">


                                                                    </div>
                                                                </div>
                                                                <!-- Modal END -->
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    </section>
 

                                    <section class="welcome_area">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="row">
                                                    <div class="col-md-8 col-sm-8 col-xs-12">
                                                        <div class="banner-top">
                                                            <div class="banner-inner-content">
                                                                <img src="images/banner1-fashion2.jpg" alt="" />
                                                                <div class="overlay"></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4 col-sm-4 col-xs-12">
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
                                            </div>
                                        </div>
                                    </section>
                
                                    <section class="latest_product_area">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="common_heading">
                                                    <h2>Annonces de votre région</h2>
                                                </div>
                                                <div class="latest_product">
                                                    <div id="latest-product-caro">

                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">

                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature3.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature4.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature5.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>
 
                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/feature2.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="item">
                                                            <div class="single_featured_product">
                                                                <div class="image_feature_change">
                                                                    <div class="featured_img">
                                                                        <div class=""></div>
                                                                        <a href="product.jsp"><img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                    <div class="single_feature_img_hover">
                                                                        <div class=""></div>
                                                                       <a href="product.jsp"> <img src="images/image-offre1.jpg" alt="" /></a>
                                                                    </div>
                                                                </div>
                                                                <div class="heart-icon">
                                                                    <a class="fa fa-search" href=""></a> 
                                                                </div>

                                                                <div class="featured_info">
                                                                    <a href="product.jsp">Ensemble bonnet gants mitaines en...</a>
                                                                    <p>Orange / Vaucluse</p>
                                                                    <span class="amount">8 €</span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </section>

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
                                                                    <a href="blog-right-sidebar.html">La boutique premium</a>
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
                                                                    <a href="article2.jsp">Un site multi-service</a>
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

 