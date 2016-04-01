/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//webshim.polyfill('forms');
$(function(){
    // use all implemented API-features on DOM-ready
     console.log("go");
    
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
        }
        animator();
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






