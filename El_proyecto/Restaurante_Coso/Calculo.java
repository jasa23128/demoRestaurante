package Restaurante_Coso;

public class Calculo {

    public static final double PORCENTAJE_PROPINA = 10.0;

    private static final int MAX_PRODUCTOS_DISTINTOS = 50;

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

    private static String obtenerNombre(Productos producto) {
        if (producto instanceof Platos_de_comido) {
            return ((Platos_de_comido) producto).getNombre();
        } else if (producto instanceof Bebidas) {
            return ((Bebidas) producto).getNombre();
        }
        return "Producto";
    }

    public static String productoMasPedido(Pedidos[] pedidos, int cantidadPedidos) {
        String[] nombres = new String[MAX_PRODUCTOS_DISTINTOS];
        int[] veces = new int[MAX_PRODUCTOS_DISTINTOS];
        int cantidadDistintos = 0;

        for (int i = 0; i < cantidadPedidos; i++) {
            Productos[] productos = pedidos[i].getProductos();
            int cantidadEnPedido = pedidos[i].getCantidadProductos();

            for (int j = 0; j < cantidadEnPedido; j++) {
                String nombre = obtenerNombre(productos[j]);
                boolean encontrado = false;

                for (int k = 0; k < cantidadDistintos; k++) {
                    if (nombres[k].equals(nombre)) {
                        veces[k]++;
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado && cantidadDistintos < MAX_PRODUCTOS_DISTINTOS) {
                    nombres[cantidadDistintos] = nombre;
                    veces[cantidadDistintos] = 1;
                    cantidadDistintos++;
                }
            }
        }

        int maxVeces = 0;
        String masPedido = "Ninguno";
        for (int i = 0; i < cantidadDistintos; i++) {
            if (veces[i] > maxVeces) {
                maxVeces = veces[i];
                masPedido = nombres[i];
            }
        }

        return masPedido + " (" + maxVeces + " veces)";
    }
}
