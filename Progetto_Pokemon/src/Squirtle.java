
public class Squirtle extends Pokemon implements TipoAcqua{

	public Squirtle(Mossa mo1, Mossa mo2, Mossa mo3, Mossa mo4) {
		super("321", tipoAcqua, -1, "Squirtle", 0, 1, 44, 48, 65, 50,
				50, 43, 30);
		
		Mossa[] mosse = new Mossa[4];
		mosse[0] = mo1;
		mosse[1] = mo2;
		mosse[2] = mo3;
		mosse[3] = mo4;
		
		super.setMosse(mosse);
	}

	
}
