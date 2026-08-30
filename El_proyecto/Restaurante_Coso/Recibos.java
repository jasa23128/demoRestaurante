package Restaurante_Coso;
import java.util.Arrays;

// Clase inmutable
public final class Recibos {

    private final String[] infoCalculoPedido;
    private final double totalCalculado;

    public Recibos(String[] infoCalculoPedido, double totalCalculado) {
        this.infoCalculoPedido = infoCalculoPedido != null
                ? Arrays.copyOf(infoCalculoPedido, infoCalculoPedido.length)
                : null;
        this.totalCalculado = totalCalculado;
    }

    // Getters
    public String[] getInfoCalculoPedido() {
        return infoCalculoPedido != null
                ? Arrays.copyOf(infoCalculoPedido, infoCalculoPedido.length)
                : null;
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
        textoRecibo += "Total a pagar: $" + totalCalculado + "\n";
        textoRecibo += "============================";

        return textoRecibo;
    }
}

