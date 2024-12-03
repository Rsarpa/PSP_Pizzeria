package Pizzeria;

import java.util.Random;

public class Cocina_Productor extends Thread {
    private Barra_Buffer barra;

    public Cocina_Productor(Barra_Buffer barra) {
        this.barra = barra;
    }

    @Override
    public void run() {
        Random rand = new Random();
        try {
            while (true) {
                int random = rand.nextInt(21);  // Número aleatorio entre 0 y 20
                int produccion = (int) (Math.random() * 10) + 1; //crear un numero aleatorio para produci

                if (random < 15) {
                    barra.añadirPizza(produccion);
                } else {
                    barra.añadirEnsalada(produccion);
                }
                Thread.sleep(1000);  // Simula tiempo de cocción
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
