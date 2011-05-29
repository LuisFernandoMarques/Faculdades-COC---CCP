public class Caixas 
{
	private Caixa[] _caixas;
	private float _tempoMaxFila; 
	private final int NumeroCaixas;
	
	/*
	 * Construtor da classe Caixas
	 * */
	public Caixas()
	{
		this.NumeroCaixas = 100;
		this._caixas = new Caixa[NumeroCaixas];		
	}
	
	/*
	 * Tempo Máximo de Atendimento da Fila
	 * */
	public void setTempoMaxFila(float _tempoMaxFila) 
	{
		this._tempoMaxFila = _tempoMaxFila;
	}
	
	
	/*
	 * Adicionar Cliente ao Caixa
	 */
	public Boolean AdicionarCliente(float tempoAtendimento)
	{
		Caixa caixaAberto = null;
		Boolean retorno = false;
		
		caixaAberto = this.retornarCaixaAberto();
		if(caixaAberto != null)
		{			
			retorno = caixaAberto.getFila().InserirCliente(tempoAtendimento);			
		}
		return retorno;			
	}
	
	/*
	 * Remover 1 cliente de cada caixa em aberto
	 * */
	public Boolean RemoverCliente()
	{
		// Quando remover o cliente deve ser informado o caixa??		
		for(Caixa caixa : _caixas)
		{
		  if(caixa.getAberto()) //Verifica se o caixa esta aberto
		  {
			  if(caixa.getFila().RemoverCliente()) // Remove o Cliente do caixa
			  {
				  if(caixa.getFila().filaVazia()) // Verifica se a fila do caia ficou vazia
				  {
					  this.fecharCaixa(caixa);
				  }
			  }
		  }
		}		
		return true;	
	}
	
	/*
	 * Abrir um novo caixa
	 * */
	private Caixa abrirCaixa()
	{
		for(Caixa caixa : _caixas)
		{
		  if(!caixa.getAberto())
		  {
			  caixa.setAberto(true);
			  return caixa;
		  }
		}
		return null;
	}
	
	/*
	 * Fechar o caixa
	 * */
	private void fecharCaixa(Caixa caixa)
	{
		caixa.setAberto(false);	
	}
	
	/*
	 * Retorna Caixa Aberto com menor tempo de atendimento
	 * */
	private Caixa retornarCaixaAberto()
	{		
		Caixa retorno = null;
		for(Caixa caixa : _caixas)
		{
			if(retorno == null)
			{
				retorno = caixa;	
			}
			else
			{
				if(caixa.getFila().TempoAtualFila() < retorno.getFila().TempoAtualFila())
				{
					retorno = caixa; 
				}
			}
		}
		if(retorno.getFila().TempoAtualFila() >= this._tempoMaxFila)
		{
	      retorno = abrirCaixa(); 
		}	   	   
		return retorno;
	}
	
}
