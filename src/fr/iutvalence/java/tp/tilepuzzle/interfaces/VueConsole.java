package fr.iutvalence.java.tp.tilepuzzle.interfaces;

import fr.iutvalence.java.tp.tilepuzzle.Plateau;
import fr.iutvalence.java.tp.tilepuzzle.Position;

/**
 * Gere l'affichage dans la console
 */
public class VueConsole implements VueTilePuzzle
{
	@Override
	public void initialiserAffichagePlateau(Plateau plateau)
	{
		/**
		 * Renvoi le contenu du plateau sous forme d'une chaine
		 * 
		 * @return Chaine representant le plateau
		 */

		String plateauAffichable = "";
		for (int ligne = 0; ligne < plateau.obtenirHauteur(); ligne++)
		{
			for (int colonne = 0; colonne < plateau.obtenirLargeur(); colonne++)
			{
				if (plateau.estCaseAllumee(new Position(ligne, colonne)))
				{
					plateauAffichable += "O ";
				}
				else
				{
					plateauAffichable += "- ";
				}
			}
			plateauAffichable += "\n";
		}
		System.out.println(plateauAffichable);
	}

	@Override
	public void mettreAJourPlateau(Plateau plateau)
	{
		//TODO
	}

	@Override
	public void afficherPartieGagnee()
	{
		System.out.println("Bravo, vous avez gagné la partie !");
	}
}
