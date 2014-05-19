package fr.iutvalence.java.tp.tilepuzzle;

/**
 * Représente une position sur un plateau
 */
public class Position
{
	/**
	 * Ligne
	 */
	private final int ligne;
	/**
	 * Colonne
	 */
	private final int colonne;
	
	/**
	 * Défini une position sur la ligne et la colonne indiquée
	 * @param ligne Ligne
	 * @param colonne Colonne
	 */
	public Position(int ligne, int colonne)
	{
		this.ligne = ligne;
		this.colonne = colonne;
	}

	/**
	 * Genere une position à partir d'une chaine de caractères de la forme [0-9]*[/-,|][0-9]*
	 * @param chaine La chaine a convertir
	 * @param ligneMax Ligne à partir de laquelle la position est invalide
	 * @param colonneMax Colonne à partir de laquelle la position est invalide
	 * @return Renvoi une nouvelle position
	 * @throws FormatInvalideException Format de la chiane invalide
	 * @throws PositionInexistanteException Position hors des limites
	 */
	public static Position parsePosition(String chaine, int ligneMax, int colonneMax) throws FormatInvalideException, PositionInexistanteException
	{
		int separateur = chaine.indexOf("/");
		if (separateur == -1)
		{
			separateur = chaine.indexOf(",");
			if (separateur == -1)
			{
				separateur = chaine.indexOf("|");
				if (separateur == -1)
				{
					separateur = chaine.indexOf("-");
					if (separateur == -1)
					{
						throw new FormatInvalideException();
					}
				}
			}
		}
		int ligne = Integer.parseInt(chaine.substring(0,separateur));
		int colonne = Integer.parseInt(chaine.substring(separateur+1));
		if ((ligne >= ligneMax) || (colonne >= colonneMax) || (ligne < 0) || (colonne < 0))
		{
			throw new PositionInexistanteException();
		}
		return new Position(ligne,colonne);
	}

	/**
	 * @return Renvoi la ligne 
	 */
	public int getLigne()
	{
		return this.ligne;
	}

	/**
	 * @return Renvoi la colonne
	 */
	public int getColonne()
	{
		return this.colonne;
	}

	@Override
	public String toString()
	{
		return "Position [ligne=" + this.ligne + ", colonne=" + this.colonne + "]";
	}

	/**
	 * Renvoie la position adjacente dans la direction indiqué à la case sur laquelle on appelle la méthode.
	 * @param direction Direction dans laquelle on recherche une position adjacente
	 * @return Nouvelle position
	 */
	public Position adjacente(Direction direction)
	{
		return new Position(this.getLigne()+direction.obtenirOffsetLigne(),this.getColonne()+direction.obtenirOffsetColonne());
	}

	/* 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Une position est égale à une autre si et seulement si les colonnes et les lignes sont identiques.
	 */
	@Override
	public boolean equals(Object arg0)
	{
		if ((((Position) arg0).getColonne() == this.getColonne()) && (((Position) arg0).getLigne() == this.getLigne()))
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		int hash = this.colonne-this.ligne;
		return hash;
	}
	
}
