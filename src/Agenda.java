import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Set;

public class Agenda {
    private List<Contacto> contactos;
    private int tamanioMaximo;

    // Constructor por defecto (capacidad de 10)
    public Agenda() {
        this.tamanioMaximo = 10;
        this.contactos = new ArrayList<>();
    }

    // Constructor con capacidad personalizada
    public Agenda(int tamanio) {
        this.tamanioMaximo = tamanio;
        this.contactos = new ArrayList<>();
    }

    // ===== TAREA 1: añadirContacto =====
    // Añade un contacto a la agenda si hay hueco y si no existe ya.
    // No se pueden duplicar nombres, aunque tengan distinto teléfono
    // (esto lo garantiza el Set gracias al equals()/hashCode() de Contacto).
    public boolean añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("No se pueden añadir más contactos, la agenda está llena.");
            return false;
        }
        // Set.add() devuelve false automáticamente si ya existe un elemento "igual"
        boolean añadido = contactos.add(c);
        if (añadido) {
            System.out.println("Contacto añadido correctamente.");
        } else {
            System.out.println("Ya existe un contacto con el nombre '" + c.getNombre() + "'. No se puede duplicar.");
        }
        return añadido;
    }

    // Indica cuántos contactos más se pueden ingresar
    public int espacioLibres() {
        return tamanoMaximo - contactos.size();
    }

    // ==========================================
    // APARTADO: LISTAR CONTACTOS
    // ==========================================
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía. No hay contactos para mostrar.");
            return;
        }

        System.out.println("===== LISTA DE CONTACTOS =====");
        for (int i = 0; i < contactos.size(); i++) {
            System.out.println((i + 1) + ". " + contactos.get(i));
        }
    }
}
    // ==========================================
    // APARTADO: BUSCA CONTACTO (Jessica)
    // ==========================================
    public void buscaContacto(String nombre) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c != null && c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado:");
                System.out.println("Nombre: " + c.getNombre() + " | Teléfono: " + c.getTelefono());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún contacto con el nombre: " + nombre);
        }
    }


    // ==========================================
    // APARTADO: VALIDAR SI EXISTE O NO EL CONTACTO (Carlos)
    // ==========================================
    public boolean existeContacto(Contacto c) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(c.getNombre())) {
                System.out.println("El contacto ya existe.");
                return true;
            }
        }
        System.out.println("El contacto no existe.");
        return false;
    }

    
  // ==========================================
    // APARTADO: Agenda llena (Diana C)
    // ==========================================

public boolean agendaLlena() {

    return contactos.size() >= tamanioMaximo;

}

}


    // ===== TAREA : eliminarContacto(Contacto C) =====
    //Elimina el contacto de la agenda
    //Indica si se ha eliminado o no de la agenda
    public void eliminarContacto() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos para eliminar.");
            return;
        }
        showContactos(); //funcion mostrar contactos
        System.out.print("Enter the number of the contact to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < contactos.size()) {
            contactos.remove(index);
            System.out.println("Contacto eliminado.");
        } else {
            System.out.println("Número no válido.");
        }
    }
