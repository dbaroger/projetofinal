function logar(){
    /* Area de Teste
    window.alert(document.getElementById("txtEmail").value);
    window.alert(document.getElementById("txtSenha").value);
    */
   
    
   if (document.getElementById("txtUser").value.indexOf("@")==-1){ 
        var mensagem = {
            racf:document.getElementById("txtUser").value,
            senha:document.getElementById("txtPass").value
                    }
    }else{
        var mensagem = {
            email:document.getElementById("txtUser").value,
            senha:document.getElementById("txtPass").value
                    }
    }

    var cabecalho = {
        method:"POST",
        body:JSON.stringify(mensagem),
        headers:{
            "Content-Type":"application/json"
        }
    }

    teste = JSON.stringify(cabecalho);
    window.alert(teste);

    if (document.getElementById("txtUser").value.indexOf("@")==-1){    
            fetch("http://localhost:8080/loginbyracf", cabecalho)
            .then(res => res.json())
            .then(res => {
                            //localStorage.setItem("logado", JSON.stringify(res));
                            //window.location="usuario.html";
                            window.alert("Logado!");
                        })
            .catch(err => {
                            window.alert("Erro");
                        });
    } else {
        fetch("http://localhost:8080/loginbyemail", cabecalho)
        .then(res => res.json())
        .then(res => {
                        //localStorage.setItem("logado", JSON.stringify(res));
                        //window.location="usuario.html";
                        window.alert("Logado!");
                    })
        .catch(err => {
                        window.alert("Erro");
                    });
    }
}