package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.AdditiveGroup;

public sealed interface PriceType extends TradingType, DescriptivelyComparable<PriceType>, AdditiveGroup<PriceType> permits PriceTypeImpl
{
}