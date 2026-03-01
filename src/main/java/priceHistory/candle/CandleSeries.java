package priceHistory.candle;

import java.time.Duration;
import java.util.List;

public interface CandleSeries
{
	Duration timeframe();

	IntervalType intervalType();

	TimedCandle candle(int index);

	int size();

	List<TimedCandle> candles(int from, int to);

	List<TimedCandle> lastNCandles(int n);

	void add(TimedCandle candle);
}