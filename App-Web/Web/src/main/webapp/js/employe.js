/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    $.ajax({
        url: './ActionServlet',
        method: 'POST', 
        data: {
            todo: "obtenir-consultation"
        },
        dataType: 'json'
    })
    .done(function(response){
         if(response.success){
             $("#info").text("Vous avez un client en attente !");
             $("#info").addClass("alert-success")
             $("#client-info").removeClass("d-none");
             $(".client").attr("data-id", response.consultation["client-id"])
             $("#prenom").text(response.consultation["client-name"]);
             $("#nom").text(response.consultation["client-surname"]);
             $("#zodiaque").text(response.consultation["signeZodiaque"]);
             $("#astrologique").text(response.consultation["signeAstrologique"]);
             $("#couleur").text(response.consultation["couleur"]);
             $("#animal").text(response.consultation["animal"]);
         }else{
             $("#info").addClass("alert-danger")
             $("#info").text("Vous n'avez pas de client en attente !");
         }
    })
    .fail(function(e){
        console.log(e);
         $("#info").addClass("alert-danger")
         $("#info").text("il y eu un probleme dans la recuperation des informations");
    });
    
    
    $("#btn-accepter").on("click", function(){
        $.ajax({
            url: './ActionServlet',
            method:'POST',
            data: {
                todo: "accepter-consultation"
            },
            dataType: 'json'
        }).done(function(response){
            if(response.done){
                alert("Un message a ete envoye au client, vous alle etre redirigé sous peu")
                window.setTimeout(function(){
                    window.location = 'consultation.html';
                }, 1000)
            }
        })
    })
    
    
    $("#prediction-form").on("submit", function(e){
        e.preventDefault();
        $.ajax({
            url:'./ActionServlet',
            method:'POST',
            data:{
                todo:"generer-prediction",
                amour: $("#amour").val(),
                sante: $("#sante").val(),
                travail: $("#travail").val(),
                id: $(".client").attr("data-id")
            },
            dataType: 'json'
        })
        .done(function(response){
            console.log(response);
            var new_text = '<div class="jumbotron-prediction">';
            
                   
            new_text += ' Amour : ' + response.prediction.Amour + '<br><br>';
            new_text += ' Santé : ' + response.prediction.Sante + '<br><br>';
            new_text += ' Travail : ' + response.prediction.Travail + '<br><br>';
            
         
            $(".jumbotron-prediction").html(new_text);
        })
    })
    
    $(".validation-form").on("submit", function(e){
            e.preventDefault();
            $.ajax({
                url:'./ActionServlet',
                method:'POST',
                data:{
                    todo:"finir-consultation",
                    fin: $("#datefin").val(),
                    debut: $("#datedeb").val(),
                    commentaire : $("#commentaire").val()
                },
                dataType: 'json'

            }).done(function(response){
                if(response.success){
                    alert("La consultation s'est bien terminée");
                }
                else{
                    alert("La consultation s'est mal terminee");
                }
            })
    })
    if(window.location.pathname!=="/consultation.html"){  
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

                new_text += ' incarnation : ' + consultation.medium + '<br>';
                new_text += ' Le : ' + consultation.dateDebut + '<br>';
                new_text += ' client : ' + consultation.client + '<br>';
                new_text += ' duree : ' +consultation.duree + 'min<br>';
                new_text += '</div>';

                $(".jumbotron-list").append(new_text);
            });
        });
    }
});