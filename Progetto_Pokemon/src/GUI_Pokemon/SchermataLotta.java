package GUI_Pokemon;

import Lotta_Pokemon.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SchermataLotta extends JPanel{
	
	private List<Pokemon> pokemonUtente;
	private List<Pokemon> pokemonCPU;
	
	private ImageIcon sfondo;
	private JLabel labelSfondo;
	
	private Pokemon attaccante;
	private Pokemon difensore;
	
	private JProgressBar healthBarAtt;
	private JProgressBar healthBarDif;

	private Border bordoHealthBar;
	
	private JPanel areaPokemonAtt;
		private JLabel labelPokemonAtt;
		private JLabel livelloPokemonAtt;
	
	private JPanel areaPokemonDif;
		private JLabel labelPokemonDif;
		private JLabel livelloPokemonDif;
	
	private JPanel areaMessaggi;
		private JTextArea testoMessaggi;
		private JButton next;
	
	private JPanel areaMosse;
		
		private List<Mossa> listaMosseUtente;
		private JButton mosse;
			private JButton mossa1;
			private JButton mossa2;
			private JButton mossa3;
			private JButton mossa4;
		
		private JPanel panelCambiaPokemon;
		private JButton buttonCambiaPokemon;
		
		private JButton borsa;
	
		
	private List<Mossa> listaMosseCPU;
	
	SchermataLotta(List<Pokemon> pokemonUtente, List<Pokemon> pokemonCPU){
		
		this.pokemonUtente = pokemonUtente;
		this.pokemonCPU = pokemonCPU;
		
		setLayout(null);
		setBackground(Color.GRAY);
		
		if (!pokemonUtente.isEmpty() && !pokemonCPU.isEmpty()) {
	        this.attaccante = pokemonUtente.get(0);  // Primo Pokémon dell'utente
	        this.difensore = pokemonCPU.get(0);  // Primo Pokémon della CPU
	    } else {
	        System.out.println("Errore: Le liste dei Pokémon sono vuote!");
    	}
		
		listaMosseCPU = difensore.getMosse(); // Setting delle mosse del primo pokemon avversario
		
		bordoHealthBar = new LineBorder(Color.BLACK); // Bordo delle healthBar
		
		// Sfondo pannello
		
		sfondo = new ImageIcon("C:/Users/megam/OneDrive/Desktop/sfondo lotta ridimensionato.jpg/");
		Image sfondoscalato = sfondo.getImage();
		labelSfondo = new JLabel(new ImageIcon(sfondoscalato));
		labelSfondo.setBounds(0,0,1000,600);
		add(labelSfondo);
		
		// HealthBar Cpu
		
		healthBarDif = new JProgressBar(0, 100);
		aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
		healthBarDif.setStringPainted(true); // Mostra il valore numerico
      
		healthBarDif.setForeground(Color.GREEN);
		healthBarDif.setBorder(bordoHealthBar);
		
		healthBarDif.setBackground(Color.WHITE);
		healthBarDif.setBounds(750, 110, 200, 20);
	
		add(healthBarDif);
		
		// HealthBar Utente
		
		healthBarAtt = new JProgressBar(0, 100);
		aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
		healthBarAtt.setStringPainted(true); // Mostra il valore numerico
        
		healthBarAtt.setForeground(Color.GREEN);
		healthBarAtt.setBorder(bordoHealthBar);
        
		healthBarAtt.setBackground(Color.WHITE);
		healthBarAtt.setBounds(30, 420, 200, 20);
		
		add(healthBarAtt);
		
		// Pokemon utente
        
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
        
        // Pokemon CPU
        
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
        
        // Area messaggi durante la lotta
        
        areaMessaggi = new JPanel();
        areaMessaggi.setBackground(Color.BLACK);
        areaMessaggi.setBounds(570, 450, 400, 100);
        areaMessaggi.setBorder(new LineBorder(Color.WHITE, 3));
        areaMessaggi.setLayout(null);
        
        	// Testo Messaggi
        	
	        testoMessaggi = new JTextArea();
	        testoMessaggi.setEditable(false); // L'utente non può scrivere
	        testoMessaggi.setWrapStyleWord(true); // Mantiene parole intere quando va a capo
	        testoMessaggi.setBackground(Color.BLACK);
	        testoMessaggi.setForeground(Color.WHITE);
	        testoMessaggi.setFont(new Font("Arial", Font.BOLD, 12));
	        testoMessaggi.setText("INIZIA LA LOTTA!");
	        testoMessaggi.setBounds(80, 40, 300, 30);
	       
        areaMessaggi.add(testoMessaggi);
        add(areaMessaggi);
        
        // Panel area mosse
        
        Border bordoAreaMosse = new LineBorder(Color.BLACK, 3);
        areaMosse = new JPanel();
        areaMosse.setBackground(Color.GRAY);
        areaMosse.setBounds(20, 20, 400, 300);
        areaMosse.setBorder(bordoAreaMosse);
        
        areaMosse.setLayout(null);
        
        	// Pulsante Mosse
        	
        	listaMosseUtente = attaccante.getMosse();
        
        	Border bordoMosse = new LineBorder(Color.WHITE, 3);
        	mosse = new JButton("Mosse");
        	mosse.setBackground(Color.RED);
        	mosse.setForeground(Color.WHITE);
        	mosse.setFont(new Font("Arial", Font.BOLD, 18));
        	mosse.setBorder(bordoMosse);
        	mosse.setBounds(15, 140, 370, 80);
        	
        	// Pulsanti delle mosse (inizialmente nascosti)
            mossa1 = creaPulsanteMossa();
            mossa2 = creaPulsanteMossa();
            mossa3 = creaPulsanteMossa();
            mossa4 = creaPulsanteMossa();

            // Posizioni nei quattro angoli
            mossa1.setBounds(10, 30, 180, 60);   // Alto sinistra
            mossa2.setBounds(200, 30, 180, 60);  // Alto destra
            mossa3.setBounds(10, 110, 180, 60);  // Basso sinistra
            mossa4.setBounds(200, 110, 180, 60); // Basso destra

            JButton[] pulsantiMosse = {mossa1, mossa2, mossa3, mossa4};
            
            for (JButton pulsante : pulsantiMosse) {
                pulsante.setVisible(false); // Inizialmente nascosti
                areaMosse.add(pulsante);
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

                                // Controllo la velocità dei pokemon per stabilire chi attacca per primo
                                if (attaccante.getVelocitàPokemon() >= difensore.getVelocitàPokemon()) {
                                    
                                	// Primo attacco: attaccante
                                	attaccante.usaMossa(difensore, listaMosseUtente.get(index));
                                	mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
                                	
                                	if(listaMosseUtente.get(index).getColpito() == false) {
                                		Timer timer = new Timer(2000, new ActionListener() {											
											@Override
											public void actionPerformed(ActionEvent e) {
												mostraMessaggio(difensore.getNome() +  " evita l'attacco");
											}
										});
                                		
                                		timer.setRepeats(false);
                                		timer.start();
                                	}
                                	
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
                                	
	                                    // Controllo KO CPU
	                                    if (difensore.esausto()) {
	                                  
	                                    	aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
	                                    	attaccante.setXp(attaccante.getXp() + difensore.getLivello()+5);
	                                    	
	                                    	Timer timerEsausto = new Timer(3000, new ActionListener() {
												@Override
												public void actionPerformed(ActionEvent e) {	
													mostraMessaggio(difensore.getNome() + " avversario " + " è esausto!");
													next.setEnabled(true);
												}
											});
	                                    	
	                                    	timerEsausto.setRepeats(false); // Il timer scatta solo una volta
	                                    	timerEsausto.start();
	                                    	
		                                    	// Controllo se l'attaccante è salito di livello
		                                    	if(attaccante.saliDiLivello()) {
		                                    		Timer timerLivello = new Timer(4000, new ActionListener() {
														@Override
														public void actionPerformed(ActionEvent e) {
															mostraMessaggio(attaccante.getNome() + "è salito di livello, ora è al " + attaccante.getLivello());
															livelloPokemonAtt.setText("Liv " + attaccante.getLivello());
														}
													});
		                                    		
		                                    		timerLivello.setRepeats(false); 
		                                            timerLivello.start();
		                                            
		                                    	}
	                                    	
	                                    	return;
	                                    }
	                                    
	                                    aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
	                                    next.setEnabled(true);
	                                    
	                                    // Dopo un piccolo ritardo, attacca la CPU
	                                    Timer timer = new Timer(3000, new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) { 
												SwingUtilities.invokeLater(() -> {
			                                        
													next.setEnabled(false);
													
			                                    	int indiceMossaCPU = attaccoCasuale(); // Salva l'indice della mossa
			                                    	Mossa mossaCPU = listaMosseCPU.get(indiceMossaCPU); // Recupera la mossa scelta
			                                    	
			                                    	difensore.usaMossa(attaccante, mossaCPU);
			                                        mostraMessaggio(difensore.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());
			                                        
			                                        if(mossaCPU.getColpito() == false) {
			                                    		Timer timer = new Timer(4000, new ActionListener() {											
			    											@Override
			    											public void actionPerformed(ActionEvent e) {
			    												mostraMessaggio(attaccante.getNome() +  " evita l'attacco");
			    											}
			    										});
			                                    		
			                                    		timer.setRepeats(false);
			                                    		timer.start();
			                                    	}
			                                        
			                                        Timer timerDif = new Timer(4000, new ActionListener() {
														
														@Override
														public void actionPerformed(ActionEvent e) {
															if(mossaCPU.getModificatore() > 1) {
																mostraMessaggio("è superefficace");
															}else if(mossaCPU.getModificatore() < 1) {
																mostraMessaggio("non è molto efficace...");
															}
														}
													});
			                                     
				                                     timerDif.setRepeats(false);
				                                     timerDif.start();
			                                        
			                                        // Controllo KO utente dopo il contrattacco
			                                        if (attaccante.esausto()) {
			                                        	
			                                        	aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());                                      
			                                        	difensore.setXp(difensore.getXp() + attaccante.getLivello()+5);
			                                        	
			                                        	for (int i = 0; i < listaMosseUtente.size(); i++) {
			    											pulsantiMosse[i].setVisible(false);
			    										}
			                                        	areaMosse.setVisible(false);
			                                        	mosse.setVisible(false);
														next.setEnabled(false);
			                                        	
														Timer timerEsaustoDif = new Timer(5000, new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																mostraMessaggio(attaccante.getNome() + " è esausto!");
					                                        	cambiaPokemonUtente(); 
					                                        	for (JButton pulsante : pulsantiMosse) {
					                                                pulsante.setEnabled(true);
					                                            }
															}
														});
														
														timerEsaustoDif.setRepeats(false); // Il timer scatta solo una volta
			                                            timerEsaustoDif.start();	
														
														// Controllo se il pokemon è salito di livello
			                                        	if(difensore.saliDiLivello()) {
			                                        		Timer timerLivelloDif = new Timer(6000, new ActionListener() {
			    												@Override
			    												public void actionPerformed(ActionEvent e) {
			    													mostraMessaggio(difensore.getNome() + " avversario " + "è salito di livello, ora è al " + attaccante.getLivello());
			    													livelloPokemonDif.setText("Liv " + difensore.getLivello());
			    												}
			    											});
			                                        		timerLivelloDif.setRepeats(false); // Il timer scatta solo una volta
			                                                timerLivelloDif.start();
			                                                
			                                        	}
		                                        	return;
			                                        }
			                                        aggiornaHealthBar(healthBarAtt, (int)attaccante.getHp(), (int)attaccante.getHpMax());
			                                        next.setEnabled(true);
			                                    });
											}
										}); 
                                
	                                    timer.setRepeats(false); // Esegui solo una volta
	                                    timer.start();
	                                    
                                } else {
                                   
                                	// Se la CPU è più veloce, attacca per prima
                                	
                                	next.setEnabled(false);
                                	
                                	int indiceMossaCPU = attaccoCasuale(); // Salva l'indice della mossa
                                	Mossa mossaCPU = listaMosseCPU.get(indiceMossaCPU); // Recupera la mossa scelta
                                	
                                	difensore.usaMossa(attaccante, mossaCPU);
                                    mostraMessaggio(difensore.getNome() + " avversario " + " usa " + mossaCPU.getNomeMossa());
                                    
                                    if(mossaCPU.getColpito() == false) {
                                		Timer timer = new Timer(2000, new ActionListener() {											
											@Override
											public void actionPerformed(ActionEvent e) {
												mostraMessaggio(attaccante.getNome() +  " evita l'attacco");
											}
										});
                                		
                                		timer.setRepeats(false);
                                		timer.start();
                                	}
                                    
                                    Timer timerDif = new Timer(2000, new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											if(mossaCPU.getModificatore() > 1) {
												mostraMessaggio("è superefficace");
											}else if(mossaCPU.getModificatore() < 1) {
												mostraMessaggio("non è molto efficace...");
											}
										}
									});
                                 
                                    timerDif.setRepeats(false);
                                    timerDif.start();
                                    
                                    // Controllo KO utente
                                    if (attaccante.esausto()) {
                                    	
                                    	difensore.setXp(difensore.getXp() + attaccante.getLivello()+5);

                                    	for (int i = 0; i < listaMosseUtente.size(); i++) {
											pulsantiMosse[i].setVisible(false);
										}
                                    	
                                    	aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
										areaMosse.setVisible(false);
										next.setEnabled(false);	
                                    	
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
										
										timerEsaustoDif.setRepeats(false); // Il timer scatta solo una volta
	                                	timerEsaustoDif.start();
										
											// Controllo se il pokemon è salito di livello
	                                    	if(difensore.saliDiLivello()) {
	                                    		Timer timerLivelloDif = new Timer(4000, new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														mostraMessaggio(difensore.getNome() + " avversario " + "è salito di livello, ora è al " + attaccante.getLivello());
														livelloPokemonDif.setText("Liv " + difensore.getLivello());
													}
												});
	                                    		timerLivelloDif.setRepeats(false); // Il timer scatta solo una volta
	                                            timerLivelloDif.start();
	                                            
	                                    	}
                                	return;
                                    }
                                    
                                    aggiornaHealthBar(healthBarAtt, (int) attaccante.getHp(), (int) attaccante.getHpMax());
                                    next.setEnabled(true);
                                    
                                    
                                    // Dopo un piccolo ritardo, attacca il giocatore
                                    Timer timer = new Timer(3000, new ActionListener() {
										@Override
										public void actionPerformed(ActionEvent e) {
											SwingUtilities.invokeLater(() -> {
		                                    	
												attaccante.usaMossa(difensore, listaMosseUtente.get(index));
		                                    	mostraMessaggio(attaccante.getNome() + " usa " + listaMosseUtente.get(index).getNomeMossa());
		                                    	
		                                    	if(listaMosseUtente.get(index).getColpito() == false) {
		                                    		Timer timer = new Timer(4000, new ActionListener() {											
		    											@Override
		    											public void actionPerformed(ActionEvent e) {
		    												mostraMessaggio(difensore.getNome() +  " evita l'attacco");
		    											}
		    										});
		                                    		
		                                    		timer.setRepeats(false);
		                                    		timer.start();
		                                    	}
		                                    	
		                                    	 Timer timerAtt = new Timer(4000, new ActionListener() {
		    											
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
		                                    	
		                                        // Controllo KO CPU
		                                        if (difensore.esausto()) {
		                                       		                                        	
		                                        	aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
		                                        	attaccante.setXp(attaccante.getXp() + difensore.getLivello()+5);
		                                        	
		                                        	Timer timerEsausto = new Timer(5000, new ActionListener() {
		    											@Override
		    											public void actionPerformed(ActionEvent e) {	
		    												mostraMessaggio(difensore.getNome() + " avversario " + " è esausto!");
		    												next.setEnabled(true);
		    											}
		    										});
		                                        	
		                                        	timerEsausto.setRepeats(false); // Il timer scatta solo una volta
		                                        	timerEsausto.start();
		                                        	
			                                        	// Controllo se il pokemon è salito di livello
			                                        	if(attaccante.saliDiLivello()) {
			                                        		Timer timerLivello = new Timer(6000, new ActionListener() {
			    												@Override
			    												public void actionPerformed(ActionEvent e) {
			    													mostraMessaggio(attaccante.getNome() + "è salito di livello, ora è al " + attaccante.getLivello());
			    													livelloPokemonAtt.setText("Liv " + attaccante.getLivello());
			    												}
			    											});
			                                        		timerLivello.setRepeats(false); // Il timer scatta solo una volta
			                                                timerLivello.start();
			                                                
			                                        	}
	                                        	return;
		                                        }
		                                        aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
		                                        next.setEnabled(true);
		                                    });
										}
									});
                                    
                                    timer.setRepeats(false);
                                    timer.start();
                                    
                                }
                            }
                        });
                    }
                }
                
            });
            
        	areaMosse.add(mosse);
        	
        	// Pulsante next
	        
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
						cambiaPokemonCPU();
						next.setEnabled(false);
					}
					for (JButton pulsante : pulsantiMosse) {
                        pulsante.setEnabled(true);
                    }
				}
			});
	    	
	    	areaMessaggi.add(next);
        	
        	// Pulsante borsa
        	
        	Border bordoBorsa = new LineBorder(Color.WHITE, 3);
        	borsa = new JButton("Borsa");
        	borsa.setBackground(Color.ORANGE);
        	borsa.setForeground(Color.WHITE);
        	borsa.setFont(new Font("Arial", Font.BOLD, 14));
        	borsa.setBorder(bordoBorsa);
        	borsa.setBounds(220, 230, 165, 50);
        	
        	areaMosse.add(borsa);
        	
        	// Pannello cambio Pokemon
        	
			 panelCambiaPokemon = new JPanel();
		     Border bordoCambioPokemon = new LineBorder(Color.WHITE, 3);
		     panelCambiaPokemon.setBackground(Color.GRAY);
		     panelCambiaPokemon.setForeground(Color.WHITE);
		     panelCambiaPokemon.setBorder(bordoCambioPokemon);
		     panelCambiaPokemon.setBounds(20, 20, 400, 300);
		     panelCambiaPokemon.setVisible(false);
		     panelCambiaPokemon.setLayout(null);
		    
		     add(panelCambiaPokemon);
        	
        	// Pulsante cambia Pokemon
        	
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
    				cambiaPokemonUtente();
    			}
    		});
        	
        	areaMosse.add(buttonCambiaPokemon);
        	
        	add(areaMosse);
  
        setComponentZOrder(labelSfondo, getComponentCount() - 1);
              
	}
	
	// Metodo per mostrare a piacimento un qualsiasi messaggio nell'area predisposta
	public void mostraMessaggio(String messaggio) {
	    testoMessaggi.setText(messaggio);
	}
	
	// Metodo per creare un pulsante mossa con lo stile desiderato
    private JButton creaPulsanteMossa() {
        JButton button = new JButton();
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBorder(new LineBorder(Color.WHITE, 3));
        return button;
    }
	
    // Metodo per cambiare automaticamente i pokemon della CPU
    public void cambiaPokemonCPU() {
        
    	// Controllo se ci sono Pokémon ancora disponibili nella lista
        if (!pokemonCPU.isEmpty()) {
            
        	// Se il difensore è esausto, rimuovilo dalla lista e scegli il prossimo
            pokemonCPU.remove(difensore); 
            
            if (!pokemonCPU.isEmpty()) {
                
            	difensore = pokemonCPU.get(0); // Il nuovo Pokémon entra in campo
                listaMosseCPU = difensore.getMosse();
                mostraMessaggio("La CPU manda in campo " + difensore.getNome());
                // Aggiorna l'interfaccia grafica
                aggiornaHealthBar(healthBarDif, (int) difensore.getHp(), (int) difensore.getHpMax());
                labelPokemonDif.setText(difensore.getNome()); 
                livelloPokemonDif.setText("Liv " + difensore.getLivello());
            
            } else {
                
            	Timer timer = new Timer(2000, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						mostraMessaggio("L'avversario non ha più Pokémon disponibili!");
						mostraMessaggio("HAI VINTO !");				
					}
				});
            
        	timer.setRepeats(false); // Il timer scatta solo una volta
        	timer.start();
            
            }
        }
    }
    
    // Metodo per permettere la sotituzione di un pokemon quando si desidera
    public void cambiaPokemonUtente() {

    	borsa.setVisible(false);
		mosse.setVisible(false);
		buttonCambiaPokemon.setVisible(false);
    	panelCambiaPokemon.setVisible(true);
    	
    	Border bordoPokemonCambiati = new LineBorder(Color.BLACK, 3);

        int x = 20;
        int y = 12;
        
        panelCambiaPokemon.removeAll(); // Rimuove tutti i componenti precedenti
        panelCambiaPokemon.revalidate();
        panelCambiaPokemon.repaint();
        
        for (Pokemon i : pokemonUtente) {
        	JButton pokemonButton = new JButton(i.getNome());
            pokemonButton.setForeground(Color.WHITE);
            pokemonButton.setBackground(Color.ORANGE);
            pokemonButton.setBorder(bordoPokemonCambiati);
            pokemonButton.setBounds(x, y, 100, 50);
            pokemonButton.setVisible(true);
            
            // Pulsante per chiudere il pannello di cambio Pokémon
            JButton chiudiButton = new JButton("Chiudi");
            chiudiButton.setForeground(Color.WHITE);
            chiudiButton.setBackground(Color.RED);
            chiudiButton.setBorder(new LineBorder(Color.BLACK, 3));
            chiudiButton.setBounds(250, 230, 120, 50);
            chiudiButton.setVisible(true);

            chiudiButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panelCambiaPokemon.setVisible(false);
                    mosse.setVisible(true);
                    borsa.setVisible(true);
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
                    attaccante = i;
                    labelPokemonAtt.setText(i.getNome());
                    listaMosseUtente = i.getMosse();
                    livelloPokemonAtt.setText("Liv " + i.getLivello());

                    // Crea i nuovi pulsanti delle mosse
                    for (Mossa m : listaMosseUtente) {
                        JButton mossa = creaPulsanteMossa();
                        mossa.setText(m.getNomeMossa());
                        areaMosse.add(mossa);
                    }
                    
                    mostraMessaggio("Coraggio " + i.getNome() + " scelgo te!");
                    aggiornaHealthBar(healthBarAtt, (int) i.getHp(), (int) i.getHpMax());
                    panelCambiaPokemon.setVisible(false);
                    buttonCambiaPokemon.setVisible(true);
                    areaMosse.setVisible(true);
                    mosse.setVisible(true);
                    next.setEnabled(false);
                    borsa.setVisible(true);
                    
                    aggiornaStatoPulsanti(); 
                    
                    areaMosse.revalidate();
                    areaMosse.repaint();
                }
            });
            
            panelCambiaPokemon.add(pokemonButton);
            y += 80; // Sposta i pulsanti in basso
            
            if (pokemonUtente.stream().allMatch(Pokemon::esausto)) {
                mostraMessaggio("Hai perso la lotta! Tutti i tuoi Pokémon sono esausti.");
                next.setEnabled(false);
            }
            
        }
        
        // Rinfresca il pannello dopo le modifiche
        panelCambiaPokemon.revalidate();
        panelCambiaPokemon.repaint();   
    }

    // Metodo per far attaccare il pokemon della CPU con una mossa a scelta tra quelle disponibili
    public int attaccoCasuale() {
    	Random interoCasuale = new Random(); 
		return interoCasuale.nextInt(3);
	}
    
    // Metodo per aggiornare le barre di salute dei pokemon quando necessario
    public void aggiornaHealthBar(JProgressBar healthBar, int hp, int hpMax) {
    	int percentuale = (int) ((hp / (double) hpMax) * 100);
    	
    	healthBar.setValue(percentuale);
    	healthBar.setString(hp + " / " + hpMax + " HP"); // Mostra i PV numerici
    	
    	if (percentuale > 70) {
    		healthBar.setForeground(Color.GREEN);
        } else if (percentuale > 20) {
        	healthBar.setForeground(Color.ORANGE);
        } else {
        	healthBar.setForeground(Color.RED);
        }
    }
    
    // Metodo per aggiornare lo stato dei pulsanti in maniera dinamica 
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
    
}

