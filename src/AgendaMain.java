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
                    String nombre = leerTextoNoVacio(sc, "Nombre: ");
                    String telefono = leerTextoNoVacio(sc, "Teléfono: ");
                    agenda.añadirContacto(new Contacto(nombre, telefono));
                    break;

                case 2: // Existe contacto
                    String nombreExiste = leerTextoNoVacio(sc, "Nombre a comprobar: ");
                    boolean existe = agenda.existeContacto(new Contacto(nombreExiste, ""));
                    System.out.println(existe ? "El contacto existe." : "El contacto no existe.");
                    break;

                case 3: // Listar contactos
                    agenda.listarContactos();
                    break;

                case 4: // Buscar contacto
                    String nombreBuscar = leerTextoNoVacio(sc, "Nombre a buscar: ");
                    agenda.buscaContacto(nombreBuscar);
                    break;

                case 5: // Eliminar contacto
                    String nombreEliminar = leerTextoNoVacio(sc, "Nombre a eliminar: ");
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
        String resp = sc.nextLine().trim();
        if (resp.equalsIgnoreCase("s")) {
            int tam;
            do {
                tam = leerEntero(sc, "Tamaño de la agenda (mínimo 1): ");
                if (tam <= 0) {
                    System.out.println("El tamaño debe ser mayor que 0.");
                }
            } while (tam <= 0);
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

    private static String leerTextoNoVacio(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Este campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }
}
