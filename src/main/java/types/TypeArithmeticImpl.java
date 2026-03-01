package types;

final class TypeArithmeticImpl implements TypeArithmetic
{
	@Override
	public PriceType add(final PriceType left, final PriceType right)
	{
		return (PriceType) left.add(right);
	}

	@Override
	public SizeType add(final SizeType left, final SizeType right)
	{
		return (SizeType) left.add(right);
	}

	@Override
	public MoneyType add(final MoneyType left, final MoneyType right)
	{
		return (MoneyType) left.add(right);
	}

	@Override
	public MoneyType multiply(final PriceType price, final SizeType size)
	{
		return switch (price)
		{
			case WholeTradingType w ->
			{
				yield switch (size)
				{
					case WholeTradingType sw -> TypeFactory.fromMoney(w.value() * sw.value());
				};
			}
		};
	}

	@Override
	public PriceType divide(final MoneyType money, final SizeType size)
	{
		return null;
	}
}