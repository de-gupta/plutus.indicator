package types;

import de.gupta.commons.utility.comparison.ComparisonResult;

record WholeTradingType(long value) implements TradingType, PriceType, SizeType, MoneyType
{
	private static final WholeTradingType ZERO = from(0);
	private static final WholeTradingType ONE = from(1);

	static WholeTradingType from(final long price)
	{
		if (price == 0) return ZERO;
		if (price == 1) return ONE;

		return new WholeTradingType(price);
	}

	@Override
	public ComparisonResult compare(final TradingType other)
	{
		return switch (other)
		{
			case WholeTradingType w -> compare(w);
		};
	}

	@Override
	public boolean isZero()
	{
		return value == 0;
	}

	@Override
	public TradingType zero()
	{
		return ZERO;
	}

	@Override
	public TradingType add(final TradingType other)
	{
		return switch (other)
		{
			case WholeTradingType w -> from(value + w.value);
		};
	}

	@Override
	public TradingType negative()
	{
		return from(-value);
	}

	private ComparisonResult compare(final WholeTradingType other)
	{
		return switch (Long.compare(value, other.value))
		{
			case 0 -> ComparisonResult.EQUAL;
			case -1 -> ComparisonResult.LESS_THAN;
			case 1 -> ComparisonResult.GREATER_THAN;
			default -> throw new IllegalStateException("Unexpected value: " + value);
		};
	}
}