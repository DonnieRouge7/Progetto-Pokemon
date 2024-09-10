import java.util.Random; 

public class Mossa{

	private String nomeMossa;
	private int elementoMossa; // fuoco, erba, etc...
	private String tipo; // fisico, speciale, stato
	private int PP; // numero massimo di volte che quella mossa può essere usata, non si resetta dopo una lotta
	int precisioneMossa;
	
	public Mossa(String nomeMossa, int elementoMossa, String tipo, int PP, int precisioneMossa){
		this.nomeMossa = nomeMossa; 
		this.elementoMossa = elementoMossa; 
		this.tipo = tipo; 
		this.PP = PP;
		this.precisioneMossa = precisioneMossa;
	}
	
	public int generaInteroCasuale(int a, int b) {
		Random interoCasuale = new Random(); 
		return interoCasuale.nextInt((b - a) + 1) + a;
	}
	
	public double generaDoubleCasuale(double a, double b) {
		Random doubleCasuale = new Random();
		return doubleCasuale.nextDouble((b - a) + 1) + a;
	}

	public String getNomeMossa() {
		return nomeMossa;
	}

	public void setNomeMossa(String nomeMossa) {
		this.nomeMossa = nomeMossa;
	}

	public int getElementoMossa() {
		return elementoMossa;
	}

	public void setElementoMossa(int elementoMossa) {
		this.elementoMossa = elementoMossa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPP() {
		return PP;
	}

	public void setPP(int pP) {
		PP = pP;
	}

	public int getPrecisioneMossa() {
		return precisioneMossa;
	}

	public void setPrecisioneMossa(int precisioneMossa) {
		this.precisioneMossa = precisioneMossa;
	}

	public boolean noPP() {
		boolean b1 = false;
		if(this.PP == 0) {
			System.out.println("hai finito i PP"); 
			b1 = false;
		}else {
			b1 = true; 
		}
	return b1; 
	}
}



