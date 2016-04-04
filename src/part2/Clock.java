package part2;



public class Clock {
	 private Time theTime;
	 private Date theDate; // vi antar att datum och tid skall vara statiskt eller skall detta implementeras som en uppräkning?
	 private State currentState;
	 
	 
	 public Clock(){
		 theTime = new Time();
		 theDate = new Date();
		 currentState = State.SHOWTIME;
		 
	 }
	/**
	 * Toggles between Time and Date. The return value contains current date or
	 * current time.
	 * 
	 * @return current date or time.
	 */
	public String changeMode() {
		String res = null;
		if(this.currentState==State.SHOWDATE){
			this.currentState = State.SHOWTIME;
			res = theTime.showTime();
		}else if(this.currentState == State.SHOWTIME){
			this.currentState = State.SHOWDATE;
			res = theDate.showDate();
		}
		return res;
		
	}

	/**
	 * The operation returns the string Alter Time or Alter Date depending in what state the machine is in
	 * @return
	 */
	public String reset() {
		String res = null;
		if(this.currentState == State.SHOWTIME){
			this.currentState = State.CHANGETIME;
			res = "Alter Time";
		}else if(this.currentState == State.SHOWDATE){
			this.currentState = State.CHANGEDATE;
			res = "Alter Date";
		}
		return res;
	}

	/**
	 * Applies to Time or Date depending on which state the clock is in. The returner string is the current date or current time.
	 * @param hourOrYear
	 * @param minuteOrMonth
	 * @param secondOrDay
	 * @return current date or time depending on state
	 */
	public String set(int hourOrYear, int minuteOrMonth, int secondOrDay) {
		String res = null;
		if(this.currentState == State.CHANGETIME){
			res = theTime.timeSet(hourOrYear, minuteOrMonth, secondOrDay);
			this.currentState = State.SHOWTIME;
		}else if(this.currentState == State.CHANGEDATE){
			res = theDate.dateSet(hourOrYear, minuteOrMonth, secondOrDay);
			this.currentState = State.SHOWDATE;
		}
		return res;
	}

}
