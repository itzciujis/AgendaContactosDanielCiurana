import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("------ AGENDA DE CONTACTOS ------");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has elegido: Añadir contacto");
                    break;
                case 2:
                    System.out.println("Has elegido: Mostrar contacto");
                    break;
                case 3:
                    System.out.println("Has elegido: Buscar contacto");
                    break;
                case 4:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println();
        }
        
    }
}
