package priceHistory.candlestick;

import types.PriceType;
import types.SizeType;

public final class CandleFactory
{
	public static <P extends PriceType<P>, S extends SizeType<S>> Candle<P, S> create(final P open, final P high, final P low, final P close, final S volume)
	{
		return CandleImpl.create(open, high, low, close, volume);
	}
}