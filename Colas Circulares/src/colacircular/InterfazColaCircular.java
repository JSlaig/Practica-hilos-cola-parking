package colacircular;

import clientescolacircular.*;

/*Las interfaces por definicion son publicas y abstractas lo cual implica 
 * que solo esten en esta clase la signatura de los métodos, y que en la 
 * clase que implementa la interfaz es en la cual se extienden los metodos
 * con el tag @Override antes de su signatura
 */
public interface InterfazColaCircular {
	
	/**
	 * Encola el objeto o en la cola y le asigna el número de ticket que le corresponde
	 * en la secuencia de llegada de objetos a la cola devolviendolo como parámetro.
	 * @param o
	 */
	public long encolar (ObjetoTest o) throws InterruptedException ;
	
	/**
	 * Devuelve el primer elemento de la cola quitándole de la misma.
	 * @return
	 */
	public ObjetoTest desencolar () throws InterruptedException;


}