package Restaurante_Coso;

public interface Acciones_meseros {
    void tomar_pedido(Pedidos pedido, Productos producto) throws Exception_producto_agotado, Exception_chef;
    void entregar_pedido(Pedidos pedido) throws Exception_pedido_vacio;
    void asignar_mesa(Mesas mesa, String cliente) throws Exception_mesa_ocupada;
    void atender_mesa(Mesas mesa);
}
