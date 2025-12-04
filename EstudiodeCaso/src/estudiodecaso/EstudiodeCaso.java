/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiodecaso;

/**
 *
 * @author Laboratorio
 */
public class EstudiodeCaso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
}        
    static Asientos[][] avion= new Asientos[5][4];
    static String[]letras={"A","B","C","D"};
        precargarAvion();
        int opcion = 0;
        while (opcion!=6);   
        String menu;
        menu = """
               1.Ver mapa del avion
               2.Reservar Aaiento
               3.Reservar con descuento
               4. Consultar Pasajero
               5.Ver resumen de vuelo
               6. Salir
               """;
        
           opcion = Integer.parseInt(
           JOptionPane.showInputDialog(menu)
           ); 
          switch(opcion){
               case 1: verMapa(); break;
               case 2: reservar(false); break;
               case 3: reservar(true); break;
               case 4: consultar(); break;
               case 5: resumen(); break;
               case 6: JOptionPane.showMessageDialog(null, "Saliendo..."); break;
     
}
           }     
                
     public static void precargarAvion() {
       for(int f = 0; f < 5; f++){
           for(int c = 0; c < 4; c++){
               String codigo = (f+1) + letras[c];
               String clase;
               double precio;
               switch (f) {
                   case 0 -> {
                       clase = "Primera";
                       precio = 500;
                   }
                   case 1 -> {
                       clase = "Business";
                       precio = 300;
                   }
                   default -> {
                       clase = "Economica";
                       precio = 100;
                   }
               }
               avion[f][c] = new Asientos(codigo,clase,precio);        
           }
}
}
       public static void verMapa(){
       String texto = "MAPA DEL AVION\n\n";
       for(int f = 0; f < 5; f++){
           texto += "Fila " + (f+1) + ": ";
           for(int c = 0; c < 4; c++){
               texto += avion[f][c].codigo + " ";
           }
           texto += "\n";
           for(int c = 0; c < 4; c++){
               texto += avion[f][c].estado + " ";
           }
           texto += "\n";
           for(int c = 0; c < 4; c++){
               texto += avion[f][c].clase + " ";
           }
           texto += "\n";
           for(int c = 0; c < 4; c++){
               texto += "$" + avion[f][c].precio + " ";
           }
           texto += "\n---------------------------\n";
       }
       JOptionPane.showMessageDialog(null, texto);
   }
       public static void reservar(boolean descuento) {
       int fila = Integer.parseInt(
               JOptionPane.showInputDialog("Fila (1-5):")
       ) - 1;
       String letra = JOptionPane.showInputDialog("Letra (A-D):").toUpperCase();
       int col = letra.charAt(0) - 'A';
       Asientos a = avion[fila][col];
       if(!a.estado.equals("Libre")){
           JOptionPane.showMessageDialog(null, "Asiento no disponible.");
           return;
       }
       String nombre = JOptionPane.showInputDialog("Nombre completo:");
       String pas = JOptionPane.showInputDialog("Pasaporte:");
       String nac = JOptionPane.showInputDialog("Nacionalidad:");
       Pasajero p = new Pasajero(nombre, pas, nac);
       a.pasajero = p;
       a.estado = "Ocupado";
       double precioFinal = a.precio;
       if(descuento){
           String resp = JOptionPane.showInputDialog("¿Cliente frecuente? (s/n):");
           if(resp.equalsIgnoreCase("s")){
               if(a.clase.equals("Economica")) precioFinal *= 0.90;
               if(a.clase.equals("Business")) precioFinal *= 0.85;
               if(a.clase.equals("Primera"))  precioFinal *= 0.82;
           }
       }
       JOptionPane.showMessageDialog(null, "Reserva realizada. Precio final: $" + precioFinal);
   }
       public static void consultar(){
       int fila = Integer.parseInt(
               JOptionPane.showInputDialog("Fila (1-5):")
       ) - 1;
       String letra = JOptionPane.showInputDialog("Letra (A-D):").toUpperCase();
       int col = letra.charAt(0) - 'A';
       Asientos a = avion[fila][col];
       if(a.estado.equals("Ocupado")){
           String info =
                   "Nombre: " + a.pasajero.nombre + "\n" +
                   "Pasaporte: " + a.pasajero.pasaporte + "\n" +
                   "Nacionalidad: " + a.pasajero.nacionalidad;
           JOptionPane.showMessageDialog(null, info);
       } else {
           JOptionPane.showMessageDialog(null, "El asiento está libre.");
       }
   }public static void resumen(){
       double total = 0;
       int libres = 0;
       int totales = 20;
       for(int f = 0; f < 5; f++){
           for(int c = 0; c < 4; c++){
               Asientos a = avion[f][c];
               if(a.estado.equals("Ocupado")){
                   total += a.precio;
               } else {
                   libres++;
               }
           }
       }
       double ocupacion = ((totales - libres) * 100.0) / totales;
       String texto =
               """
               RESUMEN DEL VUELO
               
               Total recaudado: $""" + total + "\n" +
               "Asientos libres: " + libres + "\n" +
               "Ocupación: " + ocupacion + "%";
       JOptionPane.showMessageDialog(null, texto);
   }
}
    }
    
}
