import java.util.Random; 

public class Mossa{
	int codiceMossa; 
	String nomeMossa;
	int elementoMossa; // fuoco, erba, etc...
	String tipo; // fisico, speciale, stato
	int PP; // numero massimo di volte che quella mossa può essere usata, non si resetta dopo una lotta
	int precisioneMossa;
	boolean offesa; // serve per indicare se la mossa è di tipo offensivo (true) o di tipo stato (false), così posso fare un controllo nel main e chiamare la sottoclasse attacco o quella di stato a seconda dell'evenienza
		
	public boolean noPP(Mossa m1) {
		boolean b1 = false;
		while(m1.PP == 0) {
			System.out.println("hai finito i PP");
			b1 = false;
			}
		b1 = true; 
	return b1; 
	}
	
	public int generaNumeroCasuale(int a, int b) {
		Random numeroCasuale = new Random(); 
		return numeroCasuale.nextInt((b - a) + 1) + a;
	}
	
	public double generaNumeroCasuale(double a, double b) {
		Random numeroCasuale = new Random();
		return numeroCasuale.nextDouble((b - a) + 1) + a;
	}
}



