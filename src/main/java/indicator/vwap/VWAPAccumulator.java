package indicator.vwap;

import types.PriceType;
import types.SizeType;

public interface VWAPAccumulator
{
	void update(final PriceType price, final SizeType size);

	void reset();

	PriceType value();
}