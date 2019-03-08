import java.util.*;
/**
 * Write a description of class Juego here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Juego
{
    // instance variables - replace the example below with your own
    private ArrayList<Jugador> jugadores;

    /**
     * Constructor for objects of class Juego
     */
    public Juego()
    {
        jugadores = new ArrayList<Jugador>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void adivinaNumeros()
    {
        boolean funcionar = true;
        while (funcionar){
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce tu nombre: ");
            String nombre = sc.next();
            if (nombre == "SALIR"){
                funcionar = false;
            }
            Jugador jugadorActual = new Jugador(nombre);
            jugadores.add(jugadorActual);
            System.out.println("Introduce el número de inicio: ");
            int numInicio = sc.nextInt();
            System.out.println("Introduce el número de fin: ");
            int numFin = sc.nextInt();
            Random aleatorio = new Random();
            int numeroAEncontrar = aleatorio.nextInt((numFin+1) - numInicio) + numInicio;
            boolean encontrado = false;
            int intentos = numFin - numInicio;
            if (intentos == 0){
                System.out.println("No se puede poner el mismo número");
            }
            while (!encontrado && intentos > 0){
                System.out.println("Introduzca un número: ");
                int numeroBuscado = sc.nextInt();
                if (numeroBuscado == numeroAEncontrar) {
                    encontrado = true;
                } else {
                    intentos--;
                }
            }
            System.out.println("Has acertado!");
            jugadorActual.setPuntos(intentos);
            imprimirCuadroDeHonor();
        }
    }

    public String generarPuntuaciones(){
        int i = 1;
        String puntuaciones = "";
        for(Jugador jugadorActual: jugadores){
            i++;
        }
        return puntuaciones;
    }
    public void imprimirCuadroDeHonor(){
        for (int i = jugadores.size()-1; i >= 0; i--){
            int puntuacionMinima = 0;
            int posicion = i;
            for (int j = i; j >= 0; j--){
                if (jugadores.get(j).getPuntos() > puntuacionMinima){
                    puntuacionMinima = jugadores.get(j).getPuntos();
                    posicion = j;
                }
            }
            Jugador jugadorAux = jugadores.get(posicion);
            jugadores.remove(posicion);
            jugadores.add(jugadorAux);
        }
        int posicion = 1;
        System.out.println("---CUADRO DE HONOR---");
        System.out.println("---------------------------------------------------");
        for (Jugador jugadorActual: jugadores){
            System.out.println(posicion + ". " + jugadorActual.getNombre() + ": " + jugadorActual.getPuntos());
            posicion++;
        }
        System.out.println("---------------------------------------------------");
    }
}
