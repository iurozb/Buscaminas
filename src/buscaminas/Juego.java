
package buscaminas;

import java.awt.Menu;
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
        iniciarJuego();
        
        
       
    }
    
    
    public void iniciarJuego(){
        
        tablero = new Tablero(numFilas, numColumnas, numMInas);
        tablero.insertarMinas(numMInas);
        tablero.calcularTablero();
        //tablero.imprimirPrueba();
        System.out.println("");
        tablero.imprimirPrueba();
        System.out.println("");
    }
    
    private int elegirOperacion(){
        
        boolean bandera=true;
        int opcion=0;
        
        do{
            
        
            try{
                bandera=true;
                Scanner leer = new Scanner(System.in);
                System.out.println("**** MENU ****");
                System.out.println("1. Descubrir casilla");
                System.out.println("2. Poner bandera");
                System.out.println("3. Quitar bandera");
                System.out.println("0. Rendirse");
                opcion=leer.nextInt();
            }catch(Exception e){
                System.out.println("Error en el dato introducido");
                bandera=false;
            }
        }while(bandera==false || opcion>3 || opcion<0);
        

        
        return opcion;
    }
    
    public void jugar(){
        int filas,columnas,opcion;
        tablero.imprimirPrueba();
        do{
            opcion=elegirOperacion();
            switch(opcion){
                case 1: 
                        Scanner leer = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer.nextInt();
                        columnas=leer.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                           descubrirCasilla(filas, columnas);
                           tablero.imprimirPrueba();
                           if(partidaGanada()==true){
                                System.out.println("***********************");
                                System.out.println("    VICTORIA ROYALE    ");
                                System.out.println("***********************");
                                System.exit(1);
                            }
                        }
                    break;
                    case 2:
                        Scanner leer2 = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer2.nextInt();
                        columnas=leer2.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                           descubrirBandera(filas, columnas);
                           tablero.imprimirPrueba(); 
                        };
                        break;
                    case 3:
                        Scanner leer3 = new Scanner(System.in);
                        System.out.println("Dame las coordenadas(fila,columnas)");
                        filas=leer3.nextInt();
                        columnas=leer3.nextInt();
                        if(coordenadasCorrectas(filas, columnas)){
                           tablero.getCasilla(filas, columnas);
                            quitarBandera(filas, columnas);
                            tablero.imprimirPrueba(); 
                        };
                        break;    
                        
            }
        }while(opcion!=0);
    }

    
    private void descubrirCasilla(int filas, int columnas){
        if(tablero.meterCasilla(filas,columnas)==false){
            acabarJuegoMina();
            tablero.imprimirPrueba();
            System.exit(0);
        };
        
    }
    
    private void descubrirBandera(int filas, int columnas){
        tablero.meterBandera(filas,columnas);

    }
   
     private void quitarBandera(int filas, int columnas){
        tablero.quitarBandera(filas,columnas);

    }
    
    
    private boolean coordenadasCorrectas(int filas, int columnas){
        Scanner leer = new Scanner(System.in);
        boolean bandera=true;
        
        do{
            try{ 
                    leer = new Scanner(System.in);
                    while(filas>numFilas-1){
                        leer = new Scanner(System.in);
                        System.out.println("El numero de fila no se encuentra en el tablero");
                        System.out.println("Dame otra fila");
                        filas=leer.nextInt();
                    }
                    while(columnas>numColumnas-1){
                        leer = new Scanner(System.in);
                        System.out.println("El numero de columna no se encuentra en el tablero");
                        System.out.println("Dame otra columna");
                        columnas=leer.nextInt();
                    }
  
            }catch(Exception e){
                System.out.println("Error en el dato introducido");
                bandera=false;
            }
          
        }while(bandera==false);
        return bandera;
    }
    
      private boolean partidaGanada(){
        boolean ganado = comprobarVictoria();
        return ganado;
    }
      
      public boolean comprobarVictoria(){
           boolean ganado=true;
           for (int i = 0; i < numFilas; i++) {
               for (int j = 0; j < numColumnas; j++) {
                   if(tablero.getCasilla(i, j).isMina()){
                       
                   }else{
                       if(tablero.getCasilla(i, j).isVisible()){
                           
                       }else{
                          ganado=false; 
                          break;
                       }
                   }
               }
           }
           return ganado;
}
    
    private void acabarJuegoMina(){
        
        System.out.println("    |game over muk|   ");
        
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
