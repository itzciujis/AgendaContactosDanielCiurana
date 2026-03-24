package model;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto c) {
        contactos.add(c);
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public List<Contacto> buscarContacto(String texto) {
        List<Contacto> resultado = new ArrayList<>();

        for (Contacto c : contactos) {
            if (c.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Contacto getContacto(int indice) {
        return contactos.get(indice);
    }

    public int size() {
        return contactos.size();
    }
}