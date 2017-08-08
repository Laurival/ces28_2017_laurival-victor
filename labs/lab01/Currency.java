package lab01;

// Processo 5 - Criar classe Currency (1/3)

public class Currency {

	public Currency(String currency) {
		setCurrency(currency);
		_valueInBrl = 1; // default value for _valueInBrl, if its not passed in the constructor
	}

	// Processo 11 - Acrescentar método em MoneyBag que retorna valor total em BRL (2/3)
	public Currency(String currency, int valueInBrl) {
		setCurrency(currency);
		_valueInBrl = valueInBrl;
	}

	public int getValueInBrl() {
		return _valueInBrl;
	}

	public void setValueInBrl(int valueInBrl) {
		this._valueInBrl = valueInBrl;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String _currency) {
		this._currency = _currency;
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Currency) {
			Currency aCurrency = (Currency) anObject;
			return getCurrency().equals(aCurrency.getCurrency());
		}
		return false;
	}

	public String toString() {
		return _currency;
	}

	private String _currency;
	private int _valueInBrl;
}
