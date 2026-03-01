package types;

import de.gupta.commons.utility.comparison.ComparisonResult;

record PriceTypeImpl(TradingNumber value) implements PriceType
{
	@Override
	public ComparisonResult compare(final PriceType other)
	{
		return switch (other)
		{
			case PriceTypeImpl w -> value.compare(w.value());
		};
	}

	@Override
	public PriceType zero()
	{
		return from(TradingNumberFactory.zero());
	}

	@Override
	public PriceType add(final PriceType other)
	{
		return switch (other)
		{
			case PriceTypeImpl w -> from(value.add(w.value()));
		};
	}

	@Override
	public PriceType negative()
	{
		return from(value.negative());
	}

	static PriceType from(TradingNumber value)
	{
		return new PriceTypeImpl(value);
	}
}