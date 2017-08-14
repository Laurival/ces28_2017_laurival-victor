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

	// Processo 4 - Usar @Before com método de setup()
	@Before
	public void setUp() {
		// Processo 6 - Refatorar testes para que funcionem com a class Currency
		brl = new Currency("BRL");
		eur = new Currency("EUR");

		brl40 = new Money(40, brl);
		brl60 = new Money(60, brl);
		eur30 = new Money(30, eur);
	}

	// Processo 2 - teste para Money.add(Money money) com assertTrue
	@Test
	public void whenAdding40To60Returns100() {
		Money brl100 = (Money) brl40.add(brl60);
		assertTrue(brl100.getAmount() == 100);
	}

	@Test
	public void whenAddingValueTo0ExpectValue() {
		Money money = new Money(0, brl);
		money.add(brl60);
		assertTrue(money.getAmount() == 60);
	}

	// Processo 3 - teste para Money.add(Money money) com assertEquals
	@Test
	public void whenAdding0ToValueExpectValue() {
		Money brl0 = new Money(0, brl);
		brl60.add(brl0);
		assertEquals(60, brl60.getAmount());
	}

	// Processo 10 - Modificar método add() de Money para retornar MoneyBag ou Money
	// (2/2)
	@Test
	public void whenAddingDifferentCurrenciesReturnsMoneyBag() {
		Object sum = brl40.add(eur30);
		assertTrue(sum instanceof MoneyBag);
		MoneyBag moneyBag = (MoneyBag) sum;
		assertTrue(moneyBag.contains(brl40));
		assertTrue(moneyBag.contains(eur30));
	}

}
