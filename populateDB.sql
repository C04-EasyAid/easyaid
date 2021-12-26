INSERT INTO utente VALUES('Lorenzo','Rossi','lorenzorossi1@studenti.unisa.it','Lorenzo#rossi1','T');
INSERT INTO utente VALUES('Paolo','Serrati','paoloserrati23@studenti.unisa.it','Paolo#Serrati23','T');
INSERT INTO utente VALUES('Marco','Di Bianco','mdibianco45@studenti.unisa.it','MarcoD#B1anc0','T');
INSERT INTO utente VALUES('Marco','Verdi','marcoverdi4@studenti.unisa.it','Mark#Verdi45','S');
INSERT INTO utente VALUES('Aldo','Baglio','abaglio9@studenti.unisa.it','Aldo#Baglio45','S');
INSERT INTO utente VALUES('Francesco','Neri','fneri34@studenti.unisa.it','Franc3#Ner154','S');
INSERT INTO utente VALUES('Riccardo','Distasi','rdistasi@unisa.it','R#Distasi#908','P');
INSERT INTO utente VALUES('Maurizio','lamberti','mlamberti78@unisa.it','M#Lamberti890','P');
INSERT INTO utente VALUES('Giacomo','Poretti','gporetti89@unisa.it','G#Poretti9083','P');
INSERT INTO utente VALUES('Giuseppe','Falchi','gfalchi67@unisa.it','Giu@Falchi895','PA');
INSERT INTO utente VALUES('Paolo','Neri','paoloneri45@unisa.it','Paolo#Neri892','PA');
INSERT INTO utente VALUES('Giovanni','Storti','gstorti67@unisa.it','Gio#Storti786','PA');

INSERT INTO tutor  VALUES ('lorenzorossi1@studenti.unisa.it', 'informatica', 'Laurea Triennale', '3', '17');
INSERT INTO tutor  VALUES ('paoloserrati23@studenti.unisa.it', 'informatica', 'Laurea Triennale', '16', '4');
INSERT INTO tutor  VALUES ('mdibianco45@studenti.unisa.it', 'economia', 'Laurea Triennale', '0', '20');

INSERT INTO studente  VALUES ('marcoverdi4@studenti.unisa.it', 'disabile', 'motorie', '50', '30');
INSERT INTO studente  VALUES ('abaglio9@studenti.unisa.it', 'DSA', 'dislessia', '15', '22');
INSERT INTO studente  VALUES ('fneri34@studenti.unisa.it', 'DSA', 'discalculia', '15', '14');

INSERT INTO professore_referente  VALUES ('rdistasi@unisa.it', 'informatica');
INSERT INTO professore_referente  VALUES ('mlamberti78@unisa.it', 'economia');
INSERT INTO professore_referente  VALUES ('gporetti89@unisa.it', 'farmacia');

INSERT INTO personale_amministrativo  VALUES ('gfalchi67@unisa.it');
INSERT INTO personale_amministrativo  VALUES ('paoloneri45@unisa.it');
INSERT INTO personale_amministrativo  VALUES ('gstorti67@unisa.it');

INSERT INTO supporto_esame (data, ora, ore_richieste, docente, modalità_esame, eventuali_ausili, tipo_di_assistenza, status, insegnamento, commento, luogo, dipartimento, studente_email) VALUES ('2021/08/11', '10:00', '5', 'del vecchio', 'scritto e orale', 'nessuno', 'tutor lettore', '2', 'Analisi 1', 'Ti aspetto all edificio E2', 'Edificio E2 aula e8', 'economia', 'fneri34@studenti.unisa.it');
INSERT INTO supporto_esame (data, ora, ore_richieste, docente, modalità_esame, eventuali_ausili, tipo_di_assistenza, status, insegnamento, commento, luogo, dipartimento, studente_email) VALUES ('2022-01-18', '9:30', '3', 'ferrucci', 'scritto', 'tempo aggiuntivo', 'tutor scrittore', '0', 'Ingegneria del Software', '', 'Edificio F3 aula p4', 'informatica', 'marcoverdi4@studenti.unisa.it');

INSERT INTO tutorato_didattico(date_disponibili,ore_disponibili,ore_richieste,status,insegnamento,dipartimento,studente_email) VALUES ('Lunedì,Martedì','Lunedì:16:30,Martedì:17:30',7,0,'Reti di calcolatori','informatica','marcoverdi4@studenti.unisa.it');
INSERT INTO tutorato_didattico(date_disponibili,ore_disponibili,ore_richieste,commento,status,insegnamento,dipartimento,studente_email,tutor_email) VALUES ('Mercoledì,Giovedì','Mercoledì:16:30,Giovedì:09:30',4,'Ci vediamo mercoledì!',1,'Programmazione 1','informatica','abaglio9@studenti.unisa.it','lorenzorossi1@studenti.unisa.it');

INSERT INTO lezione (tutorato, ora_inizio, ora_fine, data, tutor, status) VALUES ('13', '16:30', '18:00', '2021-12-15', 'lorenzorossi1@studenti.unisa.it', '1');
INSERT INTO lezione (tutorato, ora_inizio, ora_fine, data, tutor, status) VALUES ('13', '10:00', '12:00', '2021-12-16','lorenzorossi1@studenti.unisa.it', 1);
INSERT INTO lezione (tutorato, ora_inizio, ora_fine, data, tutor, status) VALUES ('13', '16:30', '18:30', '2021-12-22','lorenzorossi1@studenti.unisa.it', '0'); 

INSERT INTO commento (`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('5', '13', 'ok, ci sarò', '2021-12-13', '9:21', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
INSERT INTO commento(`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('6', '13', 'va bene!', '2021-12-15', '11:34', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
INSERT INTO commento (`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('7', '13', 'possiamo spostare la data?', '2021-12-22', '17:30', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
INSERT INTO commento (`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('7', '13', 'Nessun problema!.', '2021-12-22', '17:33', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
INSERT INTO commento (`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('5', '13', 'ci vediamo sempre nella stessa aula!', '2021-12-13', '9:11', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
INSERT INTO commento (`lezione`, `tutorato`, `testo`, `data`, `ora`, `studente`, `tutor`) VALUES ('6', '13', 'a domani!', '2021-12-15', '12:05', 'abaglio9@studenti.unisa.it', 'lorenzorossi1@studenti.unisa.it');
