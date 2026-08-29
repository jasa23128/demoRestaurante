package Restaurante_Coso;

public class Pedidos {
    private Productos[] productos;
    private static final int max_productos = 10;
    private int cantidadProductos; //contador
    private boolean tipo_pedido;

    public Pedidos() {
        productos = new Productos[max_productos];
        cantidadProductos = 0;
    }

    public boolean agregarProducto(Productos producto) {
        try {
            if (!producto.disponibilidad_producto()) {
                throw new Exception_producto_agotado("No hay de eso, se acabó");
            }

            if (cantidadProductos >= 10) {
                System.out.println("El pedido está lleno, no se puede agregar más productos");
                return false;
            }

            productos[cantidadProductos] = producto;
            cantidadProductos++;
            System.out.println("Producto agregado");
            return true;

        } catch (Exception_producto_agotado e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
