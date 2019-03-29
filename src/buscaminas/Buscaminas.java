
package buscaminas;


public class Buscaminas {

    
    public static void main(String[] args) {

        Tablero t = new Tablero(5, 6, 6);
        t.insertarMinas(5);
        t.imprimirPrueba();
    }
    
}
