/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiocaso;

import javax.swing.JOptionPane;

public class EstudioCaso {

    public static void main(String[] args) {
        Avion avion = new Avion();   // Aqui se maneja toda la lógica
        avion.precargarAvion();

        int opcion = 0;
        while (opcion != 6) {
            String menu = """
                1. Ver mapa del avion
                2. Reservar asiento
                3. Reservar con descuento
                4. Consultar Pasajero
                5. Ver resumen de vuelo
                6. Salir
                """;

            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            
            switch (opcion) {
                case 1 -> avion.verMapa();
                case 2 -> avion.reservar(false);
                case 3 -> avion.reservar(true);
                case 4 -> avion.consultar();
                case 5 -> avion.resumen();
                case 6 -> JOptionPane.showMessageDialog(null, "Saliendo...");
            }
        }
    }
}
