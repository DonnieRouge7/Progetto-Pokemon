
public class Bulbasaur extends Pokemon implements TipoErba {

	public Bulbasaur(Mossa mo1, Mossa mo2, Mossa mo3, Mossa mo4) {
		super("213", tipoErba, -1, "Bulbasaur", 0, 1, 45, 49, 49, 65,
				65, 45, 30);
	
	Mossa[] mosse = new Mossa[4];
	mosse[0] = mo1;
	mosse[1] = mo2;
	mosse[2] = mo3;
	mosse[3] = mo4;
	
	super.setMosse(mosse);
	
	}
	
}
