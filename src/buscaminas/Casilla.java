
package buscaminas;


public class Casilla {
    
    private boolean mina;
    private boolean blanco;
    private boolean bandera;
    private boolean visible;
    private int numero;

    public Casilla() {
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isMina() {
        return mina;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isBandera() {
        return bandera;
    }

    public boolean isBlanco() {
        return blanco;
    }

    public boolean isVisible() {
        return visible;
    }

    public String imprimirPrueba(){
        String sol = "*";
        
        if(bandera){
            return "B";
        }
        
        if(mina){
            return "M";
        }
        
        if(numero > 0){
            sol = "" + numero;
        }
        return sol;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public void setBlanco(boolean blanco) {
        this.blanco = blanco;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
