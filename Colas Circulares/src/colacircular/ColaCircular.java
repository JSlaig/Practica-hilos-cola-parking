package colacircular;

import clientescolacircular.*;


public class ColaCircular implements InterfazColaCircular{
	
	private static int defaultTam = 10;
	private int tam = defaultTam;
	
	private static long sig_ticket = 1;

	private ObjetoTest[] cola;
	
	private int inicio = 0;
	private int nelems = 0;
	
	public ColaCircular(){
		this.cola = new ObjetoTest[tam];
	}
	
	public ColaCircular(int tam) {
		this.tam = tam;
		this.cola = new ObjetoTest[this.tam];
	}
	
	private synchronized long sig_ticket() {
		return sig_ticket++;
	}

	@Override
	public synchronized long encolar(ObjetoTest item) throws InterruptedException {
		
		while(nelems == tam) {
			wait();
		}
		item.ticket = sig_ticket();
		
		cola[(this.inicio + this.nelems++) % this.tam] = item;
		
		this.notifyAll();
		
		return item.ticket;
	}

	@Override
	public synchronized ObjetoTest desencolar() throws InterruptedException {
		
		while(nelems == 0) {
			wait();
		}
		
		ObjetoTest o = cola[inicio];
		cola[inicio] = null;
		inicio = (inicio + 1) % this.tam;
		nelems--;
		this.notifyAll();
		return o;
	}

}
