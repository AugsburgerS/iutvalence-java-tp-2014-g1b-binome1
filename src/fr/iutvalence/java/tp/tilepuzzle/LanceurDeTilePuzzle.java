package fr.iutvalence.java.tp.tilepuzzle;

import javax.swing.SwingUtilities;

/**
 * @author Bouix Loïc et Sanfilippo Max
 */

/**
 * Classe initiale de l'application, permet de lancer la partie.
 */
public class LanceurDeTilePuzzle
{
	/**
	 * Methode initiale, crée la partie et affiche son 
	 * état actuel(en création, démarrage ou terminé)
	 * @param args Arguments de la ligne de commande, il n'y en a aucun pour
	 * l'instant.
	 */
	public static void main(String[] args)
	{
		Affichage affichage = new AffichageGraphique();
		SwingUtilities.invokeLater((Runnable) affichage);
		
		Joueur joueur = new JoueurClavier();
		FabriqueDePlateau fdp = new FabriqueDePlateauAleatoire();
		TilePuzzle partieDeTilePuzzle = new TilePuzzle(joueur, fdp, affichage);
		partieDeTilePuzzle.jouer();
	}
}