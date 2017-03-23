package com.mercadolibre.dojos.model;

import com.mercadolibre.dojos.exception.OccupiedCellException;

public interface ICell {

	void reclaimedBy(IInmovableObject posibleOccupant) throws OccupiedCellException;
	
	void reclaimedBy(IBomberman posibleOccupant) throws OccupiedCellException;
	
	void reclaimedBy(IEnemy posibleOccupant) throws OccupiedCellException;

	boolean isOccupiedBy(IOccupant occupant);

}
