package part2;



public class Clock {
	 private Time theTime;
	 private Date theDate; // vi antar att datum och tid skall vara statiskt eller skall detta implementeras som en uppräkning?
	 private State currentState;
	 
	 
	 public Clock(){
		 theTime = new Time();
		 theDate = new Date();
		 
	 }
	/**
	 * Toggles between Time and Date. The return value contains current date or
	 * current time.
	 * 
	 * @return current date or time.
	 */
	public String changeMode() {
//		if(this.currentState==State.SHOWDATE){
//			this.currentState = State.SHOWTIME;
//			return theTime.showTime();
//		}else if(this.currentState == State.SHOWTIME){
//			this.currentState = State.SHOWDATE;
//			return theDate.showDate();
//		}
		return null;
		
	}

	/**
	 * The operation returns the string Alter Time or Alter Date depending in what state the machine is in
	 * @return
	 */
	public String reset() {
//		if(this.currentState == State.SHOWTIME){
//			this.currentState = State.CHANGETIME;
//			return "Alter Time";
//		}else if(this.currentState == State.SHOWDATE){
//			this.currentState = State.CHANGEDATE;
//			return "Alter Date";
//		}
		return null;
	}

	/**
	 * Applies to Time or Date depending on which state the clock is in. The returner string is the current date or current time.
	 * @param hourOrYear
	 * @param minuteOrMonth
	 * @param secondOrDay
	 * @return current date or time depending on state
	 */
	public String set(int hourOrYear, int minuteOrMonth, int secondOrDay) {
//		if(this.currentState == State.CHANGETIME){
//			theTime.timeSet(hourOrYear, minuteOrMonth, secondOrDay);
//			this.currentState = State.SHOWTIME;
//			return theTime.showTime();
//		}else if(this.currentState == State.CHANGEDATE){
//			theDate.dateSet(hourOrYear, minuteOrMonth, secondOrDay);
//			this.currentState = State.SHOWDATE;
//		}
		return null;
	}
	
	public State getCurrentState(){
		return this.currentState;
	}

}
