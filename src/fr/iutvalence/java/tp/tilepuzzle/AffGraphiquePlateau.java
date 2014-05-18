package fr.iutvalence.java.tp.tilepuzzle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author augsburs
 * Gestion de l'affichage d'un plateau de TilePuzzle
 */
@SuppressWarnings("serial")
public class AffGraphiquePlateau extends JPanel implements ActionListener
{
	/**
	 * La fenêtre
	 */
	private JFrame fenetre;
	
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
	 * Création de l'affichage d'un plateau
	 * @param fenetre Fenêtre à laquelle l'affichage du plateau est associé
	 * @param plateau Plateau à afficher
	 */
	public AffGraphiquePlateau(JFrame fenetre, Plateau plateau)
	{
		this.fenetre = fenetre;
		this.plateau = plateau;
		this.hauteur = this.plateau.obtenirHauteur();
		this.largeur = this.plateau.obtenirLargeur();

		this.initBoutonsPlateau();
	}
	
	/**
	 * Initialisation des boutons du plateau
	 */
	private void initBoutonsPlateau()
	{
		this.setLayout(new GridLayout(this.hauteur, this.largeur));

		for (int i = 0; i < this.largeur*this.hauteur; i++)
		{
			JButton bouton = new JButton("");
			bouton.setFocusable(false);
			bouton.addActionListener(this);
			bouton.setToolTipText("Cliquez moi !");
			this.add(bouton);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO
	}
}