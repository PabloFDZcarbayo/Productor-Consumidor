package org.example;

public class AtencionEmpleado_Productor extends Thread {
    private Reservado reservado;

    public AtencionEmpleado_Productor(Reservado reservado){
        this.reservado = reservado;
    }

    public void run(){
        for(int i= 1; i <= 5; i++){
            try{
                Thread.sleep(3000); //Simulamos el tiempo que tarda en atender a los clientes
                reservado.sentarClientes();
                System.out.println("Empleado sentó al grupo de clientes " + i);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}


