/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudiocaso;

/**
 *
 * @author Usuario
 */
public class Asiento {
    String codigo;
    String clase;
    double precio;
    String estado;
    Pasajero pasajero;

    // Constructor con 3 parámetros
    public Asiento(String codigo, String clase, double precio) {
        this.codigo = codigo;
        this.clase = clase;
        this.precio = precio;
        this.estado = "Libre";   // valor por defecto
        this.pasajero = null;
    }
}

