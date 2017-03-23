package com.mercadolibre.dojos.model.impl;

import com.mercadolibre.dojos.exception.OccupiedCellException;
import com.mercadolibre.dojos.model.IBomberman;
import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IEnemy;
import com.mercadolibre.dojos.model.IInmovableObject;
import com.mercadolibre.dojos.model.IOccupant;

public class Cell implements ICell {

	private IOccupant occupant;
	
	public Cell() {
		this.occupant = new Nothing();
	}
	
	public Cell(IOccupant newOccupant) {
		this.occupant = newOccupant;
	}

	public boolean isOccupiedBy(IOccupant occupant) {
		return this.occupant.equals(occupant);
	}

	public void reclaimedBy(IInmovableObject posibleOccupant) throws OccupiedCellException {
		this.occupant = posibleOccupant;
	}

	public void reclaimedBy(IBomberman posibleOccupant) throws OccupiedCellException {
		posibleOccupant.bumpsInto(this.occupant);
	}

	public void reclaimedBy(IEnemy posibleOccupant) throws OccupiedCellException {
		this.occupant = posibleOccupant;
	}

}
