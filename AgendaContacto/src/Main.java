import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] nombres = new String[100];
        String[] telefonos = new String[100];
        int contador = 0;

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("------ AGENDA DE CONTACTOS ------");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    if (contador < 100) {
                        System.out.print("Introduce el nombre: ");
                        nombres[contador] = sc.nextLine();

                        System.out.print("Introduce el teléfono: ");
                        telefonos[contador] = sc.nextLine();

                        contador++;
                    } else {
                        System.out.println("La agenda está llena.");
                    }
                    break;

                case 2:
                    if (contador == 0) {
                        System.out.println("No hay contactos registrados.");
                    } else {
                        for (int i = 0; i < contador; i++) {
                            System.out.println(i + " - " + nombres[i] + " | " + telefonos[i]);
                        }
                    }
                    break;

                case 3:
                    if (contador == 0) {
                        System.out.println("No hay contactos para modificar.");
                        break;
                    }

                    for (int i = 0; i < contador; i++) {
                        System.out.println(i + " - " + nombres[i] + " | " + telefonos[i]);
                    }

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

                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
