package fr.iutvalence.java.tp.tilepuzzle.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import fr.iutvalence.java.tp.tilepuzzle.Plateau;
import fr.iutvalence.java.tp.tilepuzzle.Position;

/**
 * @author augsburs
 * Gestion de l'affichage d'un plateau de TilePuzzle
 */
@SuppressWarnings("serial")
public class JPanelPlateau extends JPanel
{
	
	/**
	 * Le plateau à afficher
	 */
	private Plateau plateau;
	
	/**
	 * La hauteur du plateau
	 */
	private int hauteur;
	
	/**
	 * La largeur du plateau
	 */
	private int largeur;

	/**
	 * L'auditeur des boutons du plateau
	 */
	private ActionListener auditeurBoutons;
	
	/**
	 * Affichage du plateau initial
	 * @param auditeurBoutons L'auditeur des boutons du plateau
	 */
	public JPanelPlateau(ActionListener auditeurBoutons)
	{
		this.auditeurBoutons = auditeurBoutons;
		this.initJPanel();
	}
	
	/**
	 * Initialisation des boutons du plateau
	 */
	private void initBoutonsPlateau()
	{
		this.removeAll();
		for (int ligne = 0; ligne < this.hauteur; ligne++)
			for (int colonne = 0; colonne < this.largeur; colonne++)
			{
				Position p = new Position(ligne, colonne);
				JButtonTilePuzzle boutonCourant;
				
				if (this.plateau.estCaseAllumee(p))
					boutonCourant = new JButtonTilePuzzle(p, true);
				else
					boutonCourant = new JButtonTilePuzzle(p, false);
				
				boutonCourant.setFocusable(false);
				boutonCourant.addActionListener(this.auditeurBoutons);
				boutonCourant.setToolTipText("Cliquez moi !");
				this.add(boutonCourant);
			}
		this.repaint();
		this.revalidate();
	}

	/**
	 * Mettre à jour l'affichage du plateau
	 * @param plateau le nouveau plateau à mettre à jour
	 */
	public void mettreAJour(Plateau plateau)
	{
		this.removeAll();
		this.initBoutonsPlateau();
		this.repaint();
		this.revalidate();
	}
	
	/**
	 * Initialisation de l'affichage du plateau
	 * @param plateau le plateau à afficher pour la première fois
	 */
	public void initialiserAffichagePlateau(Plateau plateau)
	{
		this.plateau = plateau;
		this.hauteur = this.plateau.obtenirHauteur();
		this.largeur = this.plateau.obtenirLargeur();
		this.setLayout(new GridLayout(this.hauteur, this.largeur));
		
		this.initBoutonsPlateau();
	}
	
	/**
	 * Initialisation du JPanel
	 */
	private void initJPanel()
	{
		this.setEnabled(false);
		this.setBorder(null);
	}
}