package fr.iutvalence.java.tp.tilepuzzle;

import javax.swing.SwingUtilities;

import fr.iutvalence.java.tp.tilepuzzle.interfaces.TacheDAffichageTilePuzzle;

/**
 * @author augsburs
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
		TacheDAffichageTilePuzzle tacheDAffichage = new TacheDAffichageTilePuzzle();

		TilePuzzle partieDeTilePuzzle = new TilePuzzle(tacheDAffichage, tacheDAffichage);
		
		SwingUtilities.invokeLater((Runnable) tacheDAffichage);
		
		partieDeTilePuzzle.jouer();
	}
}