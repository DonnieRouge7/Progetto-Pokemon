package Lotta_Pokemon;

/**

La classe MossaStato rappresenta una mossa di stato nei combattimenti Pokémon.

Le mosse di stato non infliggono danno, ma modificano le caratteristiche dei Pokémon in battaglia.
*/

public class MossaStato extends Mossa {

private String effetto; // Descrizione dell'effetto della mossa di stato

/**
 * Costruttore della classe MossaStato.
 *
 * @param nomeMossa Nome della mossa.
 * @param elementoMossa Tipo elementale della mossa.
 * @param tipo Tipo della mossa (fisica, speciale o stato).
 * @param PP Punti Potenza attuali della mossa.
 * @param PPmax Punti Potenza massimi della mossa.
 * @param precisioneMossa Precisione della mossa.
 * @param effetto Descrizione dell'effetto della mossa.
 */

public MossaStato(String nomeMossa, int elementoMossa, String tipo, int PP, int PPmax, int precisioneMossa, String effetto) {
    super(nomeMossa, elementoMossa, tipo, PP, PPmax, precisioneMossa);
    this.effetto = effetto;
}

/**
 * Metodo per verificare se la mossa va a segno e applicarne l'effetto.
 *
 * @param att Pokémon attaccante.
 * @param dif Pokémon difensore.
 */

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

/**
 * Metodo per applicare l'effetto della mossa di stato, modificando le statistiche del bersaglio.
 *
 * @param attaccante Pokémon che usa la mossa.
 * @param difensore Pokémon che subisce l'effetto della mossa.
 */

public void usaMossaStato(Pokemon attaccante, Pokemon difensore) {
    Pokemon bersaglio = effetto.startsWith("Aumenta") ? attaccante : difensore; // Determina il bersaglio
    double valoreModifica = 0.33; // Percentuale di modifica della statistica

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
            bersaglio.setVelocita((int) Math.max(1, bersaglio.getVelocita() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));
            break;
        case "Aumenta Elusione":
        case "Diminuisce Elusione":             
            bersaglio.setElusione((int) Math.max(1, bersaglio.getElusione() * (effetto.startsWith("Aumenta") ? 1 + valoreModifica : 1 - valoreModifica)));            
            break;
    }
}

/**
 * Metodo che verifica se la mossa ha esaurito i suoi Punti Potenza (PP).
 *
 * @return true se la mossa non ha più PP disponibili, false altrimenti.
 */

@Override
public boolean noPP() {
    return super.noPP();
}

/**
 * Metodo per ottenere l'effetto specifico della mossa di stato.
 *
 * @return Stringa contenente la descrizione dell'effetto.
 */

@Override
public String getEffetto() {
    return effetto;
}

}