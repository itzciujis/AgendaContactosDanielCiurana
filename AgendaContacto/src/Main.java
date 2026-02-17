import java.util.Scanner;

public class AgendaContactos {

    static Scanner sc = new Scanner(System.in);
    static String[] nombres = new String[100];
    static String[] telefonos = new String[100];
    static int contador = 0;

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
        if (contador >= 100) {
            System.out.println("La agenda está llena.");
            return;
        }
        System.out.print("Introduce el nombre: ");
        nombres[contador] = sc.nextLine();
        System.out.print("Introduce el teléfono: ");
        telefonos[contador] = sc.nextLine();
        contador++;
        System.out.println("Contacto añadido correctamente.");
    }

    public static void mostrarContactos() {
        if (contador == 0) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.println("\n--- LISTA DE CONTACTOS ---");
        for (int i = 0; i < contador; i++) {
            System.out.println(i + " - " + nombres[i] + " | " + telefonos[i]);
        }
    }

    public static void buscarContacto() {
        if (contador == 0) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.print("Introduce el nombre a buscar: ");
        String buscar = sc.nextLine().toLowerCase();
        boolean encontrado = false;
        for (int i = 0; i < contador; i++) {
            if (nombres[i].toLowerCase().contains(buscar)) {
                System.out.println(i + " - " + nombres[i] + " | " + telefonos[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con ese nombre.");
        }
    }

    public static void modificarContacto() {
        if (contador == 0) {
            System.out.println("No hay contactos para modificar.");
            return;
        }
        mostrarContactos();
        System.out.print("Introduce el índice del contacto a modificar: ");
        int indice = sc.nextInt();
        sc.nextLine();
        if (indice >= 0 && indice < contador) {
            System.out.print("Nuevo nombre (ENTER para dejar igual): ");
            String nuevoNombre = sc.nextLine();
            if (!nuevoNombre.isEmpty()) {
                nombres[indice] = nuevoNombre;
            }
            System.out.print("Nuevo teléfono (ENTER para dejar igual): ");
            String nuevoTelefono = sc.nextLine();
            if (!nuevoTelefono.isEmpty()) {
                telefonos[indice] = nuevoTelefono;
            }
            System.out.println("Contacto modificado correctamente.");
        } else {
            System.out.println("Índice no válido.");
        }
    }
}