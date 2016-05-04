/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//webshim.polyfill('forms');
$(function(){
    // use all implemented API-features on DOM-ready
    
     var msecsPerUpdate = 1000/60; // # of milliseconds between updates, this gives 60fps
        var progress =  $('#pr');
        var duration = 3;             // secs to animate for
        var interval = progress.attr('max')/(duration*1000/msecsPerUpdate);
        
        var animator = function(){
            progress.val(progress.val() + interval);
            if (progress.val() + interval < progress.attr('max')){
               setTimeout(animator, msecsPerUpdate);
            } else {
                progress.val(progress.attr('max'));
            }
        };
        animator();
        
        /*$('#preciP').hide();
        $('#niveau').hide();
        $('.labelHide').hide();*/
    
        $('ul.tabs li:first').addClass('active');
        $('.block article').hide();
        $('.block article:first').show();
        $('ul.tabs li').on('click',function(event)
        {
           var idUser = $("#idUserCompte").val();
           
           
           if(typeof idUser!="undefined" && idUser.length>0)
           {
               $("#mdp").attr("disabled", "disabled");
               $("#cmdp").attr("disabled", "disabled");
           }else{
               $("#mdp").removeAttr("disabled");
               $("#cmdp").removeAttr("disabled");
           }
          $('ul.tabs li').removeClass('active');
          $(this).addClass('active')
          $('.block article').hide();
          var activeTab = $(this).find('a').attr('href');
          $(activeTab).show();
          return false;
        });
        
        getDataEcole();
        
       table = $('#tableUtilisateur').DataTable(
        {
            'columnDefs': [{
            'targets': 0,
            'searchable': false,
            'orderable': false,
            'width': '1%',
            'className': 'dt-body-center',
            'render': function (data, type, full, meta){
                return '<input type="checkbox">';
            }
          },
            {
              "targets": [ 4 ],
              "visible": false,
              "searchable": false
           }// pour l'id de la categorie
           
           
          
      ],
          'order': [1, 'asc'],
           'rowCallback': function(row, data, dataIndex)
            {
              // Get row ID
              var rowId = data[0];
              // If row ID is in the list of selected row IDs
              if($.inArray(rowId, rows_selected) !== -1){
                 $(row).find('input[type="checkbox"]').prop('checked', true);
                 $(row).addClass('selected');
              }
              
            }
        }); // fin du databale
        
        
  });
  
  function addCompteUtilisateur()
  {
      var utilisateur = {};
        var civilite = document.getElementById('civilite');
        var profession = document.getElementById('prof');
        var ecole = document.getElementById('ecole');
        
        if (civilite.value=="defaut") {
         civilite.setCustomValidity('Choisir votre civilite');
         return false;
        } else {
         civilite.setCustomValidity('');
        }
        
        if (profession.value=="defaut") {
         profession.setCustomValidity('Choisir votre profession');
         return false;
        } else {
         profession.setCustomValidity('');
        }
        
        if (ecole.value=="defaut") {
         ecole.setCustomValidity('Choisir une ecole');
         return false;
        } else {
         ecole.setCustomValidity('');
        }
        
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
        
        utilisateur.niveau =$('#niveau').val();
        utilisateur.descF =$('#descF').val();
        
        utilisateur.email =$('#email').val();
        utilisateur.id =$('#idUserCompte').val();
        
        var url =''+path+'/ControllerUtilisateur?action=add';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.onloadend = function () 
        {
            var utilisateurR = JSON.parse(this.response);
            console.log("reponse " +JSON.stringify(utilisateurR));
            if(typeof utilisateurR !='undefined')//== "undefined"
            {
                cleanData();
            }
        };
        
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        console.log("send " +JSON.stringify(utilisateur));
        xhr.send(JSON.stringify(utilisateur));

        return false;
  }
  
  function choisirProfession()
  {
      var profession = $('#prof').val();
      if(profession==='etu')
        {
            $('.labelHide').each(function(index)
            {
                
                if(typeof $(this).attr('id')!='undefined')
                {
                    
                    if($(this).attr('id').toString()!='descF')
                    {
                        //console.log("id " + typeof $(this).attr('id') + ' ');
                        $(this).removeAttr("required").attr("required", "required");
                    }
                }
                
             $(this).removeClass("hidden");
         });
        }else{
            $('.labelHide').each(function(index)
            {
                
                if(typeof $(this).attr('id')!='undefined')
                {
                    
                    if($(this).attr('id').toString()!='descF')
                    {
                        //console.log("id " + typeof $(this).attr('id') + ' ');
                        $(this).removeAttr("required");
                    }
                }
                
             $(this).addClass("hidden");
         });
        }
        
        if(profession==='autre')
        {
            $('.labelHideProf').removeAttr("required").attr("required", "required");
            $('.labelHideProf').removeClass("hidden");
        }else{
             $('.labelHideProf').removeAttr("required");
            $('.labelHideProf').addClass("hidden");
        }
        
  }
function verificationMotDePasse() {
      var password1 = document.getElementById('mdp');
      var password2 = document.getElementById('cmdp');
      if (password1.value != password2.value) {
          password2.setCustomValidity('Mot de passe incorrect!');
      } else {
         password2.setCustomValidity('');
      }
      
}
   
function verifcationProfession()
{
    var professionP = document.getElementById('prof');
    // console.log("validation " + professionP.value);
    if (professionP.value =='Choisir votre profession') {
        professionP.setCustomValidity('Choisir une profession!');
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
        console.log("reponse " +JSON.stringify(datas));
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
   
   function cleanData()
   {
       $('.cleanData').each(function(){
           if($(this).attr("id")=="civilite" )
           {
               $(this).val("defaut");
           }else if($(this).attr("id")=="prof")
           {
               $(this).val("defaut");
           }else if($(this).attr("id")=="ecole")
           {
               $(this).val("defaut");
           }else{
               $(this).val("");
           }
       });
   }
    
 /*$(document).ready(function(){
        var msecsPerUpdate = 1000/60; // # of milliseconds between updates, this gives 60fps
        var progress =  $('progress');
        var duration = 3;             // secs to animate for
        var interval = progress.attr('max')/(duration*1000/msecsPerUpdate);
        
        var animator = function(){
                progress.val(progress.val() + interval);
                if (progress.val() + interval < progress.attr('max')){
                   setTimeout(animator, msecsPerUpdate);
                } else {
                    progress.val(progress.attr('max'));
                }
            }
        
        $('#theButton').click(animator);
    });*/






