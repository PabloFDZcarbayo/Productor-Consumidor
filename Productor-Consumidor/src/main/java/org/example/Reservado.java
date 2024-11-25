package org.example;

import java.util.LinkedList;

public class Reservado {
    //Atributos clase reservado
    private LinkedList<Object> mesas = new LinkedList<>();
    private final int MAX_MESAS = 3;

    public Reservado() {
    }

    //Metodo con el que ocupamos nuestras mesas
    public synchronized void sentarClientes() {
            try {
                /*Mientras que todas nuestras mesas esten ocupadas, debemos hacer esperar al siguiente hilo, con el metodo wait()*/
                while (mesas.size() >= MAX_MESAS) {
                    System.out.println("En estos momentos todas nuestras mesas estan ocupadas, por favor espere");
                    wait();
                }
                /*Una vez que tengamos mesas disponibles, ocupamos una y la añadimos a la lista*/
                mesas.add(new Object());
                System.out.println("Un grupo de clientes a ocupado una mesa. Mesas ocupadas: " + mesas.size());
                notifyAll(); //Notificamos a todos los hilos que esten esperando
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
//Metodo con el que liberamos nuestras mesas
    public synchronized void liberarMesa() {
        try {

            //Mientras que la lista este vacia, debemos esperar al siguiente hilo
            while (mesas.isEmpty()) {
                System.out.println("Mesas disponibles en este momento, esperando clientes");
                wait();
            }
            //Una vez el consumidor haya liberado una mesa, la eliminamos
        mesas.remove();
        System.out.println("Un grupo de clientes ha abandonado una mesa. Mesas ocupadas: " + mesas.size());
        notifyAll(); //Notificamos a todos los hilos que esten esperando
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }


}


