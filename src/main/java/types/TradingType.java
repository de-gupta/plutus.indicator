package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.AdditiveGroup;

public sealed interface TradingType extends DescriptivelyComparable<TradingType>, AdditiveGroup<TradingType>
		permits MoneyType, PriceType, SizeType, WholeTradingType
{
	boolean isZero();
}