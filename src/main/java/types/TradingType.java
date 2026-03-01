package types;

public sealed interface TradingType permits MoneyType, PriceType, SizeType
{
	TradingNumber value();

	default boolean isZero()
	{
		return value().isZero();
	}
}