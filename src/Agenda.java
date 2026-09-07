import java.util.LinkedHashSet;
import java.util.Set;

public class Agenda {

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
}