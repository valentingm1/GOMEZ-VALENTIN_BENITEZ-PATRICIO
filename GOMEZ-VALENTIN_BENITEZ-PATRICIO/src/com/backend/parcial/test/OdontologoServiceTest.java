package com.backend.parcial.test;

import com.backend.parcial.dao.implementacion.OdontologoDaoH2;
import com.backend.parcial.model.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.assertNotNull;

public class OdontologoServiceTest {
        private OdontologoService odontologoService;

    @BeforeAll
    static void doBefore() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/c1clase10;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void deberiaAgregarOdontologoEnMiH2(){
        odontologoService = new OdontologoService(new OdontologoDaoH2());

        Odontologo OdontologoAPersistir = new Odontologo((long)12121212,"Juan","Perez");

        Odontologo OdontologoPersistido = odontologoService.registrar(OdontologoAPersistir);

        assertNotNull(OdontologoPersistido.getId());
    }


}
