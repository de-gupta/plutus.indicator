package indicator.vwap;

import types.*;

final class VWAPAccumulatorImpl implements VWAPAccumulator
{
	private final TypeArithmetic arithmetic;

	private MoneyType accumulatedNotional = TypeFactory.zeroMoney();
	private SizeType accumulatedSize = TypeFactory.zeroSize();

	@Override
	public synchronized void update(final PriceType price, final SizeType size)
	{
		MoneyType amount = arithmetic.multiply(price, size);
		accumulatedNotional = arithmetic.add(accumulatedNotional, amount);
		accumulatedSize = arithmetic.add(accumulatedSize, size);
	}

	@Override
	public synchronized void reset()
	{
		accumulatedNotional = TypeFactory.zeroMoney();
		accumulatedSize = TypeFactory.zeroSize();
	}

	@Override
	public synchronized PriceType value()
	{
		return accumulatedSize.isZero() ? TypeFactory.zeroPrice() : arithmetic.divide(accumulatedNotional, accumulatedSize);
	}

	VWAPAccumulatorImpl(final TypeArithmetic arithmetic)
	{
		this.arithmetic = arithmetic;
	}
}