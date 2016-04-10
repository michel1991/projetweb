/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function (){
    
    $('#rememberMe').click(function(){
        if($(this).is(':checked'))
        {
            $(this).val("1");
        }else{
             $(this).val("0");
        }
    });
});

