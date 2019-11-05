import colacircular.*;
import clientescolacircular.*;
/**
 * Crea la cola circular, y al menos 2 hilos de tipo HilosQueEncolan y al menos 2 hilos de tipo HilosQueDesencolan y los pone a ejecutar
 * 
 * @author adolfo
 *
 */
public class Main {

	public static void main(String[] args) {
		
		final int NHilos = 2;
		
		ColaCircular cc = new ColaCircular(15);
		
		for(int i = 0; i <= NHilos; i++) {
		new HilosQueEncolan(cc).start();
		new Thread(new HilosQueDesencolan(cc)).start();
		}
	}

}
