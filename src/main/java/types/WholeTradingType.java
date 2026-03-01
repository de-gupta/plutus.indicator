package types;

import de.gupta.commons.utility.comparison.ComparisonResult;

public record WholeTradingType(long value)
		implements TradingType<WholeTradingType>, PriceType<WholeTradingType>, SizeType<WholeTradingType>
{
	private static final WholeTradingType ZERO = from(0);

	static WholeTradingType from(final long price)
	{
		return new WholeTradingType(price);
	}

	@Override
	public ComparisonResult compare(final WholeTradingType other)
	{
		return switch (Long.compare(value, other.value))
		{
			case 0 -> ComparisonResult.EQUAL;
			case -1 -> ComparisonResult.LESS_THAN;
			case 1 -> ComparisonResult.GREATER_THAN;
			default -> throw new IllegalStateException("Unexpected value: " + value);
		};
	}

	@Override
	public WholeTradingType identity()
	{
		return ZERO;
	}

	@Override
	public WholeTradingType inverse(final WholeTradingType element)
	{
		return from(-element.value);
	}

	@Override
	public WholeTradingType multiply(final WholeTradingType a, final WholeTradingType b)
	{
		return from(a.value * b.value);
	}
}