package Lotta_Pokemon;

import java.util.List;

public class Pokemon {

	private String codice;
	private int tipo1; // ogni tipo ha un codice di riferimento nel file "Modificatore_Mosse"
	private int tipo2; // se è -1 significa che non ha un secondo tipo 
	private String nome;
	private int xp;
	private int livello; 
	private double hp; 
	private double hpMax;
	private int attacco;
	private int difesa; 
	private int attaccoSpeciale;
	private int difesaSpeciale;
	private int velocità; 
	private double elusione = 30; 
	private List<Mossa> mosse;
	
	
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, double hpMax, int attacco, int difesa, int attaccoSpeciale, int difesaSpeciale, int velocità, double elusione) {
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.nome = nome;
		this.xp = xp;
		this.livello = livello;
		this.hp = hp;
		this.hpMax = hpMax;
		this.attacco = attacco;
		this.difesa = difesa;
		this.attaccoSpeciale = attaccoSpeciale;
		this.difesaSpeciale = difesaSpeciale;
		this.velocità = velocità;
		this.elusione = 30;
	}
	
	@Override
	public String toString() {
		return "Pokemon [codice=" + codice + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", nome=" + nome + ", xp=" + xp
				+ ", livello=" + livello + ", hp=" + hp + ", attaccoPokemon=" + attacco + ", difesaPokemon="
				+ difesa + ", attaccoSpecialePokemon=" + attaccoSpeciale + ", difesaSpecialePokemon="
				+ difesaSpeciale + ", velocitàPokemon=" + velocità + ", elusionePokemon="
				+ elusione;
	}

	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getTipo1() {
		return tipo1;
	}
	public void setTipo1(int tipo1) {
		this.tipo1 = tipo1;
	}
	public int getTipo2() {
		return tipo2;
	}
	public void setTipo2(int tipo2) {
		this.tipo2 = tipo2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLivello() {
		return livello;
	}
	public void setLivello(int livello) {
		this.livello = livello;
	}
	public double getHp() {
		return hp;
	}
	public void setHp(double hp) {
		this.hp = hp;
	}
	public double getHpMax() {
		return hpMax;
	}
	public void setHpMax(double hpMax) {
		this.hpMax = hpMax;
	}
	public int getAttacco() {
		return attacco;
	}
	public void setAttacco(int attacco) {
		this.attacco = attacco;
	}
	public int getDifesa() {
		return difesa;
	}
	public void setDifesa(int difesa) {
		this.difesa = difesa;
	}
	public int getAttaccoSpeciale() {
		return attaccoSpeciale;
	}
	public void setAttaccoSpeciale(int attaccoSpeciale) {
		this.attaccoSpeciale = attaccoSpeciale;
	}
	public int getDifesaSpeciale() {
		return difesaSpeciale;
	}
	public void setDifesaSpeciale(int difesaSpeciale) {
		this.difesaSpeciale = difesaSpeciale;
	}
	public int getVelocità() {
		return velocità;
	}
	public void setVelocità(int velocità) {
		this.velocità = velocità;
	}
	public double getElusione() {
		return elusione;
	}
	public void setElusione(double elusione) {
		this.elusione = elusione;
	}
	public List<Mossa> getMosse() {
		return mosse;
	}
	public void setMosse(List<Mossa> mosse) {
		this.mosse = mosse;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	// Per verificare quando il Pokemon sale di livello 
	
	public boolean saliDiLivello() {
		boolean saliDiLivello = false;
		if(xp >= getLivello()*10) {
			setLivello(livello + 1);
			setAttacco(attacco + 3);
			setAttaccoSpeciale(attaccoSpeciale + 3);
			setDifesa(difesa + 3);
			setDifesaSpeciale(difesaSpeciale + 3);
			setVelocità(velocità + 3);
			setElusione(elusione + 3);
			setHpMax(hpMax + 3);
			saliDiLivello = true;
		}
		
		return saliDiLivello;
	}
	
	// Per scegliere se usare una Mossa per infliggere danni o modificare le caratteristiche di uno dei due Pokemon
	
	public void usaMossa(Pokemon bersaglio, Mossa mossa) {
	    mossa.noPP();
	    System.out.println(this.getNome() + " usa " + mossa.getNomeMossa() + " su " + bersaglio.getNome());
	    
	    if (mossa instanceof MossaAttacco) {
	        ((MossaAttacco) mossa).attaccaDanno(this, bersaglio);
	    } else if (mossa instanceof MossaStato) {
	        ((MossaStato) mossa).attaccaStato(this, bersaglio);
	    }
	}
	
	// Per verificare quando un Pokemon è esausto
	
	public boolean esausto() {
		boolean esausto = false;
		if(getHp() <= 0) {
			setHp(0);
			esausto = true;
		}else {
			esausto = false;
		}
		return esausto;
	}
	
}


