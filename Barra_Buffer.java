package Pizzeria;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.*;

public class Barra_Buffer {
    private LinkedList<Integer> pizzas=new LinkedList<>();

    private LinkedList<Integer> ensaladas=new LinkedList<>();

    private final int MAX_PIZZAS = 10;
    private final int MAX_ENSALADAS = 5;

    synchronized void añadirPizza(int i) throws InterruptedException {

        while (pizzas.size() >= MAX_PIZZAS) {
            try {
                System.out.println("La barra está llena de ensaladas");
                wait();
            }catch (InterruptedException e){
                System.out.println("El tamaño de pizzas es igual a 0");
            }
        }
        pizzas.add(i);
        System.out.println("Cocinero ha añadido una pizza. Total de pizzas: " + pizzas.size());
        //notificar que ya puede consumir
        notify();
    }

    synchronized void añadirEnsalada(int i) throws InterruptedException {

        while (ensaladas.size() >= MAX_ENSALADAS) {
            try {
            System.out.println("La barra está llena de ensaladas");
            wait();
            }catch (InterruptedException e){
                System.out.println("El tamaño de ensaladas es igual a 0");
            }
        }
        ensaladas.add(i);
        System.out.println("Cocinero ha añadido una ensalada. Total de ensaladas: " + ensaladas.size());
        //notificar que ya puedo consumir
        notify();
    }

    synchronized int consumirPizza(int i) throws InterruptedException {

        while (pizzas.size() == 0) {
            try {
                System.out.println("La barra está vacía de pizzas. Espera");
                wait();
            }catch (InterruptedException e){
                System.out.println("El tamaño de pizzas es igual a 0");
            }
        }
        System.out.println("Cliente ha consumido una pizza. Total de pizzas: " + pizzas.size());
        notify();
        int valor = pizzas.remove();
        return valor;

    }

    synchronized int consumirEnsalada(int i) throws InterruptedException {

        while (ensaladas.size() == 0) {
            try {
                System.out.println("La barra está vacía de ensaladas. Espera");
                wait();
            }catch (InterruptedException e){
                System.out.println("El tamaño de ensaladas es igual a 0");
            }
        }
        System.out.println("Cliente ha consumido una ensalada. Total de ensaladas: " + ensaladas.size());
        notify();
        int valor = ensaladas.remove();
        return valor;
    }
}
