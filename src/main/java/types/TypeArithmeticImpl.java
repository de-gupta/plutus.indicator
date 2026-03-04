package types;

import de.gupta.commons.utility.math.algebra.ring.DivisionResult;

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
		return TypeFactory.fromPrice(money.value().divide(size.value()).quotient());
	}

	@Override
	public DivisionResult<PriceType> divideExact(final MoneyType money, final SizeType size)
	{
		final var price = money.value().divide(size.value());
		return DivisionResult.of(TypeFactory.fromPrice(price.quotient()), TypeFactory.fromPrice(price.remainder()));
	}
}