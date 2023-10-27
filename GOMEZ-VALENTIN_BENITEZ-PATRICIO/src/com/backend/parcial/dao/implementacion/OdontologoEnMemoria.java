package com.backend.parcial.dao.implementacion;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoEnMemoria implements IDao<Odontologo> {
    private final Logger LOGGER = Logger.getLogger(OdontologoEnMemoria.class);
    private List<Odontologo> ListaOdontologos;

    public OdontologoEnMemoria(List<Odontologo> listaOdontologos) {
        ListaOdontologos = listaOdontologos;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Long id = (long) (ListaOdontologos.size() + 1);
        ListaOdontologos.add(odontologo);
        Odontologo odontologoGuardado = new Odontologo(odontologo.getNroMatricula(),odontologo.getNombre(),odontologo.getApellido(),id);
        LOGGER.info("Odontologo guardado: " + odontologoGuardado);
        return odontologo;
    }

    @Override
    public Odontologo mostrarOdontologos() {
        LOGGER.info(ListaOdontologos);
        return null;
    }


}
