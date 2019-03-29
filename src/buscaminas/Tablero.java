
package buscaminas;

import java.util.Random;


public class Tablero {

    private int numMinas;
    private int numFilas;
    private int numColumnas;
    private Casilla[][] tabla;

    //Constructor para crear el tablero
    public Tablero(int numMinas, int numFilas, int numColumnas) {
        this.numMinas = numMinas;
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        tablero(numFilas, numColumnas);
    }
    
    //Inicializar el tablero con casillas en cada posición de matriz
    private void tablero(int numFilas, int numColumnas){
        
        this.tabla = new Casilla[numFilas][numColumnas];
        
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                tabla[i][j] = new Casilla();
            }
        }
        
    }
    
    //Método para insertar minas en el tablero aleatoriamente
    public void insertarMinas(int numMinas){
        Random r = new Random();
     
        int fila, columna;
        this.numMinas = numMinas;
        
        while(numMinas > 0){
            fila = r.nextInt(numFilas);
            columna = r.nextInt(numColumnas);
            
            if(!tabla[fila][columna].isMina()){
                tabla[fila][columna].setMina(true);
                numMinas--;
            }
         
        }
    }
    /*
    public void imprimirPrueba(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(tabla[i][j].isBlanco()){
                    System.out.println("");
                }else if(tabla[i][j].isMina()){
                    System.out.println("M");
                }else {
                    System.out.println(tabla[i][j].getNumero());
                }
                
                System.out.println(" | ");
            }
            System.out.println("\n");
        }
        
    }
    */
    
    public void colocarCasillas(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if(!tabla[i][j].isMina()){
                    
                }
            }
        }
    }
}
