package com.backend.parcial.model;

public class Odontologo {
    private Long nroMatricula;
    private String Nombre;
    private String Apellido;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo(Long nroMatricula, String nombre, String apellido, Long id) {
        this.nroMatricula = nroMatricula;
        Nombre = nombre;
        Apellido = apellido;
        this.id = id;
    }

    public Odontologo(Long nroMatricula, String nombre, String apellido) {
        this.nroMatricula = nroMatricula;
        Nombre = nombre;
        Apellido = apellido;
    }

    public Long getNroMatricula() {
        return nroMatricula;
    }

    public void setNroMatricula(Long nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "nroMatricula=" + nroMatricula +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", id=" + id +
                '}';
    }
}
