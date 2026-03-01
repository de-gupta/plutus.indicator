package types;

public final class TypeFactory
{
	public static PriceType<WholeTradingType> fromTicks(final long ticks)
	{
		return WholeTradingType.from(ticks);
	}

	public static SizeType<WholeTradingType> fromSize(final long size)
	{
		return WholeTradingType.from(size);
	}

	public static TradingType<WholeTradingType> fromValue(final long value)
	{
		return WholeTradingType.from(value);
	}
}