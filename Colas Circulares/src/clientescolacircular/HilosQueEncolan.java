package clientescolacircular;
import colacircular.*;

/**
 * Los objetos de esta clase son hilos que crean e introducen en la cola circular objetos del tipo ObjetoTest.
 * 
 * @author adolfo
 *
 */
public class HilosQueEncolan extends Thread{
	
	private ColaCircular cc;
	
	public HilosQueEncolan(ColaCircular c) {
		cc = c;
	}
	
	@Override
	public void run() {
		while(true) {
			int n = (int)Math.round(1000*Math.random());
			ObjetoTest ot = new ObjetoTest();
			ot.inf = n;
			try {
				cc.encolar(ot);
				System.out.println("El objeto con matricula "+ot.inf+" y ticket "+ot.ticket+" ha sido encolado.");
			
				} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
		
	}

}
