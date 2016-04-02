<%-- 
    Document   : qsn
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

        <!-- ///// CONTENT REGLES DE DIFFUSION  ///// -->
        <section class="content_wrapper">
            <div class="container">
                <div class="row">  
                    <div class="col-md-12 col-sm-12 col-xs-12">

                        <div class="divbAide">
                            <div class="center ctAide">

                                <div class="lineSpcregl">REGLES GENERALES DE DIFFUSION</div> 
                                <HR>

                                <p>
                                    Toute annonce insérée au profit d'un professionnel faisant une offre de vente, de services ou destinée à faire connaître son activité doit obligatoirement comporter un numéro SIREN (9 chiffres).
                                </p>

                                <p>
                                    Si vous déposez des annonces au profit d'une association, d'une mairie ou en tant qu'autoentrepreneur, vous devez indiquer un numéro SIREN. Si votre association n'en possède pas, nous vous invitons à en faire la demande auprès de la Direction Régionale de l'INSEE.
                                </p>


                                <div class="lineSpcregl"><i class="fa fa-cube"></i> BONNES PRATIQUES</div> 
                                <div class="lineSpcregl">Voici quelques points à retenir lorsque vous déposez une annonce: </div> 
                                <ul class="divrgdt">
                                    <li>Le texte de l'annonce doit impérativement décrire le produit/bien/service de l'annonce. Les annonces contenant un texte généraliste du type «nombreux produits à vendre dans notre magasin» ne sont pas acceptées. Le texte d’une même annonce ne doit pas proposer plusieurs biens.</li>
                                    <li>L’annonce doit être déposée dans une catégorie correspondant à l’objet de l’annonce.</li>
                                    <li>L'annonce d'un bien à vendre doit être déposée dans la commune où le bien est localisé.</li>
                                    <li>Vous devez supprimer une annonce ancienne avant d'en insérer une nouvelle relative au même bien. Vous ne pouvez avoir simultanément plusieurs fois la même annonce sur le site (dans plusieurs départements ou plusieurs catégories).</li>
                                    <li>Les échanges sont autorisés sur le site. Cependant, il n'est pas possible de lister plus de 5 références de modèles qui pourraient servir de base à un échange. </li>
                                    <li>Vous devez indiquer le prix total et TTC du bien dans le champ "Prix".</li>
                                </ul>

                                <p>
                                    Plusieurs catégories sont fermées aux professionnels : Montres & Bijoux ; Jeux vidéo & Consoles ; Billetterie ; Chaussures ; Vêtements ; Téléphonie ; Cours Particulier ; Accessoires & Bagagerie ; Colocation ; Covoiturage ; Autres.
                                </p>

                                <p class="lineSpcregl"><i class="fa fa-cube"></i> INTERDICTIONS GENERALES</p> 
                                <p>
                                    Toute annonce contenant des éléments de texte (mots, expressions, phrases… etc.) qui sembleraient contraires aux dispositions légales ou réglementaires, aux bonnes mœurs, aux règles de diffusion de notre site ou susceptible de troubler ou choquer les lecteurs sera refusée par Leboncoin.fr sans que cela ne fasse naître au profit de l'annonceur un quelconque droit à indemnité.
                                </p>

                                <p class="lineSpcregl"><i class="fa fa-cube"></i> CONTENUS NON AUTORISES</p> 					
                                <p>
                                    Il est interdit de déposer une annonce: Exclusivement rédigée en termes étrangers. Les annonces doivent être rédigées en français (obligation légale imposée par la loi n°94-345 du 4 août 1994). Lorsqu'un terme étranger ne peut trouver son équivalent en français, il doit être circonscrit d'une manière assez précise pour ne pas induire en erreur l'utilisateur du site. Comportant des termes ou des descriptions sans lien avec le contenu proposé.
                                </p>

                                <p>
                                    Présentant une utilisation abusive de mots clefs.
                                    Dirigeant directement ou indirectement vers un site autre que le nôtre.
                                    A caractère politique, sectaire, discriminatoire, sexiste etc.
                                </p>

                                <p class="lineSpcregl"><i class="fa fa-cube"></i> PRODUITS NON AUTORISES</p> 
                                <p>
                                    En tant qu'utilisateur du service Leboncoin.fr, vous devez vous assurer que le bien que vous cherchez à vendre ou à acheter est un produit autorisé sur le site et dont la vente est légale.
                                </p>

                                <p class="lineSpcregl">Nous vous invitons à prendre connaissance des produits/biens/services interdits sur notre site: </p> 
                                <ul class="divrgdt">
                                    <li>Tabac, drogue et objets associés, substances dangereuses et illicites,</li>
                                    <li>Cosmétique, médicament et parapharmacie,</li>
                                    <li>Armes blanches de combat ou d’autodéfense, armes à feu, explosifs, pièges de chasse,</li>
                                    <li>Contenu réservé aux adultes,</li>
                                    <li>Certaines espèces végétales et animales protégées, menacées ou prélevées dans leur milieu naturel,</li>
                                    <li>Objets consignés,</li>
                                    <li>Appel aux dons financiers privés ou à but humanitaire,</li>
                                    <li>Offres pouvant mener à des pratiques tendancieuses,</li>
                                    <li>Avis de recherche d’une personne,</li>
                                    <li>La majorité des produits de grande consommation de manufacture industrielle,</li>
                                    <li>Produits amincissants, de compléments alimentaires ou présentés comme étant miraculeux.</li>
                                </ul>

                                <p class="lineSpcregl"><i class="fa fa-cube"></i> PROPRIETE INTELLECTUELLE</p> 

                                <p>
                                    Seule la diffusion d'annonce proposant la vente de produits originaux est autorisée (appareils électroniques, DVD, CD, jeux vidéo, logiciels informatiques, cartes pour télévision payante, vêtements de marque et accessoires de marque …).
                                </p>

                                <p>
                                    Nous vous rappelons que la vente de copie ou de reproduction de toute sorte est susceptible de constituer un acte de contrefaçon, passible de trois ans d'emprisonnement et 300.000 euros d'amende sur le fondement de l'article L. 335-2 alinéa 2 du Code de la propriété intellectuelle.
                                </p>

                                <p>
                                    Vous devez être légalement propriétaire du contenu ou être autorisé à le vendre par le propriétaire, par son mandataire agréé ou par la loi. La vente de certains biens immatériels n’est pas autorisée sur notre site.
                                </p>

                                <p>
                                    Il est autorisé d’insérer des photos comportant un watermark (tatouage numérique) dans le but d'assurer la protection des droits de propriété intellectuelle. Seules les mentions des propriétaires de la photo sous forme de texte sont acceptées. Ces textes doivent obligatoirement être de couleur noire ou blanche.
                                </p>

                                <p class="lineSpcregl">L’insertion de logos ou d’adresse de site internet sur les photos reste strictement interdite.</p> 
                                <p class="lineSpcregl">Photographies non autorisées</p> 
                                <p class="lineSpcregl">Les photographies insérées doivent représenter le bien à vendre et ne peuvent être utilisées pour illustrer plusieurs annonces.</p> 
                                <p class="lineSpcregl">Il est interdit d’insérer des photos comportant: </p> 

                                <ul class="divrgdt">
                                    <li>Enfants mineurs reconnaissables</li>
                                    <li>Logos (à l'exception des catégories d'annonces Emploi et Services)</li>
                                    <li>Lien vers un site internet</li>
                                    <li>Représentations sans lien avec l’offre proposée</li>
                                </ul>

                            </div>    	
                        </div>

                    </div>
                </div>
            </div>
        </section>

        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 

    </body>

</html>