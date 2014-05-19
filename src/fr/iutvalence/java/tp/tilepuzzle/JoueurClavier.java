package fr.iutvalence.java.tp.tilepuzzle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Définit un joueur, capable d'interagir avec le plateau via une entrée clavier
 */
public class JoueurClavier implements Joueur
{
	/**
	 * Lecteur sur l'entrée standard
	 */
	private BufferedReader consoleReader;

	/**
	 * Crée un nouveau joueur clavier
	 */
	public JoueurClavier()
	{
		InputStreamReader isr = null;
		try
		{
			isr = new InputStreamReader(System.in, "US-ASCII");
		}
		catch (UnsupportedEncodingException e)
		{
			// Ignore it, US-ASCII is always supported
		}
		this.consoleReader = new BufferedReader(isr);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable
	{
		super.finalize();
		this.consoleReader.close();
	}


	/**
	 * Récupère une position correspondant à la case à activer
	 * 
	 * @param hauteurPlateau
	 *            Hauteur du plateau sur lequel on joue
	 * @param largeurPlateau
	 *            Largeur du plateau sur lequel on joue
	 * @return Renvoi la position de la case à activer
	 */
	public Position getPosition(int hauteurPlateau, int largeurPlateau)
	{
		try
		{
			return Position.parsePosition(this.consoleReader.readLine(), hauteurPlateau, largeurPlateau);
		}
		catch (IOException e)
		{
			return null;
		}
		catch (FormatInvalideException e)
		{
			return null;
		}
		catch (PositionInexistanteException e)
		{
			return null;
		}
	}
}
