package fr.iutvalence.java.tp.tilepuzzle;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Permet d'obtenir un plateau généré alatoirement
 */
public class FabriqueDePlateauAleatoire implements FabriqueDePlateau
{
	/**
	 * Taille par défaut d'un plateau généré aléatoirement
	 */
	public static final int TAILLE_PAR_DEFAUT = 3;
	
	@Override
	public Plateau obtenirPlateau()
	{
		Set<Position> cases = new HashSet<Position>();
		return new Plateau(TAILLE_PAR_DEFAUT, TAILLE_PAR_DEFAUT, cases);
	}
	
	@Override
	public Plateau obtenirPlateauDefini(int hauteur, int largeur, int difficulte)
	{
		Set<Position> cases = new HashSet<Position>();	
		Plateau plateau = new Plateau(hauteur, largeur, cases);
		
		int nombreDeCasesAAllumer = (int) Math.round((difficulte/20.0)*hauteur*largeur);
		Random machineAlea = new Random();
		while (plateau.obtenirNombreDeCasesAllumees() != nombreDeCasesAAllumer)
		{
			Position positionAlea = new Position(machineAlea.nextInt(hauteur-1), machineAlea.nextInt(largeur-1));
			plateau.inverserCasesAutourDe(positionAlea);
		}
		
		return plateau;
	}

}
