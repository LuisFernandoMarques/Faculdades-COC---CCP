/*
 * Name: Caixa
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe responsável por definir o tipo Caixa
 */

public class Caixa 
{	
	private Fila _fila;
	private Boolean _aberto;
	private int _codigoCaixa;
	
	/*
	 * Construtor da classe Caixa
	 * */
	public Caixa(int codigoCaixa) throws Exception
	{
		try
		{
			this._fila = new Fila();
			this._aberto = false;
			this._codigoCaixa = codigoCaixa;
		}
		catch(Exception ex)
		{
			throw ex;
		}		
	}
	
	/*
	 * Retorna a fila
	 * */
	public Fila GetFila() 
	{
		return this._fila;
	}

	/*
	 * Seta Status do caixa
	 * */
	public void SetAberto(Boolean aberto) 
	{
		this._aberto = aberto;
	}

	/*
	 * Retorna o Status do Caixa
	 * */
	public Boolean GetAberto() 
	{

		return this._aberto;
	}

	/*
	 * Retorno o código do Caixa
	 * */
	public int GetCodigoCaixa() 
	{
		return this._codigoCaixa;
	}	
	
}
