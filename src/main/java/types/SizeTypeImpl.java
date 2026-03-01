package types;

import de.gupta.commons.utility.comparison.ComparisonResult;

record SizeTypeImpl(TradingNumber value) implements SizeType
{
	@Override
	public ComparisonResult compare(final SizeType other)
	{
		return switch (other)
		{
			case SizeTypeImpl w -> value.compare(w.value());
		};
	}

	@Override
	public SizeType zero()
	{
		return from(TradingNumberFactory.zero());
	}

	@Override
	public SizeType add(final SizeType other)
	{
		return switch (other)
		{
			case SizeTypeImpl w -> from(value.add(w.value()));
		};
	}

	@Override
	public SizeType negative()
	{
		return from(value.negative());
	}

	static SizeType from(TradingNumber value)
	{
		return new SizeTypeImpl(value);
	}
}