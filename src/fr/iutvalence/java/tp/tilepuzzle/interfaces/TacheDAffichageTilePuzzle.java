package fr.iutvalence.java.tp.tilepuzzle.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import fr.iutvalence.java.tp.tilepuzzle.Plateau;
import fr.iutvalence.java.tp.tilepuzzle.TilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.ihm.BarreDeMenuTilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.ihm.JButtonTilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.ihm.JPanelPlateau;

/**
 * Gere l'affichage graphique
 */
public class TacheDAffichageTilePuzzle implements VueTilePuzzle, Runnable, ActionListener
{
	/**
	 * La fenêtre
	 */
	public JFrame fenetre;
	
	/**
	 * L'Affichage du plateau
	 */
	private JPanelPlateau jPanelPlateau = new JPanelPlateau(this);

	/**
	 * Le contrôleur
	 */
	private ControleTilePuzzle controleur;

	@Override
	public void initialiserAffichagePlateau(Plateau plateau)
	{
		this.jPanelPlateau.initialiserAffichagePlateau(plateau);
	}

	@Override
	public void mettreAJourPlateau(Plateau plateau)
	{
		this.jPanelPlateau.mettreAJour(plateau);
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
		this.fenetre.setSize(600, 623);
		this.fenetre.setTitle("Tile Puzzle");
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetre.setJMenuBar(new BarreDeMenuTilePuzzle(this.fenetre));
		this.fenetre.setResizable(false);
		
		this.fenetre.getContentPane().add(this.jPanelPlateau);
		
		this.fenetre.setVisible(true);
	}

	/**
	 * Associer un contrôleur
	 * @param controleur le contrôleur à associer
	 */
	public void associerControleur(ControleTilePuzzle controleur)
	{
		this.controleur = controleur;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof JButtonTilePuzzle)
		{
			JButtonTilePuzzle source = (JButtonTilePuzzle) e.getSource();
			this.controleur.inverserCasesAutourDe(source.obtenirPosition());
		}
	}
}