import java.util.Scanner;

public class AgendaMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = crearAgenda(sc);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Elige una opción: ");

            switch (opcion) {
                case 1: // Añadir contacto
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    Long telefono = sc.nextLong();
                    agenda.añadirContacto(new Contacto(nombre, telefono));
                    break;

                case 2: // Existe contacto
                    System.out.print("Nombre a comprobar: ");
                    String nombreExiste = sc.nextLine();
                    boolean existe = agenda.existeContacto(new Contacto(nombreExiste, ""));
                    System.out.println(existe ? "El contacto existe." : "El contacto no existe.");
                    break;

                case 3: // Listar contactos
                    agenda.listarContactos();
                    break;

                case 4: // Buscar contacto
                    System.out.print("Nombre a buscar: ");
                    String nombreBuscar = sc.nextLine();
                    agenda.buscaContacto(nombreBuscar);
                    break;

                case 5: // Eliminar contacto
                    System.out.print("Nombre a eliminar: ");
                    String nombreEliminar = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nombreEliminar, ""));
                    break;

                case 6: // Agenda llena
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Todavía hay espacio.");
                    break;

                case 7: // Espacios libres
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;

                case 0:
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 0);

        sc.close();
    }

    private static Agenda crearAgenda(Scanner sc) {
        System.out.print("¿Quieres indicar un tamaño para la agenda? (s/n): ");
        String resp = sc.nextLine();
        if (resp.equalsIgnoreCase("s")) {
            int tam = leerEntero(sc, "Tamaño de la agenda: ");
            return new Agenda(tam);
        }
        System.out.println("Se usará el tamaño por defecto (10).");
        return new Agenda();
    }

    private static void mostrarMenu() {
        System.out.println("===== MENÚ AGENDA TELEFÓNICA =====");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Comprobar si existe un contacto");
        System.out.println("3. Listar contactos");
        System.out.println("4. Buscar contacto por nombre");
        System.out.println("5. Eliminar contacto");
        System.out.println("6. Comprobar si la agenda está llena");
        System.out.println("7. Ver espacios libres");
        System.out.println("0. Salir");
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            System.out.print(mensaje);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // limpiar el salto de línea
        return valor;
    }
}