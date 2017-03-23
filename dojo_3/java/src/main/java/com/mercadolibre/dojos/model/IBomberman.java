package com.mercadolibre.dojos.model;

import com.mercadolibre.dojos.exception.OccupiedCellException;

public interface IBomberman extends IOccupant {

	boolean isIn(ICell cell);
	
	void stepsIn(ICell cell) throws OccupiedCellException;

	void bumpsInto(IOccupant occupant) throws OccupiedCellException;
	
	boolean isDead();
	
	boolean isAlive();

	void die();

}
