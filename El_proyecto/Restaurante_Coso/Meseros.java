package Restaurante_Coso;

public class Meseros implements Acciones_meseros {
    private int id;
    private int mesas_atendidas;
    private Double totalVentas;

    public Meseros(int id, int mesas_atendidas) {
        this.id = id;
        this.mesas_atendidas = mesas_atendidas;
        this.totalVentas = null;
    }

    public Meseros(int id) {
        this(id, 0);
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

    public void atender_mesa(Mesas mesa, String nota) {
        System.out.println("Mesero " + id + " atendiendo la mesa " + mesa.getNumero() + " - Nota: " + nota);
    }

    @Override
    public void tomar_pedido(Pedidos pedido, Productos producto) throws Exception_producto_agotado, Exception_chef {
        pedido.agregarProducto(producto);
    }

    @Override
    public void entregar_pedido(Pedidos pedido) throws Exception_pedido_vacio {
        pedido.cerrarPedido();
        System.out.println("Mesero " + id + " entregó el pedido #" + pedido.getNumeroPedido());
    }

    public void setTotalVentas(double total) {
        this.totalVentas = total;
    }

    public Double getTotalVentas() {
        return totalVentas;
    }

    public int getId() {
        return id;
    }

    public int getMesasAtendidas() {
        return mesas_atendidas;
    }
}
