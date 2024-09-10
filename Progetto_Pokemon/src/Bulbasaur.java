
public class Bulbasaur extends Pokemon implements TipoErba {

	public Bulbasaur(Mossa mo1, Mossa mo2) {
		super("213", tipoErba, -1, "Bulbasaur", 0, 1, 45, 49, 49, 65,
				65, 45, 30);
	
	Mossa[] mosse = new Mossa[2];
	mosse[0] = mo1;
	mosse[1] = mo2;
	
	super.setMosse(mosse);
	
	}
	
}
