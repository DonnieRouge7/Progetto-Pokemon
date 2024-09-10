
public class Charmander extends Pokemon implements TipoFuoco{
	
	public Charmander(Mossa mo1, Mossa mo2) {
		super("123", tipoFuoco, -1, "Charmander", 0, 1, 39, 52, 43, 50,
				50, 65, 30);
		
		Mossa[] mosse = new Mossa[2];
		mosse[0] = mo1;
		mosse[1] = mo2;
		
		super.setMosse(mosse);
	}
}
