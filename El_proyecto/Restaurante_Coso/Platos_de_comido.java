package Restaurante_Coso;

public class Platos_de_comido extends Productos {
    private boolean especial_chef;
    private String nombre;

    public Platos_de_comido(boolean especial_chef,String nombre, int codigo, String tipo, boolean disponibilidad, double precio) {
        super(codigo, tipo, disponibilidad, precio);
        this.especial_chef = especial_chef;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public boolean getEspecial_chef(){
        return especial_chef;
    }

    @Override
    public boolean disponibilidad_producto() {
        if(especial_chef) {
            if(disponibilidad){
                System.out.println("Si hay: " + nombre);
            }
            else{
                System.out.println("No hay ome bobolon");
            }
        } else {
            System.out.println("No hay ome bobolon");
        }
        return especial_chef && disponibilidad;
    }
}
