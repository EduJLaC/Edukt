package com.fisi.disoft.modelo.dao.mongo;

import com.fisi.disoft.modelo.dao.IVinoDAO;

import java.util.List;

public class MongoVinoDAO implements IVinoDAO {
    @Override
    public List<Integer> vinoConGradoSuperiorProducidoPor(int grado, int productor) {
        return null;
    }

    @Override
    public List<Integer> idVinoProducidoEnMayorCantidad() {
        return null;
    }

    @Override
    public int mostrarVinosSignificativos(int botellasProducidas) {
        return 0;
    }
}
