//const idList = document.getElementsByClassName("deleteUser");

//document.getElementById("delete").addEventListener("click", deleteUser, false);


function countNameCharacters() {

    let name = document.getElementById("name").value;
    let countName = name.length;

    if (countName < 5) {
        document.getElementById("countName").innerHTML = `O nome deve possuir pelo menos 5 caracteres.`;
        return false;
    } else {
        document.getElementById("countName").innerHTML = "";
        return true;
    }

}

function validateEmail() {
    if (!/([A-Za-z0-9\.\-\_]{2,})@([a-z0-9]{2,})(\.[a-z]{2,})(\.[a-z]{2,})?/.test(document.getElementById("email").value)) {
        document.getElementById("validateEmail").innerHTML = "Digite um email válido (exemplo: email@email.com)";
        return false;
    } else {
        document.getElementById("validateEmail").innerHTML = "";
        return true;
    }
}

function validatePassword() {

    let password = document.getElementById("password").value;
    
    if (/\d/.test(password)) {

        document.querySelector("#num").setAttribute("style","color: #009900");
    } else {
        document.querySelector("#num").setAttribute("style","color: #990000");
    }

    if (/[a-z]/.test(password)) {

        document.querySelector("#lowChar").setAttribute("style","color: #009900");
    } else {
        document.querySelector("#lowChar").setAttribute("style","color: #990000");
    }

    if (/[A-Z]/.test(password)) {

        document.querySelector("#upChar").setAttribute("style","color: #009900");
    } else {
        document.querySelector("#upChar").setAttribute("style","color: #990000");
    }

    if (password.length >= 6 && password.length <= 20){
        document.querySelector("#passwordLength").setAttribute("style","color: #009900");
    } else {
        document.querySelector("#passwordLength").setAttribute("style","color: #990000");
    }

}

function validateForm() {

    let regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;

    if (countNameCharacters() && regex.test(document.getElementById("password").value) && validateEmail()) {
        return confirm('Deseja confirmar o cadastro?');
    } else {
        alert('Dados inválidos, revise todos os campos e tente novamente');
        return false;
    }

}

function deleteUser(id) {
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.open("DELETE", "http://localhost:8080/users/delete/" + id)
    xmlhttp.send();
    window.location.href = "http://localhost:8080/users";

    //fetch('/users/delete/' + id, { method: 'DELETE'})
}