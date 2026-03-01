package priceHistory.candlestick;

import types.PriceType;
import types.SizeType;

public interface Candle<P extends PriceType<P>, S extends SizeType<S>>
{
	P open();

	P high();

	P low();

	P close();

	S volume();

	default boolean isHollow()
	{
		return close().isGreaterThan(open());
	}

	default boolean isSolid()
	{
		return close().isLessThan(open());
	}

	default boolean closedHigherThan(P price)
	{
		return close().isGreaterThan(price);
	}
	default boolean closedLowerThan(P price)
	{
		return close().isLessThan(price);
	}

	default boolean closedHigherThan(Candle<P, S> other)
	{
		return closedHigherThan(other.close());
	}
	default boolean closedLowerThan(Candle<P, S> other)
	{
		return closedLowerThan(other.close());
	}
}