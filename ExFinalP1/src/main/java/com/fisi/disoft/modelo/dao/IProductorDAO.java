package com.fisi.disoft.modelo.dao;

import com.fisi.disoft.modelo.dao.entity.Productor;

import java.util.List;

public interface IProductorDAO {

    /**
     * Pregunta 1 <br>
     * Muestra el nombre y el apellido de los productores de una región determinada que han tenido una producción
     * superior a una cantidad determinada de botellas
     * @param region la region del productor
     * @param cantidad la cantidad de botellas producidas
     * @return lista de productores
     */
    List<Productor> productoresDeRegionPorProduccionMayorA(String region, int cantidad);

    /**
     * Pregunta 3 <br>
     * Número, nombre y apellido de los productores que no han producido vinos
     * @return lista de productores
     */
    List<Productor> productoresSinProduccion();

    /**
     * Pregunta 7 <br>
     *     Productores que producen al menos todos los vinos que son producidos por el productor determinado
     * @param idProductor id del productor
     * @return lista de productores con produccion similar
     */
    List<Productor> productoresPorProduccionSimilar(int idProductor);

    /**
     * Pregunta 8 <br>
     * Productores que no tienen nombre y que no tengan producción alguna
     * @return lista de productores
     */
    List<Productor> productoresSinNombreNiProduccion();

    /**
     * Pregunta 5 <br>
     * Nombre y su apellido de los productores que producen por lo menos N vinos diferentes
     * @param cantidadVinos cantidad de vinos diferentes producidos
     * @return lista de productores
     */
    List<Productor> productoresQueProducenALoMasVinos(int cantidadVinos);
}
