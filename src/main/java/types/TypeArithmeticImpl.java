package types;

final class TypeArithmeticImpl implements TypeArithmetic
{
	@Override
	public PriceType add(final PriceType left, final PriceType right)
	{
		return left.add(right);
	}

	@Override
	public SizeType add(final SizeType left, final SizeType right)
	{
		return left.add(right);
	}

	@Override
	public MoneyType add(final MoneyType left, final MoneyType right)
	{
		return left.add(right);
	}

	@Override
	public MoneyType multiply(final PriceType price, final SizeType size)
	{
		return TypeFactory.fromMoney(price.value().multiply(size.value()));
	}

	@Override
	public PriceType divide(final MoneyType money, final SizeType size)
	{
		return null;
	}
}