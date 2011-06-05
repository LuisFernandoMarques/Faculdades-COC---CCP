/*
 * Name: Caixa
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe responsavel por definir o tipo Caixa
 */

public class Caixa 
{	
	private Fila _fila;
	private Boolean _aberto;
	
	/*
	 * Construtor da classe Caixa
	 * */
	public Caixa()
	{
		this._fila = new Fila();
		this._aberto = false;
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
	
}
