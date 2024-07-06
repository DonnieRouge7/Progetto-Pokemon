
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
	private Mossa[] mosse = new Mossa[4];
	
	public Pokemon(String codice, int tipo1, int tipo2, String nome, int xp, int livello, double hp, int attaccoPokemon, int difesaPokemon, int attaccoSpecialePokemon, int difesaSpecialePokemon, int velocitàPokemon, double elusionePokemon) {
		this.codice = codice;
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
			this.elusionePokemon += 3;
			this.hp += 3;
		}
		
		// aggiungere ricerca mosse da imparare 
	}
	public void esausto(Pokemon p1) {
		if(p1.hp <= 0) {
			System.out.println(p1.nome + " è esausto");
		}else {
			System.out.println(p1.nome + " è ancora vivo");
		}
		
	}
	
	public void attacca(Pokemon p1, Pokemon p2) {
		
	}
	
	public void subisciAttacco(Mossa[] mosse) {

	}
	
}


