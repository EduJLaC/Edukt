package com.fisi.disoft.modelo.dao.sql;

import com.fisi.disoft.modelo.dao.IVinoDAO;
import org.sql2o.Connection;

import java.util.List;

import static com.fisi.disoft.modelo.dao.sql.SqlSource.getSQLConnection;

public class SqlVinoDAO implements IVinoDAO {

    @Override
    public List<Integer> vinoConGradoSuperiorProducidoPor(int grado, int productor) {

        try (Connection connection = getSQLConnection().open()) {
            return connection
                    .createQuery(
                            "SELECT DISTINCT " +
                                    "idVino " +
                                    "FROM VINOS v " +
                                    "INNER JOIN PRODUCCION pr " +
                                    "ON pr.vinos_idVino = v.idVino " +
                                    "WHERE (v.grado > :grado) " +
                                    "OR (productores_idProductor = :productor)")
                    .addParameter("grado", grado)
                    .addParameter("productor", productor)
                    .executeScalarList(Integer.class);
        }
    }

    @Override
    public List<Integer> idVinoProducidoEnMayorCantidad() {

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT vinos_idVino " +
                            "FROM PRODUCCION " +
                            "WHERE cantidadBotellas = " +
                            "(SELECT MAX(cantidadBotellas) " +
                            "FROM PRODUCCION)")
                    .executeScalarList(Integer.class);
        }
    }


    @Override
    public int mostrarVinosSignificativos(int botellasProducidas) {

        return 0; // TODO fix
//        try (Connection connection = getSQLConnection().open()) {
//            return connection.createQuery(
//                    "SELECT COUNT(pr.cantidadBotellas > :cantidad) " +
//                            "FROM PRODUCTORES p " +
//                            "INNER JOIN PRODUCCION pr " +
//                            "ON pr.productores_idProductor = p.idProductor")
//                    .addParameter("cantidad", botellasProducidas)
//                    .executeAndFetchTable();
//
//        }

    }
}
