package part2;

public class Time {
	private int hour = 00; // 24 h
	private int minute = 00; // 59 min
	private int second = 00; // 59 s

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
	public String timeSet(int hour, int minute, int second) {
		String res = null;
		if (hour > 0 && hour <= 24 && minute >= 00 && minute < 60
				&& second >= 0 && second < 60) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;


			res = showTime();

		}
		return res;
	}

	/**
	 * The operation returns current time
	 * @return
	 */
	public String showTime() {
		return 	String.format("%02d:%02d:%02d", hour, minute, second);


	}

}