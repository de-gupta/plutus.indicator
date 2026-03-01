package priceHistory.candlestick;

import types.PriceType;
import types.SizeType;

public interface Candle
{
	PriceType open();

	PriceType high();

	PriceType low();

	PriceType close();

	SizeType volume();

	default boolean isBullish()
	{
		return close().isGreaterThan(open());
	}

	default boolean isBearish()
	{
		return close().isLessThan(open());
	}

	default boolean closedHigherThan(PriceType price)
	{
		return close().isGreaterThan(price);
	}
	default boolean closedLowerThan(PriceType price)
	{
		return close().isLessThan(price);
	}

	default boolean closedHigherThan(Candle other)
	{
		return closedHigherThan(other.close());
	}
	default boolean closedLowerThan(Candle other)
	{
		return closedLowerThan(other.close());
	}
}