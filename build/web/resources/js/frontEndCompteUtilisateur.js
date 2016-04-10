/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function (){
    getDataEcole();
    
    $('#checkboxes1').click(function(){
        if($('#checkboxes1').is(':checked'))
        {
            $("#validerF").removeAttr("disabled");
        }else{
            $("#validerF").removeAttr("disabled").attr("disabled", "disabled");
        }
    });
});

function verificationMotDePasse() {
      var password1 = document.getElementById('mdp');
      var password2 = document.getElementById('cmdp');
      if (password1.value != password2.value) {
          password2.setCustomValidity('Mot de passe incorrect!');
      } else {
         password2.setCustomValidity('');
      }
      
}

function choisirProfession()
  {
      var profession = $('#prof').val();
      if(profession==='etu')
        {
            $('.infosComplementaireEtu').removeClass("hidden");
        }else{
             $('.infosComplementaireEtu').removeClass("hidden").addClass("hidden");
        }
        
        if(profession==='autre')
        {
            $('#preciP').removeAttr("required").attr("required", "required");
             $('.autreProfession').removeClass("hidden");
        }else{
            $('#preciP').removeAttr("required");
             $('.autreProfession').removeClass("hidden").addClass("hidden");
        }
        
  }

function getDataEcole()
{
    var url =''+path+'/ControllerUtilisateur?action=dataEcole';
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var datas =  JSON.parse(this.response);
        //console.log("reponse " +JSON.stringify(datas));
        if(typeof datas !='undefined')
        {
            for(var i =0; i<datas.length; i++)
            {

                $('#ecole').append($('<option>', {
                        value: datas[i].id,
                        text: datas[i].nom
                }));
            }
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send("");
}

function addCompteUtilisateurFrontEnd()
{
    var utilisateur = {};
    var civilite = document.getElementById('civilite');
    var profession = document.getElementById('prof');
    var ecole = document.getElementById('ecole');

   
    utilisateur.civilite =$('#civilite').val();
    utilisateur.profession =$('#prof').val();

    utilisateur.detailProf =$('#preciP').val();
    utilisateur.nom =$('#nom').val();

    utilisateur.prenom =$('#prenom').val();
    utilisateur.adresse =$('#adresse').val();

    utilisateur.cp =$('#cp').val();
    utilisateur.myPhone =$('#myPhone').val();

    utilisateur.dateN =$('#dateN').val();
    utilisateur.login =$('#login').val();

    utilisateur.mdp =$('#mdp').val();
    utilisateur.ecole =$('#ecole').val();

    utilisateur.descF =$('#descF').val();
    utilisateur.email =$('#email').val();
    
    if($('#checkboxes0').is(':checked'))
    {
        utilisateur.recevoirOffre ="1";
    }else{
        utilisateur.recevoirOffre ="0";
    }
    
    if($('#checkboxes1').is(':checked'))
    {
        utilisateur.acceptCondi ="1";
    }else{
         utilisateur.acceptCondi ="0";
    }
     console.log("send " +JSON.stringify(utilisateur));
    

    var url =''+path+'/ControllerServletFrontEnd?action=add';
    var urlRedirection =''+path+'/ServletControllerIndex?action=accueil';
    
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var utilisateurR = JSON.parse(this.response);
        console.log("reponse " +JSON.stringify(utilisateurR));
        if(typeof utilisateurR !='undefined')//== "undefined"
        {
            if(utilisateurR.id!='undefined' && utilisateurR.result=='success')
            {
                window.location=urlRedirection;
            }
        }
    };
    $("#validerF").removeAttr("disabled").attr("disabled", "disabled");
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    //console.log("send " +JSON.stringify(utilisateur));
    xhr.send(JSON.stringify(utilisateur));

    return false;
  }


