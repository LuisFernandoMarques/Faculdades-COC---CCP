/*
 * Name: Numericos
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe contendo somente métodos estáticos responsável por conversões e validações numéricas
 */

public class Numericos 
{

	/*
	 * Método para verificação se é inteiro o valor
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
	 * Método para verificação se é ponto flutuante o valor
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
