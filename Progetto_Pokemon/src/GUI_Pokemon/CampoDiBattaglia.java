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
    
    /** Lista dei Pokémon selezionati dall'utente */
    private List<Pokemon> pokemonUtente;
    
    /** Lista dei Pokémon selezionati dalla CPU */
    private List<Pokemon> pokemonCPU;
    
    /** Lista delle mosse disponibili per i Pokémon della CPU */
    private List<Mossa> listaMosseCPU;
    
    /** Icona dell'immagine di sfondo */
    private ImageIcon sfondo;
    
    /** Etichetta che mostra l'immagine di sfondo */
    private JLabel labelSfondo;
    
    /** Pokémon attuale dell'utente in battaglia */
    private Pokemon attaccante;
    
    /** Pokémon attuale della CPU in battaglia */
    private Pokemon difensore;
    
    /** Barra della salute del Pokémon dell'utente */
    private JProgressBar healthBarAtt;
    
    /** Barra della salute del Pokémon della CPU */
    private JProgressBar healthBarDif;
    
    /** Bordo delle barre della salute */
    private Border bordoHealthBar;
    
    /** Pannello contenente le informazioni del Pokémon dell'utente */
    private JPanel areaPokemonAtt;
    
        /** Etichetta per il nome del Pokémon dell'utente */
        private JLabel labelPokemonAtt;
        
        /** Etichetta per il livello del Pokémon dell'utente */
        private JLabel livelloPokemonAtt;
    
    /** Pannello contenente le informazioni del Pokémon della CPU */
    private JPanel areaPokemonDif;
    
        /** Etichetta per il nome del Pokémon della CPU */
        private JLabel labelPokemonDif;
        
        /** Etichetta per il livello del Pokémon della CPU */
        private JLabel livelloPokemonDif;
    
    /** Pannello per visualizzare i messaggi durante la lotta */
    private JPanel areaMessaggi;
    
        /** Area di testo per visualizzare i messaggi della battaglia */
        private JTextArea testoMessaggi;
        
        /** Pulsante per avanzare al turno successivo */
        private JButton next;
    
    /** Pannello che contiene le mosse, il cambio Pokémon e la borsa */
    private JPanel panelAreaMosse;
    
        /** Lista delle mosse disponibili per il Pokémon dell'utente */
        private List<Mossa> listaMosseUtente;
        
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
        
        /** Pannello per il cambio Pokémon */
        private JPanel panelCambiaPokemon;
        
        /** Pulsante per cambiare il Pokémon attuale dell'utente */
        private JButton buttonCambiaPokemon;
        
        /** Pulsante per aprire la borsa degli oggetti */
        private JButton borsa;
    
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

