package types;

import de.gupta.commons.utility.comparison.DescriptivelyComparable;
import de.gupta.commons.utility.math.algebra.algebraicGroup.GroupStructure;

public interface TradingType<T extends TradingType<T>> extends DescriptivelyComparable<T>, GroupStructure<T>
{
}