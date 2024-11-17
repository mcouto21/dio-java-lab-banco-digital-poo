public interface IConta {
	Boolean sacar(double valor);

	Boolean depositar(double valor);

	void transferir(double valor, IConta contaDestino);

	void imprimirExtrato();
}