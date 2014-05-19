package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Définit un joueur, capable d'interagir avec le plateau.
 */
public interface Joueur
{
	/**
	 * Renvoi une position correspondant à la case à activer
	 * @param hauteurPlateau Hauteur du plateau sur lequel on joue
	 * @param largeurPlateau Largeur du plateau sur lequel on joue
	 * @return Renvoi la position de la case à activer, ou <tt>null</tt> si erreur
	 */
	public Position getPosition(int hauteurPlateau, int largeurPlateau);
}
