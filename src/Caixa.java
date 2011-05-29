
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
	public Fila getFila() 
	{
		return this._fila;
	}

	/*
	 * Seta Status do caixa
	 * */
	public void setAberto(Boolean aberto) {
		this._aberto = aberto;
	}

	/*
	 * Retorna o Status do Caixa
	 * */
	public Boolean getAberto() {
		return this._aberto;
	}	
}
