package com.mercadolibre.dojos.model.impl;

import com.mercadolibre.dojos.exception.OccupiedCellException;
import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IEnemy;

public class Enemy implements IEnemy {

	public Enemy(Cell bornCell) throws OccupiedCellException {
		bornCell.reclaimedBy(this);
	}
	
	public boolean isIn(ICell cell) {
		return cell.isOccupiedBy(this);
	}

	public void stepsIn(ICell posiblePosition) throws OccupiedCellException {
		posiblePosition.reclaimedBy(this);
	}

}
