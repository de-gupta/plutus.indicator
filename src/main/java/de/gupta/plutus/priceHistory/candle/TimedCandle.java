package de.gupta.plutus.priceHistory.candle;

import plutus.datatypes.types.TimestampType;

import java.time.Duration;

public interface TimedCandle
{
	TimestampType startTime();

	Duration duration();

	Candle candle();

	IntervalType intervalType();
}