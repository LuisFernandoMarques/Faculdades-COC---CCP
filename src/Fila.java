/*
 * Name: Fila
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe responsável por definir o tipo fila 
 */

public class Fila {
	
	/*
	 * Declaração de Variaveis Privadas 
	 * */ 
	private Cliente _primeiroCliente;
	private Cliente _ultimoCliente;
	
	/*
	 * Construtor da Classe
	 * */ 
	public Fila() throws Exception
	{
		try
		{
			this._primeiroCliente = null;
			this._ultimoCliente = null;		
		}
		catch(Exception ex)
		{
			throw ex;
		}
	} 
	
	/*
	 * Retorna o último Cliente da fila
	 * */
	public Cliente GetUltimoCliente() 
	{
		return this._ultimoCliente;
	}
	
	/*
	 * Retorna o primeiro Cliente da fila
	 * */
	public Cliente GetPrimeiroCliente() 
	{
		return this._primeiroCliente;
	}
	
	/*
	 * Retorna se a fila se encontra vazia
	 * */
	public Boolean FilaVazia()
	{
	  Boolean retorno = false;	
	  if(this._primeiroCliente == null && this._ultimoCliente == null)
	  {
		  retorno = true;
	  }
	  return retorno;
	}
	
	/* 
	 * Número de Pessoas na fila 
	 */
	public int NumeroPessoasFila()
	{
	   Cliente cliente = null;	
	   int count = 0;
	   
	   if(!this.FilaVazia())
	   {			   
		   cliente = this._primeiroCliente;
		   while(cliente != null)
		   {
			   count++;
			   cliente = cliente.GetProxCliente();
		   }  
	   }	   		
	   return count;	
	}
	
	/*
	 * Inserir Cliente a fila
	 * */ 
	public Boolean InserirCliente(float tempoAtendimento) throws Exception 
	{		
		try
		{
			Cliente novoCliente = new Cliente(tempoAtendimento);
			
			if(this.FilaVazia())
			{
				this._primeiroCliente = novoCliente;
			}
			else
			{
				this._ultimoCliente.SetProxCliente(novoCliente);
			}
			this._ultimoCliente = novoCliente;	
			return true;	
		}
		catch(Exception ex)
		{
		 throw ex;	
		}	
	}
	
	/*
	 * Remover o Cliente da Fila
	 * */ 
	@SuppressWarnings("unused")
	public Boolean RemoverCliente() 
	{
		Cliente aux = null;
		Boolean retorno = false;
		if(!this.FilaVazia()) // Se Fila não está vazia 
		{
			
			if(this._primeiroCliente == this._ultimoCliente)
			{
				this._ultimoCliente = null;
			}			
			aux = this._primeiroCliente;
			this._primeiroCliente = this._primeiroCliente.GetProxCliente();
			aux = null;
			
			retorno = true;
		}
		return retorno;
	}
	
	/*
	 * Tempo Médio de Atendimento da fila
	 * */
	public float TempoMedioFila() throws Exception 
	{		
		float tempoMedio = 0F;
		try
		{
			tempoMedio =(this.TempoAtualFila() / this.NumeroPessoasFila()); 
		}catch(Exception ex)
		{
			throw ex;
		}
		return tempoMedio;
	}
	
	/*
	 * Tempo Atual de Atendimento da Fila
	 * */
	public float TempoAtualFila() throws Exception 
	{
		float tempoTotal = 0F;		
		Cliente cliente = null;
		try
		{
			if(!this.FilaVazia())
			{			   
			  cliente = this._primeiroCliente;
			  while(cliente != null)
		      {
				 tempoTotal += cliente.GetTempoAtendimento(); 
				 cliente = cliente.GetProxCliente();
			  }  
			}	
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return tempoTotal;
	}
	
}