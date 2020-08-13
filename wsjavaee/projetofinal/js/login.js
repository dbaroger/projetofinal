function logar(){
    /* Area de Teste
    window.alert(document.getElementById("txtEmail").value);
    window.alert(document.getElementById("txtSenha").value);
    */

    var mensagem = {
        email:document.getElementById("txtEmail").value,
        senha:document.getElementById("txtSenha").value
    }

    var cabecalho = {
        method:"POST",
        body:JSON.stringify(mensagem),
        headers:{
            "Content-Type":"application/json"
        }
    }

    fetch("http://localhost:8080/login", cabecalho)
    .then(res => res.json())
    .then(res => {
                    localStorage.setItem("logado", JSON.stringify(res));
                    window.location="usuario.html";
                })
    .catch(err => {
                    window.alert("Erro");
                });
}