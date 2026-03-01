package types;

import de.gupta.commons.utility.comparison.ComparisonResult;

record MoneyTypeImpl(TradingNumber value) implements MoneyType
{
	@Override
	public ComparisonResult compare(final MoneyType other)
	{
		return switch (other)
		{
			case MoneyTypeImpl w -> value.compare(w.value());
		};
	}

	@Override
	public MoneyType zero()
	{
		return from(TradingNumberFactory.zero());
	}

	@Override
	public MoneyType add(final MoneyType other)
	{
		return switch (other)
		{
			case MoneyTypeImpl w -> from(value.add(w.value()));
		};
	}

	@Override
	public MoneyType negative()
	{
		return from(value.negative());
	}

	static MoneyType from(TradingNumber value)
	{
		return new MoneyTypeImpl(value);
	}
}