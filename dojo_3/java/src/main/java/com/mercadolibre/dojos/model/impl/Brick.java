package com.mercadolibre.dojos.model.impl;

import com.mercadolibre.dojos.exception.OccupiedCellException;
import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IInmovableObject;

public class Brick implements IInmovableObject {

	public Brick(Cell bornCell) throws OccupiedCellException {
		bornCell.reclaimedBy(this);
	}

	public boolean isIn(ICell cell) {
		return cell.isOccupiedBy(this);
	}

}
