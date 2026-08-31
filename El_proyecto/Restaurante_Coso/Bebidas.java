package Restaurante_Coso;

public class Bebidas extends Productos {
    private String nombre;
    private String marca;
    private double tamanho;

    public Bebidas(String nombre, String marca, double tamanho, int codigo, boolean disponibilidad, String tipo, double precio) {
        super(codigo, tipo, disponibilidad, precio);
        this.nombre = nombre;
        this.marca = marca;
        this.tamanho = tamanho;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public double getTamanho() {
        return tamanho;
    }

    @Override
    public boolean disponibilidad_producto() {
        System.out.println("Si hay: " + nombre);
        return true;
    }
}
