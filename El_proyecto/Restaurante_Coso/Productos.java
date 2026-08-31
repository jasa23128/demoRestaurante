package Restaurante_Coso;

public abstract class Productos {
    protected double precio;
    protected int codigo;
    protected String tipo;
    protected boolean disponibilidad;

    public Productos(int codigo, String tipo, boolean disponibilidad, double precio) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    public abstract boolean disponibilidad_producto();

    public double getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }
}
