package Pizzeria;

import java.util.Random;

public class Cliente_Consumidor extends Thread {
    private Barra_Buffer barra;
    private int tipoCliente;

    public Cliente_Consumidor(Barra_Buffer barra) {
        this.barra = barra;
        this.tipoCliente = new Random().nextInt(3) + 1;  // Genera un tipo de cliente aleatorio (1, 2 o 3)
    }

    @Override
    public void run() {
        try {
            switch (tipoCliente) {
                case 1:  // Sólo pizza
                    while (true) {
                        barra.consumirPizza(0);
                        Thread.sleep(1500);  // Tiempo para consumir la pizza
                    }
                case 2:  // Sólo ensalada
                    while (true) {
                        barra.consumirEnsalada(0);
                        Thread.sleep(1500);  // Tiempo para consumir la ensalada
                    }
                case 3:  // Pizza y ensalada
                    while (true) {
                        barra.consumirPizza(0);
                        barra.consumirEnsalada(0);
                        Thread.sleep(1500);  // Tiempo para consumir ambos
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
