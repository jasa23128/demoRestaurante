package Restaurante_Coso;

public class Bebidas extends Productos {
    private String marca;
    private double tamanho;


    public Bebidas(String marca, double tamanho, int codigo, boolean disponibilidad, String tipo, double precio){
        super(codigo,tipo, disponibilidad, precio);
        this.marca = marca;
        this.tamanho = tamanho;

    }
    public String getMarca(){
        return marca;
    }
    public double getTamanho(){
        return tamanho;
    }
    @Override
    public boolean disponibilidad_producto() {
        if (disponibilidad || tipo.equals("embotellado")) {
            System.out.println("Si hay :" + marca);
        } else {
            System.out.println("No hay ome bobolon");
        }
        return disponibilidad || tipo.equals("embotellado");
    }
}

