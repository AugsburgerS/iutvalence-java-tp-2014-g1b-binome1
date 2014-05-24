package fr.iutvalence.java.tp.tilepuzzle.ihm;

import java.awt.Color;

import javax.swing.JButton;

import fr.iutvalence.java.tp.tilepuzzle.Position;

/**
 * JButton spécifique au TilePuzzle : contenant les coordonnées et l'état du bouton
 * @author augsburs
 */
@SuppressWarnings("serial")
public class JButtonTilePuzzle extends JButton
{
	/**
	 * position du bouton
	 */
	private final Position position;
	
	/**
	 * état du bouton
	 */
	private boolean etat;

	/**
	 * @param position la position du bouton
	 * @param etat l'état du bouton
	 */
	public JButtonTilePuzzle(Position position, boolean etat)
	{
		this.position = position;
		this.etat = etat;
		this.initUI();
	}
	
	/**
	 * Initialisation de l'affichage du bouton suivant son état
	 */
	private void initUI()
	{
		this.setBorder(null);
		if (this.estAllume())
			this.setBackground(new Color(255, 215, 0));
		else
			this.setBackground(new Color(0, 0, 0));
	}

	/**
	 * Accesseur en lecture de la position
	 * @return position du bouton
	 */
	public Position obtenirPosition()
	{
		return this.position;
	}

	/**
	 * Accesseur en lecture de l'état du bouton
	 * @return état du bouton
	 */
	public boolean estAllume()
	{
		return this.etat;
	}

	/**
	 * Modifier l'état du bouton
	 * @param etat L'état du bouton
	 */
	public void modifierEtat(boolean etat)
	{
		this.etat = etat;
	}
}
