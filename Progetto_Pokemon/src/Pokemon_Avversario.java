import Lotta_Pokemon.Mossa;

// questa classe ancora non sono sicuro sia utile, per ora la tengo, non si sa mai 
public class Pokemon_Avversario {

		protected String codiceAvversario;
		protected String tipo1Avversario;
		protected String tipo2Avversario; 
		protected String nomeAvversario;
		protected int xpAvversario;
		protected int livelloAvversario; 
		protected int hpAvversario; 
		protected int attaccoPokemonAvversario;
		protected int difesaPokemonAvversario; 
		protected int attaccoSpecialePokemonAvversario;
		protected int difesaSpecialePokemonAvversario;
		protected int velocitàPokemonAvversario; 
		protected Mossa[] mosse = new Mossa[4];
		protected String getCodiceAvversario() {
			return codiceAvversario;
		}
		public void setCodiceAvversario(String codiceAvversario) {
			this.codiceAvversario = codiceAvversario;
		}
		public String getTipo1Avversario() {
			return tipo1Avversario;
		}
		public void setTipo1Avversario(String tipo1Avversario) {
			this.tipo1Avversario = tipo1Avversario;
		}
		public String getTipo2Avversario() {
			return tipo2Avversario;
		}
		public void setTipo2Avversario(String tipo2Avversario) {
			this.tipo2Avversario = tipo2Avversario;
		}
		public String getNomeAvversario() {
			return nomeAvversario;
		}
		public void setNomeAvversario(String nomeAvversario) {
			this.nomeAvversario = nomeAvversario;
		}
		public int getXpAvversario() {
			return xpAvversario;
		}
		public void setXpAvversario(int xpAvversario) {
			this.xpAvversario = xpAvversario;
		}
		public int getLivelloAvversario() {
			return livelloAvversario;
		}
		public void setLivelloAvversario(int livelloAvversario) {
			this.livelloAvversario = livelloAvversario;
		}
		public int getHpAvversario() {
			return hpAvversario;
		}
		public void setHpAvversario(int hpAvversario) {
			this.hpAvversario = hpAvversario;
		}
		public int getAttaccoPokemonAvversario() {
			return attaccoPokemonAvversario;
		}
		public void setAttaccoPokemonAvversario(int attaccoPokemonAvversario) {
			this.attaccoPokemonAvversario = attaccoPokemonAvversario;
		}
		public int getDifesaPokemonAvversario() {
			return difesaPokemonAvversario;
		}
		public void setDifesaPokemonAvversario(int difesaPokemonAvversario) {
			this.difesaPokemonAvversario = difesaPokemonAvversario;
		}
		public int getAttaccoSpecialePokemonAvversario() {
			return attaccoSpecialePokemonAvversario;
		}
		public void setAttaccoSpecialePokemonAvversario(int attaccoSpecialePokemonAvversario) {
			this.attaccoSpecialePokemonAvversario = attaccoSpecialePokemonAvversario;
		}
		public int getDifesaSpecialePokemonAvversario() {
			return difesaSpecialePokemonAvversario;
		}
		public void setDifesaSpecialePokemonAvversario(int difesaSpecialePokemonAvversario) {
			this.difesaSpecialePokemonAvversario = difesaSpecialePokemonAvversario;
		}
		public int getVelocitàPokemonAvversario() {
			return velocitàPokemonAvversario;
		}
		public void setVelocitàPokemonAvversario(int velocitàPokemonAvversario) {
			this.velocitàPokemonAvversario = velocitàPokemonAvversario;
		}
		public Mossa[] getMosse() {
			return mosse;
		}
		public void setMosse(Mossa[] mosse) {
			this.mosse = mosse;
		}
	}
