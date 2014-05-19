package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * @author augsburs
 * Gestion de l'affichage d'un plateau de TilePuzzle
 */
@SuppressWarnings("serial")
public class JPanelPlateau extends JPanel implements ActionListener
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
	 * Si la première initialisation du plateau a été faite
	 */
	private boolean initialise = false;
	
	/**
	 * Affichage du plateau initial
	 */
	public JPanelPlateau()
	{
		this.initJPanel();
	}
	
	/**
	 * Initialisation des boutons du plateau
	 */
	private void initBoutonsPlateau()
	{
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
				boutonCourant.addActionListener(this);
				boutonCourant.setToolTipText("Cliquez moi !");
				this.add(boutonCourant);
			}
	}

	/**
	 * Mettre à jour l'affichage du plateau
	 * @param plateau le nouveau plateau à mettre à jour
	 */
	public void mettreAJour(Plateau plateau)
	{
		if (this.initialise == false)
		{
			this.plateau = plateau;
			this.hauteur = this.plateau.obtenirHauteur();
			this.largeur = this.plateau.obtenirLargeur();
			this.setLayout(new GridLayout(this.hauteur, this.largeur));
			
			this.initBoutonsPlateau();
			this.initialise = true;
		}
		else
		{
			this.removeAll();
			this.initBoutonsPlateau();
			this.revalidate();
		}
	}
	
	/**
	 * Initialisation du JPanel
	 */
	private void initJPanel()
	{
		this.setEnabled(false);
		this.setBorder(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO
	}
}