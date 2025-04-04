package GUI_Pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe della Leaderboard per l'inserimento degli score delle lotte
 */
public class LeaderboardManager {
    private static final String FILE_PATH = "C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git-finale/Progetto_Pokemon/src/GUI_Pokemon/leaderboard/";

    /**
     * Per salvare la serie di vittorie
     * @param serieVittorie rappresenta l'attuale serie di vittorie in corso
     */
    public static void salvaLeaderboard(int serieVittorie) {
        List<Integer> serieVittorieList = new ArrayList<>();
        if (isLeaderboardEmpty()){ // Controlla se la leaderboard è vuota
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                writer.write(String.valueOf(serieVittorie));
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(isLeaderboardFull()){ // Controlla se la leaderboard è piena
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;            
                while ((line = reader.readLine()) != null) {
                    if (!line.isEmpty()) {
                        serieVittorieList.add(Integer.parseInt(line));
                    }
                }
                if(serieVittorieList.get(serieVittorieList.size()-1) < serieVittorie){ // Se la serie di vittorie è maggiore dell'ultima
                    serieVittorieList.remove(serieVittorieList.size()-1); // Rimuovi l'ultima
                    serieVittorieList.add(serieVittorie); // Aggiungi la nuova
                }
                ordinaLeaderboard(serieVittorieList); // Ordina la leaderboard
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            }
        } 

        else{
            serieVittorieList = caricaLeaderboard(); // Carica la leaderboard
            serieVittorieList.add(serieVittorie); // Aggiungi la nuova serie di vittorie
            ordinaLeaderboard(serieVittorieList); // Ordina la leaderboard
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

    /**
     * Controlla se la leaderboard è piena
     * @return true se la leaderboard è piena, false altrimenti
     */
    public static boolean isLeaderboardFull(){
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return false; // Ritorna false se il file non esiste
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    count++;
                }
            }
            return count >= 10; // Ritorna true se ci sono già 10 record
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Ritorna false in caso di errore
    }

    /** 
     * controlla se la leaderboard è vuota
     * @return true se la leaderboard è vuota, false altrimenti
     */
    public static boolean isLeaderboardEmpty(){
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return true; // Ritorna true se il file non esiste
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    return false; // Ritorna false se ci sono record
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true; // Ritorna true se il file è vuoto
    }

    /**
     * Per ordinare la leaderboard in ordine decrescente e salvare i primi 10 record
     * @param serieVittorieList rappresenta la lista delle vittorie da ordinare in ordine descrescente
     */
    public static void ordinaLeaderboard(List<Integer> serieVittorieList) {
        serieVittorieList.sort((a, b) -> Integer.compare(b, a)); // Ordina in ordine decrescente
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < Math.min(serieVittorieList.size(), 10); i++) {
                writer.write(String.valueOf(serieVittorieList.get(i)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



