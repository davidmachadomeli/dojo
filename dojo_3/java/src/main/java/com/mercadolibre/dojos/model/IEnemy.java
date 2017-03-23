package com.mercadolibre.dojos.model;

import com.mercadolibre.dojos.exception.OccupiedCellException;

public interface IEnemy extends IOccupant {

	void stepsIn(ICell cell) throws OccupiedCellException;

}
