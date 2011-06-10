/*
 * Name: Cliente
 * Author: 
 * 		Henrique Sylvestre da Silva
 * 		Iser Estable
 * 		Luis Fernando Marques
 * 		Marcos Diego de Azevedo
 * Date: 01/06/2011
 * Description:
 * 	 Classe responsavel por definir o tipo Cliente
 */


public class Cliente 
{
	
  private float _tempoAtendimento; // Tempo de Atendimento do Cliente
  private Cliente _proxCliente; //Referece ao proximo cliente a ser atendido
    
  /*
   * Construtor da classe Cliente
   * */
  public Cliente(float tempoAtendimento) throws Exception
  {
	  try
	  {
		 this._proxCliente = null; 
		 this.SetTempoAtendimento(tempoAtendimento);
	  }
	  catch(Exception ex)
	  {
		  throw ex;
	  }	
  }

  /*
   * Retorna o próximo cliente a ser atendido
   * */
  public Cliente GetProxCliente() 
  {
	 return this._proxCliente;
  }
  
  /*
   * Seta o próximo cliente a ser atendido
   * */
  public void SetProxCliente(Cliente _proxCliente) 
  {
	 this._proxCliente = _proxCliente;
  }
  
  /*
   * Seta o tempo de atendimento do cliente
   * */
  public void SetTempoAtendimento(float tempoAtendimento) 
  {
	 this._tempoAtendimento = tempoAtendimento;
  }

  /*
   * Retorna o tempo de atendimento do cliente
   * */
  public float GetTempoAtendimento() 
  {
	  return this._tempoAtendimento;
  }
	
}
