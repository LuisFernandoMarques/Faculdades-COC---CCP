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
			menu.append("GERENCIADOR DE CAIXAS");
			menu.append("1 - Inserir novo cliente no caixa");
			menu.append("2 - Imprimir Tempo Maximo Atendimento");
			menu.append("3 - Informacoes dos caixas");
			menu.append("4 - Atender Cliente");
			menu.append("0 - Sair");
			menu.append("_______________________________________");
			menu.append("Digite a opcao desejada: ");
		
			opcaoMenu = Integer.getInteger(JOptionPane.showInputDialog(menu.toString()));
			
			switch(opcaoMenu)
			{
				case 1: //inserir novo cliente
					InserirCliente();
					break;
				
				case 2:  //imprimir tempo máximo de atendimento
					ImprimirTempoMaximoAtendimento();
					break;
					
				case 3: //imprimi as informações de todos os caixas
					ImprimirInformacoesCaixas();
					break;
					
				case 4: //atender cliente
					AtenderCliente();
					break;
					
				case 0: //sair
					JOptionPane.showMessageDialog(null, "Programa Encerrado!");
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Opção Inválida!");
					break;
			}
		}while(opcaoMenu != 0);
	}
	
	public static boolean InserirCliente()
	{
		int cliente = 0;
		boolean retorno = false;
		
		try
		{
			cliente = Integer.getInteger(JOptionPane.showInputDialog("Informe o tempo de atendimento do cliente"));
			if(cliente == 0 || cliente < 0)
			{
				JOptionPane.showMessageDialog(null, "O tempo de atendimento não é válido!");
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
	
	public static boolean ImprimirTempoMaximoAtendimento()
	{
		boolean retorno = false;
		try
		{
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir o tempo máximo de atendimento!", ex);
		}
		return retorno;
	}
	
	public static boolean ImprimirInformacoesCaixas()
	{
		boolean retorno = false;
		try
		{
			
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir as informações dos caixas!", ex);
		}
		return retorno;
	}
	
	public static boolean AtenderCliente()
	{
		boolean retorno = false;
		try
		{
			
			
			retorno = true;
		}
		catch(Exception ex)
		{
			TratarErro("Erro ao imprimir as informações dos caixas!", ex);
		}
		return retorno;
	}
	
	public static void TratarErro(String message, Exception ex)
	{
		JOptionPane.showMessageDialog(null, String.format("{0} \n Erro: {1}", message, ex.getMessage()));
	}
	
}