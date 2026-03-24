import controller.ControladorAgenda;
import model.Agenda;
import model.Contacto;
import view.VistaAgenda;

public class Main {

    public static void main(String[] args) {

        Agenda modelo = new Agenda();
        VistaAgenda vista = new VistaAgenda();
        ControladorAgenda controlador = new ControladorAgenda(modelo);

        int opcion = 0;

        while (opcion != 5) {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();

            switch (opcion) {

                case 1 -> {
                    String nombre = vista.pedirNombre();
                    String telefono = vista.pedirTelefono();
                    controlador.agregarContacto(nombre, telefono);
                    vista.mostrarMensaje("Contacto añadido.");
                }

                case 2 -> {
                    vista.mostrarContactos(controlador.listarContactos());
                }

                case 3 -> {
                    String texto = vista.pedirBusqueda();
                    vista.mostrarContactos(controlador.buscarContacto(texto));
                }

                case 4 -> {
                    vista.mostrarContactos(controlador.listarContactos());
                    int indice = vista.pedirIndice();

                    Contacto c = controlador.obtenerContacto(indice);

                    System.out.print("Nuevo nombre (ENTER para mantener): ");
                    String nuevoNombre = vista.pedirNombre();
                    if (!nuevoNombre.isEmpty()) {
                        c.setNombre(nuevoNombre);
                    }

                    System.out.print("Nuevo teléfono (ENTER para mantener): ");
                    String nuevoTelefono = vista.pedirTelefono();
                    if (!nuevoTelefono.isEmpty()) {
                        c.setTelefono(nuevoTelefono);
                    }

                    vista.mostrarMensaje("Contacto modificado.");
                }

                case 5 -> vista.mostrarMensaje("Saliendo...");

                default -> vista.mostrarMensaje("Opción no válida.");
            }
        }
    }
}