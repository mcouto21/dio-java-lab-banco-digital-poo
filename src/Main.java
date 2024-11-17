
public class Main {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Nome Cliente");
		
		Conta contaCorrente = new ContaCorrente(cliente);
		Conta contaPoupanca = new ContaPoupanca(cliente);

		double valor = 5.27;
		contaCorrente.depositar(valor);
		System.out.println();

		valor = 4;
		contaCorrente.transferir(valor, contaPoupanca);
		System.out.println();

		valor = 126;
		contaCorrente.depositar(valor);
		System.out.println();
		
		valor = 150;
		contaCorrente.sacar(valor);
		System.out.println();

		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
	}
}