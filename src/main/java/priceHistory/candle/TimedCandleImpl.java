package priceHistory.candle;

import plutus.datatypes.types.TimestampType;

import java.time.Duration;

record TimedCandleImpl(TimestampType startTime, Duration duration, Candle candle, IntervalType intervalType)
		implements TimedCandle
{
}