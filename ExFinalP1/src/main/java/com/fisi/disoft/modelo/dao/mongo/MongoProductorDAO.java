package com.fisi.disoft.modelo.dao.mongo;

import com.fisi.disoft.modelo.dao.IProductorDAO;
import com.fisi.disoft.modelo.dao.entity.Productor;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.List;

public class MongoProductorDAO implements IProductorDAO {
    @Override
    public List<Productor> productoresDeRegionPorProduccionMayorA(String region, int cantidad) {

        System.out.println(MongoSource.getInstance().getConnection().getCollection("productores"));
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("cantidadBotellas", 500);
        FindIterable<Document> cursor = MongoSource.getInstance().getConnection().getCollection("productores").find(whereQuery);
        while (cursor.iterator().hasNext()) {
            System.out.println(cursor.iterator());
        }

        return null;
    }

    @Override
    public List<Productor> productoresSinProduccion() {
        return null;
    }

    @Override
    public List<Productor> productoresPorProduccionSimilar(int idProductor) {
        return null;
    }

    @Override
    public List<Productor> productoresSinNombreNiProduccion() {
        return null;
    }

    @Override
    public List<Productor> productoresQueProducenALoMasVinos(int cantidadVinos) {
        return null;
    }
}
