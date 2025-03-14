package Lotta_Pokemon;

import java.util.List;

/**
 * Rappresenta un Pokémon con statistiche, tipi e mosse.
 * Contiene metodi per l'uso delle mosse e la gestione del livello.
 * 
 * @author Massimo Donnini
 * @numero_matricola 1965076
 */
public class Pokemon {
	
	/** Codice identificativo del Pokémon */
	private String codice;
	
	/** Tipo primario del Pokémon (rappresentato da un codice numerico) */
	private int tipo1;
	
	/** Tipo secondario del Pokémon, -1 se non ha un secondo tipo */
	private int tipo2;
	
	/** Nome del Pokémon */
	private String nome;
	
	/** Esperienza attuale del Pokémon */
	private int xp;
	
	/** Livello attuale del Pokémon */
	private int livello;
	
	/** Punti vita attuali del Pokémon */
	private double hp;
	
	/** Punti vita massimi del Pokémon */
	private double hpMax;
	
	/** Attacco fisico del Pokémon */
	private int attacco;
	
	/** Difesa fisica del Pokémon */
	private int difesa;
	
	/** Attacco speciale del Pokémon */
	private int attaccoSpeciale;
	
	/** Difesa speciale del Pokémon */
	private int difesaSpeciale;
<<<<<<< HEAD
	private int velocita; 
	private double elusione = 30; 
=======
	
	/** Velocità del Pokémon */
	private int velocita;
	
	/** Percentuale di elusione del Pokémon */
	private double elusione = 30;
	
	/** Lista delle mosse disponibili del Pokémon */
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e
	private List<Mossa> mosse;

	/**
	 * Costruttore della classe Pokemon.
	 * 
	 * @param codice Identificativo del Pokémon.
	 * @param tipo1 Tipo primario del Pokémon.
	 * @param tipo2 Tipo secondario del Pokémon (-1 se non esiste).
	 * @param nome Nome del Pokémon.
	 * @param xp Esperienza del Pokémon.
	 * @param livello Livello attuale del Pokémon.
	 * @param hp Punti vita attuali.
	 * @param hpMax Punti vita massimi.
	 * @param attacco Attacco fisico del Pokémon.
	 * @param difesa Difesa fisica del Pokémon.
	 * @param attaccoSpeciale Attacco speciale del Pokémon.
	 * @param difesaSpeciale Difesa speciale del Pokémon.
	 * @param velocita Velocità del Pokémon.
	 * @param elusione Percentuale di elusione del Pokémon.
	 */
	
<<<<<<< HEAD
	
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, double hpMax, int attacco, int difesa, int attaccoSpeciale, int difesaSpeciale, int velocita, double elusione) {
		this.tipo1 = tipo1;
=======
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, double hpMax, int attacco, int difesa, int attaccoSpeciale, int difesaSpeciale, int velocita, double elusione) {
		this.codice = codice;
		this.tipo1 = tipo1; 
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e
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
		this.velocita = velocita;
		this.elusione = 30;
	}
	
	@Override
	public String toString() {
		return "Pokemon [codice=" + codice + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", nome=" + nome + ", xp=" + xp
				+ ", livello=" + livello + ", hp=" + hp + ", attaccoPokemon=" + attacco + ", difesaPokemon="
				+ difesa + ", attaccoSpecialePokemon=" + attaccoSpeciale + ", difesaSpecialePokemon="
				+ difesaSpeciale + ", velocitàPokemon=" + velocita + ", elusionePokemon="
<<<<<<< HEAD
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
	public int getVelocita() {
		return velocita;
	}
	public void setVelocita(int velocità) {
		this.velocita = velocita;
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
=======
				+ elusione + "]";
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e
	}
	
	/**
	 * Verifica se il Pokémon può salire di livello in base all'XP.
	 * Se il Pokémon sale di livello, migliora le sue statistiche.
	 * 
	 * @return true se il Pokémon è salito di livello, false altrimenti.
	 */
	public boolean saliDiLivello() {
		if (xp >= getLivello() * 10) {
			setLivello(livello + 1);
			setAttacco(attacco + 3);
			setAttaccoSpeciale(attaccoSpeciale + 3);
			setDifesa(difesa + 3);
			setDifesaSpeciale(difesaSpeciale + 3);
			setVelocita(velocita + 3);
			setElusione(elusione + 3);
			setHpMax(hpMax + 3);
			return true;
		}
		return false;
	}
	
	/**
	 * Permette al Pokémon di usare una mossa su un bersaglio.
	 * Se la mossa è di attacco, infligge danno; se è di stato, modifica statistiche.
	 * 
	 * @param bersaglio Il Pokémon bersaglio dell'attacco.
	 * @param mossa La mossa da utilizzare.
	 */
	public void usaMossa(Pokemon bersaglio, Mossa mossa) {
	    mossa.noPP();
	    System.out.println(this.getNome() + " usa " + mossa.getNomeMossa() + " su " + bersaglio.getNome());
	    
	    if (mossa instanceof MossaAttacco) {
	        ((MossaAttacco) mossa).attaccaDanno(this, bersaglio);
	    } else if (mossa instanceof MossaStato) {
	        ((MossaStato) mossa).attaccaStato(this, bersaglio);
	    }
	}
	
	/**
	 * Controlla se il Pokémon è esausto (ha 0 HP).
	 * 
	 * @return true se il Pokémon è esausto, false altrimenti.
	 */
	public boolean esausto() {
		if (getHp() <= 0) {
			setHp(0);
			return true;
		}
		return false;
	}

	// Getters e Setters 
	public String getCodice() { return codice; }
	public void setCodice(String codice) { this.codice = codice; }
	
	public int getTipo1() { return tipo1; }
	public void setTipo1(int tipo1) { this.tipo1 = tipo1; }
	
	public int getTipo2() { return tipo2; }
	public void setTipo2(int tipo2) { this.tipo2 = tipo2; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public int getLivello() { return livello; }
	public void setLivello(int livello) { this.livello = livello; }
	
	public double getHp() { return hp; }
	public void setHp(double hp) { this.hp = hp; }
	
	public double getHpMax() { return hpMax; }
	public void setHpMax(double hpMax) { this.hpMax = hpMax; }
	
	public int getAttacco() { return attacco; }
	public void setAttacco(int attacco) { this.attacco = attacco; }
	
	public int getDifesa() { return difesa; }
	public void setDifesa(int difesa) { this.difesa = difesa; }
	
	public int getAttaccoSpeciale() { return attaccoSpeciale; }
	public void setAttaccoSpeciale(int attaccoSpeciale) { this.attaccoSpeciale = attaccoSpeciale; }
	
	public int getDifesaSpeciale() { return difesaSpeciale; }
	public void setDifesaSpeciale(int difesaSpeciale) { this.difesaSpeciale = difesaSpeciale; }
	
	public int getVelocita() { return velocita; }
	public void setVelocita(int velocita) { this.velocita = velocita; }
	
	public double getElusione() { return elusione; }
	public void setElusione(double elusione) { this.elusione = elusione; }
	
	public List<Mossa> getMosse() { return mosse; }
	public void setMosse(List<Mossa> mosse) { this.mosse = mosse; }
	
	public int getXp() { return xp; }
	public void setXp(int xp) { this.xp = xp; }
}
