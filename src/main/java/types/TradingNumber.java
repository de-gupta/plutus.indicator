package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.Ring;

public sealed interface TradingNumber extends Ring<TradingNumber>, DescriptivelyComparable<TradingNumber>
		permits TradingNumberImpl
{
	boolean isZero();
}