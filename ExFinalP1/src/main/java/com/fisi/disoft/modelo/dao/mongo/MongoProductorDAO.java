package com.fisi.disoft.modelo.dao.mongo;

import com.fisi.disoft.modelo.dao.IProductorDAO;
import com.fisi.disoft.modelo.dao.entity.Productor;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoProductorDAO implements IProductorDAO {

    MongoCollection<Document> productoresC = MongoSource
            .getInstance()
            .getConnection()
            .getCollection("productores");

    @Override
    public List<Productor> productoresDeRegionPorProduccionMayorA(String region, int cantidad) {

        List<Productor> productores = new ArrayList<>();
        BasicDBObject whereQuery = BasicDBObject.parse(
                "{ $and: [ " +
                        "{ cantidadBotellas: {$gt: " + cantidad + "}}, " +
                        "{ region: \"" + region + "\"} " +
                        "] }");

        FindIterable<Document> cursor = productoresC.find(whereQuery);

        for (Document document : cursor) {
            productores.add(new Productor(document.getString("nombre"), document.getString("apellido")));
        }

        return productores;
    }

    @Override
    public List<Productor> productoresSinProduccion() {

        List<Productor> productores = new ArrayList<>();
        BasicDBObject whereQuery = BasicDBObject.parse(
                "{ cantidadBotellas: 0}"
        );

        FindIterable<Document> cursor = productoresC.find(whereQuery);
        for (Document document : cursor) {
            productores.add(new Productor(document.getString("nombre"), document.getString("apellido")));
        }

        return productores;
    }

    @Override
    public List<Productor> productoresPorProduccionSimilar(int idProductor) { // TODO fix
        return null;
    }

    @Override
    public List<Productor> productoresSinNombreNiProduccion() {

        List<Productor> productores = new ArrayList<>();
        BasicDBObject whereQuery = BasicDBObject.parse(
                "{ $and: [ " +
                        "{ nombre: \"\"}, " +
                        "{ cantidadBotellas: 0} " +
                        "] }");

        FindIterable<Document> cursor = productoresC.find(whereQuery);

        for (Document document : cursor) {
            productores.add(new Productor(document.getString("nombre"), document.getString("apellido")));
        }

        return productores;
    }

    @Override
    public List<Productor> productoresQueProducenALoMasVinos(int cantidadVinos) {
        List<Productor> productores = new ArrayList<>();
        BasicDBObject whereQuery = BasicDBObject.parse(
                "{ cantidadBotellas: {\"$gte\": " + cantidadVinos + "}}");

        FindIterable<Document> cursor = productoresC.find(whereQuery);

        for (Document document : cursor) {
            productores.add(new Productor(document.getString("nombre"), document.getString("apellido")));
        }

        return productores;
    }
}
