package types;

public interface TypeArithmetic
{
	PriceType add(final PriceType left, final PriceType right);
	SizeType add(final SizeType left, final SizeType right);
	MoneyType add(final MoneyType left, final MoneyType right);

	MoneyType multiply(final PriceType price, final SizeType size);

	PriceType divide(final MoneyType money, final SizeType size);
}