package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Produit des plateaux
 */
public interface FabriqueDePlateau
{
	/**
	 * @return Renvoi un nouveau plateau généré avec les paramètres par défaut
	 */
	public Plateau obtenirPlateau();
	
	/**
	 * @param hauteur Hauteur du plateau a generer
	 * @param largeur Largeur du plateau a generer
	 * @param difficulte Difficulte du plateau a generer
	 * @return Renvoi un nouveau plateau généré avec les paramètres fournis
	 */
	public Plateau obtenirPlateauDefini(int hauteur, int largeur, int difficulte);
}
