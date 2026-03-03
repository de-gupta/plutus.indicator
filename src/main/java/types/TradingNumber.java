package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.ring.EuclideanDomain;

public sealed interface TradingNumber extends EuclideanDomain<TradingNumber>, DescriptivelyComparable<TradingNumber>
		permits TradingNumberImpl
{
	boolean isZero();
}