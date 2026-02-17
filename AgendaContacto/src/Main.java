import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contacto> contactos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 5) {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1 -> anadirContacto();
                case 2 -> mostrarContactos();
                case 3 -> buscarContacto();
                case 4 -> modificarContacto();
                case 5 -> System.out.println("Saliendo de la agenda...");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("\n------ AGENDA DE CONTACTOS ------");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Mostrar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Modificar contacto");
        System.out.println("5. Salir");
        System.out.print("Elija una opción: ");
    }

    public static int leerOpcion() {
        int opcion;
        try {
            opcion = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Por favor, introduce un número válido.");
            sc.nextLine();
            opcion = 0;
        }
        return opcion;
    }

    public static void anadirContacto() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce el teléfono: ");
        String telefono = sc.nextLine();
        contactos.add(new Contacto(nombre, telefono));
        System.out.println("Contacto añadido correctamente.");
    }

    public static void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE CONTACTOS ---");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println(i + " - " + contactos.get(i));
        }
    }

    public static void buscarContacto() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.print("Introduce el nombre a buscar: ");
        String buscar = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getNombre().toLowerCase().contains(buscar)) {
                System.out.println(i + " - " + contactos.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    public static void modificarContacto() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos para modificar.");
            return;
        }
        mostrarContactos();
        System.out.print("Introduce el índice del contacto a modificar: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice >= 0 && indice < contactos.size()) {
            Contacto c = contactos.get(indice);
            System.out.print("Nuevo nombre (ENTER para dejar igual): ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                c.setNombre(nuevoNombre);
            }
            System.out.print("Nuevo teléfono (ENTER para dejar igual): ");
            String nuevoTelefono = sc.nextLine();
            if (!nuevoTelefono.isEmpty()) {
                c.setTelefono(nuevoTelefono);
            }
            System.out.println("Contacto modificado correctamente.");
        } else {
            System.out.println("Índice no válido.");
        }
    }
}