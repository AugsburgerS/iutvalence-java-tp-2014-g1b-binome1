package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Interface définissant les méthodes relatives à l'affichage
 */
public interface Affichage
{
	
	/**
	 * Affiche la demande de position
	 */
	public void afficherDemandePosition();
	
	/**
	 * Affiche le plateau transmis
	 * @param plateau Plateau a afficher
	 */
	public void afficherPlateau(Plateau plateau);
}
