function cadastrar(){

   var mensagem = {
       nomeArtistico : document.getElementById("txtNome").value,
       nacionalidade : document.getElementById("txtEmail").value,
       nacionalidade : document.getElementById("txtCelular").value,
       nacionalidade : document.getElementById("txtData").value,
       nacionalidade : document.getElementById("txtAgencia").value,
       nacionalidade : document.getElementById("ttHoraIni").value,
       nacionalidade : document.getElementById("ttHoraFim").value
   }
    
   var cabecalho = {
       method:"POST",
       body:JSON.stringify(mensagem),
       headers:{
            "Content-Type":"Application/json"
       }
   }

       fetch("http://localhost:8080/novoagendamento", cabecalho)
       .then(res => res.json())
       .then(res => {window.alert("Gravado co sucesso.");})
       .catch(err => {window.alert("Erro.");});
 
}


function carregarArtistas(){
    var usuarioLogado = localStorage.getItem("logado");
    if (!usuarioLogado){
        window.location="index.html";
    }else{
        fetch("http://localhost:8080/artistas")
        .then(res => res.json())
        .then(res => preencherArtistas(res));
    }
}


function preencherArtistas(lista){
 
    var saida = 
    "<div class='row>" + 
    "<div class='col-12>" +
    "<table border='1' cellpadding='5' cellspacing='2' align='center' width'80%'>" +
    "<tr>" + 
    "<th>Artista</th> <th>Nacionalidade</th> <th>Nascimento</th>" + 
    "</tr>";
    for(i=0;i<lista.length;i++){
        saida+=
        "<tr>" +
        "<td>" + lista[i].nomeArtistico + "</td>" +
        "<td>" + lista[i].nacionalidade + "</td>" +
        "<td>" + lista[i].nascimento + "</td>" +
        "</tr>";
    }
    saida+="</table></div></div>"
    document.getElementById("artistas").innerHTML=saida;
}
    
