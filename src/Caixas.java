/*
 * Name: Caixas
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe responsavel por armazenar os caixas
 */

public class Caixas 
{
	private final int NumeroCaixas; //Numéro Total de Caixas
	
	private Caixa[] _caixas; // Caixas
	private float _tempoMaxFila; //Tempo maximo da fila
	private int _nroCaixasAberto; //Número de Caixas em aberto
	
	/*
	 * Construtor da classe Caixas
	 * */
	public Caixas()
	{
		this.NumeroCaixas = 100;
		this._nroCaixasAberto = 0;
		this._caixas = new Caixa[NumeroCaixas];		
	}	
	
	/*
	 * Retorna o número de caixas aberto
	 * */
	public int NroCaixasAberto()
	{
		return this._nroCaixasAberto;
	} 
	
	/*
	 * Tempo Máximo de Atendimento da Fila
	 * */
	public void SetTempoMaxFila(float _tempoMaxFila) 
	{
		this._tempoMaxFila = _tempoMaxFila;
	}
	
	/*
	 * Tempo Máximo de Atendimento da Fila
	 * */
	public float GetTempoMaxFila()
	{
		return this._tempoMaxFila; 
	}
	
	/*
	 * Adicionar Cliente ao Caixa
	 */
	public Boolean AdicionarCliente(float tempoAtendimento)
	{
		Caixa caixaAberto = null;
		Boolean retorno = false;
		
		caixaAberto = this.RetornarCaixaAberto();
		if(caixaAberto != null)
		{			
			retorno = caixaAberto.GetFila().InserirCliente(tempoAtendimento);			
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
		  if(caixa.GetAberto()) //Verifica se o caixa esta aberto
		  {
			  if(caixa.GetFila().RemoverCliente()) // Remove o Cliente do caixa
			  {
				  if(caixa.GetFila().FilaVazia()) // Verifica se a fila do caia ficou vazia
				  {
					  this.FecharCaixa(caixa);
				  }
			  }
		  }
		}		
		return true;	
	}
	
	/*
	 * Retorna os dados dos caixas abertos
	 * */	
	@Override
	public String toString()
	{
		int count = 0;
		StringBuilder sbCaixa = new StringBuilder();
		try
		{
			for(Caixa caixa : _caixas)
			{
			  if(caixa.GetAberto()) //Verifica se o caixa esta aberto
			  {
				  count++;
				  sbCaixa.append(String.format("Caixa: {0}", count));
				  sbCaixa.append(String.format("Tempo atual do Caixa: {0}", caixa.GetFila().TempoAtualFila()));
				  sbCaixa.append(String.format("Tempo Médio do Caixa: {0}", caixa.GetFila().TempoMedioFila()));
				  sbCaixa.append(String.format("Número total de pessoas no Caixa: {0}", caixa.GetFila().NumeroPessoasFila()));			  
			  }
			} 
			if (count == 0)
			{
				sbCaixa.append("Os caixas estão fechados");
			}								
		}
		catch(Exception ex) // Verificar o tratamento de erro aqui
		{
			ex.printStackTrace();
		}
		return sbCaixa.toString();
	}
	
	/*
	 * Abrir um novo caixa
	 * */
	private Caixa AbrirCaixa()
	{
		for(Caixa caixa : _caixas)
		{
		  if(!caixa.GetAberto())
		  {
			  this._nroCaixasAberto++;
			  caixa.SetAberto(true);
			  return caixa;
		  }
		}
		return null;
	}
	
	/*
	 * Fechar o caixa
	 * */
	private void FecharCaixa(Caixa caixa)
	{
		this._nroCaixasAberto--;
		caixa.SetAberto(false);	
	}
	
	/*
	 * Retorna Caixa Aberto com menor tempo de atendimento
	 * */
	private Caixa RetornarCaixaAberto()
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
				if(caixa.GetFila().TempoAtualFila() < retorno.GetFila().TempoAtualFila())
				{
					retorno = caixa; 
				}
			}
		}
		if(retorno.GetFila().TempoAtualFila() >= this._tempoMaxFila)
		{
	      retorno = AbrirCaixa(); 
		}	   	   
		return retorno;
	}	
}