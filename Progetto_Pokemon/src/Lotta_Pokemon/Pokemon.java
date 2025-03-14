package Lotta_Pokemon;

import java.util.List;

/**
 * Rappresenta un Pokémon con statistiche, tipi e mosse.
 * Contiene metodi per l'uso delle mosse e la gestione del livello.
 * 
 * @author Massimo Donnini
 * 
 */
public class Pokemon {
	
	/** Codice identificativo del Pokemon */
	private String codice;
	
	/** Tipo primario del Pokemon (rappresentato da un codice numerico) */
	private int tipo1;
	
	/** Tipo secondario del Pokemon, -1 se non ha un secondo tipo */
	private int tipo2;
	
	/** Nome del Pokemon */
	private String nome;
	
	/** Esperienza attuale del Pokemon */
	private int xp;
	
	/** Livello attuale del Pokemon */
	private int livello;
	
	/** Punti vita attuali del Pokemon */
	private double hp;
	
	/** Punti vita massimi del Pokemon */
	private double hpMax;
	
	/** Attacco fisico del Pokemon */
	private int attacco;
	
	/** Difesa fisica del Pokemon */
	private int difesa;
	
	/** Attacco speciale del Pokemon */
	private int attaccoSpeciale;
	
	/** Difesa speciale del Pokemon */
	private int difesaSpeciale;
	
	/** Velocità del Pokémon */
	private int velocita;
	
	/** Percentuale di elusione del Pokemon */
	private double elusione = 30;
	
	/** Lista delle mosse disponibili del Pokemon */
	private List<Mossa> mosse;

