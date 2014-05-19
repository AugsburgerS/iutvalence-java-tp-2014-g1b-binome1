package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Ensemble de directions
 */
public enum Direction
{
	/**
	 * On crée la direction vers le haut
	 */
	HAUT(-1,0),
	/**
	 * On crée la direction vers la droite
	 */
	DROITE(0,1),
	/**
	 * On crée la direction vers le bas
	 */
	BAS(1,0),
	/**
	 * On crée la direction vers la gauche
	 */
	GAUCHE(0,-1);
	
	
	/**
	 * Décalage des lignes pour cette direction
	 */
	private final int offsetLigne;
	
	/**
	 * Décalage des colonnes pour cette direction
	 */
	private final int offsetColonne;

	/**
	 * Crée une direction avec les décalages indiqués
	 * @param offsetLigne Décalage des lignes pour cette direction
	 * @param offsetColonne Décalage des colonnes pour cette direction
	 */
	private Direction(int offsetLigne, int offsetColonne)
	{
		this.offsetLigne = offsetLigne;
		this.offsetColonne = offsetColonne;
	}

	/**
	 * @return the offsetLigne
	 */
	public int obtenirOffsetLigne()
	{
		return this.offsetLigne;
	}

	/**
	 * @return the offsetColonne
	 */
	public int obtenirOffsetColonne()
	{
		return this.offsetColonne;
	}
	
	
}
