import java.util.ArrayList;
import java.util.List;

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
}