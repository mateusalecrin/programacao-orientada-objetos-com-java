package controle;

public class Principal {

	public static void main(String[] args) {

		Controladora controladora = new Controladora();
		controladora.exibeMenu();

	}
}

// public torna um membro da classe visível :
// Pela própria classe;
// Pelas classes do mesmo pacote;
// Pelas subclasses; e
// Por qualquer classe, mesmo de outros pacotes;

// protected torna um membro da classe visível :
// Pela própria classe;
// Pelas classes do mesmo pacote; e
// Pelas subclasses;

// default torna um membro da classe visível :
// Pela própria classe; e
// Pelas classes do mesmo pacote; e
// private torna um membro da classe visível pela própria classe.

// Quando não definimos, o método assume o modificador Default.