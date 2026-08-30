package Restaurante_Coso;

public class Meseros implements Acciones_meseros {
    private int id;
    private int mesas_atendidas;

    public Meseros(int id, int mesas_atendidas) {
        this.id = id;
        this.mesas_atendidas = mesas_atendidas;
    }

    @Override
    public void asignar_mesa(Mesas mesa, String cliente) throws Exception_mesa_ocupada {
        mesa.ocupar_mesa(cliente);
        mesas_atendidas++;
        System.out.println("Mesero " + id + " asignado a la mesa " + mesa.getNumero());
    }

    @Override
    public void atender_mesa(Mesas mesa) {
        System.out.println("Mesero " + id + " atendiendo la mesa " + mesa.getNumero());
    }

    @Override
    public void tomar_pedido(Pedidos pedido, Productos producto) throws Exception_producto_agotado {
        pedido.agregarProducto(producto);
    }

    @Override
    public void entregar_pedido(Pedidos pedido) throws Exception_pedido_vacio {
        pedido.cerrarPedido();
        System.out.println("Mesero " + id + " entregó el pedido #" + pedido.getNumeroPedido());
    }

    public int getId() {
        return id;
    }

    public int getMesasAtendidas() {
        return mesas_atendidas;
    }
}
