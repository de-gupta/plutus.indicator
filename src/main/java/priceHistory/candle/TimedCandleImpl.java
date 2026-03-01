package priceHistory.candle;

import types.TimestampType;

import java.time.Duration;

record TimedCandleImpl(TimestampType startTime, Duration duration, Candle candle, IntervalType intervalType)
		implements TimedCandle
{
}