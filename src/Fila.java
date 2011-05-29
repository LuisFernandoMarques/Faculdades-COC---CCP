public class Fila {
	
	/*
	 * Declaração de Variaveis Privadas 
	 * */ 
	private Cliente _primeiroCliente;
	private Cliente _ultimoCliente;
		
	/*
	 * Construtor da Classe
	 * */ 
	public Fila()
	{
		this._primeiroCliente = null;
		this._ultimoCliente = null;		
	} 
	
	//Testando controlador de fonte.
	
	/*
	 * Retorna o último Cliente da fila
	 * */
	public Cliente getUltimoCliente() 
	{
		return this._ultimoCliente;
	}
	
	/*
	 * Retorna o primeiro Cliente da fila
	 * */
	public Cliente getPrimeiroCliente() 
	{
		return this._primeiroCliente;
	}
	
	/*
	 * Retorna se a fila se encontra vazia
	 * */
	public Boolean filaVazia()
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
	   
	   if(!this.filaVazia())
	   {			   
		   cliente = this._primeiroCliente;
		   while(cliente != null)
		   {
			   count++;
			   cliente = cliente.getProxCliente();
		   }  
	   }	   		
	   return count;	
	}
	
	/*
	 * Inserir Cliente a fila
	 * */ 
	public Boolean InserirCliente(float tempoAtendimento) 
	{		
		Cliente novoCliente = new Cliente(tempoAtendimento);
		
		if(this.filaVazia())
		{
			this._primeiroCliente = novoCliente;
		}
		else
		{
			this._ultimoCliente.setProxCliente(novoCliente);
		}
		this._ultimoCliente = novoCliente;				
		return true;
	}
	
	/*
	 * Remover o Cliente da Fila
	 * */ 
	@SuppressWarnings("unused")
	public Boolean RemoverCliente() 
	{
		Cliente aux = null;
		Boolean retorno = false;
		if(!this.filaVazia()) // Se Fila não está vazia 
		{
			
			if(this._primeiroCliente == this._ultimoCliente)
			{
				this._ultimoCliente = null;
			}			
			aux = this._primeiroCliente;
			this._primeiroCliente = this._primeiroCliente.getProxCliente();
			aux = null;
			
			retorno = true;
		}
		return retorno;
	}
	
	/*
	 * Tempo Médio de Atendimento da fila
	 * */
	public float TempoMedioFila() 
	{		
		return (this.TempoAtualFila() / this.NumeroPessoasFila());
	}
	
	/*
	 * Tempo Atual de Atendimento da Fila
	 * */
	public float TempoAtualFila() 
	{
		float tempoTotal = 0F;		
		Cliente cliente = null;	
		  
		if(!this.filaVazia())
		{			   
		  cliente = this._primeiroCliente;
		  while(cliente != null)
	      {
			 tempoTotal += cliente.getTempoAtendimento(); 
			 cliente = cliente.getProxCliente();
		  }  
		}
		return tempoTotal;
	}
	
}