	/**
	 * Costruttore della classe Pokemon.
	 * 
	 * @param codice Identificativo del Pokemon.
	 * @param tipo1 Tipo primario del Pokemon.
	 * @param tipo2 Tipo secondario del Pokemon (-1 se non esiste).
	 * @param nome Nome del Pokemon.
	 * @param xp Esperienza del Pokemon.
	 * @param livello Livello attuale del Pokemon.
	 * @param hp Punti vita attuali.
	 * @param hpMax Punti vita massimi.
	 * @param attacco Attacco fisico del Pokemon.
	 * @param difesa Difesa fisica del Pokemon.
	 * @param attaccoSpeciale Attacco speciale del Pokemon.
	 * @param difesaSpeciale Difesa speciale del Pokemon.
	 * @param velocita Velocità del Pokemon.
	 * @param elusione Percentuale di elusione del Pokemon.
	 */
	
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, double hpMax, int attacco, int difesa, int attaccoSpeciale, int difesaSpeciale, int velocita, double elusione) {
		this.codice = codice;
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
		this.velocita = velocita;
		this.elusione = 30;
	}
	
	// Getters e Setters 
	
		/**
		 * Restituisce il codice identificativo del Pokemon.
		 * @return Il codice del Pokémon.
		 */
		public String getCodice() { return codice; }

		/**
		 * Imposta il codice identificativo del Pokemon.
		 * @param codice Il codice da assegnare.
		 */
		public void setCodice(String codice) { this.codice = codice; }

		/**
		 * Restituisce il tipo primario del Pokemon.
		 * @return Il codice del tipo primario.
		 */
		public int getTipo1() { return tipo1; }

		/**
		 * Imposta il tipo primario del Pokemon.
		 * @param tipo1 Il codice del tipo primario.
		 */
		public void setTipo1(int tipo1) { this.tipo1 = tipo1; }

		/**
		 * Restituisce il tipo secondario del Pokemon.
		 * @return Il codice del tipo secondario o -1 se non presente.
		 */
		public int getTipo2() { return tipo2; }

		/**
		 * Imposta il tipo secondario del Pokemon.
		 * @param tipo2 Il codice del tipo secondario.
		 */
		public void setTipo2(int tipo2) { this.tipo2 = tipo2; }

		/**
		 * Restituisce il nome del Pokemon.
		 * @return Il nome del Pokemon.
		 */
		public String getNome() { return nome; }

		/**
		 * Imposta il nome del Pokemon.
		 * @param nome Il nome da assegnare.
		 */
		public void setNome(String nome) { this.nome = nome; }

		/**
		 * Restituisce il livello attuale del Pokemon.
		 * @return Il livello attuale.
		 */
		public int getLivello() { return livello; }

		/**
		 * Imposta il livello del Pokemon.
		 * @param livello Il livello da assegnare.
		 */
		public void setLivello(int livello) { this.livello = livello; }

		/**
		 * Restituisce i punti vita attuali del Pokemon.
		 * @return Gli HP attuali.
		 */
		public double getHp() { return hp; }

		/**
		 * Imposta i punti vita attuali del Pokemon.
		 * @param hp Gli HP da assegnare.
		 */
		public void setHp(double hp) { this.hp = hp; }

		/**
		 * Restituisce i punti vita massimi del Pokemon.
		 * @return Gli HP massimi.
		 */
		public double getHpMax() { return hpMax; }

		/**
		 * Imposta i punti vita massimi del Pokemon.
		 * @param hpMax Gli HP massimi da assegnare.
		 */
		public void setHpMax(double hpMax) { this.hpMax = hpMax; }

		/**
		 * Restituisce il valore di attacco fisico del Pokemon.
		 * @return Il valore dell'attacco fisico.
		 */
		public int getAttacco() { return attacco; }

		/**
		 * Imposta il valore di attacco fisico del Pokemon.
		 * @param attacco Il valore dell'attacco fisico.
		 */
		public void setAttacco(int attacco) { this.attacco = attacco; }

		/**
		 * Restituisce il valore della difesa fisica del Pokemon.
		 * @return Il valore della difesa.
		 */
		public int getDifesa() { return difesa; }

		/**
		 * Imposta il valore della difesa fisica del Pokemon.
		 * @param difesa Il valore della difesa.
		 */
		public void setDifesa(int difesa) { this.difesa = difesa; }

		/**
		 * Restituisce il valore dell'attacco speciale del Pokemon.
		 * @return Il valore dell'attacco speciale.
		 */
		public int getAttaccoSpeciale() { return attaccoSpeciale; }

		/**
		 * Imposta il valore dell'attacco speciale del Pokemon.
		 * @param attaccoSpeciale Il valore dell'attacco speciale.
		 */
		public void setAttaccoSpeciale(int attaccoSpeciale) { this.attaccoSpeciale = attaccoSpeciale; }
		
		/**
		 * Restituisce il valore della difesa speciale del Pokemon.
		 * @return Il valore della difesa speciale.
		 */
		public int getDifesaSpeciale() { return difesaSpeciale; }

		/**
		 * Imposta il valore della difesa speciale del Pokemon.
		 * @param difesaSpeciale Il valore della difesa speciale.
		 */
		public void setDifesaSpeciale(int difesaSpeciale) { this.difesaSpeciale = difesaSpeciale; }
		
		/**
		 * Restituisce il valore della velocita del Pokemon.
		 * @return Il valore della velocita.
		 */
		public int getVelocita() { return velocita; }

		/**
		 * Imposta il valore della velocita del Pokemon.
		 * @param velocita Il valore della velocita.
		 */
		public void setVelocita(int velocita) { this.velocita = velocita; }
		
		/**
		 * Restituisce il valore dell'elusione del Pokemon.
		 * @return Il valore dell'elusione.
		 */
		public double getElusione() { return elusione; }

		/**
		 * Imposta il valore dell'elusione del Pokemon.
		 * @param elusione Il valore dell'elusione.
		 */
		public void setElusione(double elusione) { this.elusione = elusione; }
		
		/**
		 * Restituisce il valore degli xp del Pokemon.
		 * @return Il valore degli xp.
		 */
		public int getXp() { return xp; }
			
		/**
		 * Imposta il valore degli xp del Pokemon.
		 * @param xp Il valore degli xp.
		 */
		public void setXp(int xp) { this.xp = xp; }
			
		/**
		 * Restituisce la lista delle mosse del Pokemon.
		 * @return La lista delle mosse.
		 */
		public List<Mossa> getMosse() { return mosse; }
			
		/**
		 * Imposta la lista delle mosse del Pokemon.
		 * @param mosse la lista delle mosse.
		 */
		public void setMosse(List<Mossa> mosse) { this.mosse = mosse; }
			
	
	@Override
	public String toString() {
		return "Pokemon [codice=" + codice + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", nome=" + nome + ", xp=" + xp
				+ ", livello=" + livello + ", hp=" + hp + ", attaccoPokemon=" + attacco + ", difesaPokemon="
				+ difesa + ", attaccoSpecialePokemon=" + attaccoSpeciale + ", difesaSpecialePokemon="
				+ difesaSpeciale + ", velocitàPokemon=" + velocita + ", elusionePokemon="
				+ elusione + "]";
	}
	
	/**
	 * Verifica se il Pokemon può salire di livello in base all'XP.
	 * Se il Pokémon sale di livello, migliora le sue statistiche.
	 * 
	 * @return true se il Pokemon è salito di livello, false altrimenti.
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
	 * @param bersaglio Il Pokemon bersaglio dell'attacco.
	 * @param mossa La mossa da utilizzare.
	 */
	public void usaMossa(Pokemon bersaglio, Mossa mossa) {
	    mossa.noPP();
	    
	    if (mossa instanceof MossaAttacco) {
	        ((MossaAttacco) mossa).attaccaDanno(this, bersaglio);
	    } else if (mossa instanceof MossaStato) {
	        ((MossaStato) mossa).attaccaStato(this, bersaglio);
	    }
	}
	
	/**
	 * Controlla se il Pokemon è esausto (ha 0 HP).
	 * 
	 * @return true se il Pokemon è esausto, false altrimenti.
	 */
	public boolean esausto() {
		if (getHp() <= 0) {
			setHp(0);
			return true;
		}
		return false;
	}

	

}
