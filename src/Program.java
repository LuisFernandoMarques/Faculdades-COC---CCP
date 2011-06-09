import javax.swing.JOptionPane;

public class Program {

	private static Caixas _caixas;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int opcaoMenu = 0;
		_caixas = new Caixas();
		
		do
		{
			StringBuilder menu = new StringBuilder();
			menu.append("GERENCIADOR DE CAIXAS \n\n");
			menu.append("1 - Inserir novo cliente no caixa \n");
			menu.append("2 - Imprimir Tempo Maximo Atendimento \n");
			menu.append("3 - Informacoes dos caixas \n");
			menu.append("4 - Atender Cliente \n");
			menu.append("0 - Sair\n");
			menu.append("_______________________________________\n");
			menu.append("Digite a opcao desejada: ");
		
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog(menu.toString()));
			
			switch(opcaoMenu)
			{
				case 1: //inserir novo cliente
					InserirCliente();
					break;
				
				case 2:  //imprimir tempo m�ximo de atendimento
					ImprimirTempoMaximoAtendimento();
					break;
					
				case 3: //imprimi as informa��es de todos os caixas
					ImprimirInformacoesCaixas();
					break;
					
				case 4: //atender cliente
					AtenderCliente();
					break;
					
				case 0: //sair
					JOptionPane.showMessageDialog(null, "Programa Encerrado!");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Op��o Inv�lida!");
					break;
			}
		}while(opcaoMenu != 0);
	}
	
	/*
	 * Procedimento respons�vel por inserir um cliente no caixa com menor n�mero de atendimento
	 * */
	private static boolean InserirCliente()
	{
		int cliente = 0;
		boolean retorno = false;
		
		try
		{
			cliente = Integer.parseInt(JOptionPane.showInputDialog("Informe o tempo de atendimento do cliente"));
			if(cliente == 0 || cliente < 0)
			{
				JOptionPane.showMessageDialog(null, "O tempo de atendimento n�o � v�lido!");
			}
			else
			{
				_caixas.AdicionarCliente(cliente);
				retorno = true;
			}
		}
		catch(Exception ex)
		{		
			TratarErro("Erro ao inserir o cliente!", ex);
		}
		return retorno;
	}
		
	/*
	 * M�todo respons�vel por imprimir o tempo m�ximo de atendimento
	 * */
	private static boolean ImprimirTempoMaximoAtendimento()
	{
		boolean retorno = false;
		try
		{
			JOptionPane.showMessageDialog(null, String.format("Tempo M�ximo de Atendimento dos Caixas: {0}", _caixas.GetTempoMaxFila()));
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir o tempo m�ximo de atendimento!", ex);
		}
		return retorno;
	}
	
	/*
	 * M�todo respons�vel por Imprimir as informa��o do caixas em aberto
	 * */
	private static boolean ImprimirInformacoesCaixas()
	{
		boolean retorno = false;
		try
		{			
			JOptionPane.showMessageDialog(null, String.format("Informa��es dos Caixas abertos: \n\n {0}", _caixas.toString()));			
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir as informa��es dos caixas!", ex);
		}
		return retorno;
	}
	
	/*
	 * M�todo respons�vel por remover um cliente de uma determinado caixa
	 * */
	private static boolean AtenderCliente()
	{
		boolean retorno = false;
		int numeroCaixa = 0;
		try
		{
			numeroCaixa = Integer.parseInt(JOptionPane.showInputDialog("Entre com o n�mero do caixa?"));
			if(numeroCaixa < 0 || numeroCaixa == 0)
			{
				JOptionPane.showMessageDialog(null, "O n�mero do caixa n�o pode ser 0 ou menor que 0");
				retorno = false;
			}
			else
			{
				retorno = _caixas.RemoverCliente(numeroCaixa);
			}
		}
		catch(Exception ex)
		{
			TratarErro(String.format("Erro ao atender o cliente do caixa: {0}", numeroCaixa), ex);
		}
		return retorno;
	}
	
	/*
	 * M�todo responsavel pelos tratamentos de erros
	 * */
	private static void TratarErro(String message, Exception ex)
	{
		JOptionPane.showMessageDialog(null, String.format("{0} \n Erro: {1}", message, ex.getMessage()));
	}
	
}