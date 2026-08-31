package Restaurante_Coso;

public class Pedidos {
    static int contador_pedidos = 0;

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

    public boolean agregarProducto(Productos producto) throws Exception_producto_agotado, Exception_chef {
        if (!producto.disponibilidad_producto()) {
            if (producto instanceof Platos_de_comido) {
                Platos_de_comido plato = (Platos_de_comido) producto;
                if (plato.getEspecial_chef()) {
                    throw new Exception_chef("El especial del chef '" + plato.getNombre() + "' ya se agotó");
                }
            }
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

    public void validarNoDuplicado(Pedidos otro) throws Exception_equals {
        if (this.equals(otro)) {
            throw new Exception_equals("El pedido #" + numero_pedido + " ya existe, no se puede duplicar");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pedidos otro = (Pedidos) obj;
        return this.numero_pedido == otro.numero_pedido;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numero_pedido);
    }

    @Override
    public String toString() {
        return "Pedido #" + numero_pedido + " - Tipo: " + tipo_pedido + " - " + cantidad_productos + " producto(s)";
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
