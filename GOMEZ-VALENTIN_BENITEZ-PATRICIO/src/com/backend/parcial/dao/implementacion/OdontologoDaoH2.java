package com.backend.parcial.dao.implementacion;

import com.backend.parcial.dao.H2Connection;
import com.backend.parcial.dao.IDao;
import com.backend.parcial.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo){
        Connection connection = null;
        Odontologo OdontologoPersistido = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);



            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NROMATRICULA,NOMBRE,APELLIDO) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, odontologo.getNroMatricula());
            preparedStatement.setString(2,odontologo.getNombre());
            preparedStatement.setString(3,odontologo.getApellido());
            preparedStatement.execute();

            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()){
                OdontologoPersistido = new Odontologo(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
            }

            LOGGER.info("Se guardó el odontólogo: " + OdontologoPersistido);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Hubo un error con la base de datos:" + ex.getMessage());
            }
        }

        return OdontologoPersistido;
    }

    @Override
    public Odontologo mostrarOdontologos() {
            ArrayList<Odontologo> ListaOdontologos = new ArrayList<>();
            Odontologo odontologo = null;
            Connection connection = null;
            try {
                connection = H2Connection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    odontologo = crearObjetoOdontologo(resultSet);
                    ListaOdontologos.add(odontologo);

                }
                LOGGER.info(ListaOdontologos);

            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception ex) {
                    LOGGER.error("Hubo un error con la base de datos:" + ex.getMessage());
                    ex.printStackTrace();
                }
            }


            return odontologo;
        }


    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {
        Long nroMatricula = resultSet.getLong("nroMatricula");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        Long id = resultSet.getLong("id");
        return new Odontologo(nroMatricula,nombre,apellido,id);

    }
    }
