import javax.swing.JOptionPane;


public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		StringBuilder menu = new StringBuilder();
		int opcaoMenu = 0; 
		
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
			case 1:
				break;
			
			case 2:
				break;
				
			case 3:
				break;
				
			case 4:
				break;
		
		
		}
		
		
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
