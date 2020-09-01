package com.fisi.disoft.modelo.dao.sql;

import com.fisi.disoft.modelo.dao.IProductorDAO;
import com.fisi.disoft.modelo.dao.entity.Productor;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

import static com.fisi.disoft.modelo.dao.sql.SqlSource.getSQLConnection;

public class SqlProductorDAO implements IProductorDAO {

    @Override
    public List<Productor> productoresDeRegionPorProduccionMayorA(String region, int cantidad) {

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT p.* " +
                            "FROM PRODUCTORES p " +
                            "INNER JOIN PRODUCCION P2 " +
                            "on p.idProductor = P2.productores_idProductor " +
                            "WHERE p.region = :region " +
                            "AND P2.cantidadBotellas > :cantidad")
                    .addParameter("region", region)
                    .addParameter("cantidad", cantidad)
                    .executeAndFetch(Productor.class);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    @Override
    public List<Productor> productoresSinProduccion() {

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT p.idProductor, p.nombre, p.apellido " +
                            "FROM PRODUCTORES p " +
                            "INNER JOIN PRODUCCION P2 " +
                            "on p.idProductor = P2.productores_idProductor " +
                            "WHERE cantidadBotellas = 0")
                    .executeAndFetch(Productor.class);
        }
    }

    @Override
    public List<Productor> productoresPorProduccionSimilar(int idProductor) { // TODO fix Subquery returns more than 1 row

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT nombre, apellido " +
                            "FROM PRODUCTORES AS pda " +
                            "WHERE (" +
                            "SELECT  vinos_idVino " +
                            "FROM PRODUCCION " +
                            "WHERE productores_idProductor = pda.idProductor) " +
                            "IN (SELECT vinos_idVino FROM PRODUCCION WHERE productores_idProductor = :productor)")
                    .addParameter("productor", idProductor)
                    .executeAndFetch(Productor.class);
        }
    }


    @Override
    public List<Productor> productoresSinNombreNiProduccion() {

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT DISTINCT " +
                            "p.* " +
                            "FROM PRODUCTORES p " +
                            "INNER JOIN PRODUCCION P2 " +
                            "on p.idProductor = P2.productores_idProductor " +
                            "WHERE p.nombre IS NULL AND P2.cantidadBotellas = 0")
                    .executeAndFetch(Productor.class);
        }
    }

    @Override
    public List<Productor> productoresQueProducenALoMasVinos(int cantidadVinos) {

        try (Connection connection = getSQLConnection().open()) {
            return connection.createQuery(
                    "SELECT pd.nombre, pd.apellido " +
                            "FROM PRODUCTORES AS pd " +
                            "WHERE (" +
                            "SELECT COUNT(*) " +
                            "FROM PRODUCCION AS pc " +
                            "WHERE pc.productores_idProductor = pd.idProductor" +
                            ") >= :cantidad")
                    .addParameter("cantidad", cantidadVinos)
                    .executeAndFetch(Productor.class);
        }
    }
}
