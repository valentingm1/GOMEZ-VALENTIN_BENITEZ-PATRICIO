package com.backend.parcial.service;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;

public class OdontologoService {
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

