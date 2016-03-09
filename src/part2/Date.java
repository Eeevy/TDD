package part2;

public class Date {
	private int year = 2000; // 2000...2100
	private int month = 1; // Januari till december (1-12)
	private int day = 1; // 1...31
	
	/**
	 * The operation sets the date if the given parameters are valid
	 * @param year
	 * @param month
	 * @param day
	 */
	public String dateSet(int year, int month, int day) {
		String res = null;
		int monthType = 1;
		//months with 30 days (4, 6, 9, 11)
		if(month == 4 || month == 6 || month == 9 || month == 9 || month == 11 ){
			monthType = 0;
		}
		if(year >= 2000 && year <=2100 && month >=1 && month <= 12 && day > 00 && day <= (30 + monthType) ){
			this.year = year;
			this.month = month;
			this.day = day;
			res = String.format("%02d-%02d-%02d", year, month, day);
		}
		return res;
	}
	
	/**
	 * The operation returns current date
	 * @return
	 */
	public String showDate() {
		return String.format("%02d-%02d-%02d", year, month, day);

	}
}