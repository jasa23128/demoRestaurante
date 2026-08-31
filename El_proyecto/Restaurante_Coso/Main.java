package Restaurante_Coso;

public class Main {
    public static void main(String[] args) {

        Meseros mesero1 = new Meseros(1);
        Mesas mesa1 = new Mesas(5, null, true);

        Productos[] menu = new Productos[2];
        menu[0] = new Platos_de_comido(false, "Bandeja Paisa", 101, "plato", true, 25000);
        menu[1] = new Bebidas("Limonada", "Casera", 0.5, 201, true, "embotellado", 6000);

        double[] preciosMenu = new double[menu.length];
        for (int i = 0; i < menu.length; i++) {
            preciosMenu[i] = menu[i].getPrecio();
        }
        double sumaPrecios = 0;
        for (double precio : preciosMenu) {
            sumaPrecios += precio;
        }
        System.out.println("Suma de precios del menu: $" + sumaPrecios);

        try {
            mesero1.asignar_mesa(mesa1, "Cliente Juan");
        } catch (Exception_mesa_ocupada e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Asignación de mesa procesada");
        }

        mesero1.atender_mesa(mesa1, "Cliente pidió agua aparte");

        Turno turno = new Turno();

        Pedidos pedido1 = new Pedidos(Tipo_orden.EN_RESTAURANTE);
        turno.agregarPedido(pedido1);

        try {
            mesero1.tomar_pedido(pedido1, menu[0]);
            mesero1.tomar_pedido(pedido1, menu[1]);
        } catch (Exception_producto_agotado | Exception_chef e) {
            System.out.println("Error: " + e.getMessage());
        }

        String nombreBuscado = "Limonada";
        for (Productos producto : menu) {
            if (producto instanceof Platos_de_comido) {
                Platos_de_comido plato = (Platos_de_comido) producto;
                System.out.println("Plato: " + plato.getNombre() + " - $" + plato.getPrecio());
            } else if (producto instanceof Bebidas) {
                Bebidas bebida = (Bebidas) producto;
                System.out.println("Bebida: " + bebida.getNombre() + " - $" + bebida.getPrecio());
                if (bebida.getNombre().equals(nombreBuscado)) {
                    System.out.println("  -> Coincide con la bebida buscada: " + nombreBuscado);
                }
            }
        }

        try {
            mesero1.entregar_pedido(pedido1);
        } catch (Exception_pedido_vacio e) {
            System.out.println("Error: " + e.getMessage());
        }

        double total = Calculo.calcularTotal(pedido1);
        mesero1.setTotalVentas(total);

        System.out.println(pedido1);
        System.out.println("Total vendido por el mesero " + mesero1.getId() + ": $" + mesero1.getTotalVentas());
        System.out.println("Producto mas pedido del turno: " + turno.productoMasVendido());
    }
}
