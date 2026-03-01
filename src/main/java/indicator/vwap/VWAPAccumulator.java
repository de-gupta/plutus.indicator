package indicator.vwap;

import types.PriceType;
import types.SizeType;
import types.TypeFactory;
import types.WholeTradingType;

public final class VWAPAccumulator<P extends PriceType<P>, S extends SizeType<S>>
{
	private final VWAPAccumulationType accumulation = VWAPTypeFactory.zero();
	private final SizeType<WholeTradingType> totalSize = TypeFactory.fromSize(0);
	private final SizeType<WholeTradingType> totalSize2 = TypeFactory.fromSize(0);
	private final WholeTradingType totalSize3 = null;
	private final WholeTradingType totalSize4 = null;




}