package fr.iutvalence.java.tp.tilepuzzle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
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
	 * Le splitpane contenant le plateau
	 */
	private JSplitPane splitPanePlateau;

	@Override
	public void afficherPlateau(Plateau plateau)
	{
		this.initSplitPane();
		this.splitPanePlateau.add(new AffGraphiquePlateau(this.fenetre, plateau));
		this.fenetre.getContentPane().add(this.splitPanePlateau);
	}

	@Override
	public void afficherDemandePosition()
	{
		System.out.println("DEMANDE POSITION");
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
		
		this.fenetre.setVisible(true);
	}
	
	/**
	 * Initialisation d'un SplitPane
	 */
	private void initSplitPane()
	{
		this.splitPanePlateau = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		this.splitPanePlateau.setEnabled(false);
		this.splitPanePlateau.setDividerSize(0);
		this.splitPanePlateau.setResizeWeight(1.0);
		this.splitPanePlateau.setBorder(null);
	}
}