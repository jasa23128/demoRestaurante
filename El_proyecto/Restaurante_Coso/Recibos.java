package Restaurante_Coso;

import java.util.Arrays;

// Clase inmutable
public final class Recibos {

    private final String[] infoCalculoPedido;
    private final double subtotal;
    private final double propina;
    private final double totalCalculado;

    public Recibos(String[] infoCalculoPedido, double subtotal, double propina, double totalCalculado) {
        this.infoCalculoPedido = infoCalculoPedido != null
                ? Arrays.copyOf(infoCalculoPedido, infoCalculoPedido.length)
                : null;
        this.subtotal = subtotal;
        this.propina = propina;
        this.totalCalculado = totalCalculado;
    }

//sobrecarga
    public Recibos(Pedidos pedido) {
        if (pedido != null) {
            this.subtotal = Calculo.calcularSubtotal(pedido);
            this.propina = Calculo.calcularPropina(this.subtotal, pedido.getTipoPedido());
            this.totalCalculado = Calculo.calcularTotal(pedido);
            this.infoCalculoPedido = extraerDetallePedido(pedido);
        } else {
            this.subtotal = 0.0;
            this.propina = 0.0;
            this.totalCalculado = 0.0;
            this.infoCalculoPedido = null;
        }
    }

    private String[] extraerDetallePedido(Pedidos pedido) {
        Productos[] productos = pedido.getProductos();
        int cantidad = pedido.getCantidadProductos();

        if (productos == null || cantidad == 0) {
            return new String[0];
        }

        String[] detalle = new String[cantidad];
        for (int i = 0; i < cantidad; i++) {
            if (productos[i] != null) {
                detalle[i] = productos[i].getNombre() + " - $" + productos[i].getPrecio();
            } else {
                detalle[i] = "Producto sin detalle";
            }
        }
        return detalle;
    }

    // Getters
    public String[] getInfoCalculoPedido() {
        return infoCalculoPedido != null
                ? Arrays.copyOf(infoCalculoPedido, infoCalculoPedido.length)
                : null;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getPropina() {
        return propina;
    }

    public double getTotalCalculado() {
        return totalCalculado;
    }

    @Override
    public String toString() {
        String textoRecibo = "===== RECIBO DE COMPRA =====\n";

        if (infoCalculoPedido != null) {
            for (int i = 0; i < infoCalculoPedido.length; i++) {
                textoRecibo += " - " + infoCalculoPedido[i] + "\n";
            }
        }

        textoRecibo += "----------------------------\n";
        textoRecibo += "Subtotal:        $" + subtotal + "\n";
        textoRecibo += "Propina (10%):   $" + propina + "\n";
        textoRecibo += "----------------------------\n";
        textoRecibo += "Total a pagar:   $" + totalCalculado + "\n";
        textoRecibo += "============================";

        return textoRecibo;
    }
}