package model.dao;

import model.bean.TutorBean;

import java.sql.SQLException;

public interface ITutorDAO {
  TutorBean doRetrieveByEmail(String email) throws SQLException, ClassNotFoundException;
}
