
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

    
    
    
}
