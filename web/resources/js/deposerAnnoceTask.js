/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function(){
    getDataCategories();
    
    /*$("#formDepotAnnonce").submit(function( event ) {
        var categorieAnnonce = document.getElementById('categorieAnnonce');
        
        console.log($('#categorieAnnonce').val().length);
        if ($('#categorieAnnonce').val().length==0) {//categorieAnnonce.value=="defaut"
                console.log($('#categorieAnnonce').val());
                categorieAnnonce.setCustomValidity('Choisissez une categorie');
                event.preventDefault();
           }else{
              categorieAnnonce.setCustomValidity(''); 
           } 
        
      });*/
    /*$(".linkClik").click(function(event){
       //console.log("event " + $(this).attr("id")); 
       $(this).removeClass("hidden").addClass("hidden");
    });*/
    
    $('#urgenteDepotAnnonce').click(function(){
        if($('#urgenteDepotAnnonce').is(':checked'))
        {
           $(this).attr("value", 1);
           console.log("value" , $(this).attr("value"));
        }else{
            $(this).attr("value", 0);
        }
    });
    
    $('#checkboxesMarquerPhone').click(function(){
        if($('#checkboxesMarquerPhone').is(':checked'))
        {
           $(this).attr("value", 1);
           console.log("value" , $(this).attr("value"));
        }else{
            $(this).attr("value", 0);
        }
    });
    
    
    $('#checkboxesSouhaitePas').click(function(){
        if($('#checkboxesSouhaitePas').is(':checked'))
        {
           $(this).attr("value", 1);
           console.log("value" , $(this).attr("value"));
        }else{
            $(this).attr("value", 0);
        }
    });
    
});


function deposerAnnoceFrontEnd()
{
    var annonce = {};
    var categorieAnnonce = document.getElementById('categorieAnnonce');
    if (categorieAnnonce.value=="defaut") {
     categorieAnnonce.setCustomValidity('Choisissez une categorie');
     return false;
    } else {
     categorieAnnonce.setCustomValidity('');
    }
    
    var prixE = document.getElementById('prix');
    var prixInt = parseInt(prixE.value)
    if (prixInt=='undefined' || prixInt<0) {
        prixE.setCustomValidity('Prix incorrect');
     return false;
    } else{
     prixE.setCustomValidity('');
    }
    
    

    annonce.categorieAnnonce =$('#categorieAnnonce').val();
    annonce.titreAnnonce =$('#titreAnnonce').val();

    annonce.textAnnonce =$('#textAnnonce').val();
    annonce.prix =$('#prix').val();
    
    annonce.type=$('input[name=radios]:checked').val();

    
    if($('#checkboxesMarquerPhone').is(':checked'))
    {
        annonce.MarquerPhoneAnnce ="1";
    }else{
        annonce.MarquerPhoneAnnce ="0";
    }
    
    if($('#urgenteDepotAnnonce').is(':checked'))
    {
        annonce.annonceUrgente ="1";
    }else{
        annonce.annonceUrgente ="0";
    }
    
    if($('#checkboxesSouhaitePas').is(':checked'))
    {
        annonce.anncePart ="1";
    }else{
         annonce.anncePart ="0";
    }
     console.log("send " +JSON.stringify(annonce));
    
    return;

    var url =''+path+'/ControllerCentralDepotAnnoceFE?action=add';
    var urlRedirection =''+path+'/ServletControllerIndex?action=accueil';// mettre un petit 
    
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var annonceR = JSON.parse(this.response);
        console.log("reponse " +JSON.stringify(annonceR));
        if(typeof annonceR !='undefined')//== "undefined"
        {
            if(annonceR.id!='undefined' && annonceR.result=='success')
            {
                window.location=urlRedirection;
            }
        }
    };
    /*$("#validerF").removeAttr("disabled").attr("disabled", "disabled");*/
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    //console.log("send " +JSON.stringify(utilisateur));
    xhr.send(JSON.stringify(annonce));

    return false;
  }
  
   function readImagesAndPreview(files, image, inputId, link) 
    {
        var reader = new FileReader();
        var fichier = files[0];
        var formats =["image/jpeg", "image/jpg", "image/gif", "image/png"];
        console.log("fichier type " + typeof fichier.type +" size " + typeof fichier.size + " size " + fichier.size +" type " +fichier.type);
        
            if($.inArray(fichier.type.toLowerCase(),formats)!==-1)
            {
                reader.onload = function(e) {

                  var img = $('#'+image);
                  console.log("source "+ " id " +img.attr("id"));
                  //img.src = e.target.result;
                  //img.width = 100;
                  img.attr("src", e.target.result);
                  //container.appendChild(img);
               };
             reader.readAsDataURL(files[0]);
            
             //$("."+inputId).removeClass("hidden").addClass("hidden");
             //$("#"+link).removeClass("hidden");
            }else{
                $("#contenuMessage").text("format non supporter");
                $('#modalMessage').modal('show');
            }
    }
    
    function initialise(idInput, idLink, idImage)
    {
        $("#"+idInput).removeAttr("hidden");
        $("#"+idLink).removeClass("hidden").addClass("hidden");
        $("#"+idImage).attr("src","images/appartus-photo.png");
    }
   

