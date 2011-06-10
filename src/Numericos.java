/*
 * Classe contendo somente métodos esáticos responsável por conversões e validações numéricos
 * */
public class Numericos {

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
