package GUI_Pokemon;

import Lotta_Pokemon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Classe principale CampoDiBttaglia dove avviene la lotta 
 */


public class CampoDiBattaglia extends JPanel{
	
    /** Il frame principale della finestra di gioco */
    private JFrame frame;
    
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
        
        /** Pulsante per aprire la borsa degli oggetti */
        private JButton borsa;
    
    /** Mossa della CPU*/
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
                
                /** Pulsante per chiudere la finestra della leaderboard */
                private JButton buttonChiudi;
    
                /** Lista delle serie di vittorie dell'utente */
                private List<Integer> serieVittorieList;
                
                /** Serie di vittorie attuale dell'utente */
                private int serieVittorie;
    
    /** Mossa di default quando un pokemon ha esaurito i PP di tutte le mosse*/        
    private Mossa scontro = new MossaAttacco("Scontro", 0, "fisico", 100, 100, 100, 50);

		/**
		 * Costruttore della classe CampoDiBattaglia 
		 * @param frame il frame principale dove avviene la lotta
		 * @param pokemonUtente; la lista dei pokemon dell'utente
		 * @param pokemonCPU; la lista dei pokemon della CPU
		 */
		
        CampoDiBattaglia(JFrame frame, List<Pokemon> listaPokemonUtente, List<Pokemon> listaPokemonCPU){
			
			this.frame = frame;
			this.listaPokemonUtente = listaPokemonUtente;
			this.listaPokemonCPU = listaPokemonCPU;
			this.serieVittorieList = LeaderboardManager.caricaLeaderboard();
			this.serieVittorie = 0;
									
				setLayout(null); 
				setBackground(Color.GRAY);
				
				/* Audio */
				audioPlayer = new AudioPlayer();
				audioPlayer.playMusic("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/Pokémon Battle Music - Anime Version.wav");
				
				if (!listaPokemonUtente.isEmpty() && !listaPokemonCPU.isEmpty()) { /* Controllo se le liste non sono vuote */
					this.pokemonUtente = listaPokemonUtente.get(0);  /* Seleziono il primo Pokémon dell'utente */
					this.pokemonCPU = listaPokemonCPU.get(pokemonCasuale());  /* Primo Pokémon della CPU selezionato casualemente tra quelli disponibili nella sua squadra */
				}  
				
				listaMosseCPU = pokemonCPU.getMosse(); /* Setting delle mosse del primo pokemon avversario */
				
				bordoHealthBar = new LineBorder(Color.BLACK); /* Bordo delle healthBar */
				
				/* Sfondo pannello */
				sfondo = new ImageIcon("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/sfondo lotta.jpg");
				Image sfondoscalato = sfondo.getImage();
				labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
				labelSfondo.setBounds(0,0,1000,600);
				add(labelSfondo);
				
				/* HealthBar Cpu */
				healthBarCPU = new JProgressBar(0, 100);
				aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
				healthBarCPU.setStringPainted(true); /* Mostra il valore numerico */
				
				healthBarCPU.setForeground(Color.GREEN);
				healthBarCPU.setBorder(bordoHealthBar);
				healthBarCPU.setBackground(Color.WHITE);
				
				healthBarCPU.setBounds(750, 110, 200, 20);
			
				add(healthBarCPU);
				
				/* HealthBar Utente */
				healthBarUtente = new JProgressBar(0, 100);
				aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
				healthBarUtente.setStringPainted(true); /* Mostra il valore numerico */
				
				healthBarUtente.setForeground(Color.GREEN);
				healthBarUtente.setBorder(bordoHealthBar);
				healthBarUtente.setBackground(Color.WHITE);
				
				healthBarUtente.setBounds(30, 420, 200, 20);
				
				add(healthBarUtente);
				
				/* Pokemon utente */
				areaPokemonUtente = new JPanel();
				Border bordo = new LineBorder(Color.WHITE);
				areaPokemonUtente.setBackground(Color.BLACK);
				areaPokemonUtente.setBounds(30, 390, 200, 30);
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
				areaPokemonCPU.setBounds(750, 80, 200, 30);
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
				areaMessaggi.setBounds(570, 450, 400, 100);
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
					testoMessaggi.setBounds(80, 40, 300, 30);
					
				areaMessaggi.add(testoMessaggi);
				add(areaMessaggi);
				
				/* Panel area mosse */
				Border bordoAreaMosse = new LineBorder(Color.BLACK, 3);
				panelAreaMosse = new JPanel();
				panelAreaMosse.setBackground(Color.GRAY);
				panelAreaMosse.setBounds(20, 20, 400, 300);
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
					mosse.setBounds(15, 140, 370, 80);
					
					/* Pulsanti delle mosse (inizialmente nascosti) */
					mossa1 = creaPulsanteMossa();
					mossa2 = creaPulsanteMossa();
					mossa3 = creaPulsanteMossa();
					mossa4 = creaPulsanteMossa();
		
					/* Posizioni nei quattro angoli */
					mossa1.setBounds(10, 30, 180, 60);   // Alto sinistra
					mossa2.setBounds(200, 30, 180, 60);  // Alto destra
					mossa3.setBounds(10, 110, 180, 60);  // Basso sinistra
					mossa4.setBounds(200, 110, 180, 60); // Basso destra

					/* Array di pulsanti per le mosse */
					JButton[] pulsantiMosse = {mossa1, mossa2, mossa3, mossa4};
					
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
											
											/* Primo attacco: attaccante */                      	
											pokemonUtente.usaMossa(pokemonUtente, pokemonCPU, listaMosseUtente.get(index));
											System.out.println(pokemonUtente.getElusione());
											
											/* Verifico se la mossa non ha esaurito i PP */
											if(listaMosseUtente.get(index).noPP()) {
												mostraMessaggio("hai finito i PP, usa un'altra mossa");
												for(JButton pulsante:pulsantiMosse) {
													pulsante.setEnabled(true);
												}
												buttonCambiaPokemon.setEnabled(true);
												borsa.setEnabled(true);
												return;
											}
											
											mostraMessaggio(pokemonUtente.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
											
											/* Verifico se l'attacco è andato a segno */
											if(listaMosseUtente.get(index).getColpito() == false) {
												timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() +  " evita l'attacco"));                              											
											} else {                             		
												/* Controllo se la mossa usata ha un effetto di tipo stato */
												if(!listaMosseUtente.get(index).getEffetto().equals("")) {
													timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() + " " + listaMosseUtente.get(index).getEffetto()));                                   		
												
												} else {                                   		
													/* Timer per mostrare l'efficacia dell'attacco */
													if(listaMosseUtente.get(index).getModificatore() > 1) {
														timerTask(2000, () -> mostraMessaggio("è superefficace"));
													}else if(listaMosseUtente.get(index).getModificatore() < 1){
														timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
													}
												}                                                                  		
											
													/* Controllo se la CPU è KO dopo l'attacco */
													if (pokemonCPU.esausto()) {		                                  
														
														/* Aggiorna la healthBar della CPU */
														aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
														/* Aggiorna l'esperienza del pokemon dell'utente */
														pokemonUtente.setXp(pokemonUtente.getXp() + pokemonCPU.getLivello()+5);		                                    										
														
														/* Mostra il messaggio di KO */
														timerTask(3000, () -> {
															mostraMessaggio(pokemonCPU.getNome() + " avversario " + " è esausto!"); 
															next.setEnabled(true);
														});
															
														/* Controllo se l'attaccante è salito di livello */
														if(pokemonUtente.saliDiLivello()){
															timerTask(4000, () -> {
															mostraMessaggio(pokemonUtente.getNome() + " è salito di livello, ora è al " + pokemonUtente.getLivello()); 
															livelloPokemonUtente.setText("Liv " + pokemonUtente.getLivello());
															});
														}	                                    	
														return;
													
													} else {
														/* Aggiorna la healthBar della CPU */
														aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
														/* Abilita il pulsante next */
														timerTask(4000, () -> next.setEnabled(true));
													}	                                	
												}
														
												/* Dopo un piccolo ritardo, attacca la CPU */
												Timer timer = new Timer(4000, new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) { 
														SwingUtilities.invokeLater(() -> {
															
															next.setEnabled(false);
															
															int indiceMossaCPU = attaccoCasuale(); /* Salva l'indice della mossa */
															mossaCPU = listaMosseCPU.get(indiceMossaCPU); /* Recupera la mossa scelta */
															
															/* Verifico se la mossa ha ancora dei PP e può essere utilizzata regoalarmente */
															if(mossaCPU.noPP()) {
																mossaNoPP();
																timerTask(3000, () -> next.setEnabled(true));
															} else {
																
																/* il pokemon della CPU attacca */
																pokemonCPU.usaMossa(pokemonCPU, pokemonUtente, mossaCPU);																																																			
																mostraMessaggio(pokemonCPU.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());																																				
			
																/* Verifico se l'attacco della CPU è andato a segno */
																if(mossaCPU.getColpito() == false) {
																	timerTask(2000, () -> {
																	mostraMessaggio(pokemonUtente.getNome() +  " evita l'attacco"); 
																	next.setEnabled(true);	       		
																	});
																	return; /* esce dal ciclo se la l'utente evita l'attacco */
																
																} else {
																	/* Controllo se la mossa usata ha un effetto di tipo stato */
																	if(!mossaCPU.getEffetto().equals("")) {
																		timerTask(2000, () -> mostraMessaggio(pokemonCPU.getNome() + " " + mossaCPU.getEffetto()));		                                        		
																	
																	} else {													
																		/* Timer per mostrare l'efficacia dell'attacco */
																		if(mossaCPU.getModificatore() > 1) {
																			timerTask(2000, () -> mostraMessaggio("è superefficace"));
																		}else if(mossaCPU.getModificatore() < 1){
																			timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
																		}
																	}
																
																	/* Controllo KO utente dopo il contrattacco della CPU */
																	if (pokemonUtente.esausto()) {
																		
																		/* Aggiorna la healthBar dell'utente */
																		aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());                                      
																		/* Aggiorna l'esperienza del pokemon della CPU */
																		pokemonCPU.setXp(pokemonCPU.getXp() + pokemonUtente.getLivello()+5);
																		
																		/* Nasconde i pulsanti delle mosse */
																		for(JButton pulsante : pulsantiMosse) {
																			pulsante.setVisible(false);
																		}
			
																		panelAreaMosse.setVisible(false);
																		next.setEnabled(false);
																		
																		/* Timer per far vedere il messaggio di esaustione */																		
																		timerTask(3000, () -> {
																			mostraMessaggio(pokemonUtente.getNome() + " è esausto!");
																			cambiaPokemonUtente(); 
																			for (JButton pulsante : pulsantiMosse) {
																				pulsante.setEnabled(true);
																			}																				
																		});																																																																																													
																		
																		/* Controllo se il pokemon è salito di livello */
																		if(pokemonCPU.saliDiLivello()) {
																			timerTask(4000, () -> {
																			mostraMessaggio(pokemonCPU.getNome() + " avversario " + "è salito di livello, ora è al " + pokemonCPU.getLivello()); 
																			livelloPokemonCPU.setText("Liv " + pokemonCPU.getLivello());				                                                
																			});
																		}			                                        	
																		return;
																	
																	}else {
																		/* Aggiorna la healthBar dell'utente */
																		aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
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
											
											/* Verifico se la mossa selezionata ha ancora dei PP e può essere utilizzata regoalarmente */
											if(mossaCPU.noPP()) {
												mossaNoPP();
											} else {
												/* il Pokemon della CPU attacca*/
												pokemonCPU.usaMossa(pokemonCPU, pokemonUtente, mossaCPU);										
												mostraMessaggio(pokemonCPU.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());
												
												/* Verifico se l'attacco della CPU è andato a segno */
												if(mossaCPU.getColpito() == false) {
													timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() +  " evita l'attacco"));                               	
												
												} else {                            		
													/* Controllo se la mossa usata ha un effetto di tipo stato */
													if(!mossaCPU.getEffetto().equals("")) {
														timerTask(2000, () -> mostraMessaggio(pokemonCPU.getNome() + " " + mossaCPU.getEffetto()));		                                        		
													
													} else {                                   		
															/* Timer per mostrare l'efficacia dell'attacco */
															if(mossaCPU.getModificatore() > 1) {
																timerTask(2000, () -> mostraMessaggio("è superefficace"));
															}else if(mossaCPU.getModificatore() < 1){
																timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
															}
													}
												
														/* Controllo se l'utente è KO dopo l'attacco della CPU */
														if (pokemonUtente.esausto()) {	                                        	
															
															/* Aggiorna la healthBar */
															aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
															pokemonCPU.setXp(pokemonCPU.getXp() + pokemonUtente.getLivello()+5); // Aggiorna l'esperienza del pokemon avversario
															
															/* Nasconde i pulsanti delle mosse */
															for(JButton pulsante : pulsantiMosse) {
																pulsante.setVisible(false);
															}
			
															panelAreaMosse.setVisible(false);
															next.setEnabled(false);	
															
															/* Timer per far vedere il messaggio di esaustione */																															
															timerTask(3000, () -> {
																mostraMessaggio(pokemonUtente.getNome() + " è esausto!");
																cambiaPokemonUtente();
																for (JButton pulsante : pulsantiMosse) {
																	pulsante.setEnabled(true);
																}
															});																	
																																																													
															/* Controllo se il pokemon avversario è salito di livello */
															if(pokemonCPU.saliDiLivello()) {
																timerTask(4000, () -> {
																mostraMessaggio(pokemonCPU.getNome() + " avversario " + "è salito di livello, ora è al " + pokemonCPU.getLivello()); livelloPokemonCPU.setText("Liv " + pokemonCPU.getLivello());	    	                                            
																});
															}
															return;
														
														} else {
															/* Aggiorna la healthBar dell'utente */
															aggiornaHealthBar(healthBarUtente, (int) pokemonUtente.getHp(), (int) pokemonUtente.getHpMax());
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
														pokemonUtente.usaMossa(pokemonCPU, pokemonUtente, listaMosseUtente.get(index));
														
														/* Verifico se la mossa non ha esaurito i PP */
														if(listaMosseUtente.get(index).noPP()) {
															mostraMessaggio("hai finito i PP, usa un'altra mossa");
															for(JButton pulsante:pulsantiMosse) {
																pulsante.setEnabled(true);
															}
															buttonCambiaPokemon.setEnabled(true);
															borsa.setEnabled(true);
															return;
														}
														
														mostraMessaggio(pokemonUtente.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());			                                													
		
														/* Verifico se l'attacco è andato a segno */
														if(listaMosseUtente.get(index).getColpito() == false) {
															timerTask(2000, () -> {
															mostraMessaggio(pokemonCPU.getNome() +  " evita l'attacco"); next.setEnabled(true);			                                		
															});
															
															return; /* esce dal ciclo se il pokemon avversario evita l'attacco */
														
														} else {
															
															/* Controllo se la mossa usata ha un effetto di tipo stato */
															if(!listaMosseUtente.get(index).getEffetto().equals("")) {
																timerTask(2000, () -> mostraMessaggio(pokemonUtente.getNome() + " " + listaMosseUtente.get(index).getEffetto()));
																
															} else {			                                    	
																/* Timer per mostrare l'efficacia dell'attacco */
																if(listaMosseUtente.get(index).getModificatore() > 1) {
																	timerTask(2000, () -> mostraMessaggio("è superefficace"));
																}else if(listaMosseUtente.get(index).getModificatore() < 1){
																	timerTask(2000, () -> mostraMessaggio("non è molto efficace..."));
																}
															
															}                                                                  		
														
															/* Controllo KO CPU */
															if (pokemonCPU.esausto()) {
																
																/* Aggiorna la healthBar del pokemon della CPU */
																aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
																/* Aggiorna l'esperienza del pokemon dell'utente */
																pokemonUtente.setXp(pokemonUtente.getXp() + pokemonCPU.getLivello()+5);
																
																/* Mostra il messaggio di KO */
																timerTask(3000, () -> {
																	mostraMessaggio(pokemonCPU.getNome() + " avversario " + " è esausto!"); next.setEnabled(true);
																});
																
																	/* Controllo se il pokemon è salito di livello */
																	if(pokemonUtente.saliDiLivello()) {
																		timerTask(4000, () -> {																	
																		mostraMessaggio(pokemonUtente.getNome() + " è salito di livello, ora è al " + pokemonUtente.getLivello()); 
																		livelloPokemonUtente.setText("Liv " + pokemonUtente.getLivello());	
																		});
																	
																	}
																	return;
															
															}else {			                                        	
																/* Aggiorna la healthBar */
																aggiornaHealthBar(healthBarCPU, (int) pokemonCPU.getHp(), (int) pokemonCPU.getHpMax());
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
					next.setBounds(340, 70, 50, 20);
					
					next.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(pokemonCPU.esausto()) {
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
						panelCambiaPokemon.setBounds(20, 20, 400, 300);
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
					buttonCambiaPokemon.setBounds(15, 230, 160, 50);
					
					buttonCambiaPokemon.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							for(JButton button: pulsantiMosse) {
								button.setVisible(false);
							}    				
							cambiaPokemonUtente();
						}
					});
					
					panelAreaMosse.add(buttonCambiaPokemon);
					
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

							/* Button chiudi frame leaderboard */
							buttonChiudi = new JButton("Chiudi");
							buttonChiudi.setForeground(Color.WHITE);
							buttonChiudi.setBackground(Color.BLACK);
							buttonChiudi.setFont(new Font("Arial", Font.BOLD, 11));
							buttonChiudi.setBounds(50, 215, 100, 40);

							Border bordoButtonChiudi = new LineBorder(Color.WHITE, 2);
							buttonChiudi.setBorder(bordoButtonChiudi);

							buttonChiudi.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									frameLeaderboard.dispose();
									audioPlayer.stopMusic();
								}
							});

						panelLeaderboard.add(buttonChiudi);
						panelLeaderboard.add(leaderboard);
						
					frameLeaderboard.add(panelLeaderboard);

		add(panelAreaMosse);

	setComponentZOrder(labelSfondo, getComponentCount() - 1);
			
}

/**
 * Metodo per mostrare a piacimento un qualsiasi messaggio nell'area predisposta
 * @param messaggio desiderato
 */
public void mostraMessaggio(String messaggio) {
	testoMessaggi.setText(messaggio);
}

/**
 * Metodo per creare un pulsante mossa con lo stile desiderato
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
	serieVittorie++; /* Aumenta il contatore delle vittorie */
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

		} while (indicePokemonCPU != startIndex); /* Se ha girato tutta la lista e non ha trovato Pokémon validi, termina. */

		/* Se arriva qui significa che tutti i Pokémon sono esausti */
		mostraMessaggio("L'avversario non ha più Pokémon disponibili!");                    
		panelAreaMosse.setVisible(false);
		serieVittorieList.add(serieVittorie); /* Aggiunge la serie di vittorie alla lista */
		LeaderboardManager.salvaLeaderboard(serieVittorie); /* Salva la leaderboard */
        
		/* Aggiunta Pokemon alla squadra della CPU quando viene sconfitta (se non già presenti in squadra) */
		Pidgey pidgey = new Pidgey(); 
		Pikachu pikachu = new Pikachu();
		
		boolean pidgeyPresente = false;
		boolean pikachuPresente = false;
	
		/* Controlliamo quali Pokémon sono già presenti nella lista */
		for (Pokemon p : listaPokemonCPU) {
			if (p.getNome().equals(pidgey.getNome())) {
				pidgeyPresente = true;
			}
			if (p.getNome().equals(pikachu.getNome())) {
				pikachuPresente = true;
			}
		}

		/* Prima aggiungiamo Pidgey se non è presente */
		if (!pidgeyPresente) {
			listaPokemonCPU.add(pidgey);
		} 
		
		/* Pikachu viene aggiunto solo **nella lotta successiva**, se Pidgey è già presente */
		else if (!pikachuPresente) {
			listaPokemonCPU.add(pikachu);
		}
		
		/* Aumenta il livello della squadra CPU */
		aumentaLivelloCPU();
		
		/* Timer per chiudere la finestra di sconfitta */
		Timer timer = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();	
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
								frameWIN.dispose();	
								aggiornaLeaderboard();
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
     * Metodo per permettere la sotituzione di un pokemon quando l'utente lo desidera
     */
    public void cambiaPokemonUtente() {
    	
    	panelAreaMosse.setVisible(false);
    	borsa.setVisible(false);
		mosse.setVisible(false);
		buttonCambiaPokemon.setVisible(false);
    	
		panelCambiaPokemon.setVisible(true);
    	
    	panelCambiaPokemon.removeAll(); /* Rimuove tutti i componenti precedenti */
        panelCambiaPokemon.revalidate();
        panelCambiaPokemon.repaint();
    	
    	Border bordoPokemonCambiati = new LineBorder(Color.BLACK, 3);

        int x = 20;
        int y = 10;          
        
        for (Pokemon i : listaPokemonUtente) {
        	JButton pokemonButton = new JButton(i.getNome());
            pokemonButton.setForeground(Color.WHITE);
            pokemonButton.setBackground(Color.ORANGE);
            pokemonButton.setBorder(bordoPokemonCambiati);
            pokemonButton.setBounds(x, y, 100, 50);
            pokemonButton.setVisible(true);
            
            /* Pulsante per chiudere il pannello di cambio Pokémon */
            JButton chiudiButton = new JButton("Chiudi");
            chiudiButton.setForeground(Color.WHITE);
            chiudiButton.setBackground(Color.RED);
            chiudiButton.setBorder(new LineBorder(Color.BLACK, 3));
            chiudiButton.setBounds(250, 230, 120, 50);
            chiudiButton.setVisible(true);
            
            if(pokemonUtente.esausto()) chiudiButton.setEnabled(false);
            
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
            
            panelCambiaPokemon.add(pokemonButton);
            y += 55; /* Sposta i pulsanti in basso */
            
			/* Verifico se tutti i pokemon dell'utente sono esausti */
            if (listaPokemonUtente.stream().allMatch(Pokemon::esausto)) {
				mostraMessaggio("Tutti i tuoi Pokémon sono esausti.");
                next.setEnabled(false);
                chiudiButton.setEnabled(false);
                
				for(Pokemon pokemon:listaPokemonCPU){
					pokemon.setHp(pokemon.getHpMax());
					for(Mossa mossa:pokemon.getMosse()){
						mossa.setPP(mossa.getPPmax());
					}
				}

				Timer timer = new Timer(4000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						frame.dispose();
						audioPlayer.stopMusic();
						aggiornaLeaderboard();
						
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
            
        }
        
        /* Rinfresca il pannello dopo le modifiche */
        panelCambiaPokemon.revalidate();
        panelCambiaPokemon.repaint();         
    }

	/**
	 * Metodo per aggiorna la leaderboard con gli ultimi score
	 */
	private void aggiornaLeaderboard() {
        StringBuilder sb = new StringBuilder();
        int posizione = 1;
        for (int vittorie : serieVittorieList) {
            if(posizione > 10) break; /* Mostra solo le prime 10 posizioni */
			sb.append(posizione).append(") ").append("Serie di vittorie: ").append(vittorie).append("\n");
            posizione++;
        }
        leaderboard.setText(sb.toString());
    }

	/**
	 * Metodo per far partire un timer con un compito da svolgere dopo un certo ritardo
	 * @param delay; ritardo impostato
	 * @param task; task da eseguire 
	 */
	private void timerTask(int delay, Runnable task) {
        Timer timer = new Timer(delay, e -> task.run());
        timer.setRepeats(false);
        timer.start();
    }
    
	/**
	 * Metodo per far attaccare il pokemon della CPU con una mossa a scelta tra quelle disponibili
	 * @return l'intero desiderato
	 */
    public int attaccoCasuale() {
    	Random interoCasuale = new Random(); 
		return interoCasuale.nextInt(3);
	}
    
    /**
     * Metodo per selezionare casualemente i Pokemon che la CPU schiera
     * @return l'intero desiderato
     */
    
    public int pokemonCasuale() {
    	Random interoCasuale = new Random(); 
		return interoCasuale.nextInt(listaPokemonCPU.size());
	}
    
    /**
     * Metodo per aggiornare le barre di salute dei pokemon quando necessario
     * @param healthBar; la barra della vita da aggiornare
     * @param hp; gli hp attuali 
     * @param hpMax; gli hp massimi
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
     * Metodo per aumentare il livello della squadra della CPU dopo che viene sconfitta dall'utente
     * 
     */
    
    public void aumentaLivelloCPU() { 
    	for (Pokemon p : listaPokemonCPU) {
    		p.setLivello(p.getLivello()+1);
    		p.setAttacco(p.getAttacco()+3);
    		p.setDifesa(p.getDifesa()+3);
    		p.setAttaccoSpeciale(p.getAttaccoSpeciale()+3);
    		p.setDifesaSpeciale(p.getDifesaSpeciale()+3);
    		p.setVelocita(p.getVelocita()+3);
    		p.setElusione(p.getElusione()+3);
    		p.setHpMax(p.getHpMax()+3);
    		p.setHp(p.getHpMax());
    	}
    }
    
    /**
     * Metodo per verificare se la CPU ha ancora delle mosse da poter utilizzare, altrimenti usa la mossa base SCONTRO
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
                mostraMessaggio(pokemonCPU.getNome() + " avversario" + " usa " + mossa.getNomeMossa()); aggiornaHealthBar(healthBarUtente, (int)pokemonUtente.getHp(), (int)pokemonUtente.getHpMax());
                });
                
                if(mossa.getColpito() == false) {
                	timerTask(3000, () -> {              		
                	mostraMessaggio(pokemonUtente.getNome() + " evita l'attacco");               	
                	});
                	return;
                }else {
                	// Verifico se la mossa ha un effetto di stato o meno
                    if(!mossa.getEffetto().equals("")) {
                    	timerTask(3000, () -> mostraMessaggio(pokemonCPU.getNome() + " avversario " + mossa.getEffetto()));		                                        						
    				}else {
    					if(mossa.getModificatore() > 1) {
    						timerTask(3000, () -> mostraMessaggio("è superefficace"));
    					}else if(mossa.getModificatore() < 1){
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
            mostraMessaggio(pokemonCPU.getNome() + " usa " + scontro.getNomeMossa()); pokemonCPU.usaMossa(pokemonUtente, pokemonCPU, scontro); aggiornaHealthBar(healthBarUtente, (int)pokemonUtente.getHp(), (int)pokemonUtente.getHpMax());
            });            
        	timerTask(3000, () -> {
                int dannoContraccolpo = (int) (pokemonCPU.getHp() / 4); // Contraccolpo del 25% degli HP massimi
                pokemonCPU.setHp(pokemonCPU.getHp() - dannoContraccolpo);
                mostraMessaggio(pokemonCPU.getNome() + " subisce " + dannoContraccolpo + " danni dal contraccolpo!");                
            });    
        }
    }


}

