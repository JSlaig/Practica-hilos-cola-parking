package clientescolacircular;

import colacircular.ColaCircular;


/**
 * Los objetos de esta clase desencolan de la cola circular objetos del tipo ObjetoTest y los imprimen en la salida estándar mediante la
 * cadena: "El objeto con campo información: <ObjetoTest.inf> y ticket: <ObjetoTest.ticket> ha sido desencolado." 
 * @author adolfo
 *
 */
public class HilosQueDesencolan implements Runnable{
	
	private ColaCircular cc;
	
	public HilosQueDesencolan(ColaCircular c) {
		cc = c;
	}

	@Override
	public void run() {
		while(true) {
			ObjetoTest ot = null;
		try {
			ot = (ObjetoTest) cc.desencolar();
			System.out.println("El objeto con matricula "+ot.inf+" y ticket "+ot.ticket+" ha sido desencolado.");
		}catch(InterruptedException e) {
			e.printStackTrace();
			}
		}
		
		
		
	}

}