package controle;

public class Principal {

	public static void main(String[] args) {

		Controladora controladora = new Controladora();
		controladora.exibeMenu();

	}
}

// public torna um membro da classe vis�vel :
// Pela pr�pria classe;
// Pelas classes do mesmo pacote;
// Pelas subclasses; e
// Por qualquer classe, mesmo de outros pacotes;

// protected torna um membro da classe vis�vel :
// Pela pr�pria classe;
// Pelas classes do mesmo pacote; e
// Pelas subclasses;

// default torna um membro da classe vis�vel :
// Pela pr�pria classe; e
// Pelas classes do mesmo pacote; e
// private torna um membro da classe vis�vel pela pr�pria classe.

// Quando n�o definimos, o m�todo assume o modificador Default.