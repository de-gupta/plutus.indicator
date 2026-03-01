package types;

public final class TypeFactory
{
	public static PriceType fromTicks(final long ticks)
	{
		return WholeTradingType.from(ticks);
	}

	public static SizeType fromSize(final long size)
	{
		return WholeTradingType.from(size);
	}

	public static MoneyType fromMoney(final long money)
	{
		return WholeTradingType.from(money);
	}

	public static TradingType fromValue(final long value)
	{
		return WholeTradingType.from(value);
	}
}