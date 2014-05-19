package fr.iutvalence.java.tp.tilepuzzle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Gere l'affichage graphique
 */
public class AffichageGraphique implements Affichage, Runnable
{
	/**
	 * La fenêtre
	 */
	public JFrame fenetre;
	
	/**
	 * L'Affichage du plateau
	 */
	private JPanelPlateau jPanelPlateau = new JPanelPlateau();

	@Override
	public void afficherPlateau(Plateau plateau)
	{
		this.run();
		this.jPanelPlateau.mettreAJour(plateau);
	}

	@Override
	public void afficherDemandePosition()
	{
		System.out.println("DEMANDE POSITION");
		//TODO
	}
	
	@Override
	public void run()
	{
		this.initInterfaceGraphique();
	}

	/**
	 * Initialisation de la fenêtre
	 */
	private void initInterfaceGraphique()
	{
		this.fenetre = new JFrame();
		this.fenetre.setSize(600, 600);
		this.fenetre.setTitle("Tile Puzzle");
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetre.setJMenuBar(new BarreDeMenuTilePuzzle(this.fenetre));
		this.fenetre.setResizable(false);
		
		this.fenetre.getContentPane().add(this.jPanelPlateau);
		
		this.fenetre.setVisible(true);
	}
}