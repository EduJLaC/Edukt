package com.fisi.disoft.modelo.dao;

import com.fisi.disoft.modelo.dao.entity.Productor;
import com.fisi.disoft.modelo.dao.entity.Vino;

import java.util.List;

public interface IVinoDAO {

    /**
     * Pregunta 2 <br>
     * Número de identificación de los vinos que tienen un grado superior a uno determinado o que han sido
     * producidos por el productor determinado
     * @param grado grado del vino
     * @param productor el que produce el vino
     * @return Numero de identificación de los vinos
     */
    List<Integer> vinoConGradoSuperiorProducidoPor(int grado, int productor);

    /**
     * Pregunta 4 <br>
     *     número de identificación de el(los) vino(s) que se ha producido en mayor cantidad.
     * @return Numero de identificación del vino
     */
    List<Integer> idVinoProducidoEnMayorCantidad();

    /**
     * Pregunta 6 <br>
     * Muestra para cada productor el número de vinos significativos
     * @param botellasProducidas las botellas producidas
     * @return el numero de vinos significativos
     */
    int mostrarVinosSignificativos(int botellasProducidas);
}
