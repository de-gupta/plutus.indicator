package types;

public final class TradingNumberFactory
{
	public static TradingNumber from(final long value)
	{
		return TradingNumberImpl.from(value);
	}

	public static TradingNumber zero()
	{
		return TradingNumberImpl.from(0);
	}
}