package view;

import model.Contacto;

import java.util.List;
import java.util.Scanner;

public class VistaAgenda {

    private Scanner sc = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("------ AGENDA DE CONTACTOS ------");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Modificar contacto");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
    }

    public int leerOpcion() {
        int opcion;
        try {
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Número inválido.");
            sc.nextLine();
            opcion = 0;
        }
        return opcion;
    }

    public String pedirNombre() {
        System.out.print("Introduce el nombre: ");
        return sc.nextLine();
    }

    public String pedirTelefono() {
        System.out.print("Introduce el teléfono: ");
        return sc.nextLine();
    }

    public String pedirBusqueda() {
        System.out.print("Introduce el nombre a buscar: ");
        return sc.nextLine();
    }

    public int pedirIndice() {
        System.out.print("Introduce el índice: ");
        int indice = sc.nextInt();
        sc.nextLine();
        return indice;
    }

    public void mostrarContactos(List<Contacto> contactos) {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos.");
            return;
        }

        for (int i = 0; i < contactos.size(); i++) {
            System.out.println(i + " - " + contactos.get(i));
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}