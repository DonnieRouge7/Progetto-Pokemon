
public class Pikachu extends Pokemon implements TipoElettro{

	public Pikachu(Mossa mo1, Mossa mo2) {
		super("111",tipoElettro, -1, "Pikachu", 0, 1, 35, 55, 40, 50,
				50, 90, 30);
		
		Mossa[] mosse = new Mossa[2];
		mosse[0] = mo1;
		mosse[1] = mo2;
		
		super.setMosse(mosse);
	}

}
