package com.fisi.disoft.modelo.dao.sql;

import org.sql2o.Sql2o;

public class SqlSource {

    private static Sql2o sql2o;

    private SqlSource(){}

    /**
     * Genera la conexión con la base de datos
     * @return C
     */
    public static Sql2o getSQLConnection () {
        if (sql2o == null) {
            sql2o = new Sql2o("jdbc:mariadb://localhost:3306/final_p1_vinos", "root", "EduJLaC12!");
        }
        return sql2o;
    }

}
