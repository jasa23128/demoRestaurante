package Restaurante_Coso;

public class Meseros implements Acciones_meseros {
    private int id;
    private int mesas_atendidas;

    public Meseros(int id, int mesas_atendidas) {
        this.id = id;
        this.mesas_atendidas = mesas_atendidas;
    };

    @Override
    public void asignar_mesa() {
    };

    @Override
    public void atender_mesa() {
    };

    @Override
    public void tomar_pedido() {
    };

    @Override
    public void entregar_pedido() {
    };
};
