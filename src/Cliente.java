public class Cliente 
{
	
  private float _tempoAtendimento; // Tempo de Atendimento do Cliente
  private Cliente _proxCliente; //Referece ao proximo cliente a ser atendido
    
  /*
   * Construtor da classe Cliente
   * */
  public Cliente(float tempoAtendimento)
  {
	 this._proxCliente = null; 
	 this.SetTempoAtendimento(tempoAtendimento);
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
