package indicator.vwap;

import types.*;

import java.util.concurrent.locks.StampedLock;

final class VWAPAccumulatorImpl implements VWAPAccumulator
{
	private final TypeArithmetic arithmetic;

	private final StampedLock lock = new StampedLock();

	private MoneyType accumulatedNotional = TypeFactory.zeroMoney();
	private SizeType accumulatedSize = TypeFactory.zeroSize();

	@Override
	public synchronized void update(final PriceType price, final SizeType size)
	{
		MoneyType amount = arithmetic.multiply(price, size);
		long stamp = lock.writeLock();
		try
		{
			accumulatedNotional = arithmetic.add(accumulatedNotional, amount);
			accumulatedSize = arithmetic.add(accumulatedSize, size);
		}
		finally
		{
			lock.unlockWrite(stamp);
		}
	}

	@Override
	public synchronized void reset()
	{
		long stamp = lock.writeLock();
		try
		{
			accumulatedNotional = TypeFactory.zeroMoney();
			accumulatedSize = TypeFactory.zeroSize();
		}
		finally
		{
			lock.unlockWrite(stamp);
		}
	}

	@Override
	public synchronized PriceType value()
	{
		// optimistic read first - no lock acquisition if no concurrent write
		long stamp = lock.tryOptimisticRead();
		MoneyType notional = accumulatedNotional;
		SizeType size = accumulatedSize;
		if (!lock.validate(stamp))
		{
			// concurrent write detected - fall back to full read lock
			stamp = lock.readLock();
			try
			{
				notional = accumulatedNotional;
				size = accumulatedSize;
			}
			finally
			{
				lock.unlockRead(stamp);
			}
		}
		return size.isZero() ? TypeFactory.zeroPrice() : arithmetic.divide(notional, size);
	}

	VWAPAccumulatorImpl(final TypeArithmetic arithmetic)
	{
		this.arithmetic = arithmetic;
	}
}