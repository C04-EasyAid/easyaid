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