package model.dao;

import model.bean.StudenteBean;

import java.sql.SQLException;

public interface IStudenteDAO {
    //Metodo che restituisce lo studente
    StudenteBean doRetrieveByEmail(String email) throws SQLException;
}