<<<<<<< HEAD
	
	CampoDiBattaglia(JFrame frame, List<Pokemon> pokemonUtente, List<Pokemon> pokemonCPU){
=======
		/**
		 * Costruttore della classe CampoDiBattaglia 
		 * @param frame il frame principale dove avviene la lotta
		 * @param pokemonUtente; la lista dei pokemon dell'utente
		 * @param pokemonCPU; la lista dei pokemon della CPU
		 */
		
        CampoDiBattaglia(JFrame frame, List<Pokemon> pokemonUtente, List<Pokemon> pokemonCPU){
			
			this.frame = frame;
			this.pokemonUtente = pokemonUtente;
			this.pokemonCPU = pokemonCPU;
			this.serieVittorieList = LeaderboardManager.caricaLeaderboard();
			this.serieVittorie = 0;
									
				setLayout(null); 
				setBackground(Color.GRAY);
				
				/* Audio */
				audioPlayer = new AudioPlayer();
				audioPlayer.playMusic("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/Pokémon Battle Music - Anime Version.wav");
				
				if (!pokemonUtente.isEmpty() && !pokemonCPU.isEmpty()) { /* Controllo se le liste non sono vuote */
					this.attaccante = pokemonUtente.get(0);  /* Seleziono il primo Pokémon dell'utente */
					this.difensore = pokemonCPU.get(pokemonCasuale());  /* Primo Pokémon della CPU selezionato casualemente tra quelli disponibili nella sua squadra */
				}  
				
				listaMosseCPU = difensore.getMosse(); /* Setting delle mosse del primo pokemon avversario */
				
				bordoHealthBar = new LineBorder(Color.BLACK); /* Bordo delle healthBar */
				
				/* Sfondo pannello */
				sfondo = new ImageIcon("C:/Users/megam/eclipse-workspace/Progetto-Pokemon-Git/Progetto-Pokemon/sfondo lotta.jpg");
				Image sfondoscalato = sfondo.getImage();
				labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
				labelSfondo.setBounds(0,0,1000,600);
				add(labelSfondo);
				
				/* HealthBar Cpu */
				healthBarDif = new JProgressBar(0, 100);
				aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
				healthBarDif.setStringPainted(true); /* Mostra il valore numerico */
				
				healthBarDif.setForeground(Color.GREEN);
				healthBarDif.setBorder(bordoHealthBar);
				healthBarDif.setBackground(Color.WHITE);
				
				healthBarDif.setBounds(750, 110, 200, 20);
			
				add(healthBarDif);
				
				/* HealthBar Utente */
				healthBarAtt = new JProgressBar(0, 100);
				aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
				healthBarAtt.setStringPainted(true); /* Mostra il valore numerico */
				
				healthBarAtt.setForeground(Color.GREEN);
				healthBarAtt.setBorder(bordoHealthBar);
				healthBarAtt.setBackground(Color.WHITE);
				
				healthBarAtt.setBounds(30, 420, 200, 20);
				
				add(healthBarAtt);
				
				/* Pokemon utente */
				areaPokemonAtt = new JPanel();
				Border bordo = new LineBorder(Color.WHITE);
				areaPokemonAtt.setBackground(Color.BLACK);
				areaPokemonAtt.setBounds(30, 390, 200, 30);
				areaPokemonAtt.setBorder(bordo);
				
				labelPokemonAtt = new JLabel(attaccante.getNome()); 
				labelPokemonAtt.setForeground(Color.WHITE);
				
				livelloPokemonAtt = new JLabel("Liv " + attaccante.getLivello());
				livelloPokemonAtt.setForeground(Color.WHITE);
				
				areaPokemonAtt.add(labelPokemonAtt);
				areaPokemonAtt.add(livelloPokemonAtt);
				add(areaPokemonAtt);
				
				/* Pokemon CPU */
				areaPokemonDif = new JPanel();
				Border bordo2 = new LineBorder(Color.WHITE);
				areaPokemonDif.setBackground(Color.BLACK);
				areaPokemonDif.setBounds(750, 80, 200, 30);
				areaPokemonDif.setBorder(bordo2);
				
				labelPokemonDif = new JLabel(difensore.getNome());
				labelPokemonDif.setForeground(Color.WHITE);
				
				livelloPokemonDif = new JLabel("Liv " + difensore.getLivello());
				livelloPokemonDif.setForeground(Color.WHITE);
				
				areaPokemonDif.add(labelPokemonDif);
				areaPokemonDif.add(livelloPokemonDif);
				add(areaPokemonDif);
				
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
					listaMosseUtente = attaccante.getMosse();
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
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e
		
					/* Posizioni nei quattro angoli */
					mossa1.setBounds(10, 30, 180, 60);   // Alto sinistra
					mossa2.setBounds(200, 30, 180, 60);  // Alto destra
					mossa3.setBounds(10, 110, 180, 60);  // Basso sinistra
					mossa4.setBounds(200, 110, 180, 60); // Basso destra

<<<<<<< HEAD
            // Posizioni nei quattro angoli
            mossa1.setBounds(10, 30, 180, 60);   // Alto sinistra
            mossa2.setBounds(200, 30, 180, 60);  // Alto destra
            mossa3.setBounds(10, 110, 180, 60);  // Basso sinistra
            mossa4.setBounds(200, 110, 180, 60); // Basso destra

            JButton[] pulsantiMosse = {mossa1, mossa2, mossa3, mossa4};
            
            for (JButton pulsante : pulsantiMosse) {
                pulsante.setVisible(false); // Inizialmente nascosti
                panelAreaMosse.add(pulsante);
            }
            
            mosse.addActionListener(new ActionListener() {
                @Override
            	public void actionPerformed(ActionEvent e) {
                    mosse.setVisible(false); // Nasconde il pulsante principale

                    // Assegna le mosse ai pulsanti e li rende visibili
                    for (int i = 0; i < listaMosseUtente.size(); i++) {
                        pulsantiMosse[i].setText(listaMosseUtente.get(i).getNomeMossa());
                        pulsantiMosse[i].setVisible(true);
                        
                        // Rimuove tutti i vecchi listener prima di aggiungere il nuovo
                        for (ActionListener al : pulsantiMosse[i].getActionListeners()) {
                            pulsantiMosse[i].removeActionListener(al);
                        }
                        
                        final int index = i; // Variabile finale per ActionListener
                        pulsantiMosse[i].addActionListener(new ActionListener() {
                            @Override
                        	public void actionPerformed(ActionEvent e) {
                                
                            	// Disabilita i pulsanti delle mosse per evitare doppi input
                                for (JButton pulsante : pulsantiMosse) {
                                    pulsante.setEnabled(false);
                                }
                                
                                next.setEnabled(false);
                                borsa.setEnabled(false);
                                buttonCambiaPokemon.setEnabled(false);                                                              
                                
                                // Controllo la velocità dei pokemon per stabilire chi attacca per primo
                                if (attaccante.getVelocita() >= difensore.getVelocita()) {
                                    
                                	// Primo attacco: attaccante
                                	attaccante.usaMossa(difensore, listaMosseUtente.get(index));
                                	mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
                                	
                                	// Verifico se l'attacco è andato a segno
                                	if(listaMosseUtente.get(index).getColpito() == false) {
                                		Timer timer = new Timer(2000, new ActionListener() {											
											@Override
											public void actionPerformed(ActionEvent e) {
												mostraMessaggio(difensore.getNome() +  " evita l'attacco");
											}
										});
                                		
                                		timer.setRepeats(false);
                                		timer.start();
                                	
                                	} else {
                                		
                                		// Controllo se la mossa usata ha un effetto di tipo stato
                                		if(!listaMosseUtente.get(index).getEffetto().equals("")) {
                                    		Timer timerEffetto = new Timer(2000, new ActionListener() {										
    											@Override
    											public void actionPerformed(ActionEvent e) {												
    												mostraMessaggio(attaccante.getNome() + " " + listaMosseUtente.get(index).getEffetto());
    											}
    										});
                                    		
                                    		timerEffetto.setRepeats(false);
                                    		timerEffetto.start();
                                    		
                                    	} else {
                                    		
                                		// Timer per mostrare l'efficacia dell'attacco
                                       	 Timer timerAtt = new Timer(2000, new ActionListener() {    											
       											@Override
       											public void actionPerformed(ActionEvent e) {
       												if(listaMosseUtente.get(index).getModificatore() > 1) {
       													mostraMessaggio("è superefficace");
       												}else if(listaMosseUtente.get(index).getModificatore() < 1) {
       													mostraMessaggio("non è molto efficace...");
       												}
       											}
       										});
                                            
                                            timerAtt.setRepeats(false);
                                            timerAtt.start();
                                    	}                                                                  		
                                	
	                                		// Controllo KO CPU
		                                    if (difensore.esausto()) {
		                                  
		                                    	aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
		                                    	attaccante.setXp(attaccante.getXp() + difensore.getLivello()+5);
		                                    	
		                                    	Timer timerEsausto = new Timer(4000, new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {	
														mostraMessaggio(difensore.getNome() + " avversario " + " è esausto!");
														next.setEnabled(true);
=======
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
										if (attaccante.getVelocita() >= difensore.getVelocita()) {                                   
											
											/* Primo attacco: attaccante */                      	
											attaccante.usaMossa(difensore, listaMosseUtente.get(index));
											mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
											
											/* Verifico se l'attacco è andato a segno */
											if(listaMosseUtente.get(index).getColpito() == false) {
												avviaTimerSingleTask(2000, () -> mostraMessaggio(attaccante.getNome() +  " evita l'attacco"));                              
											
											} else {                             		
												/* Controllo se la mossa usata ha un effetto di tipo stato */
												if(!listaMosseUtente.get(index).getEffetto().equals("")) {
													avviaTimerSingleTask(2000, () -> mostraMessaggio(attaccante.getNome() + " " + listaMosseUtente.get(index).getEffetto()));                                   		
												
												} else {                                   		
													/* Timer per mostrare l'efficacia dell'attacco */
													if(listaMosseUtente.get(index).getModificatore() > 1) {
														avviaTimerSingleTask(2000, () -> mostraMessaggio("è superefficace"));
													}else if(listaMosseUtente.get(index).getModificatore() < 1){
														avviaTimerSingleTask(2000, () -> mostraMessaggio("non è molto efficace..."));
>>>>>>> 9ccb2dfefe5bdb0ad0937017e02b4abd8e6e246e
													}
												}                                                                  		
											
													/* Controllo se la CPU è KO dopo l'attacco */
													if (difensore.esausto()) {		                                  
														
														/* Aggiorna la healthBar della CPU */
														aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
														/* Aggiorna l'esperienza del pokemon dell'utente */
														attaccante.setXp(attaccante.getXp() + difensore.getLivello()+5);		                                    										
														
														/* Mostra il messaggio di KO */
														avviaTimerDoubleTask(3000, () -> mostraMessaggio(difensore.getNome() + " avversario " + " è esausto!"), () -> next.setEnabled(true));
															
														/* Controllo se l'attaccante è salito di livello */
														if(attaccante.saliDiLivello()){
															avviaTimerDoubleTask(4000, () -> mostraMessaggio(attaccante.getNome() + " è salito di livello, ora è al " + attaccante.getLivello()), () -> livelloPokemonAtt.setText("Liv " + attaccante.getLivello()));
														}	                                    	
														return;
													
													} else {
														/* Aggiorna la healthBar della CPU */
														aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
														/* Abilita il pulsante next */
														avviaTimerSingleTask(4000, () -> next.setEnabled(true));
													}	                                	
												}
														
												/* Dopo un piccolo ritardo, attacca la CPU */
												Timer timer = new Timer(4000, new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) { 
														SwingUtilities.invokeLater(() -> {
															
															next.setEnabled(false);
															
															int indiceMossaCPU = attaccoCasuale(); /* Salva l'indice della mossa */
															Mossa mossaCPU = listaMosseCPU.get(indiceMossaCPU); /* Recupera la mossa scelta */
															
															/* il pokemon della CPU attacca */
															difensore.usaMossa(attaccante, mossaCPU);
															mostraMessaggio(difensore.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());																																				
		
															/* Verifico se l'attacco della CPU è andato a segno */
															if(mossaCPU.getColpito() == false) {
																avviaTimerDoubleTask(2000, () -> mostraMessaggio(attaccante.getNome() +  " evita l'attacco"), () -> next.setEnabled(true));	       		
																return; /* esce dal ciclo se la l'utente evita l'attacco */
															
															} else {
																/* Controllo se la mossa usata ha un effetto di tipo stato */
																if(!mossaCPU.getEffetto().equals("")) {
																	avviaTimerSingleTask(2000, () -> mostraMessaggio(difensore.getNome() + " " + mossaCPU.getEffetto()));		                                        		
																
																} else {													
																	/* Timer per mostrare l'efficacia dell'attacco */
																	if(mossaCPU.getModificatore() > 1) {
																		avviaTimerSingleTask(2000, () -> mostraMessaggio("è superefficace"));
																	}else if(mossaCPU.getModificatore() < 1){
																		avviaTimerSingleTask(2000, () -> mostraMessaggio("non è molto efficace..."));
																	}
																}
															
																/* Controllo KO utente dopo il contrattacco della CPU */
																if (attaccante.esausto()) {
																	
																	/* Aggiorna la healthBar dell'utente */
																	aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());                                      
																	/* Aggiorna l'esperienza del pokemon della CPU */
																	difensore.setXp(difensore.getXp() + attaccante.getLivello()+5);
																	
																	/* Nasconde i pulsanti delle mosse */
																	for(JButton pulsante : pulsantiMosse) {
																		pulsante.setVisible(false);
																	}
		
																	panelAreaMosse.setVisible(false);
																	next.setEnabled(false);
																	
																	/* Timer per far vedere il messaggio di esaustione */
																	Timer timerEsaustoDif = new Timer(3000, new ActionListener() {
																		@Override
																		public void actionPerformed(ActionEvent e) {
																			mostraMessaggio(attaccante.getNome() + " è esausto!");
																			cambiaPokemonUtente(); 
																			for (JButton pulsante : pulsantiMosse) {
																				pulsante.setEnabled(true);
																			}
																		}
																	});
																	
																	timerEsaustoDif.setRepeats(false); /* Il timer scatta solo una volta */
																	timerEsaustoDif.start();	
																	
																	/* Controllo se il pokemon è salito di livello */
																	if(difensore.saliDiLivello()) {
																		avviaTimerDoubleTask(4000, () -> mostraMessaggio(difensore.getNome() + " avversario " + "è salito di livello, ora è al " + difensore.getLivello()), () -> livelloPokemonDif.setText("Liv " + difensore.getLivello()));				                                                
																	}			                                        	
																	return;
																
																}else {
																	/* Aggiorna la healthBar dell'utente */
																	aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
																	/* Abilita il pulsante next */
																	avviaTimerSingleTask(4000, () -> next.setEnabled(true));			                                        	
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
											
											int indiceMossaCPU = attaccoCasuale(); /* Salva l'indice della mossa */
											Mossa mossaCPU = listaMosseCPU.get(indiceMossaCPU); /* Recupera la mossa scelta */
											
											difensore.usaMossa(attaccante, mossaCPU);
											mostraMessaggio(difensore.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());
											
											/* Verifico se l'attacco della CPU è andato a segno */
											if(mossaCPU.getColpito() == false) {
												avviaTimerSingleTask(2000, () -> mostraMessaggio(attaccante.getNome() +  " evita l'attacco"));                               	
											
											} else {                            		
												/* Controllo se la mossa usata ha un effetto di tipo stato */
												if(!mossaCPU.getEffetto().equals("")) {
													avviaTimerSingleTask(2000, () -> mostraMessaggio(difensore.getNome() + " " + mossaCPU.getEffetto()));		                                        		
												
												} else {                                   		
														/* Timer per mostrare l'efficacia dell'attacco */
														if(mossaCPU.getModificatore() > 1) {
															avviaTimerSingleTask(2000, () -> mostraMessaggio("è superefficace"));
														}else if(mossaCPU.getModificatore() < 1){
															avviaTimerSingleTask(2000, () -> mostraMessaggio("non è molto efficace..."));
														}
												}
											
													/* Controllo se l'utente è KO dopo l'attacco della CPU */
													if (attaccante.esausto()) {	                                        	
														
														/* Aggiorna la healthBar */
														aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
														difensore.setXp(difensore.getXp() + attaccante.getLivello()+5); // Aggiorna l'esperienza del pokemon avversario
														
														/* Nasconde i pulsanti delle mosse */
														for(JButton pulsante : pulsantiMosse) {
															pulsante.setVisible(false);
														}
		
														panelAreaMosse.setVisible(false);
														next.setEnabled(false);	
														
														/* Timer per far vedere il messaggio di esaustione */
														Timer timerEsaustoDif = new Timer(3000, new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																mostraMessaggio(attaccante.getNome() + " è esausto!");
																cambiaPokemonUtente();
																for (JButton pulsante : pulsantiMosse) {
																	pulsante.setEnabled(true);
																}
															}
														});
														
														timerEsaustoDif.setRepeats(false); /* Il timer scatta solo una volta */
														timerEsaustoDif.start();
		
															
		
															/* Controllo se il pokemon avversario è salito di livello */
															if(difensore.saliDiLivello()) {
																avviaTimerDoubleTask(4000, () -> mostraMessaggio(difensore.getNome() + " avversario " + "è salito di livello, ora è al " + difensore.getLivello()), () -> livelloPokemonDif.setText("Liv " + difensore.getLivello()));	    	                                            
															}
															return;
													
													} else {
														/* Aggiorna la healthBar dell'utente */
														aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
														/* Abilita il pulsante next */
														avviaTimerSingleTask(3000, () -> next.setEnabled(true));                               	
													}	                                		
												}                                                                                                                                     
											
												/* Dopo un piccolo ritardo, attacca il giocatore */
												Timer timer = new Timer(4000, new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {
													SwingUtilities.invokeLater(() -> {
														
														/* il pokemon dell'utente attacca */
														attaccante.usaMossa(difensore, listaMosseUtente.get(index));
														mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());			                                													
		
														/* Verifico se l'attacco è andato a segno */
														if(listaMosseUtente.get(index).getColpito() == false) {
															avviaTimerDoubleTask(2000, () -> mostraMessaggio(difensore.getNome() +  " evita l'attacco"), () -> next.setEnabled(true));			                                		
															return; /* esce dal ciclo se il pokemon avversario evita l'attacco */
														
														} else {
															
															/* Controllo se la mossa usata ha un effetto di tipo stato */
															if(!listaMosseUtente.get(index).getEffetto().equals("")) {
																avviaTimerSingleTask(2000, () -> mostraMessaggio(attaccante.getNome() + " " + listaMosseUtente.get(index).getEffetto()));
																
															} else {			                                    	
																/* Timer per mostrare l'efficacia dell'attacco */
																if(listaMosseUtente.get(index).getModificatore() > 1) {
																	avviaTimerSingleTask(2000, () -> mostraMessaggio("è superefficace"));
																}else if(listaMosseUtente.get(index).getModificatore() < 1){
																	avviaTimerSingleTask(2000, () -> mostraMessaggio("non è molto efficace..."));
																}
															
															}                                                                  		
														
															/* Controllo KO CPU */
															if (difensore.esausto()) {
																
																/* Aggiorna la healthBar del pokemon della CPU */
																aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
																/* Aggiorna l'esperienza del pokemon dell'utente */
																attaccante.setXp(attaccante.getXp() + difensore.getLivello()+5);
																
																/* Mostra il messaggio di KO */
																avviaTimerDoubleTask(3000, () -> mostraMessaggio(difensore.getNome() + " avversario " + " è esausto!"), () -> next.setEnabled(true));
																
																	/* Controllo se il pokemon è salito di livello */
																	if(attaccante.saliDiLivello()) {
																		avviaTimerDoubleTask(4000, () -> mostraMessaggio(attaccante.getNome() + " è salito di livello, ora è al " + attaccante.getLivello()), () -> livelloPokemonAtt.setText("Liv " + attaccante.getLivello()));				                                                
																	}
																	return;
															
															}else {			                                        	
																/* Aggiorna la healthBar */
																aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
																// Abilita il pulsante next
																avviaTimerSingleTask(4000, () -> next.setEnabled(true));                                     	
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
					
					/* Pulsante next */
					
					next = new JButton("AVANTI");
					Border bordoNext = new LineBorder(Color.WHITE, 3);
					next.setBorder(bordoNext);
					next.setForeground(Color.WHITE);
					next.setBackground(Color.GRAY);
					next.setBounds(340, 70, 50, 20);
					
					next.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if(difensore.esausto()) {
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
	if (!pokemonCPU.isEmpty()) { 
		int startIndex = indicePokemonCPU; /* Salva l'indice di partenza */

		do {
			/* Passa al Pokémon successivo, ciclando la lista */
			indicePokemonCPU = (indicePokemonCPU + 1) % pokemonCPU.size();
			
			/* Se il Pokémon non è esausto, lo manda in campo */
			if (!pokemonCPU.get(indicePokemonCPU).esausto()) {
				difensore = pokemonCPU.get(indicePokemonCPU);
				listaMosseCPU = difensore.getMosse();
				mostraMessaggio("La CPU manda in campo " + difensore.getNome());

				/* Aggiorna l'interfaccia grafica */
				aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
				labelPokemonDif.setText(difensore.getNome());
				livelloPokemonDif.setText("Liv " + difensore.getLivello());
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
		for (Pokemon p : pokemonCPU) {
			if (p.getNome().equals(pidgey.getNome())) {
				pidgeyPresente = true;
			}
			if (p.getNome().equals(pikachu.getNome())) {
				pikachuPresente = true;
			}
		}

		/* Prima aggiungiamo Pidgey se non è presente */
		if (!pidgeyPresente) {
			pokemonCPU.add(pidgey);
		} 
		
		/* Pikachu viene aggiunto solo **nella lotta successiva**, se Pidgey è già presente */
		else if (!pikachuPresente) {
			pokemonCPU.add(pikachu);
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
        
        for (Pokemon i : pokemonUtente) {
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
            
            if(attaccante.esausto()) chiudiButton.setEnabled(false);
            
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
            
            if (i.equals(attaccante) || i.esausto()) {
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
                	
                	attaccante = i;
                    labelPokemonAtt.setText(i.getNome());
                    listaMosseUtente = i.getMosse();
                    livelloPokemonAtt.setText("Liv " + i.getLivello());

                    /* Crea i nuovi pulsanti delle mosse */
                    for (Mossa m : listaMosseUtente) {
                        JButton mossa = creaPulsanteMossa();
                        mossa.setText(m.getNomeMossa());
                        panelAreaMosse.add(mossa);
                    }
                     
                    mostraMessaggio("Coraggio " + i.getNome() + " SCELGO TE!");
                    aggiornaHealthBar(healthBarAtt, (int) i.getHp(), (int) i.getHpMax());
                    
                    aggiornaStatoPulsanti(); 
                    
                    panelAreaMosse.revalidate();
                    panelAreaMosse.repaint();
                }
            });
            
            panelCambiaPokemon.add(pokemonButton);
            y += 55; /* Sposta i pulsanti in basso */
            
			/* Verifico se tutti i pokemon dell'utente sono esausti */
            if (pokemonUtente.stream().allMatch(Pokemon::esausto)) {
				mostraMessaggio("Tutti i tuoi Pokémon sono esausti.");
                next.setEnabled(false);
                chiudiButton.setEnabled(false);
                
				for(Pokemon pokemon:pokemonCPU){
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
	private void avviaTimerSingleTask(int delay, Runnable task) {
        Timer timer = new Timer(delay, e -> task.run());
        timer.setRepeats(false);
        timer.start();
    }
	
	/**
	 * Metodo per far partire due timer con due compiti da svolgere dopo un certo ritardo
	 * @param delay; il ritardo impostato
	 * @param task; la prima task da eseguire
	 * @param task2; la seconda task da eseguire
	 */
	private void avviaTimerDoubleTask(int delay, Runnable task, Runnable task2){
		Timer timer = new Timer(delay, e -> task.run());
		timer.setRepeats(false);
		timer.start();
		Timer timer2 = new Timer(delay, e -> task2.run());
		timer2.setRepeats(false);
		timer2.start();
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
		return interoCasuale.nextInt(pokemonCPU.size());
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
                for (Pokemon p : pokemonUtente) {
                    if (btn.getText().equals(p.getNome())) {
                        btn.setEnabled(!(p.equals(attaccante) || p.esausto()));
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
    	for (Pokemon p : pokemonCPU) {
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
}

