
package buscaminas;

import java.util.Random;
import java.util.Scanner;


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
    
    public void imprimirPrueba(){
        
        System.out.println("  ");
        for (int i = 0; i < numColumnas; i++) {
            System.out.println(i + "|");
        }
        System.out.println(" ");
        
        
        for (int i = 0; i < numFilas; i++) {
            System.out.println(i + "|");
            for (int j = 0; j < numColumnas; j++) {
                System.out.println(tabla[i][j].imprimirPrueba() + " ");
            }
            System.out.println("|" + i);
            System.out.println("");
        }
        System.out.println("  ");
        
        for (int i = 0; i < numColumnas; i++) {
            System.out.println(i + " ");
        }
        System.out.println("");
    }
    
    
    public void colocarCasillas(){
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if(!tabla[i][j].isMina()){   
                }
            }
        }
    }
    
    public int calculaMinasCasilla(int fila, int columna){
        
        int num = 0;
        
        for (int i = fila - 1; i <= fila + 1; i++) {
            if(i >= 0 && i < numFilas){
                for (int j = columna - 1; j <= columna + 1; j++) {
                    if((j >= 0 && j < numColumnas) && (tabla[i][j].isMina())){
                        num++;
                    }
                }
            }
        }
      
        return num;
    }
    
    public void calcularTablero(){
        
        Scanner leer = new Scanner(System.in);
        
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                
                if(!tabla[i][j].isMina()){
                    tabla[i][j].setNumero(calculaMinasCasilla(leer.nextInt(), leer.nextInt()));
                }
            }
        }
    }
    
    public Casilla getCasilla(int fila, int columna){
        
        return this.tabla[fila][columna];
    }
    
    
    public boolean meterCasilla(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isMina()){
            fin=false;
        }
        tabla[filas][columnas].setVisible(true);
        
        return fin;
    }
    
    public void meterBandera(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isBandera()){
            System.out.println("La bandera ya esta puesta");
        }else{
            tabla[filas][columnas].setBandera(true);
            tabla[filas][columnas].setVisible(true);
        }
 
    }
 
        public void quitarBandera(int filas, int columnas){
        boolean fin=true;
        if(tabla[filas][columnas].isBandera()){
            
            tabla[filas][columnas].setBandera(false);
            tabla[filas][columnas].setVisible(false);
            }
        }
    
}
