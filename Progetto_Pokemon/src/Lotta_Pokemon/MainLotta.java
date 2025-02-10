package Lotta_Pokemon;

public class MainLotta {

	public static void main(String[] args) {
		
		Pokemon charmander = new Charmander();
		Pokemon bulbasaur = new Bulbasaur(); 
		Pokemon squirtle = new Squirtle();
		
//		
		while(charmander.getHp() > 0 && squirtle.getHp() > 0) {
			if(charmander.getVelocitàPokemon() > squirtle.getVelocitàPokemon()) {
				charmander.scegliMossa(2, squirtle);
				if(squirtle.getHp() <= 0) {
					break;
				}
				squirtle.scegliMossa(0, charmander);
				if(charmander.getHp() <= 0) {
					break;
				}
			} else {
				squirtle.scegliMossa(3, charmander);
				charmander.scegliMossa(4, squirtle);
			}
		}
		
		System.out.println("\n");
		
		if(charmander.esausto() == true) {
			squirtle.setXp(charmander.getLivello()+10);
			squirtle.saliDiLivello();
			System.out.println("Squirtle vince la lotta");
		}else if(squirtle.esausto() == true) {
			charmander.setXp(squirtle.getLivello()+10);
			System.out.println("Charmander vince la lotta");
		}
		
		
		
	}
	
	
}
