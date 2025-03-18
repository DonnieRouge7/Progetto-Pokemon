package GUI_Pokemon;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Questa classe gestisce la riproduzione di file audio.
 * Permette di avviare e fermare la riproduzione musicale in loop continuo.
 */

public class AudioPlayer {
    private Clip clip;

    /**
     * Metodo per riprodurre la musica.
     * 
     * @param filePath Percorso del file audio da riprodurre.
     */

    public void playMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); /* Imposta il loop infinito */
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per fermare la musica
     * 
     */

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
