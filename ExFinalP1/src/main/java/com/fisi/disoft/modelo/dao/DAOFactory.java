package com.fisi.disoft.modelo.dao;

import com.fisi.disoft.modelo.dao.mongo.MongoDaoFactory;
import com.fisi.disoft.modelo.dao.sql.SqlDaoFactory;

public abstract class DAOFactory {

    public static final int Relacional = 1;
    public static final int NoRelacional = 2;

    public abstract IVinoDAO getVinoDAO();
    public abstract IProductorDAO getProductorDAO();

    public static DAOFactory getDAOFactory(int factory) {
        switch (factory) {
            case Relacional:
                return new SqlDaoFactory();
            case NoRelacional:
                return new MongoDaoFactory();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
