package Restaurante_Coso;
// libreria arrays
import java.util.Arrays;
//clase inmutable
public final class Recibos {
    private final String[] infoCalculoPedido;
    private final double totalCalculado;

    public Recibos(String[ ]infoCaculoPedido, double totalCalculo) {
        if (infoCaculoPedido != null) {
            this.infoCalculoPedido = Arrays.copyOf(infoCaculoPedido, infoCaculoPedido.length);
        }else {
            this.infoCalculoPedido = new String[0];
        }
        this.totalCalculado = totalCalculo;
    }

    public String[] getInfoCalculoPedido(){
        return Arrays.copyOf(infoCalculoPedido, infoCalculoPedido.length);
    }

    public  double getTotalCalculado(){
        return totalCalculado;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================\n");
        sb.append("                 RECIBO              \n");
        sb.append("=====================================\n");
        sb.append("Detalle del Pedido:\n");

        for (String item : infoCalculoPedido){
            sb.append("-").append(item).append("\n");
        }
        sb.append("-------------------------------------\n");
        sb.append(String.format("Total : $%.2f\n", totalCalculado));
        sb.append("=====================================");
        return sb.toString();
    }


}
