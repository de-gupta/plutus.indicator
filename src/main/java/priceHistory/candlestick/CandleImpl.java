package priceHistory.candlestick;

import types.PriceType;
import types.SizeType;

record CandleImpl(PriceType open, PriceType high, PriceType low, PriceType close, SizeType volume)
		implements Candle
{
	static Candle create(final PriceType open, final PriceType high, final PriceType low, final PriceType close, final SizeType volume)
	{
		return new CandleImpl(open, high, low, close, volume);
	}
}