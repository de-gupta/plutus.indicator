package de.gupta.plutus.priceHistory.candle;

import plutus.datatypes.types.PriceType;
import plutus.datatypes.types.SizeType;

public final class CandleFactory
{
	public static Candle create(final PriceType open, final PriceType high, final PriceType low, final PriceType close,
								final SizeType volume)
	{
		return CandleImpl.create(open, high, low, close, volume);
	}
}