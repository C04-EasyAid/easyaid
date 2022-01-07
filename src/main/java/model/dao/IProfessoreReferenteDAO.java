package model.dao;

import model.bean.ProfessoreReferenteBean;

import java.sql.SQLException;

public interface IProfessoreReferenteDAO {
    ProfessoreReferenteBean doRetrieveByEmail(String email) throws SQLException, ClassNotFoundException;
}
