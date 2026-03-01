package priceHistory.candlestick;

import de.gupta.commons.utility.math.algebra.algebraicGroup.Group;
import types.PriceType;
import types.SizeType;

record CandleImpl<P extends PriceType<P>, S extends SizeType<S>>(P open, P high, P low, P close, S volume)
		implements Candle<P, S>
{
	static <P extends PriceType<P>, S extends SizeType<S>> Candle<P, S> create(final P open, final P high, final P low, final P close, final S volume)
	{
		return new CandleImpl<>(open, high, low, close, volume);
	}
}