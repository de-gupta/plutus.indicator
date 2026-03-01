package indicator.vwap;

final class VWAPTypeFactory
{
	static VWAPAccumulationType zero()
	{
		return VWAPAccumulationTypeImpl.fromValue(0);
	}
}