package GUI_Pokemon;

import Lotta_Pokemon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.util.ArrayList;

/**
 * Classe principale CampoDiBttaglia dove avviene la lotta
 */

public class CampoDiBattaglia extends JPanel {

	/** Il frameMenuLotta principale della finestra di gioco */
	private JFrame frameMenuLotta;

	/** Il gestore della musica di sottofondo */
	private AudioPlayer audioPlayer;

	/** Icona dell'immagine di sfondo */
	private ImageIcon sfondo;

	/** Etichetta che mostra l'immagine di sfondo */
	private JLabel labelSfondo;

	/** Lista dei Pokémon selezionati dall'utente */
	private List<Pokemon> listaPokemonUtente;

	/** Lista delle mosse disponibili per il Pokémon dell'utente */
	private List<Mossa> listaMosseUtente;

	/** Lista dei Pokémon selezionati dalla CPU */
	private List<Pokemon> listaPokemonCPU;

	/** Lista delle mosse disponibili per i Pokémon della CPU */
	private List<Mossa> listaMosseCPU;

	/** Pokémon attuale dell'utente in battaglia */
	private Pokemon pokemonUtente;

	/** Pokémon attuale della CPU in battaglia */
	private Pokemon pokemonCPU;

	/** Barra della salute del Pokémon dell'utente */
	private JProgressBar healthBarUtente;

	/** Barra della salute del Pokémon della CPU */
	private JProgressBar healthBarCPU;

	/** Bordo delle barre della salute */
	private Border bordoHealthBar;

	/** Pannello contenente le informazioni del Pokémon dell'utente */
	private JPanel areaPokemonUtente;

	/** Etichetta per il nome del Pokémon dell'utente */
	private JLabel labelPokemonUtente;

	/** Etichetta per il livello del Pokémon dell'utente */
	private JLabel livelloPokemonUtente;

	/** Pannello contenente le informazioni del Pokémon della CPU */
	private JPanel areaPokemonCPU;

	/** Etichetta per il nome del Pokémon della CPU */
	private JLabel labelPokemonCPU;

	/** Etichetta per il livello del Pokémon della CPU */
	private JLabel livelloPokemonCPU;

	/** Pannello per visualizzare i messaggi durante la lotta */
	private JPanel areaMessaggi;

	/** Area di testo per visualizzare i messaggi della battaglia */
	private JTextArea testoMessaggi;

	/** Pulsante per avanzare al turno successivo */
	private JButton next;

	/** Pannello che contiene le mosse, il cambio Pokémon e la borsa */
	private JPanel panelAreaMosse;

	/** Pulsante per visualizzare le mosse disponibili */
	private JButton mosse;

	/** Pulsante per selezionare la prima mossa */
	private JButton mossa1;

	/** Pulsante per selezionare la seconda mossa */
	private JButton mossa2;

	/** Pulsante per selezionare la terza mossa */
	private JButton mossa3;

	/** Pulsante per selezionare la quarta mossa */
	private JButton mossa4;

	/** Pulsante per cambiare il Pokémon attuale dell'utente */
	private JButton buttonCambiaPokemon;

	/** Pannello per il cambio Pokémon */
	private JPanel panelCambiaPokemon;

	/** Button per chiudere il panel cambio Pokemon */
	private JButton chiudiButton;

	/** Button dei pokemon sostituibili */
	private JButton pokemonButton;

	/** Array dei pokemonButton */
	private List<JButton> pokemonButtons;

	/** Pulsante per aprire la borsa degli oggetti */
	private JButton borsa;

	/** Mossa della CPU */
	private Mossa mossaCPU;

	/** Indice del Pokémon attuale della CPU */
	private int indicePokemonCPU = 0;

	/** Frame della finestra di vittoria */
	private JFrame frameWIN;

	/** Pannello della finestra di vittoria */
	private JPanel panelWIN;

	/** Etichetta che mostra il messaggio di vittoria */
	private JLabel youWIN;

	/** Frame della finestra di sconfitta */
	private JFrame frameLOSE;

	/** Pannello della finestra di sconfitta */
	private JPanel panelLOSE;

	/** Etichetta che mostra il messaggio di sconfitta */
	private JLabel youLOSE;

	/** Frame della finestra della leaderboard */
	private JFrame frameLeaderboard;

	/** Pannello della finestra della leaderboard */
	private JPanel panelLeaderboard;

	/** Area di testo per mostrare la leaderboard */
	private JTextArea leaderboard;

	/** Etichetta per la leaderboard */
	private JLabel labelLaderboard;

	/** Pulsante per continuare le lotte dopo aver vinto */
	private JButton buttonContinua;

	/** Pulsante per tornare al menu dopo aver perso una lotta */
	private JButton buttonMenu;

	/** Lista delle serie di vittorie dell'utente */
	private List<Integer> serieVittorieList;

	/** Serie di vittorie attuale dell'utente */
	private int serieVittorie;

	/** Mossa di default quando un pokemon ha esaurito i PP di tutte le mosse */
	private Mossa scontro = new MossaAttacco("Scontro", 0, "fisico", 100, 100, 100, 50);

	/**
	 * Costruttore della classe CampoDiBattaglia
	 * 
	 * @param frameMenuSceltaSquadra il frame principale dove avviene la scelta della squadra
	 * @param frameMenuLotta il frame principale dove avviene la lotta
	 * @param pokemonUtente; la lista dei pokemon dell'utente
	 * @param pokemonCPU;    la lista dei pokemon della CPU
	 */

