package fr.iutvalence.java.tp.tilepuzzle.interfaces;

import fr.iutvalence.java.tp.tilepuzzle.Position;

/**
 * @author augsburs
 * Interface permettant le contrôle de la partie de TilePuzzle
 */
public interface ControleTilePuzzle
{
	/**
	 * Inverser les cases autour d'une position
	 * @param position La position autour de laquelle il faut inverser les cases
	 */
	public void inverserCasesAutourDe(Position position);
}
