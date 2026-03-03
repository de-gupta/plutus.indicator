package types;

import de.gupta.commons.utility.comparison.ComparisonResult;
import de.gupta.commons.utility.math.algebra.ring.DivisionResult;

final class TradingNumberImpl implements TradingNumber
{
	private static final TradingNumber ZERO = from(0);
	private static final TradingNumber ONE = from(1);

	private final long value;

	@Override
	public TradingNumber zero()
	{
		return ZERO;
	}

	@Override
	public TradingNumber add(final TradingNumber other)
	{
		return switch (other)
		{
			case TradingNumberImpl w -> from(value + w.value);
		};
	}

	@Override
	public TradingNumber negative()
	{
		return from(-value);
	}

	@Override
	public ComparisonResult compare(final TradingNumber other)
	{
		return switch (other)
		{
			case TradingNumberImpl w -> compareValue(w);
		};
	}

	@Override
	public boolean isZero()
	{
		return value == 0;
	}

	@Override
	public TradingNumber identity()
	{
		return ONE;
	}

	@Override
	public TradingNumber multiply(final TradingNumber other)
	{
		return switch (other)
		{
			case TradingNumberImpl w -> from(Math.multiplyExact(value, w.value));
		};
	}

	@Override
	public DivisionResult<TradingNumber> divide(final TradingNumber other)
	{
		return switch (other)
		{
			case TradingNumberImpl w -> DivisionResult.of(from(Math.divideExact(value, w.value)), from(value % w.value));
		};
	}

	private ComparisonResult compareValue(final TradingNumberImpl other)
	{
		return switch (Long.compare(value, other.value))
		{
			case 0 -> ComparisonResult.EQUAL;
			case -1 -> ComparisonResult.LESS_THAN;
			case 1 -> ComparisonResult.GREATER_THAN;
			default -> throw new IllegalStateException("Unexpected value: " + value);
		};
	}

	static TradingNumber from(final long price)
	{
		if (price == 0) return ZERO;
		if (price == 1) return ONE;

		return new TradingNumberImpl(price);
	}

	private TradingNumberImpl(long value)
	{
		this.value = value;
	}
}