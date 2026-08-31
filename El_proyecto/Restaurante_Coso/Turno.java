package Restaurante_Coso;

public class Turno {

    private static final int MAX_PEDIDOS = 50;

    private Pedidos[] pedidos;
    private int cantidadPedidos;

    public Turno() {
        this.pedidos = new Pedidos[MAX_PEDIDOS];
        this.cantidadPedidos = 0;
    }

    public void agregarPedido(Pedidos pedido) {
        if (cantidadPedidos < pedidos.length) {
            pedidos[cantidadPedidos] = pedido;
            cantidadPedidos++;
        }
    }

    public String productoMasVendido() {
        return Calculo.productoMasPedido(pedidos, cantidadPedidos);
    }

    public int getCantidadPedidos() {
        return cantidadPedidos;
    }
}
