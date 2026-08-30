package Restaurante_Coso;

public class Calculo {

    public static final double PORCENTAJE_PROPINA = 10.0;

    private Calculo() {}

    public static double calcularSubtotal(Pedidos pedido) {
        double subtotal = 0;
        Productos[] productos = pedido.getProductos();
        int cantidad = pedido.getCantidadProductos();

        for (int i = 0; i < cantidad; i++) {
            subtotal = subtotal + productos[i].getPrecio();
        }

        return subtotal;
    }

    public static double calcularPropina(double subtotal, Tipo_orden tipo) {
        if (tipo == Tipo_orden.EN_RESTAURANTE) {
            return subtotal * (PORCENTAJE_PROPINA / 100);
        }
        return 0;
    }

    public static double calcularTotal(Pedidos pedido) {
        double subtotal = calcularSubtotal(pedido);
        double propina = calcularPropina(subtotal, pedido.getTipoPedido());
        return subtotal + propina;
    }
}
