package Lotta_Pokemon;

public class MossaStato extends Mossa {
    
    private String effetto;
    
    public MossaStato(String nomeMossa, int elementoMossa, String tipo, int PP, int PPmax, int precisioneMossa, String effetto) {
        super(nomeMossa, elementoMossa, tipo, PP, PPmax, precisioneMossa);
        this.effetto = effetto;
    }
    
    // Per l'applicazione dell'effetto delle mosse che modificano le caratteristiche
    public void usaMossaStato(Pokemon attaccante, Pokemon difensore) {
        Pokemon bersaglio = effetto.startsWith("Aumenta") ? attaccante : difensore; // Scegli il bersaglio
        double valoreModifica = 0.33; // 33% di modifica

        switch (effetto) {
            case "Aumenta Difesa":
            case "Diminuisce Difesa":         
				bersaglio.setDifesa((int) Math.max(1, bersaglio.getDifesa() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));
				break;
            case "Aumenta Attacco":
            case "Diminuisce Attacco":                   	   
				bersaglio.setAttacco((int) Math.max(1, bersaglio.getAttacco() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));                            
				break;
            case "Aumenta Difesa Speciale":
            case "Diminuisce Difesa Speciale":
                bersaglio.setDifesaSpeciale((int) Math.max(1, bersaglio.getDifesaSpeciale() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));
                break;
            case "Aumenta Attacco Speciale":
            case "Diminuisce Attacco Speciale":
                bersaglio.setAttaccoSpeciale((int) Math.max(1, bersaglio.getAttaccoSpeciale() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));
                break;
            case "Aumenta Velocità":
            case "Diminuisce Velocità":
                bersaglio.setVelocità((int) Math.max(1, bersaglio.getVelocità() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));
                break;
            case "Aumenta Elusione":
            case "Diminuisce Elusione":             
                bersaglio.setElusione((int) Math.max(1, bersaglio.getElusione() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));            
                break;
        }
    }

    @Override
    public boolean noPP() {
        return super.noPP();
    }
    
    // Per verificare se un attacco va a segno o meno
    public void attaccaStato(Pokemon att, Pokemon dif) {
        int precisione = getPrecisioneMossa();
        double elusione = dif.getElusione();
        int a = generaInteroCasuale(0, 100);
        double probabilitaSuccesso = precisione / elusione;
        if (probabilitaSuccesso * 100 > a) {
            setColpito(true);
            usaMossaStato(att, dif);
            setPP(getPP() - 1);
        } else {
            setColpito(false);
            setPP(getPP() - 1);
        }
    }

    @Override
    public String getEffetto() {
        return effetto; // Restituisce l'effetto specifico
    }
}