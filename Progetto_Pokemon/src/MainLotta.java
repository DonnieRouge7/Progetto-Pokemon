
public class MainLotta {

	public static void main(String[] args) {
	
		Mossa tackle = new MossaAttacco("Tackle", 0, "fisico", 35, 100, 40);
		Mossa growl = new MossaStato("Growl", 0, "stato", 40, 100, "Diminuisci Attacco");
		Mossa scratch = new MossaAttacco("Scratch", 0, "fisico", 35, 100, 40);
		Mossa tail_whip = new MossaStato("Tail whip", 0, "stato", 30, 100, "Diminuisci Difesa");
		Mossa quick_attack = new MossaAttacco("Quick Attack", 0, "fisico", 30, 100, 40);
		
		Pokemon charmander = new Charmander(scratch, tail_whip, tackle, growl);
		Pokemon bulbasaur = new Bulbasaur(tackle, growl, quick_attack, quick_attack); 
		Pokemon squirtle = new Squirtle(tail_whip, tackle, quick_attack, quick_attack);
		Pokemon pikachu = new Pikachu(quick_attack, growl);
		
//		
		while(charmander.getHp() > 0 && squirtle.getHp() > 0) {
			if(charmander.getVelocitàPokemon() > squirtle.getVelocitàPokemon()) {
				charmander.usaMossa(squirtle, (MossaStato) growl);
				if(squirtle.getHp() <= 0) {
					break;
				}
				squirtle.usaMossa(charmander, (MossaAttacco) tackle);
				if(charmander.getHp() <= 0) {
					break;
				}
			} else {
				squirtle.usaMossa(charmander, (MossaAttacco) tackle);
				charmander.usaMossa(squirtle, (MossaAttacco) scratch);
			}
		}
		
		System.out.println("\n");
		
		if(charmander.esausto() == true) {
			squirtle.setXp(charmander.getLivello()+10);
			squirtle.saliDiLivello();
			System.out.println(squirtle.getLivello());
			System.out.println("Squirtle vince la lotta");
		}else if(squirtle.esausto() == true) {
			System.out.println("Charmander vince la lotta");
		}
		
		
		
	}
	
	
}
