package types;

public final class TypeFactory
{
	public static PriceType fromPrice(final TradingNumber price)
	{
		return PriceTypeImpl.from(price);
	}

	public static PriceType zeroPrice()
	{
		return PriceTypeImpl.from(TradingNumberFactory.zero());
	}

	public static SizeType fromSize(final TradingNumber size)
	{
		return SizeTypeImpl.from(size);
	}

	public static SizeType zeroSize()
	{
		return SizeTypeImpl.from(TradingNumberFactory.zero());
	}

	public static MoneyType fromMoney(final TradingNumber money)
	{
		return MoneyTypeImpl.from(money);
	}

	public static MoneyType zeroMoney()
	{
		return MoneyTypeImpl.from(TradingNumberFactory.zero());
	}
}