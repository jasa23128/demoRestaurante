package Restaurante_Coso;

public class Pedidos {
    private static int contador_pedidos = 0;

    private static final int max_productos = 10;

    private int numero_pedido;
    private Productos[] productos;
    private int cantidad_productos;
    private Tipo_orden tipo_pedido;

    public Pedidos(Tipo_orden tipo_pedido) {
        contador_pedidos++;
        this.numero_pedido = contador_pedidos;
        this.tipo_pedido = tipo_pedido;
        this.productos = new Productos[max_productos];
        this.cantidad_productos = 0;
    }

    public boolean agregarProducto(Productos producto) {
        try {
            if (!producto.disponibilidad_producto()) {
                throw new Exception_producto_agotado("No hay de eso, se acabó");
            }

            if (cantidad_productos >= max_productos) {
                System.out.println("El pedido está lleno, no se puede agregar más productos");
                return false;
            }

            productos[cantidad_productos] = producto;
            cantidad_productos++;
            System.out.println("Producto agregado");
            return true;

        } catch (Exception_producto_agotado e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getNumeroPedido() {
        return numero_pedido;
    }

    public Tipo_orden getTipoPedido() {
        return tipo_pedido;
    }

    public Productos[] getProductos() {
        return productos;
    }

    public int getCantidadProductos() {
        return cantidad_productos;
    }
}
