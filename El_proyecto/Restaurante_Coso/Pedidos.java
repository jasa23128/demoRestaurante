package Restaurante_Coso;

public class Pedidos {
    private Productos[] productos;
    private static final int max_productos = 10;
    private int cantidadProductos; //contador Trate de usar solo un tipo, o camelCase o snake_case, no los dos.
    private boolean tipo_pedido; //puede hacer este Tipo_orden en vez de boolean, asi saca algo que no sea t o f.

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
