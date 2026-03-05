package de.gupta.plutus.indicator.vwap;

import de.gupta.commons.utility.math.algebra.ring.DivisionResult;
import plutus.datatypes.types.PriceType;
import plutus.datatypes.types.SizeType;

public interface VWAPAccumulator
{
	void update(final PriceType price, final SizeType size);

	void reset();

	DivisionResult<PriceType> value();
}