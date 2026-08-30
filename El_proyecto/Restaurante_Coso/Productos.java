package Restaurante_Coso;

public abstract class Productos {
    protected String nombre;
    protected double precio;
    protected  int codigo;
    protected String tipo;
    protected boolean disponibilidad;

    public Productos(String nombre,int codigo, String tipo, boolean disponibilidad, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.precio = precio;
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public abstract boolean disponibilidad_producto();

}
