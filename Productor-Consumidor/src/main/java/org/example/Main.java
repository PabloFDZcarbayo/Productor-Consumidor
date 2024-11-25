package org.example;

public class Main {
    public static void main(String[] args) {

        Reservado reservado = new Reservado();
        AtencionEmpleado_Productor productor = new AtencionEmpleado_Productor(reservado);
        CobroEmpleado_Consumidor consumidor = new CobroEmpleado_Consumidor(reservado);
        productor.start();
        consumidor.start();
    }
}


