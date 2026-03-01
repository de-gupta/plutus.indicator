package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.AdditiveGroup;

public sealed interface SizeType extends TradingType, AdditiveGroup<SizeType>, DescriptivelyComparable<SizeType>
		permits SizeTypeImpl
{
}