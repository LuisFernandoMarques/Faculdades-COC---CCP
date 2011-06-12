/*
 * Name: Numericos
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe contendo somente m�todos est�ticos respons�vel por convers�es e valida��es num�ricas
 */

public class Numericos 
{

	/*
	 * M�todo para verifica��o se � inteiro o valor
	 * */
	public static boolean IsInteger(String valor)
	{
		try
		{
			Integer.parseInt(valor);
			return true;	
		}
		catch(Exception ex)
		{
			return false;
		}	
	}
	
	/*
	 * M�todo para verifica��o se � ponto flutuante o valor
	 * */
	public static boolean IsFloat(String valor)
	{
		try
		{
			Float.parseFloat(valor);
			return true;	
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
}
