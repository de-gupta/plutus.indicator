package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.AdditiveGroup;

public sealed interface MoneyType extends TradingType, AdditiveGroup<MoneyType>, DescriptivelyComparable<MoneyType>
		permits MoneyTypeImpl
{
}