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
		
		// Saque saldo insuficiente
		valor = 150;
		contaCorrente.sacar(valor);
		System.out.println();
		
		// Transferência saldo insuficiente
		valor = 37;
		contaPoupanca.transferir(valor, contaCorrente);
		System.out.println();

		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
	}
}