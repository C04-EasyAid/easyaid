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
    var commentovalid = /^[a-zA-Z\s][-_a-zA-Z0-9]{2,250}$/
    var commento_form = document.getElementById("commento");
    let commento_check = true;
    if(!commentovalid.test(commento_form.value) || commento_form.value==='')
    {
        commento_check=false;
        commento_form.focus();
        commento_form.style.background='#f08080';
    }
    return commento_check;
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
function setLine()
{
    var input= document.getElementById("date_disponibili");
    input.value=input.value.replace(' ', '-');
    var inputore =document.getElementById("ore_disponibili");
    inputore.value=inputore.value.replace(' ','-');
}

function validazioneRichiestaTutorato(){
    var insegnamento = document.getElementById("insegnamento");
    var insegnamentoreg = /^[a-zA-Z\s]*$/;
    var docente = document.getElementById("docente_t");
    var docentereg = /^[a-zA-Z\s]*$/;
    var datereg = /^[a-zA-Z-\s]*$/;
    var orereg= /^[0-9-\s]*$/;
    var date_disponibili= document.getElementById("date_disponibili");
    var ore_disponibili =document.getElementById("ore_disponibili");
    let check = true;
    if(!date_disponibili.value.includes("lunedi") && !date_disponibili.value.includes("martedi") && !date_disponibili.value.includes("mercoledi")&& !date_disponibili.value.includes("giovedi")&& !date_disponibili.value.includes("venerdi") )
    {
        date_disponibili.focus();
        date_disponibili.style.background='#f08080';
        check= false;
    }

    if(!datereg.test(date_disponibili.value))
    {
        date_disponibili.focus();
        date_disponibili.style.background='#f08080';
        check=false;
    }

    if(!orereg.test(ore_disponibili.value))
    {
        check=false
        ore_disponibili.focus();
        ore_disponibili.style.background='#f08080';
    }
    if(!docentereg.test(docente.value))
    {
        check=false;
        docente.focus();
        docente.style.background='#f08080';
    }
    if(!insegnamentoreg.test(insegnamento.value))
    {
        check=false;
        insegnamento.focus();
        insegnamento.style.background='#f08080';
    }
    if(!check)
        return false;
    return true;
}

function validazioneRichiestaSupporto(){
    var insegnamento = document.getElementById("insegnamento");
    var oreRichieste = document.getElementById("ore_richieste");
    var docente = document.getElementById("docente");
    var luogo = document.getElementById("luogo");
    var check = true;
    var insegnamentoreg = /^[a-zA-Z\s]*$/;
    var oreRichiestereg = /^[1-9][0-9]?$|^100$/;
    var docentereg = /^[a-zA-Z\s]*$/;
    var luogoreg = /^[a-zA-Z0-9_.-]*$/;

    if(!insegnamentoreg.test(insegnamento.value)){
        check = false;
        insegnamento.focus();
        insegnamento.style.background='#f08080';
    }

    if(!oreRichiestereg.test(oreRichieste.value)){
        check = false;
        oreRichieste.focus();
        oreRichieste.style.background='#f08080';
    }

    if(!docentereg.test(docente.value)){
        check = false;
        docente.focus();
        docente.style.background='#f08080';
    }

    if(!luogoreg.test(luogo.value)){
        check = false;
        luogo.focus();
        luogo.style.background='#f08080';
    }

    if(!check){
        return false;
    }
    return true;
}

function setData() {
    var oggi = new Date();
    var dd = oggi.getDate();
    var mm = oggi.getMonth()+1; //Gennaio è 0 però aggiungo 1 per poterlo settare nell element
    var yyyy = oggi.getFullYear();
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }

    oggi = yyyy+'-'+mm+'-'+dd;
    document.getElementById("data").setAttribute("min", oggi);
    document.getElementById("data").setAttribute("value", oggi);
}