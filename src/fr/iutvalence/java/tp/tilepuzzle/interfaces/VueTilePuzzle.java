package fr.iutvalence.java.tp.tilepuzzle.interfaces;

import fr.iutvalence.java.tp.tilepuzzle.Plateau;

/**
 * Interface définissant les méthodes relatives à l'affichage
 */
public interface VueTilePuzzle
{
	
	/**
	 * Affiche le plateau transmis
	 * @param plateau Plateau a afficher
	 */
	public void initialiserAffichagePlateau(Plateau plateau);
	
	/**
	 * Met à jour le plateau affiché
	 * @param plateau Le plateau à mettre à jour
	 */
	public void mettreAJourPlateau(Plateau plateau);
}
