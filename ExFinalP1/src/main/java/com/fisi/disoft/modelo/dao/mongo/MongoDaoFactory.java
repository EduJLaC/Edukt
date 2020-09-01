package com.fisi.disoft.modelo.dao.mongo;

import com.fisi.disoft.modelo.dao.DAOFactory;
import com.fisi.disoft.modelo.dao.IProductorDAO;
import com.fisi.disoft.modelo.dao.IVinoDAO;

public class MongoDaoFactory extends DAOFactory {
    @Override
    public IVinoDAO getVinoDAO() {
        return new MongoVinoDAO();
    }

    @Override
    public IProductorDAO getProductorDAO() {
        return new MongoProductorDAO();
    }
}
