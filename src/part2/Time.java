package part2;

public class Time {
	private int hour = 0; // 24 h
	private int minute = 0; // 59 min
	private int second = 0; // 59 s

	public Time() {
	}

	/**
	 * The operation sets the time if given parameters are valid
	 * 
	 * @param hour
	 * @param minute
	 * @param second
	 * @return - current set time
	 */
	public void timeSet(int hour, int minute, int second) {
		if (hour > 00 && hour <= 24 && minute >= 00 && minute <= 60
				&& second >= 00 && second <= 60) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;

		}
	}

	/**
	 * The operation returns current time
	 * @return
	 */
	public String showTime() {
		return hour + ":" + minute + ":" + second;

	}

}