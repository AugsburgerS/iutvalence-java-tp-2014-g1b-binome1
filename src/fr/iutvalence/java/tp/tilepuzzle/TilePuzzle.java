package fr.iutvalence.java.tp.tilepuzzle;

import fr.iutvalence.java.tp.tilepuzzle.interfaces.VueTilePuzzle;

/**
 * Classe principale du jeu, initialise la partie en créant un plateau et un joueur.
 */
public class TilePuzzle
{

	/**
	 * Plateau
	 */
	private Plateau plateau;
	
	/**
	 * Support d'affichage
	 */
	private VueTilePuzzle vue;

	
	/**
	 * Le joueur de la partie
	 */
	private Joueur joueur;
	
	/**
	 * Crée une partie prête à être jouée.
	 * Cela implique la mise en place d'un plateau et d'un joueur pour cette partie.
	 * @param vue La vue à associer
	 * @param joueur le joueur de la partie
	 */
	public TilePuzzle(VueTilePuzzle vue, Joueur joueur)
	{
		FabriqueDePlateau fdp = new FabriqueDePlateauAleatoire();
		this.plateau = fdp.obtenirPlateauDefini(5, 5, 10);
		this.vue = vue;
		this.joueur = joueur;
	}

	/**
	 * Inverser les cases autour d'une position
	 * @param position la position autour de laquelle inverser les cases
	 */
	private void inverserCasesAutourDe(Position position)
	{
		if (this.plateau.obtenirNombreDeCasesAllumees() < this.plateau.obtenirHauteur()*this.plateau.obtenirLargeur())
		{
			this.plateau.inverserCasesAutourDe(position);
			this.vue.mettreAJourPlateau(this.plateau);
		}
	}

	/**
	 * Crée une nouvelle partie
	 * @param hauteur la hauteur de la partie
	 * @param largeur la largeur de la partie
	 * @param niveau le niveau de la partie
	 */
	public void creerNouvellePartie(int hauteur, int largeur, int niveau)
	{
		FabriqueDePlateau fdp = new FabriqueDePlateauAleatoire();
		this.plateau = fdp.obtenirPlateauDefini(hauteur, largeur, niveau);
		this.vue.initialiserAffichagePlateau(this.plateau);
	}

	/**
	 * Lance la partie
	 */
	public void jouer()
	{
		this.vue.initialiserAffichagePlateau(this.plateau);
		while (this.plateau.obtenirNombreDeCasesAllumees() < this.plateau.obtenirHauteur()*this.plateau.obtenirLargeur())
		{
			this.inverserCasesAutourDe(this.joueur.getPosition(this.plateau.obtenirHauteur(),this.plateau.obtenirLargeur()));
			this.vue.mettreAJourPlateau(this.plateau);
		}
	}
}
