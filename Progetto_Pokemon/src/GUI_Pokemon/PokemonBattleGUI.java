package GUI_Pokemon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PokemonBattleGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lotta tra Pokémon");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new GridLayout(3, 1));

            // Pannello per la selezione dei Pokémon
            JPanel selectionPanel = new JPanel();
            JComboBox<String> pokemon1Combo = new JComboBox<>(new String[] {"Pikachu", "Charmander", "Bulbasaur"});
            JComboBox<String> pokemon2Combo = new JComboBox<>(new String[] {"Squirtle", "Eevee", "Jigglypuff"});
            selectionPanel.add(new JLabel("Scegli Pokémon 1:"));
            selectionPanel.add(pokemon1Combo);
            selectionPanel.add(new JLabel("Scegli Pokémon 2:"));
            selectionPanel.add(pokemon2Combo);

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
                    String pokemon2 = (String) pokemon2Combo.getSelectedItem();
                    String result = simulateBattle(pokemon1, pokemon2);
                    resultArea.setText(result);
                }
            });

            frame.setVisible(true);
        });
    }

    // Simula la lotta tra due Pokémon
    private static String simulateBattle(String pokemon1, String pokemon2) {
        // Semplice logica di battaglia per l'esempio
        if (pokemon1.equals(pokemon2)) {
            return pokemon1 + " e " + pokemon2 + " sono dello stesso tipo! È un pareggio!";
        }

        // Logica di battaglia semplificata
        return pokemon1 + " attacca " + pokemon2 + "!\n" +
               pokemon2 + " è stato sconfitto!";
    }
}