package fr.iutvalence.java.tp.tilepuzzle.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author augsburs
 * Barre de menu du Tile Puzzle
 */
@SuppressWarnings("serial")
public class BarreDeMenuTilePuzzle extends JMenuBar implements ActionListener
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
			JOptionPane.showMessageDialog(this.fenetre,"Application développée par Bouix Loïc et Sans Fil Ippo et IHM intégrée par Augsburger Sébastien et son fidèle assistant qui le suit dans tous ses déplacements et travaux : Belle Aurélien ","A propos", JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		if (itemClique == this.menuItemQuitter)
		{
			if (JOptionPane.showConfirmDialog(this.fenetre, "C'est votre dernier mot ?", "Confirmation",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
				this.fenetre.dispose();
		}

		if (itemClique == this.menuItemReinitialiser)
		{
			System.out.println("reinit");
			// if (JOptionPane.showConfirmDialog(this.fenetre,
			// "Etes-vous sûr ? Vous perdrez la partie en cours.",
			// "Confirmation", JOptionPane.OK_CANCEL_OPTION,
			// JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		}

		if (itemClique == this.menuItemNouvellePartie)
		{
			System.out.println("new");
		}
	}
}
