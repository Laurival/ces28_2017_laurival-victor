package lab01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

//Processo 7 - Criar classe MoneyBag

public class MoneyBagTest {

	private Currency brl;
	private Currency eur;
	private Currency chf;

	private Money brl40;
	private Money brl60;
	private Money eur30;
	private Money chf70;

	private MoneyBag moneyBag;

	@Before
	public void setUp() {
		brl = new Currency("BRL", 1);
		eur = new Currency("EUR", 4);
		chf = new Currency("CHF", 2);

		brl40 = new Money(40, brl);
		brl60 = new Money(60, brl);
		eur30 = new Money(30, eur);
		chf70 = new Money(70, chf);

		moneyBag = new MoneyBag();
	}

	@Test
	public void whenAddedMoneyExpectsMoneyInList() {
		moneyBag.add(brl40);
		assertEquals(brl40, moneyBag.get(0));
	}

	@Test
	public void whenIsEmptySizeReturnsZero() {
		assertEquals(0, moneyBag.size());
	}

	@Test
	public void whenAddedTwoMoneySizeReturns2() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		assertEquals(2, moneyBag.size());
	}

	@Test
	public void whenAddingMoniesExpectAddedMoneyInList() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(chf70);
		assertTrue(moneyBag.contains(eur30));
	}

	@Test
	public void whenAddingMoneisToDifferentBagsExpectBothAreEqual() {
		MoneyBag anotherMoneyBag = new MoneyBag();
		anotherMoneyBag.add(brl40);
		anotherMoneyBag.add(eur30);
		anotherMoneyBag.add(chf70);

		moneyBag.add(chf70);
		moneyBag.add(brl40);
		moneyBag.add(eur30);

		assertEquals(moneyBag, anotherMoneyBag);
	}

	@Test
	public void whenAddingMoniesWithEqualCurrencyExpectSum() {
		Money brl100 = new Money(100, brl);

		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(brl60);

		assertTrue(moneyBag.contains(brl100));
	}

	@Test
	public void whenAddingMoniesWithDifferentCurrenciesReturnTotalAmountInBrl() {
		moneyBag.add(brl40);
		moneyBag.add(eur30);
		moneyBag.add(chf70);
		assertEquals(300, moneyBag.getTotalAmountInBrl());
	}

	@Test
	public void whenEmptyExpectZeroAsTotalAmountInBrl() {
		assertEquals(0, moneyBag.getTotalAmountInBrl());
	}

	@Test
	public void whenAddingMoneyInBrlExpectSameMoneyAsTotalAmountInBrl() {
		moneyBag.add(brl40);
		assertEquals(40, moneyBag.getTotalAmountInBrl());
	}
}
