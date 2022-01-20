function validate()
{
    var email_valid=/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    var email_form=document.getElementById("email");
    var email_check=true;
    if(!email_valid.test(email_form.value) || email_form.value=='')
    {
        email_check=false;
        email_form.focus();
        email_form.style.background='#f08080';
    }
    if(!email_check)
    {
        return (false);
    }
    return (true);
}
function validateInserimento()
{
    var pass_valid="/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{12,}$/";
    var email_valid=/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    var email_form=document.getElementById("email");
    var pass_form=document.getElementById("password")
    var email_check=true;
    var pass_check=true;
    if(!email_valid.test(email_form.value) || email_form.value=='')
    {
        email_check=false;
        email_form.focus();
        email_form.style.background='#f08080';
    }
    if(!pass_valid.test(pass_form.value) || pass_form.value=='')
    {
        pass_check=false;
        pass_form.focus();
        pass_form.style.background='#f08080';
    }
    if(!email_check || !pass_check)
    {
        return (false);
    }
    return (true);
}
function changeInput()
{
    var disabile_check=document.getElementById("disabile");
    var dsa_check=document.getElementById("dsa");
    var specifica_value=document.getElementById("specifica");
    disabile_check.addEventListener("change",function (){
        specifica_value.readOnly=false;
    });
    dsa_check.addEventListener("change",function (){
        specifica_value.readOnly=true;
    });
}

function inserimentoCommento(){
    var commentovalid = /^[a-zA-Z][-_a-zA-Z0-9]{2,250}$/
    var commento_form = document.getElementById("commento");
    var commento_check = true;
    if(!commento_valid.test(commento_form.value) || commento_form.value=='')
    {
        commento_check=false;
        commento_form.focus();
        commento_form.style.background='#f08080';
    }
    if(!commento_check)
    {
        return (false);
    }
    return (true);
}

function inserimentoLezione() {
    var luogo_form = document.getElementById("luogo");
    if(luogo_form.length.value()<2 || luogo_form.length.value()>250 ){
        luogo_form.focus();
        luogo_form.style.background='#f08080';
        return false;
    }

    return true;
}
function validazioneRichiestaSupporto(){
    var UserDate = document.getElementById("data").value;
    console.log("DATA:-->"+UserDate);
    var insegnamento = document.getElementById("insegnamento");
    var oreRichieste = document.getElementById("ore_richieste");
    var docente = document.getElementById("docente");
    var luogo = document.getElementById("luogo");
    var ToDate = new Date();
    var check = true;
    var insegnamentoreg = /^[A-Za-z]+$/;
    var oreRichiestereg = /^[1-9][0-9]?$|^100$/;
    var docentereg = /^[A-Za-z]+$/;
    var luogoreg = /^[a-zA-Z0-9_.-]*$/;

    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
        check=false;
    }

    if(!insegnamentoreg.test(insegnamento.value)){
        check = false;
        insegnamento.focus();
    }

    if(!oreRichiestereg.test(oreRichieste.value)){
        check = false;
        oreRichieste.focus();
    }

    if(!docentereg.test(docente.value)){
        check = false;
        docente.focus();
    }

    if(!luogoreg.test(luogo.value)){
        check = false;
        luogo.focus();
    }

    if(!check){
        return false;
    }
    return true;
}

function validaData() {
    var UserDate = document.getElementById("data").value;
    var ToDate = new Date();

    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
        alert("The Date must be Bigger or Equal to today date");
        return false;
    }
    else
        alert("ciacia");
    return true;
}