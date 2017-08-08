package lab01;

public class Money {

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
	
	public Object add(Money money) {
		if (this._currency.equals(money.getCurrency())) {
			return new Money(getAmount() + money.getAmount(), getCurrency());
		} else {
			MoneyBag moneyBag = new MoneyBag();
			moneyBag.add(this);
			moneyBag.add(money);
			return moneyBag;
		}
	}
	
	public int getAmountInBrl() {
		return getAmount() * getCurrency().getValueInBrl();
	}

	public int getAmount() {
		return _amount;
	}

	public void setAmount(int amount) {
		this._amount = amount;
	}

	public Currency getCurrency() {
		return _currency;
	}

	public void setCurrency(Currency currency) {
		this._currency = currency;
	}

	private int _amount;
	private Currency _currency;

}
