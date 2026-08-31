package Restaurante_Coso;

public class Mesas {
    private int numero;
    private String cliente_mesa;
    private boolean disponible;

    public Mesas(int numero, String cliente_mesa, boolean disponible) {
        this.numero = numero;
        this.cliente_mesa = cliente_mesa;
        this.disponible = disponible;
    }

    public boolean disponibilidad_mesa() {
        return disponible;
    }

    public void ocupar_mesa(String cliente) throws Exception_mesa_ocupada {
        if (!disponible) {
            throw new Exception_mesa_ocupada("La mesa " + numero + " ya está ocupada");
        }
        this.disponible = false;
        this.cliente_mesa = cliente;
    }

    public void liberar_mesa() {
        this.disponible = true;
        this.cliente_mesa = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getClienteMesa() {
        return cliente_mesa;
    }
}
