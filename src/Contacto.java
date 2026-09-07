public class Contacto {
    private String nombre;
    private long telefono;

    public Contacto(String nombre, long telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

// Dos contactos son iguales si tienen el mismo nombre
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Contacto other = (Contacto) obj;
    return this.nombre != null && this.nombre.equalsIgnoreCase(other.nombre);
}

@Override
public int hashCode() {
    return nombre == null ? 0 : nombre.toLowerCase().hashCode();
}

@Override
public String toString() {
    return "Nombre: " + nombre + " | Teléfono: " + telefono;
}
}