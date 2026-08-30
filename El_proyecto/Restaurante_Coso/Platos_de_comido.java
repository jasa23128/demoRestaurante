package Restaurante_Coso;

public class Platos_de_comido extends Productos {
    private boolean especial_chef;
    private String nombre;

    public Platos_de_comido(boolean especial_chef, String nombre, int codigo, String tipo, boolean disponibilidad, double precio) {
        super(codigo, tipo, disponibilidad, precio);
        this.especial_chef = especial_chef;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEspecial_chef() {
        return especial_chef;
    }

    @Override
    public boolean disponibilidad_producto() {
        if (especial_chef) {
            // Solo los especiales del chef pueden agotarse durante el día
            if (disponibilidad) {
                System.out.println("Si hay: " + nombre);
            } else {
                System.out.println("No hay: " + nombre + " (especial del chef agotado)");
            }
            return disponibilidad;
        } else {
            // Un plato normal (no especial) siempre está disponible
            System.out.println("Si hay: " + nombre);
            return true;
        }
    }
}
