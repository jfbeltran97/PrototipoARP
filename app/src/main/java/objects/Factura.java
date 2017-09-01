package objects;

/**
 * Created by johnny on 30/08/17.
 */

public class Factura {
    private Plato[] platos;
    private int[] qties;
    public static final double IVA = 0.12f;

    public Factura(Plato[] platos, int[] qties){
        this.platos = platos;
        this.qties = qties;
    }

    public double getPrecio(){
        double precio = 0;

        for (int i = 0; i < platos.length; i++) {
            precio += platos[i].getPrecio()*qties[i];
        }

        return precio;
    }

    public double getTotalPrice(){
        return getPrecio()*(1+IVA);
    }

}
