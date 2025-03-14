package GUI_Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe della Leaderboard per l'inserimento degli score delle lotte
 */
public class LeaderboardManager {
    private static final String FILE_PATH = "Progetto-Pokemon/Progetto_Pokemon/src/GUI_Pokemon/leaderboard";

    /**
     * Per salvare la serie di vittorie
     * @param serieVittorie rappresenta l'attuale serie di vittorie in corso
     */
    public static void salvaLeaderboard(int serieVittorie) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(String.valueOf(serieVittorie));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Per caricare la leaderboard
     * @return la lista delle vittorie
     */
    public static List<Integer> caricaLeaderboard() {
        List<Integer> serieVittorieList = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return serieVittorieList; // Ritorna una lista vuota se il file non esiste
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    serieVittorieList.add(Integer.parseInt(line));
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return serieVittorieList; // Ritorna la lista delle serie di vittorie
    }

    /**
     * Per azzerare la leaderboard
     */
    public static void azzeraLeaderboard() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // Scrive un file vuoto per azzerare il contenuto    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per azzerare la leaderboard alla chiusura del progetto
     */
    public static void shutdown() {
        azzeraLeaderboard();
    }
}
