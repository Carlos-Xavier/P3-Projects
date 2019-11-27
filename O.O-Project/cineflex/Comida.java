
package cineflex;

public final class Comida {
    private float pipoca, doce, bebida;

    public Comida() {
        this.pipoca = 8.50f;
        this.doce = 3.99f;
        this.bebida = 6.99f;
    }

    public float getPipoca() {
        return pipoca;
    }

    public void setPipoca(float pipoca) {
        this.pipoca = pipoca;
    }

    public float getDoce() {
        return doce;
    }

    public void setDoce(float doce) {
        this.doce = doce;
    }

    public float getBebida() {
        return bebida;
    }

    public void setBebida(float bebida) {
        this.bebida = bebida;
    }
}
