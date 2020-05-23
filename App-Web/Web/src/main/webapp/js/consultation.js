/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$( document ).ready(function() {
    console.log( "document loaded" );
    if(window.location.pathname==="/historique.html"){  
                 
        // Appel AJAX
        $.ajax({
        url:'./ActionServlet',
        method: 'POST',
        data: {
            todo: "listerconsultation-client"
        },
        dataType: 'json'
    }).done(function(response){
        $.each(response.consultation, function(key, consultation){

            var new_text = '<div class="jumbotron consultation">';
                   
            new_text += ' Avec : ' + consultation.medium + '<br>';
            new_text += ' Le : ' + consultation.dateDebut + '<br>';
            new_text += ' Durée : ' +consultation.duree + ' minutes <br>' ;
            new_text += '</div>';

            $(".jumbotron-list").append(new_text);
        });
    });
    }
    if(window.location.pathname==="/historiqueemployee.html"){  
                 
        // Appel AJAX
        $.ajax({
        url:'./ActionServlet',
        method: 'POST',
        data: {
            todo: "listerconsultation-employe"
        },
        dataType: 'json'
    }).done(function(response){
        $.each(response.consultation, function(key, consultation){

            var new_text = '<div class="jumbotron consultation">';
                   
            new_text += ' Avec : ' + consultation.medium + '<br>';
            new_text += ' Client : ' +consultation.client + '<br>';
            new_text += ' Le : ' + consultation.dateDebut + '<br>';
            new_text += ' Durée : ' +consultation.duree + ' minutes <br>' ;
            new_text += ' Commentaire ' +consultation.commentaire +'<br>';
            new_text += '</div>';

            $(".jumbotron-list").append(new_text);
        });
    });
    }
    
});
