function validate() {
    const email_valid = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    const email_form = document.getElementById("email");
    let email_check = true;
    if (!email_valid.test(email_form.value) || email_form.value === '') {
        email_check = false;
        email_form.focus();
        email_form.style.background = '#f08080';
    }
    return email_check;

}

function validateInserimento() {
    const pass_valid = "/^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{12,}$/";
    const email_valid = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/;
    const email_form = document.getElementById("email");
    const pass_form = document.getElementById("password");
    let check = true;
    if (!email_valid.test(email_form.value) || email_form.value === '') {
        check = false;
        email_form.focus();
        email_form.style.background = '#f08080';
    }
    if (!pass_valid.test(pass_form.value) || pass_form.value === '') {
        check = false;
        pass_form.focus();
        pass_form.style.background = '#f08080';
    }
    return check;

}

function changeInput() {
    const disabile_check = document.getElementById("disabile");
    const dsa_check = document.getElementById("dsa");
    const specifica_value = document.getElementById("specifica");
    disabile_check.addEventListener("change", function () {
        specifica_value.readOnly = false;
    });
    dsa_check.addEventListener("change", function () {
        specifica_value.readOnly = true;
    });
}

function inserimentoCommento() {
    const commentovalid = /^[a-zA-Z\s][-_a-zA-Z0-9]{2,250}$/;
    const commento_form = document.getElementById("commento");
    let commento_check = true;
    if (!commentovalid.test(commento_form.value) || commento_form.value === '') {
        commento_check = false;
        commento_form.focus();
        commento_form.style.background = '#f08080';
    }
    return commento_check;
}

function inserimentoLezione() {
    const luogo_form = document.getElementById("luogo");
    if (luogo_form.length.value() < 2 || luogo_form.length.value() > 250) {
        luogo_form.focus();
        luogo_form.style.background = '#f08080';
        return false;
    }

    return true;
}

function setLine() {
    const input = document.getElementById("date_disponibili");
    input.value = input.value.replace(' ', '-');
    const inputore = document.getElementById("ore_disponibili");
    inputore.value = inputore.value.replace(' ', '-');
}

function validazioneRichiestaTutorato() {
    const insegnamento = document.getElementById("insegnamento");
    const insegnamentoreg = /^[a-zA-Z\s]*$/;
    const docente = document.getElementById("docente_t");
    const docentereg = /^[a-zA-Z\s]*$/;
    const datereg = /^[a-zA-Z-\s]*$/;
    const orereg = /^[0-9-:\s]*$/;
    var date_disponibili = document.getElementById("date_disponibili");
    date_disponibili.value = date_disponibili.value.replaceAll('ì', 'i');
    const ore_disponibili = document.getElementById("ore_disponibili");
    let check = true;
    if (!date_disponibili.value.includes("lunedi") && !date_disponibili.value.includes("martedi") && !date_disponibili.value.includes("mercoledi") && !date_disponibili.value.includes("giovedi") && !date_disponibili.value.includes("venerdi")) {
        date_disponibili.focus();
        date_disponibili.style.background = '#f08080';
        check = false;
    }

    if (!datereg.test(date_disponibili.value)) {
        date_disponibili.focus();
        date_disponibili.style.background = '#f08080';
        check = false;
    }

    if (!orereg.test(ore_disponibili.value)) {
        check = false
        ore_disponibili.focus();
        ore_disponibili.style.background = '#f08080';
    }
    if (!docentereg.test(docente.value)) {
        check = false;
        docente.focus();
        docente.style.background = '#f08080';
    }
    if (!insegnamentoreg.test(insegnamento.value)) {
        check = false;
        insegnamento.focus();
        insegnamento.style.background = '#f08080';
    }
    return check;

}

function validazioneRichiestaSupporto() {
    const insegnamento = document.getElementById("insegnamento");
    const oreRichieste = document.getElementById("ore_richieste");
    const docente = document.getElementById("docente");
    const luogo = document.getElementById("luogo");
    let check = true;
    const insegnamentoreg = /^[a-zA-Z\s]*$/;
    const oreRichiestereg = /^[1-9][0-9]?$|^100$/;
    const docentereg = /^[a-zA-Z\s]*$/;
    const luogoreg = /^[a-zA-Z0-9\s_.-]*$/;

    if (!insegnamentoreg.test(insegnamento.value)) {
        check = false;
        insegnamento.focus();
        insegnamento.style.background = '#f08080';
    }

    if (!oreRichiestereg.test(oreRichieste.value)) {
        check = false;
        oreRichieste.focus();
        oreRichieste.style.background = '#f08080';
    }

    if (!docentereg.test(docente.value)) {
        check = false;
        docente.focus();
        docente.style.background = '#f08080';
    }

    if (!luogoreg.test(luogo.value)) {
        check = false;
        luogo.focus();
        luogo.style.background = '#f08080';
    }

    return check;

}

function setData() {
    var oggi = new Date();
    let dd = oggi.getDate();
    let mm = oggi.getMonth() + 1; //Gennaio è 0 però aggiungo 1 per poterlo settare nell element
    const yyyy = oggi.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    oggi = yyyy + '-' + mm + '-' + dd;
    document.getElementById("data").setAttribute("min", oggi);
    document.getElementById("data").setAttribute("value", oggi);
}