package fr.iutvalence.java.tp.tilepuzzle.interfaces;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import fr.iutvalence.java.tp.tilepuzzle.Joueur;
import fr.iutvalence.java.tp.tilepuzzle.Plateau;
import fr.iutvalence.java.tp.tilepuzzle.Position;
import fr.iutvalence.java.tp.tilepuzzle.ihm.BarreDeMenuTilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.ihm.JButtonTilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.ihm.JPanelPlateau;

/**
 * Gere l'affichage graphique
 */
public class TacheDAffichageTilePuzzle implements VueTilePuzzle, Runnable, ActionListener, Joueur
{
	/**
	 * La fenêtre
	 */
	public JFrame fenetre;
	
	/**
	 * L'Affichage du plateau
	 */
	private JPanelPlateau jPanelPlateau;
	
	/**
	 * La dernière position cliquée
	 */
	private Position position;
	
	/**
	 * Si la position a été changée
	 */
	private boolean positionChangee;
	
	/**
	 * Création de la tâche d'affichage du TilePuzzle
	 */
	public TacheDAffichageTilePuzzle()
	{
		this.jPanelPlateau = new JPanelPlateau(this);
	}

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
		this.fenetre.setLocationRelativeTo(null);
		this.fenetre.setTitle("Tile Puzzle");
		this.fenetre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.fenetre.setJMenuBar(new BarreDeMenuTilePuzzle(this.fenetre));
		this.fenetre.setResizable(false);
		
		this.fenetre.getContentPane().add(this.jPanelPlateau);
		
		this.fenetre.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() instanceof JButtonTilePuzzle)
		{
			JButtonTilePuzzle source = (JButtonTilePuzzle) e.getSource();
			this.position = source.obtenirPosition();
			this.positionChangee = true;
		}
	}

	@Override
	public Position getPosition(int hauteurPlateau, int largeurPlateau)
	{
		this.positionChangee = false;
		while (!this.positionChangee)
		{
			try
			{
				Thread.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		return this.position;
	}

	@Override
	public void afficherPartieGagnee()
	{
		//TODO Proposer une nouvelle partie
		this.fenetre.dispose();
		
		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		JFrame partieGagnee = new JFrame();
		partieGagnee.setSize(600, 623);
		partieGagnee.setLocationRelativeTo(null);
		partieGagnee.setTitle("Tile Puzzle");
		partieGagnee.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		partieGagnee.setResizable(false);
		
		JPanel p = new JPanel();
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(new JLabel("Non, ce n'était pas un bug... Bravo !"));
		
		partieGagnee.getContentPane().add(p);
		
		partieGagnee.setVisible(true);
	}
}