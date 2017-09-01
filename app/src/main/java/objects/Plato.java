package objects;

/**
 * Created by johnny on 30/08/17.
 */

public class Plato {
    private String name;
    private int picture;
    private double precio;

    public Plato(String name, int picture, double precio){
        this.name = name;
        this.picture = picture;
        this.precio = precio;
    }

    public String getName(){
        return name;
    }

    public double getPrecio(){
        return precio;
    }

    public int getPicture(){
        return picture;
    }
}
