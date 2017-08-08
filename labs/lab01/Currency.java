package lab01;

public class Currency {
	
	public Currency(String currency) {
		setCurrency(currency);
		_valueInBrl = 1;
	}
	
	public Currency(String currency, int valueInBrl) {
		setCurrency(currency);
		_valueInBrl = valueInBrl;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String _currency) {
		this._currency = _currency;
	}
	
	public int getValueInBrl() {
		return _valueInBrl;
	}
	
	public void setValueInBrl(int valueInBrl) {
		this._valueInBrl = valueInBrl;
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
