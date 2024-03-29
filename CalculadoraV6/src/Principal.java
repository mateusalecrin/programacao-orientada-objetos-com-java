import javax.swing.JOptionPane;

		public class Principal {

			public static void main(String[] args) {
			
				int continuar;
				double resultado = 0;
				Operacoes oper = null;
				do {
					double num1 = EntradaSaida.solicitaNumero("1�");
					double num2 = EntradaSaida.solicitaNumero("2�");
					int operacao = EntradaSaida.solicitaOperacao();
				
					switch (operacao) {
					case 1:
						oper = new Soma();
					break;
					case 2:
						oper = new Subtracao();
					break;
					case 3:
						oper = new Multiplicacao();
					break;
					case 4:
						while (num2==0) {
							num2 = EntradaSaida.solicitaNumero("2�");
						}
						oper = new Divisao();
					break;
					default:
						JOptionPane.showMessageDialog(null, "Opera��o inv�lida! A calculadora ser� encerrada!");
						System.exit(0);
					}
					oper.setNum1(num1);
					oper.setNum2(num2);
					resultado = oper.calcula();
					
					EntradaSaida.mostraResultado(resultado, operacao);
					
					continuar = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar calculando? 1- Sim  | 2- N�o"));
				} while (continuar ==1);
			}
			
		}

		//public torna um membro da classe vis�vel :
		//	Pela pr�pria classe;
		//	Pelas classes do mesmo pacote;
		//	Pelas subclasses; e
		//	Por qualquer classe, mesmo de outros pacotes;
		
		//protected torna um membro da classe vis�vel :
		//	Pela pr�pria classe;
		//	Pelas classes do mesmo pacote; e
		//	Pelas subclasses;
		
		//default torna um membro da classe vis�vel :
		//	Pela pr�pria classe; e
		//	Pelas classes do mesmo pacote; e
		//	private torna um membro da classe vis�vel pela pr�pria classe.
		
		// Quando n�o definimos, o m�todo assume o modificador Default.