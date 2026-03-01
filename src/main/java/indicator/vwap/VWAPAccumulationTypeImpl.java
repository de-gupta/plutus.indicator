package indicator.vwap;

record VWAPAccumulationTypeImpl(long value) implements VWAPAccumulationType
{
	static VWAPAccumulationType fromValue(final long value)
	{
		return new VWAPAccumulationTypeImpl(value);
	}

	@Override
	public VWAPAccumulationType identity()
	{
		return fromValue(0);
	}

	@Override
	public VWAPAccumulationType inverse(final VWAPAccumulationType element)
	{
		return fromValue(-element.value());
	}

	@Override
	public VWAPAccumulationType multiply(final VWAPAccumulationType a, final VWAPAccumulationType b)
	{
		return fromValue(a.value() * b.value());
	}
}