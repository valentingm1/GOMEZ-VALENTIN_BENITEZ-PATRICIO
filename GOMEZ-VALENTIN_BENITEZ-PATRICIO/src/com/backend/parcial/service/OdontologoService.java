package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;

public class OdontologoService {
    //capa de logica de negocio que interactua con la capa de persistencia, pero desconoce los detalles de la implementacion de esa persistencia
    private IDao<Odontologo> OdontologoIDao;


    public OdontologoService(IDao<Odontologo> OdontologoIDao) {
        this.OdontologoIDao = OdontologoIDao;
    }

    public Odontologo registrar(Odontologo odontologo) {
        return OdontologoIDao.registrar(odontologo);
    }

    public Odontologo mostrarOdontologos(){
        return  OdontologoIDao.mostrarOdontologos();
    }


}

