
public class Main {

	public static void main(String[] args) {
	
		MossaAttacco tackle = new MossaAttacco("Tackle", 1, "fisico", 35, 100, 40);
		MossaStato growl = new MossaStato("Growl", 1, "stato", 40, 100, "Aumenta Attacco");
		MossaAttacco scratch = new MossaAttacco("Scratch", 1, "fisico", 35, 100, 40);
		MossaStato tail_whip = new MossaStato("Scratch", 1, "stato", 30, 100, "Diminuisci Difesa");
		
		Charmander charmander = new Charmander(scratch, growl);
		Pokemon bulbasaur = new Bulbasaur(tackle, growl); 
		Pokemon squirtle = new Squirtle(tail_whip, tackle);
		
		
		while(charmander.getHp() > 0 && squirtle.getHp() > 0) {
			if(charmander.getVelocitàPokemon() > squirtle.getVelocitàPokemon()) {
				charmander.usaMossa(squirtle, scratch);
				if(charmander.getHp() <= 0 || squirtle.getHp() <= 0) {
					break;
				}
				squirtle.usaMossa(charmander, tackle);
				if(charmander.getHp() <= 0 || squirtle.getHp() <= 0) {
					break;
				}
			} else {
				squirtle.usaMossa(charmander, tackle);
				charmander.usaMossa(squirtle, scratch);
			}
		}
		
	}
	
	
}
