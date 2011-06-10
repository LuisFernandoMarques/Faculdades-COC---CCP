/*
 * Classe contendo somente m�todos es�ticos respons�vel por convers�es e valida��es num�ricos
 * */
public class Numericos {

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