	CampoDiBattaglia(JFrame frameMenuSceltaSquadra, JFrame frameMenuLotta, List<Pokemon> listaPokemonUtente, List<Pokemon> listaPokemonCPU) {

		this.frameMenuLotta = frameMenuLotta;
		this.listaPokemonUtente = listaPokemonUtente;
		this.listaPokemonCPU = listaPokemonCPU;
		this.serieVittorieList = LeaderboardManager.caricaLeaderboard();
		this.serieVittorie = 0;

		setLayout(null);
		setBackground(Color.GRAY);

		/* Audio */
		audioPlayer = new AudioPlayer();
		java.net.URL audioURL = getClass().getClassLoader().getResource("assets/pokemonBattleMusic.wav");
		audioPlayer.playMusic(audioURL.getPath());

		if (!listaPokemonUtente.isEmpty() && !listaPokemonCPU.isEmpty()) { /* Controllo se le liste non sono vuote */
			if(listaPokemonUtente.get(0).esausto()){
				for (Pokemon pokemon : listaPokemonUtente) {
					if(!pokemon.esausto()){
						this.pokemonUtente = pokemon; /* Seleziono il primo Pokémon dell'utente che non è KO */
						break;
					}
				}
			}
			this.pokemonUtente = listaPokemonUtente.get(0); /* Seleziono il primo Pokémon dell'utente */
			this.pokemonCPU = listaPokemonCPU.get(pokemonCasuale());
			
			/*
			 * Primo Pokémon della CPU selezionato
			 * casualemente tra quelli disponibili nella sua
			 * squadra
			 */
		}

		listaMosseCPU = pokemonCPU.getMosse(); /* Setting delle mosse del primo pokemon avversario */

		bordoHealthBar = new LineBorder(Color.BLACK); /* Bordo delle healthBar */

		/* Sfondo pannello */
		java.net.URL imgURL = getClass().getClassLoader().getResource("assets/sfondoLotta.jpg");
		sfondo = new ImageIcon(imgURL);
		Image sfondoscalato = sfondo.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
		labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
		labelSfondo.setBounds(0, 0, 1000, 600);
		add(labelSfondo);

		/* HealthBar Cpu */
		healthBarCPU = new JProgressBar(0, 100);
		aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
		healthBarCPU.setStringPainted(true); /* Mostra il valore numerico */

		healthBarCPU.setForeground(Color.GREEN);
		healthBarCPU.setBorder(bordoHealthBar);
		healthBarCPU.setBackground(Color.WHITE);

		add(healthBarCPU);

		/* HealthBar Utente */
		healthBarUtente = new JProgressBar(0, 100);
		aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
		healthBarUtente.setStringPainted(true); /* Mostra il valore numerico */

		healthBarUtente.setForeground(Color.GREEN);
		healthBarUtente.setBorder(bordoHealthBar);
		healthBarUtente.setBackground(Color.WHITE);

		add(healthBarUtente);

		/* Pokemon utente */
		areaPokemonUtente = new JPanel();
		Border bordo = new LineBorder(Color.WHITE);
		areaPokemonUtente.setBackground(Color.BLACK);
		areaPokemonUtente.setBorder(bordo);

		labelPokemonUtente = new JLabel(pokemonUtente.getNome());
		labelPokemonUtente.setForeground(Color.WHITE);

		livelloPokemonUtente = new JLabel("Liv " + pokemonUtente.getLivello());
		livelloPokemonUtente.setForeground(Color.WHITE);

		areaPokemonUtente.add(labelPokemonUtente);
		areaPokemonUtente.add(livelloPokemonUtente);
		add(areaPokemonUtente);

		/* Pokemon CPU */
		areaPokemonCPU = new JPanel();
		Border bordo2 = new LineBorder(Color.WHITE);
		areaPokemonCPU.setBackground(Color.BLACK);
		areaPokemonCPU.setBorder(bordo2);

		labelPokemonCPU = new JLabel(pokemonCPU.getNome());
		labelPokemonCPU.setForeground(Color.WHITE);

		livelloPokemonCPU = new JLabel("Liv " + pokemonCPU.getLivello());
		livelloPokemonCPU.setForeground(Color.WHITE);

		areaPokemonCPU.add(labelPokemonCPU);
		areaPokemonCPU.add(livelloPokemonCPU);
		add(areaPokemonCPU);

		/* Area messaggi durante la lotta */
		areaMessaggi = new JPanel();
		areaMessaggi.setBackground(Color.BLACK);
		areaMessaggi.setBorder(new LineBorder(Color.WHITE, 3));
		areaMessaggi.setLayout(null);

		/* Testo Messaggi */
		testoMessaggi = new JTextArea();
		testoMessaggi.setEditable(false); /* L'utente non può scrivere */
		testoMessaggi.setWrapStyleWord(true); /* Mantiene parole intere quando va a capo */
		testoMessaggi.setBackground(Color.BLACK);
		testoMessaggi.setForeground(Color.WHITE);
		testoMessaggi.setFont(new Font("Arial", Font.BOLD, 12));
		testoMessaggi.setText("INIZIA LA LOTTA!");

		areaMessaggi.add(testoMessaggi);
		add(areaMessaggi);

		/* Panel area mosse */
		Border bordoAreaMosse = new LineBorder(Color.WHITE, 3);
		panelAreaMosse = new JPanel();
		panelAreaMosse.setBackground(Color.GRAY);
		panelAreaMosse.setBorder(bordoAreaMosse);

		panelAreaMosse.setLayout(null);

		/* Pulsante Mosse */
		listaMosseUtente = pokemonUtente.getMosse();
		Border bordoMosse = new LineBorder(Color.WHITE, 3);
		mosse = new JButton("Mosse");
		mosse.setBackground(Color.RED);
		mosse.setForeground(Color.WHITE);
		mosse.setFont(new Font("Arial", Font.BOLD, 18));
		mosse.setBorder(bordoMosse);

		/* Pulsanti delle mosse (inizialmente nascosti) */
		mossa1 = creaPulsanteMossa();
		mossa2 = creaPulsanteMossa();
		mossa3 = creaPulsanteMossa();
		mossa4 = creaPulsanteMossa();

		/* Array di pulsanti per le mosse */
		JButton[] pulsantiMosse = { mossa1, mossa2, mossa3, mossa4 };

		/* Nasconde i pulsanti delle mosse (all'inizio) */
		for (JButton pulsante : pulsantiMosse) {
			pulsante.setVisible(false);
			panelAreaMosse.add(pulsante);
		}

		/* Action Listener per il pulsante Mosse */
		mosse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mosse.setVisible(false); /* Nasconde il pulsante principale */

				/* Assegna le mosse ai pulsanti e li rende visibili */
				for (int i = 0; i < listaMosseUtente.size(); i++) {
					pulsantiMosse[i].setText(listaMosseUtente.get(i).getNomeMossa());
					pulsantiMosse[i].setVisible(true);

					/* Rimuove tutti i vecchi listener prima di aggiungere il nuovo */
					for (ActionListener al : pulsantiMosse[i].getActionListeners()) {
						pulsantiMosse[i].removeActionListener(al);
					}

					final int index = i; /* Variabile finale per ActionListener */
					pulsantiMosse[i].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							/* Disabilita i pulsanti delle mosse per evitare doppi input */
							for (JButton pulsante : pulsantiMosse) {
								pulsante.setEnabled(false);
							}

							/* Disabilito i pulsanti non cliccabili durante l'esecuzione dell'attacco (next, borsa, cambiaPokemon) */
							next.setEnabled(false);
							borsa.setEnabled(false);
							buttonCambiaPokemon.setEnabled(false);

							/* Controllo la velocità dei pokemon per stabilire chi attacca per primo */
							if (pokemonUtente.getVelocita() >= pokemonCPU.getVelocita()) {

								/* Primo attacco: pokemon Utente */
								pokemonUtente.usaMossa(pokemonUtente, pokemonCPU, listaMosseUtente.get(index));							

								/* Verifico se la mossa non ha esaurito i PP */
								if (listaMosseUtente.get(index).noPP()) {
									mostraMessaggio("hai finito i PP, usa un'altra mossa");
									for (JButton pulsante : pulsantiMosse) {
										pulsante.setEnabled(true);
									}
									buttonCambiaPokemon.setEnabled(true);
									borsa.setEnabled(true);
									return;
								}

								mostraMessaggio(
										pokemonUtente.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());

								/* Verifico se l'attacco è andato a segno */
								if (listaMosseUtente.get(index).getColpito() == false) {
									timerTask(2000,
											() -> mostraMessaggio(pokemonCPU.getNome() + " evita l'attacco"));
								} else {
									/* Controllo se la mossa usata ha un effetto di tipo stato */
									if (!listaMosseUtente.get(index).getEffetto().equals("")) {
										timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() + " "
												+ listaMosseUtente.get(index).getEffetto()));

									} else {
										/* Timer per mostrare l'efficacia dell'attacco */
										if (listaMosseUtente.get(index).getModificatore() > 1) {
											timerTask(2000, () -> mostraMessaggio("è superefficace"));
										} else if (listaMosseUtente.get(index).getModificatore() < 1) {
											timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
										}
									}

									/* Controllo se la CPU è KO dopo l'attacco */
									if (pokemonCPU.esausto()) {

										/* Aggiorna la healthBar della CPU */
										aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(),
												(int) pokemonCPU.getHpMax());
										/* Aggiorna l'esperienza del pokemon dell'utente */
										pokemonUtente.setXp(pokemonUtente.getXp() + pokemonCPU.getLivello() + 5);

										/* Mostra il messaggio di KO */
										timerTask(3000, () -> {
											mostraMessaggio(pokemonCPU.getNome() + " avversario " + " è esausto!");
											next.setEnabled(true);
										});

										/* Controllo se l'attaccante è salito di livello */
										if (pokemonUtente.saliDiLivello()) {
											timerTask(4000, () -> {
												mostraMessaggio(
														pokemonUtente.getNome() + " è salito di livello, ora è al "
																+ pokemonUtente.getLivello());
												livelloPokemonUtente.setText("Liv " + pokemonUtente.getLivello());
											});
										}
										return;

									} else {
										/* Aggiorna la healthBar della CPU */
										aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(),
												(int) pokemonCPU.getHpMax());							
									}
								}

								/* Dopo un piccolo ritardo, attacca la CPU */
								Timer timer = new Timer(4000, new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										SwingUtilities.invokeLater(() -> {											

											int indiceMossaCPU = attaccoCasuale(); /* Salva l'indice della mossa */
											mossaCPU = listaMosseCPU.get(indiceMossaCPU); /* Recupera la mossa scelta */

											/*
											 * Verifico se la mossa ha ancora dei PP e può essere utilizzata
											 * regoalarmente
											 */
											if (mossaCPU.noPP()) {
												mossaNoPP();
												timerTask(3000, () -> next.setEnabled(true));
											} else {

												/* il pokemon della CPU attacca */
												pokemonCPU.usaMossa(pokemonCPU, pokemonUtente, mossaCPU);
												mostraMessaggio(pokemonCPU.getNome() + " avversario " + " usa "
														+ mossaCPU.getNomeMossa());

												/* Verifico se l'attacco della CPU è andato a segno */
												if (mossaCPU.getColpito() == false) {
													timerTask(2000, () -> {
														mostraMessaggio(pokemonUtente.getNome() + " evita l'attacco");
														next.setEnabled(true);
														System.out.println("evita");
													});
													return; /* esce dal ciclo se la l'utente evita l'attacco */

												} else {
													/* Controllo se la mossa usata ha un effetto di tipo stato */
													if (!mossaCPU.getEffetto().equals("")) {
														timerTask(2000, () -> mostraMessaggio(
																pokemonCPU.getNome() + " " + mossaCPU.getEffetto()));

													} else {
														/* Timer per mostrare l'efficacia dell'attacco */
														if (mossaCPU.getModificatore() > 1) {
															timerTask(2000, () -> mostraMessaggio("è superefficace"));
														} else if (mossaCPU.getModificatore() < 1) {
															timerTask(2000,
																	() -> mostraMessaggio("non è molto efficace..."));
														}
													}

													/* Controllo KO utente dopo il contrattacco della CPU */
													if (pokemonUtente.esausto()) {

														/* Aggiorna la healthBar dell'utente */
														aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(),
																(int) pokemonUtente.getHpMax());
														/* Aggiorna l'esperienza del pokemon della CPU */
														pokemonCPU.setXp(
																pokemonCPU.getXp() + pokemonUtente.getLivello() + 5);

														/* Nasconde i pulsanti delle mosse */
														for (JButton pulsante : pulsantiMosse) {
															pulsante.setVisible(false);
														}

														panelAreaMosse.setVisible(false);														

														/* Timer per far vedere il messaggio di esaustione */
														timerTask(3000, () -> {
															mostraMessaggio(pokemonUtente.getNome() + " è esausto!");
															cambiaPokemonUtente();
															for (JButton pulsante : pulsantiMosse) {
																pulsante.setEnabled(true);
															}
														});

														/* Controllo se il pokemon è salito di livello */
														if (pokemonCPU.saliDiLivello()) {
															timerTask(4000, () -> {
																mostraMessaggio(pokemonCPU.getNome() + " avversario "
																		+ "è salito di livello, ora è al "
																		+ pokemonCPU.getLivello());
																livelloPokemonCPU
																		.setText("Liv " + pokemonCPU.getLivello());
															});
														}
														return;

													} else {
														/* Aggiorna la healthBar dell'utente */
														aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(),
																(int) pokemonUtente.getHpMax());
														/* Abilita il pulsante next */
														timerTask(4000, () -> next.setEnabled(true));
													}
												}
											}
										});
									}
								});

								timer.setRepeats(false); /* Esegui solo una volta */
								timer.start();

							} else {

								/* Se la CPU è più veloce, attacca per prima */
								next.setEnabled(false);

								int indiceMossaCPU = attaccoCasuale(); // Salva l'indice della mossa
								mossaCPU = listaMosseCPU.get(indiceMossaCPU); // Recupera la mossa scelta
								System.out.println(mossaCPU.getPP());

								/*
								 * Verifico se la mossa selezionata ha ancora dei PP e può essere utilizzata
								 * regoalarmente
								 */
								if (mossaCPU.noPP()) {
									mossaNoPP();
								} else {
									/* il Pokemon della CPU attacca */
									pokemonCPU.usaMossa(pokemonCPU, pokemonUtente, mossaCPU);
									mostraMessaggio(
											pokemonCPU.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());

									/* Verifico se l'attacco della CPU è andato a segno */
									if (mossaCPU.getColpito() == false) {
										timerTask(2000,
												() -> mostraMessaggio(pokemonUtente.getNome() + " evita l'attacco"));										
									} else {
										/* Controllo se la mossa usata ha un effetto di tipo stato */
										if (!mossaCPU.getEffetto().equals("")) {
											timerTask(2000, () -> mostraMessaggio(
													pokemonCPU.getNome() + " " + mossaCPU.getEffetto()));

										} else {
											/* Timer per mostrare l'efficacia dell'attacco */
											if (mossaCPU.getModificatore() > 1) {
												timerTask(2000, () -> mostraMessaggio("è superefficace"));
											} else if (mossaCPU.getModificatore() < 1) {
												timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
											}
										}

										/* Controllo se l'utente è KO dopo l'attacco della CPU */
										if (pokemonUtente.esausto()) {

											/* Aggiorna la healthBar */
											aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(),
													(int) pokemonUtente.getHpMax());
											/*
											 * Aggiorna l'esperienza del pokemon avversario
											 */
											pokemonCPU.setXp(pokemonCPU.getXp() + pokemonUtente.getLivello() + 5);

											/* Nasconde i pulsanti delle mosse */
											for (JButton pulsante : pulsantiMosse) {
												pulsante.setVisible(false);
											}

											panelAreaMosse.setVisible(false);											

											/* Timer per far vedere il messaggio di esaustione */
											timerTask(3000, () -> {
												mostraMessaggio(pokemonUtente.getNome() + " è esausto!");
												cambiaPokemonUtente();
												for (JButton pulsante : pulsantiMosse) {
													pulsante.setEnabled(true);
												}
											});

											/* Controllo se il pokemon avversario è salito di livello */
											if (pokemonCPU.saliDiLivello()) {
												timerTask(4000, () -> {
													mostraMessaggio(pokemonCPU.getNome() + " avversario "
															+ "è salito di livello, ora è al "
															+ pokemonCPU.getLivello());
													livelloPokemonCPU.setText("Liv " + pokemonCPU.getLivello());
												});
											}
											return;

										} else {
											/* Aggiorna la healthBar dell'utente */
											aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(),
													(int) pokemonUtente.getHpMax());
											/* Abilita il pulsante next */
											timerTask(3000, () -> next.setEnabled(true));
										}
									}
								}

								/* Dopo un piccolo ritardo, attacca il giocatore */
								Timer timer = new Timer(4000, new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										SwingUtilities.invokeLater(() -> {											

											/* il pokemon dell'utente attacca */
											pokemonUtente.usaMossa(pokemonUtente, pokemonCPU, listaMosseUtente.get(index));													

											/* Verifico se la mossa non ha esaurito i PP */
											if (listaMosseUtente.get(index).noPP()) {
												mostraMessaggio("hai finito i PP, usa un'altra mossa");
												for (JButton pulsante : pulsantiMosse) {
													pulsante.setEnabled(true);
												}
												buttonCambiaPokemon.setEnabled(true);
												borsa.setEnabled(true);
												return;
											}

											mostraMessaggio(pokemonUtente.getNome() + " usa "
													+ listaMosseUtente.get(index).getNomeMossa());

											/* Verifico se l'attacco è andato a segno */
											if (listaMosseUtente.get(index).getColpito() == false) {
												timerTask(2000, () -> {
													mostraMessaggio(pokemonCPU.getNome() + " evita l'attacco");													
													next.setEnabled(true);
												});

												return; /* esce dal ciclo se il pokemon avversario evita l'attacco */

											} else {

												/* Controllo se la mossa usata ha un effetto di tipo stato */
												if (!listaMosseUtente.get(index).getEffetto().equals("")) {
													timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() + " "
															+ listaMosseUtente.get(index).getEffetto()));

												} else {
													/* Timer per mostrare l'efficacia dell'attacco */
													if (listaMosseUtente.get(index).getModificatore() > 1) {
														timerTask(2000, () -> mostraMessaggio("è superefficace"));
													} else if (listaMosseUtente.get(index).getModificatore() < 1) {
														timerTask(2000,
																() -> mostraMessaggio("non è molto efficace..."));
													}

												}

												/* Controllo KO CPU */
												if (pokemonCPU.esausto()) {

													/* Aggiorna la healthBar del pokemon della CPU */
													aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(),
															(int) pokemonCPU.getHpMax());
													/* Aggiorna l'esperienza del pokemon dell'utente */
													pokemonUtente
															.setXp(pokemonUtente.getXp() + pokemonCPU.getLivello() + 5);

													/* Mostra il messaggio di KO */
													timerTask(3000, () -> {
														mostraMessaggio(
																pokemonCPU.getNome() + " avversario " + " è esausto!");
														next.setEnabled(true);
													});

													/* Controllo se il pokemon è salito di livello */
													if (pokemonUtente.saliDiLivello()) {
														timerTask(4000, () -> {
															mostraMessaggio(pokemonUtente.getNome()
																	+ " è salito di livello, ora è al "
																	+ pokemonUtente.getLivello());
															livelloPokemonUtente
																	.setText("Liv " + pokemonUtente.getLivello());
														});

													}
													return;

												} else {
													/* Aggiorna la healthBar */
													aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(),
															(int) pokemonCPU.getHpMax());
													// Abilita il pulsante next
													timerTask(4000, () -> next.setEnabled(true));
												}
											}
										});
									}
								});

								/* Esegui il timer */
								timer.setRepeats(false);
								timer.start();
							}
						}
					});
				}
			}

		});

		panelAreaMosse.add(mosse);

		/* Pulsante next per avanzare al prossimo turno */

		next = new JButton("AVANTI");
		Border bordoNext = new LineBorder(Color.WHITE, 3);
		next.setBorder(bordoNext);
		next.setForeground(Color.WHITE);
		next.setBackground(Color.GRAY);

		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (pokemonCPU.esausto()) {
					for (JButton pulsante : pulsantiMosse) {
						pulsante.setEnabled(false);
					}

					borsa.setEnabled(false);
					buttonCambiaPokemon.setEnabled(false);
					cambiaPokemonCPU();
					next.setEnabled(false);
				}

				for (JButton pulsante : pulsantiMosse) {
					pulsante.setEnabled(true);
				}

				borsa.setEnabled(true);
				buttonCambiaPokemon.setEnabled(true);
			}
		});

		areaMessaggi.add(next);

		/* Button borsa (solo estetico ma senza funzionalità) */
		Border bordoBorsa = new LineBorder(Color.WHITE, 3);
		borsa = new JButton("Borsa");
		borsa.setBackground(Color.ORANGE);
		borsa.setForeground(Color.WHITE);
		borsa.setFont(new Font("Arial", Font.BOLD, 14));
		borsa.setBorder(bordoBorsa);
		borsa.setBounds(220, 230, 165, 50);

		panelAreaMosse.add(borsa);

		/* Panel per il cambio Pokemon dell'utente */
		panelCambiaPokemon = new JPanel();
		Border bordoCambioPokemon = new LineBorder(Color.WHITE, 3);
		panelCambiaPokemon.setBackground(Color.GRAY);
		panelCambiaPokemon.setForeground(Color.WHITE);
		panelCambiaPokemon.setBorder(bordoCambioPokemon);
		panelCambiaPokemon.setVisible(false);
		panelCambiaPokemon.setLayout(null);

		add(panelCambiaPokemon);

		/* Button cambia Pokemon */

		Border bordoCambio = new LineBorder(Color.WHITE, 3);
		buttonCambiaPokemon = new JButton("Cambia Pokémon");
		buttonCambiaPokemon.setBackground(Color.GREEN);
		buttonCambiaPokemon.setForeground(Color.WHITE);
		buttonCambiaPokemon.setFont(new Font("Arial", Font.BOLD, 14));
		buttonCambiaPokemon.setBorder(bordoCambio);

		buttonCambiaPokemon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (JButton button : pulsantiMosse) {
					button.setVisible(false);
				}
				cambiaPokemonUtente();
			}
		});

		pokemonButtons = new ArrayList<JButton>();

		Border bordoPokemonCambiati = new LineBorder(Color.BLACK, 3);

		for (Pokemon i : listaPokemonUtente) {

			pokemonButton = new JButton(i.getNome());
			pokemonButton.setForeground(Color.WHITE);
			pokemonButton.setBackground(Color.ORANGE);
			pokemonButton.setBorder(bordoPokemonCambiati);
			pokemonButton.setVisible(true);
			pokemonButton.setFont(new Font("Arial", Font.BOLD, 14));

			if (i.equals(pokemonUtente) || i.esausto()) {
				pokemonButton.setEnabled(false);
			} else {
				pokemonButton.setEnabled(true);
			}

			pokemonButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					panelCambiaPokemon.setVisible(false);

					next.setEnabled(false);

					borsa.setVisible(true);
					mosse.setVisible(true);
					panelAreaMosse.setVisible(true);
					buttonCambiaPokemon.setVisible(true);
					chiudiButton.setVisible(true);

					buttonCambiaPokemon.setEnabled(true);
					borsa.setEnabled(true);

					pokemonUtente = i;
					labelPokemonUtente.setText(i.getNome());
					listaMosseUtente = i.getMosse();
					livelloPokemonUtente.setText("Liv " + i.getLivello());

					/* Crea i nuovi pulsanti delle mosse */
					for (Mossa m : listaMosseUtente) {
						JButton mossa = creaPulsanteMossa();
						mossa.setText(m.getNomeMossa());
						panelAreaMosse.add(mossa);
					}

					mostraMessaggio("Coraggio " + i.getNome() + " SCELGO TE!");
					aggiornaHealthBar(healthBarUtente, (int) i.getHp(), (int) i.getHpMax());

					aggiornaStatoPulsanti();

					panelAreaMosse.revalidate();
					panelAreaMosse.repaint();
				}
			});

			pokemonButtons.add(pokemonButton);
			panelCambiaPokemon.add(pokemonButton);
		}

		panelAreaMosse.add(buttonCambiaPokemon);

		chiudiButton = new JButton("Chiudi");
		chiudiButton.setForeground(Color.WHITE);
		chiudiButton.setBackground(Color.RED);
		chiudiButton.setBorder(new LineBorder(Color.BLACK, 3));
		chiudiButton.setVisible(true);
		chiudiButton.setEnabled(true);

		panelCambiaPokemon.add(chiudiButton);

		/* Leaderboard miglior score */

		frameLeaderboard = new JFrame();
		frameLeaderboard.setSize(new Dimension(200, 300));
		frameLeaderboard.setLocationRelativeTo(null);
		frameLeaderboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLeaderboard.setVisible(false);

		panelLeaderboard = new JPanel();
		panelLeaderboard.setBounds(300, 200, 200, 300);
		panelLeaderboard.setBackground(Color.GRAY);
		panelLeaderboard.setForeground(Color.WHITE);
		panelLeaderboard.setBorder(new LineBorder(Color.WHITE, 3));
		panelLeaderboard.setLayout(null);
		panelLeaderboard.setVisible(true);

		labelLaderboard = new JLabel();
		labelLaderboard.setText("Miglior Score");
		labelLaderboard.setForeground(Color.WHITE);
		labelLaderboard.setFont(new Font("Arial", Font.BOLD, 18));
		labelLaderboard.setBounds(30, 10, 120, 20);
		panelLeaderboard.add(labelLaderboard);

		leaderboard = new JTextArea();
		leaderboard.setEditable(false);
		leaderboard.setWrapStyleWord(true);
		leaderboard.setBackground(Color.GRAY);
		leaderboard.setForeground(Color.WHITE);
		leaderboard.setFont(new Font("Arial", Font.BOLD, 14));
		leaderboard.setBounds(5, 40, 150, 200);

		/* Button continua le lotte */
		buttonContinua = new JButton("Continua");
		buttonContinua.setForeground(Color.WHITE);
		buttonContinua.setBackground(Color.BLACK);
		buttonContinua.setFont(new Font("Arial", Font.BOLD, 11));
		buttonContinua.setBounds(10, 200, 80, 30);

		Border bordoButtonContinua = new LineBorder(Color.WHITE, 2);
		buttonContinua.setBorder(bordoButtonContinua);

		buttonContinua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameLeaderboard.dispose();
				audioPlayer.stopMusic();
				
				// Aggiorna l'interfaccia
				aggiornaHealthBar(healthBarUtente, (int)pokemonUtente.getHp(), (int)pokemonUtente.getHpMax());
				aggiornaHealthBar(healthBarCPU, (int)pokemonCPU.getHp(), (int)pokemonCPU.getHpMax());
				labelPokemonUtente.setText(pokemonUtente.getNome());
				labelPokemonCPU.setText(pokemonCPU.getNome());
				livelloPokemonUtente.setText("Liv " + pokemonUtente.getLivello());
				livelloPokemonCPU.setText("Liv " + pokemonCPU.getLivello());
				mostraMessaggio("INIZIA LA LOTTA!");
				
				// Rendi visibile il campo di battaglia
				frameMenuLotta.setVisible(true);
				panelAreaMosse.setVisible(true);
				java.net.URL audioURL = getClass().getClassLoader().getResource("assets/pokemonBattleMusic.wav");
				audioPlayer.playMusic(audioURL.getPath());
			}
		});

		/* Button torna al menu */
		buttonMenu = new JButton("Menu");
		buttonMenu.setForeground(buttonContinua.getForeground());
		buttonMenu.setBackground(buttonContinua.getBackground());
		buttonMenu.setFont(buttonContinua.getFont());
		buttonMenu.setBounds(95, 200, 80, 30);
		buttonMenu.setBorder(buttonContinua.getBorder());

		buttonMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				frameLeaderboard.dispose();
				audioPlayer.stopMusic();
				frameMenuSceltaSquadra.setVisible(true);
				frameMenuLotta.dispose();
			}
		});

		panelLeaderboard.add(buttonMenu);
		panelLeaderboard.add(buttonContinua);
		panelLeaderboard.add(leaderboard);
		frameLeaderboard.add(panelLeaderboard);

		add(panelAreaMosse);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getWidth();
				int height = getHeight();

				// Ridimensiona e riposiziona lo sfondo
				Image sfondoScalato = sfondo.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
				labelSfondo.setIcon(new ImageIcon(sfondoScalato));
				labelSfondo.setBounds(0, 0, width, height);

				// Riposiziona la barra della salute della CPU
				int healthBarCPUWidth = width / 5;
				int healthBarCPUHeight = height / 20;
				int healthBarCPUX = (width - healthBarCPUWidth) - 50;
				int healthBarCPUY = (height / 6) - healthBarCPUHeight - 5;
				healthBarCPU.setBounds(healthBarCPUX, healthBarCPUY, healthBarCPUWidth, healthBarCPUHeight);
				healthBarCPU.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Riposiziona la barra della salute dell'utente
				int healthBarUtenteWidth = width / 5;
				int healthBarUtenteHeight = height / 20;
				int healthBarUtenteX = (width / 4) - healthBarUtenteWidth;
				int healthBarUtenteY = (height - healthBarUtenteHeight) - 45;
				healthBarUtente.setBounds(healthBarUtenteX, healthBarUtenteY, healthBarUtenteWidth,
						healthBarUtenteHeight);
				healthBarUtente.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Riposiziona l'area del Pokémon della CPU
				int areaPokemonCPUWidth = width / 5;
				int areaPokemonCPUHeight = height / 20;
				int areaPokemonCPUX = (width - areaPokemonCPUWidth) - 50;
				int areaPokemonCPUY = (height / 6) - areaPokemonCPUHeight - 40;
				labelPokemonCPU.setFont(new Font("Arial", Font.BOLD, height / 40));
				labelPokemonCPU.setBounds(10, 10, areaPokemonCPUWidth - 20, areaPokemonCPUHeight - 20);
				livelloPokemonCPU.setFont(new Font("Arial", Font.BOLD, height / 40));
				livelloPokemonCPU.setBounds(10, 30, areaPokemonCPUWidth - 20, areaPokemonCPUHeight - 20);
				areaPokemonCPU.setBounds(areaPokemonCPUX, areaPokemonCPUY, areaPokemonCPUWidth, areaPokemonCPUHeight);

				// Riposiziona l'area del Pokémon dell'utente
				int areaPokemonUtenteWidth = width / 5;
				int areaPokemonUtenteHeight = height / 20;
				int areaPokemonUtenteX = (width / 4) - areaPokemonUtenteWidth;
				int areaPokemonUtenteY = (height - areaPokemonUtenteHeight) - 80;
				labelPokemonUtente.setFont(new Font("Arial", Font.BOLD, height / 40));
				labelPokemonUtente.setBounds(10, 10, areaPokemonUtenteWidth - 20, areaPokemonUtenteHeight - 20);
				livelloPokemonUtente.setFont(new Font("Arial", Font.BOLD, height / 40));
				livelloPokemonUtente.setBounds(10, 30, areaPokemonUtenteWidth - 20, areaPokemonUtenteHeight - 20);
				areaPokemonUtente.setBounds(areaPokemonUtenteX, areaPokemonUtenteY, areaPokemonUtenteWidth,
						areaPokemonUtenteHeight);

				// Riposiziona l'area dei messaggi
				int areaMessaggiWidth = width / 3;
				int areaMessaggiHeight = height / 6;
				int areaMessaggiX = (width - areaMessaggiWidth) - 20;
				int areaMessaggiY = (height - areaMessaggiHeight) - 10;
				areaMessaggi.setBounds(areaMessaggiX, areaMessaggiY, areaMessaggiWidth, areaMessaggiHeight);

				// Riposizione il testo dei messaggi
				int testoMessaggiWidth = (int) (areaMessaggiWidth / 1.2);
				int testoMessaggiHeight = (int) (areaMessaggiHeight / 3);
				int testoMessaggiX = (areaMessaggiWidth - testoMessaggiWidth) - 30;
				int testoMessaggiY = (areaMessaggiHeight - testoMessaggiHeight) - 50;
				testoMessaggi.setBounds(testoMessaggiX, testoMessaggiY, testoMessaggiWidth, testoMessaggiHeight);
				testoMessaggi.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Riposiziona il pannello delle mosse
				int panelAreaMosseWidth = (int) (width / 2.5);
				int panelAreaMosseHeight = (int) (height / 1.7);
				int panelAreaMosseX = (width / 2) - panelAreaMosseWidth - 80;
				int panelAreaMosseY = (int) (height / 1.5) - panelAreaMosseHeight - 30;
				panelAreaMosse.setBounds(panelAreaMosseX, panelAreaMosseY, panelAreaMosseWidth, panelAreaMosseHeight);

				// Riposiziona il pannello per cambiare Pokémon
				int panelCambiaPokemonWidth = (int) (width / 2.5);
				int panelCambiaPokemonHeight = (int) (height / 1.7);
				int panelCambiaPokemonX = (width / 2) - panelCambiaPokemonWidth - 80;
				int panelCambiaPokemonY = (int) (height / 1.5) - panelCambiaPokemonHeight - 30;
				panelCambiaPokemon.setBounds(panelCambiaPokemonX, panelCambiaPokemonY, panelCambiaPokemonWidth,
						panelCambiaPokemonHeight);

				// Riposiziona i pulsanti

				// Pulsante next
				int nextWidth = areaMessaggiWidth / 5;
				int nextHeight = (int) (areaMessaggiHeight / 4.5);
				int nextX = (areaMessaggiWidth - nextWidth) - 20;
				int nextY = (areaMessaggiHeight - nextHeight) - 10;
				next.setBounds(nextX, nextY, nextWidth, nextHeight);
				next.setFont(new Font("Arial", Font.BOLD, height / 50));

				// Pulsante borsa
				int borsaWidth = (int) (panelAreaMosseWidth / 2.5);
				int borsaHeight = panelAreaMosseHeight / 5;
				int borsaX = (int) (panelAreaMosseWidth / 1.5) - (borsaWidth / 4);
				int borsaY = (panelAreaMosseHeight - borsaHeight) - 10;
				borsa.setBounds(borsaX, borsaY, borsaWidth, borsaHeight);
				borsa.setFont(new Font("Arial", Font.BOLD, height / 30));

				// Pulsante cambiaPokemon
				int buttonCambiaPokemonWidth = panelAreaMosseWidth / 2;
				int buttonCambiaPokemonHeight = panelAreaMosseHeight / 5;
				int buttonCambiaPokemonX = (panelAreaMosseWidth / 2) - buttonCambiaPokemonWidth + 13;
				int buttonCambiaPokemonY = (panelAreaMosseHeight - buttonCambiaPokemonHeight) - 10;
				buttonCambiaPokemon.setBounds(buttonCambiaPokemonX, buttonCambiaPokemonY, buttonCambiaPokemonWidth,
						buttonCambiaPokemonHeight);
				buttonCambiaPokemon.setFont(new Font("Arial", Font.BOLD, height / 30));

				// Bottone chiudi
				int chiudiButtonWidth = (int) (panelCambiaPokemonWidth / 4);
				int chiudiButtonHeight = panelCambiaPokemonHeight / 6;
				int chiudiButtonX = (int) (panelCambiaPokemonWidth / 1.5) - (chiudiButtonWidth / 5) + 40;
				int chiudiButtonY = (panelCambiaPokemonHeight - chiudiButtonHeight) - 10;
				chiudiButton.setBounds(chiudiButtonX, chiudiButtonY, chiudiButtonWidth, chiudiButtonHeight);
				chiudiButton.setFont(new Font("Arial", Font.BOLD, height / 50));

				// Pulsante mosse
				int mosseWidth = (int) (panelAreaMosseWidth / 1.1) + 10;
				int mosseHeight = (int) (panelAreaMosseHeight / 4);
				int mosseX = ((panelAreaMosseWidth / 2) - (mosseWidth / 2));
				int mosseY = (int) (((panelAreaMosseHeight / 2) - (mosseHeight / 4.5) + 15));
				mosse.setBounds(mosseX, mosseY, mosseWidth, mosseHeight);
				mosse.setFont(new Font("Arial", Font.BOLD, height / 40));

				int mossaWidth = (panelAreaMosseWidth / 2) - 20;
				int mossaHeight = (panelAreaMosseHeight / 5) - 5;

				// Posizionamento delle mosse nei quattro angoli
				// Mossa 1 (alto sinistra)
				int mossa1X = 10;
				int mossa1Y = 10;
				mossa1.setBounds(mossa1X, mossa1Y, mossaWidth, mossaHeight);
				mossa1.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Mossa 2 (alto destra)
				int mossa2X = panelAreaMosseWidth - mossaWidth - 10;
				int mossa2Y = 10;
				mossa2.setBounds(mossa2X, mossa2Y, mossaWidth, mossaHeight);
				mossa2.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Mossa 3 (basso sinistra)
				int mossa3X = 10;
				int mossa3Y = ((panelAreaMosseHeight / 2) - (mossaHeight - 20));
				mossa3.setBounds(mossa3X, mossa3Y, mossaWidth, mossaHeight);
				mossa3.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Mossa 4 (basso destra)
				int mossa4X = (panelAreaMosseWidth) - (mossaWidth) - 10;
				int mossa4Y = (panelAreaMosseHeight / 2) - (mossaHeight - 20);
				mossa4.setBounds(mossa4X, mossa4Y, mossaWidth, mossaHeight);
				mossa4.setFont(new Font("Arial", Font.BOLD, height / 40));

				// Pulsanti dei pokemon sostituibili
				int pokemonButtonWidth = width / 10;
				int pokemonButtonHeight = height / 11;
				int pokemonButtonX = 10;
				int pokemonButtonY = 10;

				for (JButton pokemonButton : pokemonButtons) {
					pokemonButton.setBounds(pokemonButtonX, pokemonButtonY, pokemonButtonWidth, pokemonButtonHeight);
					pokemonButton.setFont(new Font("Arial", Font.BOLD, height / 50));
					pokemonButtonY += pokemonButtonHeight + 10; // Sposta il pulsante verso il basso
				}

				panelCambiaPokemon.revalidate();
				panelCambiaPokemon.repaint();
			}
		});

		setComponentZOrder(labelSfondo, getComponentCount() - 1);
	}

	/**
	 * Metodo per mostrare a piacimento un qualsiasi messaggio nell'area predisposta
	 *
	 * @param messaggio desiderato
	 */
	public void mostraMessaggio(String messaggio) {
		testoMessaggi.setText(messaggio);
	}

	/**
	 * Metodo per creare un pulsante mossa con lo stile desiderato
	 * 
	 * @return il bottone creato
	 */
	private JButton creaPulsanteMossa() {
		JButton button = new JButton();
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBorder(new LineBorder(Color.WHITE, 3));
		return button;
	}

	/**
	 * Metodo per cambiare automaticamente i pokemon della CPU
	 */
	public void cambiaPokemonCPU() {
		if (!listaPokemonCPU.isEmpty()) {
			int startIndex = indicePokemonCPU; /* Salva l'indice di partenza */

			do {
				/* Passa al Pokémon successivo, ciclando la lista */
				indicePokemonCPU = (indicePokemonCPU + 1) % listaPokemonCPU.size();

				/* Se il Pokémon non è esausto, lo manda in campo */
				if (!listaPokemonCPU.get(indicePokemonCPU).esausto()) {
					pokemonCPU = listaPokemonCPU.get(indicePokemonCPU);
					listaMosseCPU = pokemonCPU.getMosse();
					mostraMessaggio("La CPU manda in campo " + pokemonCPU.getNome());

					/* Aggiorna l'interfaccia grafica */
					aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
					labelPokemonCPU.setText(pokemonCPU.getNome());
					livelloPokemonCPU.setText("Liv " + pokemonCPU.getLivello());
					return; /* Esce dalla funzione dopo aver trovato un Pokémon valido */
				}

			} while (indicePokemonCPU != startIndex); /*
														 * Se ha girato tutta la lista e non ha trovato Pokémon validi,
														 * termina.
														 */

			/* Se arriva qui significa che tutti i Pokémon sono esausti */
			mostraMessaggio("L'avversario ha esaurito i Pokemon!");
			panelAreaMosse.setVisible(false);
			serieVittorie ++;
		
			serieVittorieList = LeaderboardManager.caricaLeaderboard(); /* Legge la leaderboard */
			aggiornaLeaderboard(serieVittorieList);

			/*
			 * Aggiunta Pokemon alla squadra della CPU quando viene sconfitta (se non già
			 * presenti in squadra)
			 */
			Pidgey pidgey = new Pidgey();
			Pikachu pikachu = new Pikachu();

			boolean pidgeyPresente = false;

			/* Controlliamo quali Pokémon sono già presenti nella lista */
			for (Pokemon p : listaPokemonCPU) {
				if (p.getNome().equals(pidgey.getNome())) {
					pidgeyPresente = true;
				}
			}

			/*
			 * Pikachu viene aggiunto solo **nella lotta successiva**, se Pidgey è già
			 * presente
			 */
			if (pidgeyPresente) {
				listaPokemonCPU.add(pikachu);
			}

			/* Prima aggiungiamo Pidgey se non è presente */
			if (!pidgeyPresente) {
				listaPokemonCPU.add(pidgey);
			}

			/* Aumenta il livello della squadra CPU */
			aumentaLivelloCPU();

			/* Timer per chiudere la finestra di sconfitta */
			Timer timer = new Timer(4000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

				 frameMenuLotta.setVisible(false);
					audioPlayer.stopMusic();

					/* Frame WIN */

					frameWIN = new JFrame();
					frameWIN.setSize(new Dimension(300, 200));
					frameWIN.setLocationRelativeTo(null);
					frameWIN.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frameWIN.setVisible(true);

					/* Panel WIN */

					panelWIN = new JPanel();
					panelWIN.setSize(300, 200);
					panelWIN.setLayout(null);
					panelWIN.setBackground(Color.BLUE);
					frameWIN.add(panelWIN);

					/* Label youWin */

					youWIN = new JLabel("HAI VINTO");
					youWIN.setForeground(Color.YELLOW);
					youWIN.setFont(new Font("Arial", Font.BOLD, 26));
					youWIN.setBounds(75, 40, 150, 80);
					panelWIN.add(youWIN);

					/* Button menu */

					JButton menu = new JButton("menu");
					menu.setForeground(Color.YELLOW);
					menu.setBackground(Color.BLACK);
					menu.setFont(new Font("Arial", Font.BOLD, 11));
					menu.setBounds(230, 130, 50, 20);

					Border bordoMenu = new LineBorder(Color.WHITE, 2);
					menu.setBorder(bordoMenu);

					menu.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							buttonMenu.setEnabled(false);
							frameWIN.dispose();
							frameLeaderboard.setVisible(true);

						}
					});

					panelWIN.add(menu);

					frameWIN.add(panelWIN);

				}
			});

			timer.setRepeats(false);
			timer.start();
		}
	}

	/**
	 * Metodo per permettere la sotituzione di un pokemon quando l'utente lo
	 * desidera
	 */
	public void cambiaPokemonUtente() {

		panelAreaMosse.setVisible(false);
		borsa.setVisible(false);
		mosse.setVisible(false);
		buttonCambiaPokemon.setVisible(false);

		panelCambiaPokemon.setVisible(true);

		if (pokemonUtente.esausto()) {
			chiudiButton.setEnabled(false);
		}else{
			chiudiButton.setEnabled(true);
		}
				 
		for (Pokemon i : listaPokemonUtente) {
			if (i.equals(pokemonUtente) || i.esausto()) {
				pokemonButton.setEnabled(false);
			} else {
				pokemonButton.setEnabled(true);
			}
		}

		/* Pulsante per chiudere il pannello di cambio Pokémon */
		chiudiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				panelCambiaPokemon.setVisible(false);
				panelAreaMosse.setVisible(true);
				mosse.setVisible(true);
				borsa.setVisible(true);
				buttonCambiaPokemon.setVisible(true);

			}
		});

		panelCambiaPokemon.add(chiudiButton);

		/* Verifico se tutti i pokemon dell'utente sono esausti */
		if (listaPokemonUtente.stream().allMatch(Pokemon::esausto)) {
			resetCPU();
			mostraMessaggio("Tutti i tuoi Pokémon sono esausti.");
			next.setEnabled(false);
			chiudiButton.setEnabled(false);
			
			LeaderboardManager.salvaLeaderboard(serieVittorie); /* Salva la leaderboard */
			serieVittorieList = LeaderboardManager.caricaLeaderboard(); /* Legge la leaderboard */
			aggiornaLeaderboard(serieVittorieList);

			for (Pokemon pokemon : listaPokemonCPU) {
				pokemon.setHp(pokemon.getHpMax());
				for (Mossa mossa : pokemon.getMosse()) {
					mossa.setPP(mossa.getPPmax());
				}
			}

			Timer timer = new Timer(4000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

				 frameMenuLotta.setVisible(false);
					audioPlayer.stopMusic();

					/* Frame LOSE */

					frameLOSE = new JFrame();
					frameLOSE.setSize(new Dimension(300, 200));
					frameLOSE.setLocationRelativeTo(null);
					frameLOSE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frameLOSE.setVisible(true);

					/* Panel LOSE */

					panelLOSE = new JPanel();
					panelLOSE.setSize(300, 200);
					panelLOSE.setLayout(null);
					panelLOSE.setBackground(Color.BLACK);
					frameLOSE.add(panelLOSE);

					/* Label youLOSE */

					youLOSE = new JLabel("HAI PERSO");
					youLOSE.setForeground(Color.RED);
					youLOSE.setFont(new Font("Arial", Font.BOLD, 26));
					youLOSE.setBounds(75, 40, 150, 80);
					panelLOSE.add(youLOSE);

					/* Button menu */

					JButton menu = new JButton("menu");
					menu.setForeground(Color.RED);
					menu.setBackground(Color.WHITE);
					menu.setFont(new Font("Arial", Font.BOLD, 11));
					menu.setBounds(230, 130, 50, 20);

					Border bordoMenu = new LineBorder(Color.RED, 2);
					menu.setBorder(bordoMenu);

					menu.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							buttonContinua.setEnabled(false);
							buttonMenu.setEnabled(true);
							frameLOSE.dispose();
							frameLeaderboard.setVisible(true);
						}
					});

					panelLOSE.add(menu);

					frameLOSE.add(panelLOSE);
				}
			});

			timer.setRepeats(false);
			timer.start();

		}

		/* Rinfresca il pannello dopo le modifiche */
		panelCambiaPokemon.revalidate();
		panelCambiaPokemon.repaint();
	}

	/**
	 * Metodo per far partire un timer con un compito da svolgere dopo un certo
	 * ritardo
	 * 
	 * @param delay; ritardo impostato
	 * @param task;  task da eseguire
	 */
	private void timerTask(int delay, Runnable task) {
		Timer timer = new Timer(delay, e -> task.run());
		timer.setRepeats(false);
		timer.start();
	}

	/**
	 * Metodo per far attaccare il pokemon della CPU con una mossa a scelta tra
	 * quelle disponibili
	 * 
	 * @return l'intero desiderato
	 */
	public int attaccoCasuale() {
		Random interoCasuale = new Random();
		return interoCasuale.nextInt(3);
	}

	/**
	 * Metodo per selezionare casualemente i Pokemon che la CPU schiera
	 * 
	 * @return l'intero desiderato
	 */

	public int pokemonCasuale() {
		Random interoCasuale = new Random();
		return interoCasuale.nextInt(listaPokemonCPU.size());
	}

	/**
	 * Metodo per aggiornare le barre di salute dei pokemon quando necessario
	 * 
	 * @param healthBar; la barra della vita da aggiornare
	 * @param hp;        gli hp attuali
	 * @param hpMax;     gli hp massimi
	 */

	public void aggiornaHealthBar(JProgressBar healthBar, int hp, int hpMax) {
		int percentuale = (int) ((hp / (double) hpMax) * 100);

		healthBar.setValue(percentuale);
		healthBar.setString(hp + " / " + hpMax + " HP"); /* Mostra i PV numerici */

		if (percentuale > 70) {
			healthBar.setForeground(Color.GREEN);
		} else if (percentuale > 20) {
			healthBar.setForeground(Color.ORANGE);
		} else {
			healthBar.setForeground(Color.RED);
		}
	}

	/**
	 * Metodo per aggiornare lo stato dei pulsanti
	 * 
	 */

	public void aggiornaStatoPulsanti() {
		for (Component c : panelCambiaPokemon.getComponents()) {
			if (c instanceof JButton) {
				JButton btn = (JButton) c;
				for (Pokemon p : listaPokemonUtente) {
					if (btn.getText().equals(p.getNome())) {
						btn.setEnabled(!(p.equals(pokemonUtente) || p.esausto()));
					}
				}
			}
		}
	}

	/**
	 * Metodo per aumentare il livello della squadra della CPU dopo che viene
	 * sconfitta dall'utente
	 * 
	 */

	public void aumentaLivelloCPU() {
		for (Pokemon p : listaPokemonCPU) {
			p.setLivello(p.getLivello() + 1);
			p.setAttacco(p.getAttacco() + 3);
			p.setDifesa(p.getDifesa() + 3);
			p.setAttaccoSpeciale(p.getAttaccoSpeciale() + 3);
			p.setDifesaSpeciale(p.getDifesaSpeciale() + 3);
			p.setVelocita(p.getVelocita() + 3);
			p.setElusione(p.getElusione() + 0.33);
			p.setPrecisione(p.getPrecisione() + 0.33);
			p.setHpMax(p.getHpMax() + 3);
			p.setHp(p.getHpMax());
		}
	}

	/**
	 * Metodo per verificare se la CPU ha ancora delle mosse da poter utilizzare,
	 * altrimenti usa la mossa base SCONTRO
	 * 
	 */
	public void mossaNoPP() {
		boolean tutteLeMosseEsaurite = true;

		// Cerca una nuova mossa con PP disponibili
		for (Mossa mossa : listaMosseCPU) {
			if (!mossa.noPP()) {
				tutteLeMosseEsaurite = false;
				pokemonCPU.usaMossa(pokemonUtente, pokemonCPU, mossa); // Se trovo la mossa, il pokemon usa quella
				timerTask(2000, () -> {
					mostraMessaggio(pokemonCPU.getNome() + " avversario" + " usa " + mossa.getNomeMossa());
					aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
				});

				if (mossa.getColpito() == false) {
					timerTask(3000, () -> {
						mostraMessaggio(pokemonUtente.getNome() + " evita l'attacco");
					});
					return;
				} else {
					// Verifico se la mossa ha un effetto di stato o meno
					if (!mossa.getEffetto().equals("")) {
						timerTask(3000,
								() -> mostraMessaggio(pokemonCPU.getNome() + " avversario " + mossa.getEffetto()));
					} else {
						if (mossa.getModificatore() > 1) {
							timerTask(3000, () -> mostraMessaggio("è superefficace"));
						} else if (mossa.getModificatore() < 1) {
							timerTask(3000, () -> mostraMessaggio("non è molto efficace..."));
						}
					}
					break; // Trovata la mossa, esce dal ciclo
				}
			}
		}

		// Se non ha trovato alcuna mossa con PP, usa Scontro
		if (tutteLeMosseEsaurite) {
			mostraMessaggio("L'avversario ha esaurito tutte le mosse!");

			timerTask(2000, () -> {
				mostraMessaggio(pokemonCPU.getNome() + " usa " + scontro.getNomeMossa());
				pokemonCPU.usaMossa(pokemonUtente, pokemonCPU, scontro);
				aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
			});
			timerTask(3000, () -> {
				int dannoContraccolpo = (int) (pokemonCPU.getHp() / 4); // Contraccolpo del 25% degli HP massimi
				pokemonCPU.setHp(pokemonCPU.getHp() - dannoContraccolpo);
				mostraMessaggio(pokemonCPU.getNome() + " subisce " + dannoContraccolpo + " danni dal contraccolpo!");
			});
		}
	}

	/**
	 * Metodo per aggiorna la leaderboard con gli ultimi score
	 */
	private void aggiornaLeaderboard(List<Integer> serieVittorieList) {
		StringBuilder sb = new StringBuilder();
		int posizione = 1;
		for (int vittorie : serieVittorieList) {
			if (posizione > 10)
				break; /* Mostra solo le prime 10 posizioni */
			sb.append(posizione).append(") ").append("Serie di vittorie: ").append(vittorie).append("\n");
			posizione++;
		}
		leaderboard.setText(sb.toString());
	}

	public void resetCPU(){
		// Reset della CPU
		listaPokemonCPU.clear();
        listaPokemonCPU.add(new Charmander());
		listaPokemonCPU.add(new Squirtle());
        listaPokemonCPU.add(new Bulbasaur());
	}
}
