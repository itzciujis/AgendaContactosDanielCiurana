import java.util.Scanner;
public class Main {
    public static void  main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Añadir contacto");
        System.out.println("Mostrar contacto");
        System.out.println("Buscar contacto");
        System.out.println("Salir");

        System.out.println("Elija una opcion");
        String opciones = sc.next();
        String opciones1 = opciones;
        System.out.println("Has elejido la opcion: " + opciones1);

    }
}
