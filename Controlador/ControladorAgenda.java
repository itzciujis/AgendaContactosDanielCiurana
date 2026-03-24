package controller;

import model.Agenda;
import model.Contacto;

import java.util.List;

public class ControladorAgenda {

    private Agenda modelo;

    public ControladorAgenda(Agenda modelo) {
        this.modelo = modelo;
    }

    public void agregarContacto(String nombre, String telefono) {
        modelo.agregarContacto(new Contacto(nombre, telefono));
    }

    public List<Contacto> listarContactos() {
        return modelo.getContactos();
    }

    public List<Contacto> buscarContacto(String texto) {
        return modelo.buscarContacto(texto);
    }

    public Contacto obtenerContacto(int indice) {
        return modelo.getContacto(indice);
    }
}