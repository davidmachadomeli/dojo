package com.mercadolibre.dojos;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.dojos.exception.OccupiedCellException;
import com.mercadolibre.dojos.model.IBomberman;
import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IEnemy;
import com.mercadolibre.dojos.model.impl.Bomberman;
import com.mercadolibre.dojos.model.impl.Cell;
import com.mercadolibre.dojos.model.impl.Enemy;
import com.mercadolibre.dojos.model.impl.Wall;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	private IBomberman bomber;
	
	@Before
	public void setup() throws OccupiedCellException {
		 this.bomber = new Bomberman( new Cell() );
	}
	
	@Test
	public void testBomberman_whenHeStepsIntoAnEmptyCell_shouldMoveIntoThatCell() throws OccupiedCellException {
		// SETUP
		ICell here = new Cell();
		
		// WHEN
		this.bomber.stepsIn(here);
		
		// THEN
		assertThat(this.bomber.isIn(here), is( true ));
	}
	
	@Test(expected = OccupiedCellException.class)
	public void testBomberman_whenHeStepsIntoAnOccupiedCell_shouldNotMoveAndThrowException() throws OccupiedCellException {
		// SETUP
		final Cell here = new Cell( new Wall() );
		
		// WHEN
		this.bomber.stepsIn(here);
	}
	
	@Test
	public void testBomberman_whenStepsIntoACellWhichIsOccupiedWithAnEnemy_shouldDie() throws OccupiedCellException {
		// SETUP
		final Cell here = new Cell();
		final IEnemy enemy = new Enemy(here);
		
		// PRE VALIDATION
		assertThat(here.isOccupiedBy(enemy), is( true ));
		
		// WHEN
		this.bomber.stepsIn(here);
		
		// THEN
		assertThat(here.isOccupiedBy(enemy), is( true ));
		assertThat(here.isOccupiedBy(this.bomber), is( false ));
		assertThat(this.bomber.isDead(), is( true ));
		assertThat(this.bomber.isAlive(), is( false ));
	}
	
//	@Test
//	public void testBomberman_whenBombermanLeavesABoomNextToABrick_shouldExplodeAndDissapearTheBrick() throws OccupiedCellException {
//		// SETUP
//		final Cell here = new Cell();
//		final IOccupier brick = new Brick(here);
//		
//		// WHEN
//		this.bomber.leaveBoomIn(here);
//		
//		// THEN
//		assertThat(here.isOccupiedBy(brick), is( false ));
//		assertThat(here.isOccupied(), is( true ));
//	}
	
}
