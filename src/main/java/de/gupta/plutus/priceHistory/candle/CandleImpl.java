package de.gupta.plutus.priceHistory.candle;

import plutus.datatypes.types.PriceType;
import plutus.datatypes.types.SizeType;

record CandleImpl(PriceType open, PriceType high, PriceType low, PriceType close, SizeType volume)
		implements Candle
{
	static Candle create(final PriceType open, final PriceType high, final PriceType low, final PriceType close, final SizeType volume)
	{
		return new CandleImpl(open, high, low, close, volume);
	}
}