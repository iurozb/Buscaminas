
package buscaminas;

import java.util.Scanner;


public class Juego {
    
    private int numFilas;
    private int numColumnas;
    private int numMInas;
    private Tablero tablero;

    public Juego() {
    
       configurarJuego();
       iniciarJuego();
    
    }
    
    
    public void configurarJuego(){
        Scanner leer = new Scanner(System.in);
        Juego j = new Juego();
        
        System.out.println("Dime las filas y columnas del tablero");
        numFilas = leer.nextInt();
        numColumnas = leer.nextInt();
        System.out.println("Dime la cantidad de minas con las que quieres jugar");
        numMInas = leer.nextInt();          
        
       
    }
    
    
    public void iniciarJuego(){
        
        Tablero t = new Tablero(numMInas, numFilas, numColumnas);
        t.insertarMinas(numMInas);
        t.calcularTablero();
    }
    
    public void elegirOperacion(){
        
        int opc = 0;
        
        while(true){
            Menu.mostraMenu();
            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public void setNumMInas(int numMInas) {
        this.numMInas = numMInas;
    }

    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }
    
    
}
