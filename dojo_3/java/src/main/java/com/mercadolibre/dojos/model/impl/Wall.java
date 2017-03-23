package com.mercadolibre.dojos.model.impl;

import com.mercadolibre.dojos.model.ICell;
import com.mercadolibre.dojos.model.IInmovableObject;

public class Wall implements IInmovableObject {

	public boolean isIn(ICell cell) {
		return false;
	}

}
