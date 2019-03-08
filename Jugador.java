
/**
 * Write a description of class Jugador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int puntuacion;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        puntuacion = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getPuntos()
    {
        return puntuacion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setPuntos(int puntos){
        puntuacion = puntos;
    }
}
