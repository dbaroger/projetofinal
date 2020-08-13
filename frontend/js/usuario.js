function carregarUsuario(){
    var usuarioLogado = localStorage.getItem("logado");

    if (!usuarioLogado){
        window.location="index.html";
    }else{
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("foto").innerHTML = 
            "<img alt='Imagem não encontrada' width='20%' src=images/" + usuarioJson.foto + ">";
        document.getElementById("dados").innerHTML = 
            "<h3>" + usuarioJson.nome + " <br> " + usuarioJson.email + " <br>ID: " + usuarioJson.id + "</h3>"
    }
}
