package lab01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {

	private Currency brl;
	private Currency eur;
	
	private Money brl60;
	private Money brl40;
	private Money eur30;

	// Processo referente ao procedimento 4:
	@Before
	public void setUp() {
		brl = new Currency("BRL");
		eur = new Currency("EUR");
		
		brl40 = new Money(40, brl);
		brl60 = new Money(60, brl);
		eur30 = new Money(30, eur);
	}
	
	// Testes referentes ao procedimento 2:
	@Test
	public void whenAdding40To60Returns100 () {
		Money money = (Money) brl40.add(brl60);
		assertTrue(money.getAmount() == 100);
	}
	@Test
	public void whenAddingValueTo0ReturnsValue() {
		Money brl0 = new Money(0, brl);
		Money moneySum = (Money) brl0.add(brl60);
		assertTrue(moneySum.getAmount() == 60);
	}
	
	// Testes referentes ao procedimento 3:
	@Test
	public void whenAdding0ToValueReturnsValue() {
		Money brl0 = new Money(0, brl);
		Money moneySum = (Money) brl60.add(brl0);
		assertEquals(60, moneySum.getAmount());
	}
	
	// Testes referentes ao procedimento 10:
	@Test
	public void whenAddingDifferentCurrenciesReturnsMoneyBag() {
		Object sum = brl40.add(eur30);
		assertTrue(sum instanceof MoneyBag);
		MoneyBag moneyBag = (MoneyBag) sum;
		assertTrue(moneyBag.contains(brl40));
		assertTrue(moneyBag.contains(eur30));
	}
	
}
