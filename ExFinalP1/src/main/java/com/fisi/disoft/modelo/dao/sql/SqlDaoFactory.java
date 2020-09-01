package com.fisi.disoft.modelo.dao.sql;

import com.fisi.disoft.modelo.dao.DAOFactory;
import com.fisi.disoft.modelo.dao.IProductorDAO;
import com.fisi.disoft.modelo.dao.IVinoDAO;

public class SqlDaoFactory extends DAOFactory {

    @Override
    public IVinoDAO getVinoDAO() {
        return new SqlVinoDAO();
    }

    @Override
    public IProductorDAO getProductorDAO() {
        return new SqlProductorDAO();
    }
}
