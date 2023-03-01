import javax.swing.JOptionPane;

		public class Principal {
			
			private static Operacoes oper = new Operacoes();

			public static void main(String[] args) {
			
				int continuar;
				double resultado = 0;
				
				do {
					double num1 = EntradaSaida.solicitaNumero("1�");
					double num2 = EntradaSaida.solicitaNumero("2�");
					int operacao = EntradaSaida.solicitaOperacao();
				
					switch (operacao) {
					case 1:
						resultado = oper.calculaSoma(num1, num2);
					break;
					case 2:
						resultado = oper.calculaSubtracao(num1, num2);
					break;
					case 3:
						resultado = oper.calculaMultiplicacao(num1, num2);
					break;
					case 4:
						while (num2==0) {
							num2 = EntradaSaida.solicitaNumero("2�");
						}
						resultado = oper.calculaDivisao(num1, num2);
					break;
					default:
						JOptionPane.showMessageDialog(null, "Opera��o inv�lida! A calculadora ser� encerrada!");
						System.exit(0);
					}
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