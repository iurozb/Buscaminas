
package buscaminas;


public class Tablero {

    private int numMinas;
    private int numFilas;
    private int numColumnas;
    private Casilla[][] tabla;

    public Tablero(int numMinas, int numFilas, int numColumnas) {
        this.numMinas = numMinas;
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.tabla = Tablero.tablero(numFilas, numColumnas);
    }
    
    
    
    
    public static Casilla[][] tablero(int numFilas, int numColumnas){
        
        Casilla[][] tabla = new Casilla[numFilas][numColumnas];
        
        return tabla;
    }
}
