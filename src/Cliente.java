public class Cliente 
{
  private float _tempoAtendimento;
  private Cliente _proxCliente;
    
  /*
   * Construtor da classe Cliente
   * */
  public Cliente(float tempoAtendimento)
  {
	 this._proxCliente = null; 
	 this.setTempoAtendimento(tempoAtendimento);
  }

  /*
   * Retorna o próximo cliente a ser atendido
   * */
  public Cliente getProxCliente() 
  {
	 return this._proxCliente;
  }
  
  /*
   * Seta o próximo cliente a ser atendido
   * */
  public void setProxCliente(Cliente _proxCliente) 
  {
	 this._proxCliente = _proxCliente;
  }
  
  /*
   * Seta o tempo de atendimento do cliente
   * */
  public void setTempoAtendimento(float tempoAtendimento) 
  {
	 this._tempoAtendimento = tempoAtendimento;
  }

  /*
   * Retorna o tempo de atendimento do cliente
   * */
  public float getTempoAtendimento() 
  {
	  return this._tempoAtendimento;
  }
	
}
