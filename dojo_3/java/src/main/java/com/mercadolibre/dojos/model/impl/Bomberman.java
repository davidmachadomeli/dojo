package com.mercadolibre.dojos.model.impl;

import com.mercadolibre.dojos.exception.OccupiedCellException;
import com.mercadolibre.dojos.model.IBomberman;
import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IEnemy;
import com.mercadolibre.dojos.model.IInmovableObject;
import com.mercadolibre.dojos.model.IOccupant;

public class Bomberman implements IBomberman {

	private boolean amIDead;
	
	public Bomberman(Cell bornCell) throws OccupiedCellException {
		bornCell.reclaimedBy(this);
	}
	
	public void stepsIn(ICell newPosition) throws OccupiedCellException {
		newPosition.reclaimedBy(this);
	}

	public boolean isIn(ICell position) {
		return position.isOccupiedBy(this);
	}

	public boolean isDead() {
		return this.amIDead;
	}
	
	public boolean isAlive() {
		return !this.amIDead;
	}

	public void die() {
		this.amIDead = true;
	}

	public void bumpsIn(IInmovableObject inmovableObject) throws OccupiedCellException {
		throw new OccupiedCellException();
	}
	
	public void bumpsIn(IEnemy enemy) {
		this.die();
	}

	public void bumpsInto(IOccupant occupant) throws OccupiedCellException {
		this.bumpsIn(occupant);
	}

}
