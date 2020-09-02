package com.fisi.disoft.modelo.dao.mongo;

import com.fisi.disoft.modelo.dao.IVinoDAO;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class MongoVinoDAO implements IVinoDAO {

    MongoCollection<Document> cursorVino = MongoSource.getInstance().getConnection().getCollection("productores");

    @Override
    public List<Integer> vinoConGradoSuperiorProducidoPor(int grado, int productor) {

        List<Integer> vinos = new ArrayList<>();
        BasicDBObject whereQuery = BasicDBObject.parse(
                "{ $and: [ " +
                        "{ grado: {$gt: " + grado + "}}, " +
//                        "{ _id: \"" + "5f4dd6b27076a32cbbec2df4" + "\"} " +
                        "] }");

        FindIterable<Document> cursor = cursorVino.find(whereQuery);

        for (Document dc: cursor) {
            vinos.add(dc.getObjectId("_id").getCounter());
        }

        return vinos;
    }

    @Override
    public List<Integer> idVinoProducidoEnMayorCantidad() {

        BasicDBObject whereQuery = BasicDBObject.parse("{" +
                "\"$group\": " +
                "{\"_id\": null, " +
                "\"maxV\": {\"$max\": \"$cantidadBotellas\"}" +
                "}}");

        List<Bson> bsons = new ArrayList<>();
        bsons.add(whereQuery);
        int max = cursorVino.aggregate(bsons).iterator().next().getInteger("maxV");

        whereQuery = new BasicDBObject();
        whereQuery.put("cantidadBotellas", max);
        FindIterable<Document> cursor = cursorVino.find(whereQuery);

        List<Integer> vinos = new ArrayList<>();
        for (Document dc: cursor) {
            vinos.add(dc.getObjectId("_id").getCounter());
        }

        return vinos;
    }

    @Override
    public int mostrarVinosSignificativos(int botellasProducidas) {
        return 0;
    }
}

/*
Document{{_id=5f4dd6b27076a32cbbec2df4, nombre=, apellido=Cooperative, region=Bourgogne, vino=Mercurey, grado=12, year=1980, cantidadBotellas=500}}
Document{{_id=5f4dd6b27076a32cbbec2df9, nombre=Rene, apellido=Monnier, region=Bourgogne, vino=Mercurey, grado=10, year=1980, cantidadBotellas=500}}
Document{{_id=5f4dd6b27076a32cbbec2e0d, nombre=Jean Claude, apellido=Menand, region=Bourgogne, vino=Cotes du Rhone, grado=12, year=1968, cantidadBotellas=500}}
Document{{_id=5f4dd6b27076a32cbbec2e0e, nombre=, apellido=Cooperative, region=Bourgogne, vino=Chateau Chalon, grado=10, year=1978, cantidadBotellas=500}}
Document{{_id=5f4dd6b27076a32cbbec2e23, nombre=Jean, apellido=Lapierre, region=Bourgogne, vino=Richebourg, grado=12, year=1943, cantidadBotellas=500}}
Document{{_id=5f4dd6b27076a32cbbec2e70, nombre=Philippe, apellido=Mestre, region=Bourgogne, vino=Palette, grado=11, year=1969, cantidadBotellas=500}}
* */