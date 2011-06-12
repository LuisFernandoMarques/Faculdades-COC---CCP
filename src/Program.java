import javax.swing.JOptionPane;

public class Program {

	private static Caixas _caixas;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int opcaoMenu = 99;
		String retornoMenu = "";
		boolean cadastrouTempoMaximo = false;
		
		StringBuilder textoMenu = new StringBuilder();
		textoMenu.append("GERENCIADOR DE CAIXAS \n\n");
		textoMenu.append("1 - Inserir novo cliente no caixa \n");
		textoMenu.append("2 - Imprimir Tempo Maximo Atendimento \n");
		textoMenu.append("3 - Informacoes dos caixas \n");
		textoMenu.append("4 - Atender Cliente \n");
		textoMenu.append("0 - Sair\n");
		textoMenu.append("_______________________________________\n");
		textoMenu.append("Digite a opcao desejada: ");		
		
		try
		{			
			// Inicialização dos Caixas
			_caixas = new Caixas();
			
			// Cadastrar o tempo máximo de Atendimento
			cadastrouTempoMaximo = CadastrarTempoMaximoAtendimento();
			do
			{
				if(cadastrouTempoMaximo)
				{
					retornoMenu = JOptionPane.showInputDialog(textoMenu.toString());
					retornoMenu = (retornoMenu == null ? "0" : retornoMenu);
					if(Numericos.IsInteger(retornoMenu))
					{
						opcaoMenu = Integer.parseInt(retornoMenu);
					}	
				}
				else
				{
					opcaoMenu = 0; //Finalizar o programa;
				}									
					
				switch(opcaoMenu)
				{
					case 1: // Inserir novo cliente
						InserirCliente();
						break;
						
					case 2:  // Imprimir tempo máximo de atendimento
						ImprimirTempoMaximoAtendimento();
						break;
							
					case 3: // Imprimir as informações de todos os caixas
						ImprimirInformacoesCaixas();
						break;
							
					case 4: // Atender Cliente
						AtenderCliente();
						break;
						
					case 0: // Sair
						JOptionPane.showMessageDialog(null, "Programa Encerrado!", "Finalização", JOptionPane.INFORMATION_MESSAGE);
						break;
						
					default:
						JOptionPane.showMessageDialog(null, "Opção Inválida!", "Mensagem", JOptionPane.WARNING_MESSAGE);
						break;
				}			
			}while(opcaoMenu != 0);
		}
		catch(Exception ex)
		{
			TratarErro("Erro no executar o programa!", ex);
		}
	}
	
	/*
	 * Procedimento responsável por inserir um cliente no caixa com menor número de atendimento
	 * */
	private static boolean InserirCliente()
	{
		float cliente = 0;
		boolean retorno = false;
		String retornoInput = ""; 
		try
		{
			retornoInput = JOptionPane.showInputDialog("Informe o tempo de atendimento do cliente:");
			retornoInput = (retornoInput == null ? "0": retornoInput);
			
			if(!Numericos.IsFloat(retornoInput))
			{
				JOptionPane.showMessageDialog(null, "O tempo de atendimento não é válido!", "Mensagem", JOptionPane.WARNING_MESSAGE);							
			}
			else
			{
				cliente = Float.parseFloat(retornoInput);
				if(cliente == 0 || cliente < 0)
				{
					JOptionPane.showMessageDialog(null, "O tempo de atendimento não pode ser 0 ou menor que 0!", "Mensagem", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					_caixas.AdicionarCliente(cliente);
					retorno = true;
				}	
			}
		}
		catch(Exception ex)
		{		
			TratarErro("Erro ao inserir o cliente!", ex);
		}
		return retorno;
	}
		
	/*
	 * Método responsável por imprimir o tempo máximo de atendimento
	 * */
	private static boolean ImprimirTempoMaximoAtendimento()
	{
		boolean retorno = false;
		try
		{
			JOptionPane.showMessageDialog(null, String.format("Tempo Máximo de Atendimento dos Caixas: %.2f", _caixas.GetTempoMaxFila()), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir o tempo máximo de atendimento!", ex);
		}
		return retorno;
	}
	
	/*
	 * Método responsável por Imprimir as informação do caixas em aberto
	 * */
	private static boolean ImprimirInformacoesCaixas()
	{
		boolean retorno = false;
		try
		{			
			JOptionPane.showMessageDialog(null, String.format("Informações dos Caixas abertos: \n\n %s", _caixas.toString()), "Mensagem", JOptionPane.INFORMATION_MESSAGE);			
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir as informações dos caixas!", ex);
		}
		return retorno;
	}
	
	/*
	 * Método responsável por remover um cliente de uma determinado caixa
	 * */
	private static boolean AtenderCliente()
	{
		boolean retorno = false;
		int numeroCaixa = 0;
		String retornoInput = ""; 
		try
		{
			retornoInput = JOptionPane.showInputDialog("Entre com o número do caixa?");
			retornoInput = (retornoInput == null ? "0": retornoInput);
			
			if(!Numericos.IsInteger(retornoInput))
			{
				JOptionPane.showMessageDialog(null, "O número do caixa é inválido!", "Mensagem", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				numeroCaixa = Integer.parseInt(retornoInput);	
				if(numeroCaixa < 0 || numeroCaixa == 0)
				{
					JOptionPane.showMessageDialog(null, "O número do caixa não pode ser 0 ou menor que 0");
					retorno = false;
				}
				else
				{
					// Método responsável pela remoção do 1 cliente da fila
					retorno = _caixas.RemoverCliente(numeroCaixa); 
				}
			}				
		}
		catch(Exception ex)
		{
			TratarErro(String.format("Erro ao atender o cliente do caixa: %i", numeroCaixa), ex);
		}
		return retorno;
	}
	
	/*
	 * Método responsável por armazenar o tempo máximo de Atendimento
	 * */
	private static boolean CadastrarTempoMaximoAtendimento()
	{			
		boolean retorno = false;
		String retornoInput = "";
		float tempoMax = 0;
		try
		{
			StringBuilder textoMenu = new StringBuilder();
			textoMenu.append("CADASTRAR TEMPO MAXIMO DE ATENDIMENTO\n");
			textoMenu.append("Informe tempo de Atendimento dos Caixas ( minutos ):");
			
			retornoInput = JOptionPane.showInputDialog(textoMenu.toString());
			retornoInput = (retornoInput == null ? "0": retornoInput);
			
			if(!Numericos.IsFloat(retornoInput))
			{
				JOptionPane.showMessageDialog(null, "Tempo inválido!", "Mensagem", JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				tempoMax = Float.parseFloat(retornoInput);				
				if(tempoMax <= 0)
				{
				  JOptionPane.showMessageDialog(null, "Tempo inválido! Informe um tempo maior que 0", "Mensagem", JOptionPane.WARNING_MESSAGE);	
				}
				else
				{
					_caixas.SetTempoMaxFila(tempoMax); // Seta o tempo máximo da fila
					retorno = true;
				}				
			}					
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao cadastrar o tempo máximo do Atendimento", ex);
		}	
		return retorno;
	}
	
	/*
	 * Método responsavel pelos tratamentos de erros
	 * */
	private static void TratarErro(String mensagem, Exception ex)
	{
		JOptionPane.showMessageDialog(null, String.format("%s \n Mensagem: %s", mensagem, ex.getMessage()), "Erro no Programa!", JOptionPane.ERROR);
	}
			
}