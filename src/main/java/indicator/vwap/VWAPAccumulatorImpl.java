package indicator.vwap;

import types.*;

final class VWAPAccumulatorImpl implements VWAPAccumulator
{
	private final TypeArithmetic arithmetic;

	private MoneyType accumulatedNotional = TypeFactory.fromMoney(0);
	private SizeType accumulatedSize = TypeFactory.fromSize(0);

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
		accumulatedNotional = TypeFactory.fromMoney(0);
		accumulatedSize = TypeFactory.fromSize(0);
	}

	@Override
	public synchronized PriceType value()
	{
		return accumulatedSize.isZero() ? TypeFactory.fromTicks(0) :
				arithmetic.divide(accumulatedNotional, accumulatedSize);
	}

	VWAPAccumulatorImpl(final TypeArithmetic arithmetic)
	{
		this.arithmetic = arithmetic;
	}
}