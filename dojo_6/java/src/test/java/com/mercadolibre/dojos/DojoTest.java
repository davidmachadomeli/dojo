package com.mercadolibre.dojos;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Test
	public void calculateSingleItemProfit() {
		// SETUP
		Item item = new Item( new Cost( new BigDecimal(10) ) );

		UnitSale sale = new UnitSale(item, new SellingPrice( new BigDecimal(20) ));

		// WHEN
		Profit profit = sale.profit();

		// THEN
		assertThat(profit, is(notNullValue()));
		assertThat(profit, is( equalTo(new Profit( new BigDecimal(10)) ) ));
	}

	@Test
	public void calculateMultipleItemsProfit() {
		// SETUP
		Item item1 = new Item( new Cost( new BigDecimal(10) ) );
		Item item2 = new Item( new Cost( new BigDecimal(20) ) );

		List<ISellingProduct> items = new ArrayList<ISellingProduct>();
		items.add(item1);
		items.add(item2);

		MultipleProductsSale sale = new MultipleProductsSale(items, new SellingPrice( new BigDecimal(60) ));

		// WHEN
		Profit profit = sale.profit();

		// THEN
		assertThat(profit, is(notNullValue()));
		assertThat(profit, is( equalTo(new Profit( new BigDecimal(30)) ) ));
	}

	@Test
	public void calculateOneUnitOfAPackProfit() {
		// SETUP
		Pack pack = new Pack( 50, new Cost( new BigDecimal(100) ) );

		UnitSale sale = new UnitSale(pack, new SellingPrice( new BigDecimal(10) ));

		// WHEN
		Profit profit = sale.profit();

		// THEN
		assertThat(profit, is(notNullValue()));
		assertThat(profit, is( equalTo(new Profit( new BigDecimal(8)) ) ));
	}

	@Test
	public void calculateThreeUnitsOfAPackProfit() {
		// SETUP
		Pack pack = new Pack( 50, new Cost( new BigDecimal(100) ) );

		MultipleProductsSale sale = new MultipleProductsSale(pack.getItems( 3 ), new SellingPrice( new BigDecimal(10) ));

		// WHEN
		Profit profit = sale.profit();

		// THEN
		assertThat(profit, is(notNullValue()));
		assertThat(profit, is( equalTo(new Profit( new BigDecimal(4)) ) ));
	}

	@Test
	@Ignore
	public void BarterOneItem() {
		// SETUP
		Item item = new Item( new Cost( new BigDecimal(100) ) );
		Cow muu = new Cow();

//		UnitSale sale = new UnitSale(item, new SellingPrice( muu ));
//		UnitSale sale = new UnitSale(item, new BartingPrice( muu ));

		// WHEN
//		IProfit profit = sale.profit();

		// THEN
//		assertThat(profit, is( equalTo( muu ) ));
	}

}
