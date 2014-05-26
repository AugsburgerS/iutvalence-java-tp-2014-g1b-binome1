package fr.iutvalence.java.tp.tilepuzzle.ihm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author augsburs
 * Barre de menu du Tile Puzzle
 */
@SuppressWarnings("serial")
public class BarreDeMenuTilePuzzle extends JMenuBar implements ActionListener, ChangeListener
{
	/**
	 * La fenêtre
	 */
	private JFrame fenetre;
	
	/**
	 * L'item de menu "A propos"
	 */
	private JMenuItem menuItemAPropos;

	/**
	 * L'item de menu "Fermer"
	 */
	private JMenuItem menuItemQuitter;

	/**
	 * L'item de menu "Nouvelle partie"
	 */
	private JMenuItem menuItemNouvellePartie;

	/**
	 * L'item de menu "Réinitialiser"
	 */
	private JMenuItem menuItemReinitialiser;

	/**
	 * Le panneau de choix des paramètres par l'utilisateur
	 */
	private JPanel panneauChoixParametres;
	
	/**
	 * Création de la barre de menu
	 * @param fenetre La fenêtre à laquelle est associé le menu
	 */
	public BarreDeMenuTilePuzzle(JFrame fenetre)
	{
		this.fenetre = fenetre;

		JMenu menu = new JMenu("Menu");
		JMenu partie = new JMenu("Partie");

		this.menuItemAPropos = new JMenuItem("A propos");
		this.menuItemAPropos.addActionListener(this);

		this.menuItemQuitter = new JMenuItem("Quitter");
		this.menuItemQuitter.addActionListener(this);

		this.menuItemNouvellePartie = new JMenuItem("Nouvelle partie");
		this.menuItemNouvellePartie.addActionListener(this);
	
		this.menuItemReinitialiser = new JMenuItem("Réinitialiser");
		this.menuItemReinitialiser.addActionListener(this);

		menu.add(this.menuItemAPropos);
		menu.add(this.menuItemQuitter);
		partie.add(this.menuItemNouvellePartie);
		partie.add(this.menuItemReinitialiser);
		this.add(menu);
		this.add(partie);
	}
	
	/**
	 * Traitement des évènements associés aux items du menu
	 * 
	 * @param event
	 *            l'événement survenu
	 */
	@Override
	public void actionPerformed(ActionEvent event)
	{
		JMenuItem itemClique = (JMenuItem) event.getSource();

		if (itemClique == this.menuItemAPropos)
		{
			JOptionPane.showMessageDialog(this.fenetre,"Application développée par Bouix Loïc et San Filippo Max et IHM intégrée par Augsburger Sébastien et Belle Aurélien ","A propos", JOptionPane.INFORMATION_MESSAGE);
		}

		if (itemClique == this.menuItemQuitter)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "C'est votre dernier mot ?", "Confirmation",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
		}

		if (itemClique == this.menuItemReinitialiser)
		{
			System.out.println("reinit");
			//TODO
		}

		if (itemClique == this.menuItemNouvellePartie)
		{
			//int[] parametres = this.afficherChoisirParametres();
			//if (parametres != null)
				// Créer nouvelle partie avec la largeur/hauteur obtenue
		}
	}
	
	/**
	 * Choix des paramètres par l'utilisateur
	 * @return les paramètres choisis
	 */
	private int[] afficherChoisirParametres()
	{
		//TODO Ajouter choix du niveau de jeu
		JSlider choixHauteur = new JSlider();
		choixHauteur.addChangeListener(this);
		choixHauteur.setName("hauteur");
		JSlider choixLargeur = new JSlider();
		choixLargeur.addChangeListener(this);
		choixLargeur.setName("largeur");

		JLabel valeurHauteur = new JLabel("Hauteur: " + choixHauteur.getValue());
		JLabel valeurLargeur = new JLabel("Largeur: " + choixLargeur.getValue());
		
		this.panneauChoixParametres = new JPanel();
		this.panneauChoixParametres.add(valeurHauteur);
		this.panneauChoixParametres.add(choixHauteur);
		this.panneauChoixParametres.add(valeurLargeur);
		this.panneauChoixParametres.add(choixLargeur);
		
		int optionJOptionPane = JOptionPane.showConfirmDialog(this.fenetre, this.panneauChoixParametres, "Nouvelle partie - Paramètres", JOptionPane.DEFAULT_OPTION);
		if ((optionJOptionPane == JOptionPane.OK_OPTION))
		{
			int hauteur = ((JSlider) this.panneauChoixParametres.getComponent(1)).getValue();
			int largeur = ((JSlider) this.panneauChoixParametres.getComponent(3)).getValue();
			if ((hauteur > 3) && (largeur > 3))
			{
				int[] parametres = {hauteur, largeur};
				return parametres;
			}
				
		}
		return null;
	}

	@Override
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = ((JSlider) e.getSource());
		if (source.getName() == "hauteur")
			((JLabel) this.panneauChoixParametres.getComponent(0)).setText("Hauteur : " + source.getValue());
		if (source.getName() == "largeur")
			((JLabel) this.panneauChoixParametres.getComponent(2)).setText("Largeur : " + source.getValue());
	}
}
