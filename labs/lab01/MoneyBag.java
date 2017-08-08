package lab01;

import java.util.LinkedList;
import java.util.List;

public class MoneyBag {

	private List<Money> _monies = new LinkedList<Money>();

	public int size() {
		return _monies.size();
	}

	public void add(Money money) {
		boolean foundSameCurrency = false;
		for (int i = 0; i < size(); i++) {
			if (get(i).getCurrency().equals(money.getCurrency())) {
				set(i, (Money) get(i).add(money));
				foundSameCurrency = true;
			}
		}
		if (!foundSameCurrency) {
			_monies.add(money);
		}
	}
	
	public void set(int i, Money money) {
		_monies.set(i, money);
	}

	public Money get(int i) {
		return _monies.get(i);
	}

	public boolean contains(Money m) {
		return _monies.contains(m);
	}

	public boolean equals(Object anObject) {
		if (this == anObject)
			return true;
		if (!(anObject instanceof MoneyBag))
			return false;
		MoneyBag otherlist = (MoneyBag) anObject;
		if (!(otherlist.size() == this.size()))
			return false;
		for (int i = 0; i < otherlist.size(); i++) {
			if (!contains(otherlist.get(i)))
				return false;
		}
		return true;
	}
	
	public String toString() {
		String result = "MoneyBag:\n";
		for (int i = 0; i < size(); i++) {
			result += "* " + get(i) + "\n";
		}
		result += "Total Amount: " + getTotalAmountInBrl() + " BRL";
		return result;
	}
	
	public int getTotalAmountInBrl() {
		int amount = 0;
		for (int i = 0; i < size(); i++) {
			amount += get(i).getAmountInBrl();
		}
		return amount;
	}
}
