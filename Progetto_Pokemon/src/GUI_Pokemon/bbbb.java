package GUI_Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class bbbb {

    private static final String[] POKEMON = {"Pikachu", "Charmander", "Bulbasaur"};
    private static final String[] MOVES_PIKACHU = {"Thunderbolt", "Quick Attack", "Iron Tail"};
    private static final String[] MOVES_CHARMANDER = {"Flamethrower", "Scratch", "Ember"};
    private static final String[] MOVES_BULBASAUR = {"Vine Whip", "Growl", "Razor Leaf"};
   
    private static final Map<String, String[]> MOVES = new HashMap<>();
   
    static {
        MOVES.put("Pikachu", MOVES_PIKACHU);
        MOVES.put("Charmander", MOVES_CHARMANDER);
        MOVES.put("Bulbasaur", MOVES_BULBASAUR);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lotta tra Pokémon");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new GridLayout(4, 1));

            // Pannello per la selezione dei Pokémon e delle mosse
            JPanel selectionPanel = new JPanel();
            JComboBox<String> pokemon1Combo = new JComboBox<>(POKEMON);
            JComboBox<String> move1Combo = new JComboBox<>(MOVES_PIKACHU);
            JComboBox<String> pokemon2Combo = new JComboBox<>(POKEMON);
            JComboBox<String> move2Combo = new JComboBox<>(MOVES_PIKACHU);
           
            pokemon1Combo.addActionListener(e -> updateMoveOptions(pokemon1Combo, move1Combo));
            pokemon2Combo.addActionListener(e -> updateMoveOptions(pokemon2Combo, move2Combo));
           
            selectionPanel.add(new JLabel("Scegli Pokémon 1:"));
            selectionPanel.add(pokemon1Combo);
            selectionPanel.add(new JLabel("Scegli Mossa 1:"));
            selectionPanel.add(move1Combo);
            selectionPanel.add(new JLabel("Scegli Pokémon 2:"));
            selectionPanel.add(pokemon2Combo);
            selectionPanel.add(new JLabel("Scegli Mossa 2:"));
            selectionPanel.add(move2Combo);

            // Pannello per i risultati
            JPanel resultPanel = new JPanel();
            JTextArea resultArea = new JTextArea(5, 40);
            resultArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(resultArea);
            resultPanel.add(scrollPane);

            // Pannello per il pulsante di attacco
            JPanel buttonPanel = new JPanel();
            JButton attackButton = new JButton("Attacca!");
            buttonPanel.add(attackButton);

            frame.add(selectionPanel);
            frame.add(resultPanel);
            frame.add(buttonPanel);

            // Aggiungi un ActionListener al pulsante
            attackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String pokemon1 = (String) pokemon1Combo.getSelectedItem();
                    String move1 = (String) move1Combo.getSelectedItem();
                    String pokemon2 = (String) pokemon2Combo.getSelectedItem();
                    String move2 = (String) move2Combo.getSelectedItem();
                    String result = simulateBattle(pokemon1, move1, pokemon2, move2);
                    resultArea.setText(result);
                }
            });

            frame.setVisible(true);
        });
    }

    private static void updateMoveOptions(JComboBox<String> pokemonCombo, JComboBox<String> moveCombo) {
        String selectedPokemon = (String) pokemonCombo.getSelectedItem();
        String[] moves = MOVES.getOrDefault(selectedPokemon, new String[0]);
        moveCombo.setModel(new DefaultComboBoxModel<>(moves));
    }

    // Simula la lotta tra due Pokémon
    private static String simulateBattle(String pokemon1, String move1, String pokemon2, String move2) {
        // Semplice logica di battaglia per l'esempio
        String result = pokemon1 + " usa " + move1 + " contro " + pokemon2 + "!\n";
        result += pokemon2 + " usa " + move2 + " in risposta!\n";

        // Simula una battaglia semplice
        if (pokemon1.equals("Pikachu") && move1.equals("Thunderbolt") && pokemon2.equals("Charmander")) {
            result += "Thunderbolt è molto efficace su Charmander! " + pokemon2 + " è stato sconfitto!";
        } else if (pokemon1.equals("Charmander") && move1.equals("Flamethrower") && pokemon2.equals("Bulbasaur")) {
            result += "Flamethrower è molto efficace su Bulbasaur! " + pokemon2 + " è stato sconfitto!";
        } else {
            result += "La battaglia è intensa! Rimanete sintonizzati per il prossimo turno!";
        }

        return result;
    }
}