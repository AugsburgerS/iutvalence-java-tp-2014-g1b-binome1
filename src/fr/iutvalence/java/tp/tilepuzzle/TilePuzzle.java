package fr.iutvalence.java.tp.tilepuzzle;

import fr.iutvalence.java.tp.tilepuzzle.interfaces.ControleTilePuzzle;
import fr.iutvalence.java.tp.tilepuzzle.interfaces.VueTilePuzzle;

/**
 * Classe principale du jeu, initialise la partie en créant un plateau et un joueur.
 */
public class TilePuzzle implements ControleTilePuzzle
{

	/**
	 * Plateau
	 */
	private final Plateau plateau;
	
	/**
	 * Support d'affichage
	 */
	private VueTilePuzzle vue;
	
	/**
	 * Crée une partie prête à être jouée.
	 * Cela implique la mise en place d'un plateau et d'un joueur pour cette partie.
	 * @param fdp Fabrique de plateau utilisée pour la partie
	 * @param vue La vue à associer
	 */
	public TilePuzzle(FabriqueDePlateau fdp, VueTilePuzzle vue)
	{
		// TODO définir des constantes
		this.plateau = fdp.obtenirPlateauDefini(5, 5, 10);
		this.vue = vue;
		this.vue.initialiserAffichagePlateau(this.plateau);
	}

	@Override
	public void inverserCasesAutourDe(Position position)
	{
		if (this.plateau.obtenirNombreDeCasesAllumees() < this.plateau.obtenirHauteur()*this.plateau.obtenirLargeur())
		{
			this.plateau.inverserCasesAutourDe(position);
			this.vue.mettreAJourPlateau(this.plateau);
		}
	}
}
