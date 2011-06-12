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
	public Caixas() throws Exception
	{
		try
		{
			this.NumeroCaixas = 10;  // Define o número total de Caixas
			this._nroCaixasAberto = 0; // Define o número total de caixas abertos
			
			// Iniciliaza todos os caixas com status fechado
			this._caixas = new Caixa[NumeroCaixas];
			this.InicializarCaixas(); 
		}
		catch(Exception ex)
		{
			throw ex;
		}		
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
	public Boolean AdicionarCliente(float tempoAtendimento) throws Exception
	{
		Caixa caixaAberto = null;
		Boolean retorno = false;
		StringBuilder mensagemErro = new StringBuilder();		
		try
		{
			if(tempoAtendimento > (this.GetTempoMaxFila() * 0.7))
			{
				mensagemErro.append("Tempo do cliente excede 70%% do tempo maximo de atendimento do caixa. \n"); 
				mensagemErro.append(String.format("Informe tempo de atendimento inferior a {0}" , (this.GetTempoMaxFila() * 0.7)));
			}
			else
			{
				caixaAberto = this.RetornarCaixaAberto();
				if(caixaAberto != null)
				{			
					retorno = caixaAberto.GetFila().InserirCliente(tempoAtendimento);			
				}
			}
			if (!mensagemErro.toString().isEmpty()) // Se ocorreu erro  
			{
				throw new Exception(mensagemErro.toString(), null);
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}		
		return retorno;			
	}
	
	/*
	 * Remover 1 cliente de cada caixa em aberto
	 * */
	public Boolean RemoverCliente(int numeroCaixa) throws Exception
	{
		boolean retorno = false;
		int posicaoCaixa;
		Caixa caixa;
		try
		{
		  posicaoCaixa = ((numeroCaixa - 1));
		  caixa = _caixas[posicaoCaixa];
		  
		  if(caixa.GetAberto()) //Verifica se o caixa esta aberto
		  {
			  if(caixa.GetFila().RemoverCliente()) // Remove o Cliente do caixa
			  {
				  if(caixa.GetFila().FilaVazia()) // Verifica se a fila do caia ficou vazia
				  {
					  this.FecharCaixa(caixa);
				  }
				  retorno = true;
			  }
		  }
		  else
		  {
			throw new Exception("O caixa informado está fechado!", null);  
		  }
		  
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return retorno;	
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
				if(caixa.GetAberto())
				{
					count++;
					sbCaixa.append(String.format("Caixa: %d \n", count));
					sbCaixa.append(String.format("Tempo atual do Caixa: %.2f \n", caixa.GetFila().TempoAtualFila()));
					sbCaixa.append(String.format("Tempo Médio do Caixa: %.2f \n", caixa.GetFila().TempoMedioFila()));
					sbCaixa.append(String.format("Número total de pessoas no Caixa: %d \n", caixa.GetFila().NumeroPessoasFila()));
					sbCaixa.append(String.format("Tempo Máximo de Atendimento dos Caixas: %.2f \n\n", this.GetTempoMaxFila()));
				}
			} 
			if (count == 0)
			{
				sbCaixa.append("Todos os caixas estão fechados!");
			}								
		}
		catch(Exception ex) // Verificar o tratamento de erro aqui
		{
			ex.printStackTrace();
		}
		return sbCaixa.toString();
	}
	
	/*
	 * Método respoável por inicializar os caixas com estado fechado
	 * */
	private void InicializarCaixas() throws Exception
	{
		try
		{
			for(int count = 0; count < NumeroCaixas;count++)
			{
			  this._caixas[count] = new Caixa();
			  this._caixas[count].SetAberto(false);
			}
				
		}
		catch(Exception ex)
		{
			throw ex;	
		}		
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
	private Caixa RetornarCaixaAberto() throws Exception
	{		
		Caixa retorno = null;
		try
		{
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
			if(retorno != null)
			{
				if(!retorno.GetAberto())
				{
					retorno = AbrirCaixa();
				}
				else
				{
					if(retorno.GetFila().TempoAtualFila() >= this._tempoMaxFila)
					{
				      retorno = AbrirCaixa(); 
					}	
				}	
			}
			else
			{
				throw new Exception("Número de caixas excedidos!");
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return retorno;
	}	
}