package Lotta_Pokemon;

import java.util.Arrays;
import java.util.List;

public class Pokemon {

	private String codice;
	private int tipo1; // ogni tipo ha un codice di riferimento nel file "Modificatore_Mosse"
	private int tipo2; // se è -1 significa che non ha un secondo tipo 
	private String nome;
	private int xp;
	private int livello; 
	private double hp; 
	private int attaccoPokemon;
	private int difesaPokemon; 
	private int attaccoSpecialePokemon;
	private int difesaSpecialePokemon;
	private int velocitàPokemon; 
	private double elusionePokemon = 30; 
	private List<Mossa> mosse;;
	
	
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, int attaccoPokemon, int difesaPokemon, int attaccoSpecialePokemon, int difesaSpecialePokemon, int velocitàPokemon, double elusionePokemon) {
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.nome = nome;
		this.xp = xp;
		this.livello = livello;
		this.hp = hp;
		this.attaccoPokemon = attaccoPokemon;
		this.difesaPokemon = difesaPokemon;
		this.attaccoSpecialePokemon = attaccoSpecialePokemon;
		this.difesaSpecialePokemon = difesaSpecialePokemon;
		this.velocitàPokemon = velocitàPokemon;
		this.elusionePokemon = 30;
	}
	
	@Override
	public String toString() {
		return "Pokemon [codice=" + codice + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", nome=" + nome + ", xp=" + xp
				+ ", livello=" + livello + ", hp=" + hp + ", attaccoPokemon=" + attaccoPokemon + ", difesaPokemon="
				+ difesaPokemon + ", attaccoSpecialePokemon=" + attaccoSpecialePokemon + ", difesaSpecialePokemon="
				+ difesaSpecialePokemon + ", velocitàPokemon=" + velocitàPokemon + ", elusionePokemon="
				+ elusionePokemon;
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
	public int getAttaccoPokemon() {
		return attaccoPokemon;
	}
	public void setAttaccoPokemon(int attaccoPokemon) {
		this.attaccoPokemon = attaccoPokemon;
	}
	public int getDifesaPokemon() {
		return difesaPokemon;
	}
	public void setDifesaPokemon(int difesaPokemon) {
		this.difesaPokemon = difesaPokemon;
	}
	public int getAttaccoSpecialePokemon() {
		return attaccoSpecialePokemon;
	}
	public void setAttaccoSpecialePokemon(int attaccoSpecialePokemon) {
		this.attaccoSpecialePokemon = attaccoSpecialePokemon;
	}
	public int getDifesaSpecialePokemon() {
		return difesaSpecialePokemon;
	}
	public void setDifesaSpecialePokemon(int difesaSpecialePokemon) {
		this.difesaSpecialePokemon = difesaSpecialePokemon;
	}
	public int getVelocitàPokemon() {
		return velocitàPokemon;
	}
	public void setVelocitàPokemon(int velocitàPokemon) {
		this.velocitàPokemon = velocitàPokemon;
	}
	public double getElusione() {
		return elusionePokemon;
	}
	public void setElusione(double elusionePokemon) {
		this.elusionePokemon = elusionePokemon;
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
	public void saliDiLivello() {
		if(xp >= (livello*10)) {
			setLivello(livello+1);
			setAttaccoPokemon(attaccoPokemon + 3);
			setAttaccoSpecialePokemon(attaccoSpecialePokemon + 3);
			setDifesaPokemon(difesaPokemon + 3);
			setDifesaSpecialePokemon(difesaSpecialePokemon + 3);
			setVelocitàPokemon(velocitàPokemon + 3);
			setElusione(elusionePokemon + 3);
			setHp(hp + 3);
		}
		
		// aggiungere ricerca mosse da imparare 
	}
	
	public void usaMossa(Pokemon difensore, Mossa mossa) {
	    System.out.println(nome + " usa " + mossa.getNomeMossa());
	    mossa.noPP();
	    
	    if (mossa instanceof MossaAttacco) {
	        ((MossaAttacco) mossa).attaccaDanno(this, difensore);
	    } else if (mossa instanceof MossaStato) {
	        ((MossaStato) mossa).usaMossaStato(difensore);
	    }
	}
	
	public void scegliMossa(int indice, Pokemon difensore) {
	    if (indice >= 0 && indice < mosse.size()) {
	        usaMossa(difensore, mosse.get(indice));
	    } else {
	        System.out.println("Mossa non valida!");
	    } 
	}
	
	public void subisciDanno(Pokemon difensore, int danno) {
		difensore.setHp(difensore.getHp() - danno);
		if(difensore.esausto() == true) {
		}else {
			System.out.println(getNome() + " ha " + getHp() + " rimanenti");
		}
	}
	
	public boolean esausto() {
		boolean esausto = false;
		if(getHp() <= 0) {
			setHp(0);
			System.out.println(getNome() + " è esausto");
			esausto = true;
		}else {
			esausto = false;
		}
		return esausto;
	}
	
}


