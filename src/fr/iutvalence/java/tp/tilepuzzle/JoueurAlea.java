package fr.iutvalence.java.tp.tilepuzzle;

import java.util.Random;

/**
 * Définit un joueur, capable d'interagir de façon aléatoire avec le plateau.
 */
public class JoueurAlea implements Joueur
{
	/**
	 * Crée un nouveau joueur aléatoire
	 */
	public JoueurAlea()
	{
		
	}
	
	/**
	 * Genère une position correspondant à la case à activer
	 * @param hauteurPlateau Hauteur du plateau sur lequel on joue
	 * @param largeurPlateau Largeur du plateau sur lequel on joue
	 * @return Renvoi la position de la case à activer
	 */
	public Position getPosition(int hauteurPlateau, int largeurPlateau)
	{
		Random machineAlea = new Random();
		return new Position(machineAlea.nextInt(hauteurPlateau-1), machineAlea.nextInt(largeurPlateau-1));
	}
}
