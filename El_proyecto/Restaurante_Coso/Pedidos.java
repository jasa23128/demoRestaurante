package Restaurante_Coso;

public class Pedidos {
    private static int contador_pedidos = 0;

    private static final int max_productos = 10;

    private int numero_pedido;
    private Productos[] productos;
    private int cantidad_productos;
    private Tipo_orden tipo_pedido;
    private boolean cerrado;

    public Pedidos(Tipo_orden tipo_pedido) {
        contador_pedidos++;
        this.numero_pedido = contador_pedidos;
        this.tipo_pedido = tipo_pedido;
        this.productos = new Productos[max_productos];
        this.cantidad_productos = 0;
        this.cerrado = false;
    }

    public boolean agregarProducto(Productos producto) throws Exception_producto_agotado {
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
    }

    public void cerrarPedido() throws Exception_pedido_vacio {
        if (cantidad_productos == 0) {
            throw new Exception_pedido_vacio("El pedido #" + numero_pedido + " no tiene productos, no se puede cerrar");
        }
        this.cerrado = true;
    }

    public boolean isCerrado() {
        return cerrado;
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
