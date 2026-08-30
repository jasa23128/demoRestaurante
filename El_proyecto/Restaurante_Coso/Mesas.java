package Restaurante_Coso;

public class Mesas{
    private int numero;
    private String cliente_mesa;
    private boolean disponible;

    public Mesas(int numero, String cliente_mesa, boolean disponible){
        this.numero = numero;
        this.cliente_mesa = cliente_mesa;
        this.disponible = disponible;
    };

    public boolean disponibilidad_mesa(){
        return disponible;
    };
};
