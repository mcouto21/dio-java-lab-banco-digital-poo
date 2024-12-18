public abstract class Conta implements IConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int numeroAgencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	protected String tipoConta;

	public Conta(Cliente cliente) {
		this.numeroAgencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipoConta = this.verificarTipoConta();
	}

	@Override
	public Boolean sacar(double valor) {
		if (valor == 0d) {
			System.out.println(String.format("Nenhum valor a ser sacado da %s.", this.tipoConta));
			return false;
		}
		if (valor > this.saldo) {
			System.out.println(String.format("Valor do saque: R$ %.2f\nSaldo insuficiente na %s: R$ %.2f", valor, this.tipoConta, this.saldo));
			return false;
		}
		saldo-= valor;
		System.out.println(String.format("Saque de R$ %.2f na %s.\nSaldo atual: R$ %.2f", valor, this.tipoConta, saldo));
		return true;
	}

	@Override
	public Boolean depositar(double valor) {
		if (valor == 0d) {
			System.out.println(String.format("Nenhum valor a ser depositado da %s.", this.tipoConta));
			return false;
		}
		saldo+= valor;
		System.out.println(String.format("Deposito de R$ %.2f na %s.\nSaldo atual: R$ %.2f", valor, this.tipoConta, saldo));
		return true;
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		System.out.println(String.format("=== Transferência iniciada ==="));
		if (this.sacar(valor)) {
			contaDestino.depositar(valor);
		}
		System.out.println(String.format("=== Transferência concluída ==="));
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	private String verificarTipoConta() {
		String tipoConta = "Conta Bancária";
		if (this instanceof ContaCorrente)
		{
			tipoConta = "Conta Corrente";
		}
		else if (this instanceof ContaPoupanca)
		{
			tipoConta = "Conta Poupança";
		}
		return tipoConta;
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular da Conta:  %s", this.cliente.getNome()));
		System.out.println(String.format("Número da Agência: %d", this.numeroAgencia));
		System.out.println(String.format("Número da Conta:   %d", this.numeroConta));
		System.out.println(String.format("Tipo da Conta:     %s", this.tipoConta));
		System.out.println(String.format("Saldo Atual:       R$ %.2f", this.saldo));
		System.out.println();
	}
}