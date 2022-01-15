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
    var commentovalid = /^[a-zA-Z][-_a-zA-Z0-9]{1,250}$/
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
    var lezione_check = true;
    var luogo_valid = /^[a-zA-Z][-_a-zA-Z0-9]{2,250}$/;
    var luogo_form = document.getElementById("luogo");
    if(!luogo_valid.test(luogo_form.value) || luogo_form.value==''){
        lezione_check = false;
        luogo_form.focus();
        luogo_form.style.background = '#f08080';
    }
    if(!lezione_check){
        return false;
    }

    return true;
}
function validazioneRichiestaSupporto(){
    var insegnamento = document.getElementById();
    var oreRichieste = document.getElementById();
    var docente = document.getElementById();
    var luogo = document.getElementById();
    var check = true;
    var insegnamentoreg = /^[A-Za-z]+$/;
    var oreRichiestereg = /^[1-9][0-9]?$|^100$/;
    var docentereg = /^[A-Za-z]+$/;
    var luogoreg = /^[a-zA-Z0-9_.-]*$/;
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