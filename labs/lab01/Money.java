package lab01;

// Processo 1 - Criar a classe Money

public class Money {

	private int _amount;

	// Processo 5 - alterar _currency de String para Currency (2/3)
	private Currency _currency;

	public Money(int amount, Currency currency) {
		setAmount(amount);
		setCurrency(currency);
	}

	public String toString() {
		return "" + getAmount() + " " + getCurrency();
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money aMoney = (Money) anObject;
			return aMoney.getCurrency().equals(getCurrency()) && getAmount() == aMoney.getAmount();
		}
		return false;
	}

	// Processo 10 - Modificar método add() de Money para retornar MoneyBag ou Money (1/2)
	public Object add(Money money) {
		if (getCurrency().equals(money.getCurrency())) {
			// Observação: Quando adicionado um objeto do tipo Money a outro objeto do tipo
			// Money, da mesma moeda o método add deixa ambos os objetos inalterados e cria
			// uma nova instância de Money. Isto se assemelha ao comportamento de uma função
			// add() matemática.
			// Por exemplo, não expera-se que "5 + 7" redefina o número 5 para o valor 12,
			// mas sim que retorne um novo valor 12.
			return new Money(getAmount() + money.getAmount(), getCurrency());
		} else {
			MoneyBag moneyBag = new MoneyBag();
			moneyBag.add(this);
			moneyBag.add(money);
			return moneyBag;
		}
	}

	// Processo 11 - Acrescentar método em MoneyBag que retorna valor total em BRL (3/3)
	public int getAmountInBrl() {
		return getAmount() * getCurrency().getValueInBrl();
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		this._amount = amount;
	}

	// Processo 5 - alterar _currency de String para Currency (3/3)
	public Currency getCurrency() {
		return _currency;
	}

	public void setCurrency(Currency currency) {
		this._currency = currency;
	}

}
