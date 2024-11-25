package org.example;

public class CobroEmpleado_Consumidor extends Thread {
    private Reservado reservado;

    public CobroEmpleado_Consumidor(Reservado reservado) {
        this.reservado = reservado;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(8000); //Simulamos el tiempo de servicio
                reservado.liberarMesa(); //Liberamos la mesa
                System.out.println("Empleado liberó la mesa del grupo de clientes: " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}