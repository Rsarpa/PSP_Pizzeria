package Pizzeria;

public class Pizzeria_Main {
    public static void main(String[] args) throws InterruptedException {
        Barra_Buffer barra = new Barra_Buffer();

        // Crear cocineros
        Cocina_Productor cocinero1 = new Cocina_Productor(barra);
        Cocina_Productor cocinero2 = new Cocina_Productor(barra);

        // Crear clientes
        Cliente_Consumidor cliente1 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente2 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente3 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente4 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente5 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente6 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente7 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente8 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente9 = new Cliente_Consumidor(barra);
        Cliente_Consumidor cliente10 = new Cliente_Consumidor(barra);

        // Iniciar los hilos de los cocineros y clientes
        cocinero1.start();
        cocinero2.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
        cliente6.start();
        cliente7.start();
        cliente8.start();
        cliente9.start();
        cliente10.start();
    }
}