
public class Pokemon {

	private String codice;
	private int elemento1;
	private int elemento2; 
	private String nome;
	private int xp;
	private int livello; 
	private int hp; 
	private int attaccoPokemon;
	private int difesaPokemon; 
	private int attaccoSpecialePokemon;
	private int difesaSpecialePokemon;
	private int velocitàPokemon; 
	private double elusione = 30; 
	private Mossa[] mosse = new Mossa[4];
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public int getElemento1() {
		return elemento1;
	}
	public void setTipo1(int elemento1) {
		this.elemento1 = elemento1;
	}
	public int getElemento2() {
		return elemento2;
	}
	public void setTipo2(int elemento2) {
		this.elemento2 = elemento2;
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
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
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
		return elusione;
	}
	public void setElusione(double elusione) {
		this.elusione = elusione;
	}
	public Mossa[] getMosse() {
		return mosse;
	}
	public void setMosse(Mossa[] mosse) {
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
			this.attaccoPokemon += 3;
			this.attaccoSpecialePokemon += 3;
			this.difesaPokemon += 3;
			this.difesaSpecialePokemon += 3;
			this.velocitàPokemon += 3;
			this.elusione += 3;
			this.hp += 3;
		}
		
		// aggiungere ricerca mosse da imparare 
	}
	public void esausto(Pokemon p1, Pokemon p2) {
		if(p1.hp <= 0) {
			System.out.println(p1.nome + " è esausto");
		}
		if(p2.hp <= 0) {
			System.out.println(p2.nome + " è esausto");
		}
	}
	
	public void attacca(Mossa[] mosse) {
		
	}
	
	public void subisciAttacco(Mossa[] mosse) {
	mamma come subisco
	}
	
}


