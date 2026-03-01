package indicator.vwap;

import de.gupta.commons.utility.math.algebra.algebraicGroup.GroupStructure;

interface VWAPAccumulationType extends GroupStructure<VWAPAccumulationType>
{
	long value();
}