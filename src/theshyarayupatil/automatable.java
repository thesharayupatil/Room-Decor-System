package theshyarayupatil;

public interface automatable {
	
	public void dON();
	
	public void dOFF();
	
	void setType(String s);
	
	String getType();
	
	 boolean getStatus();
	 
	 void setStatus(boolean status);
	 
	 long getTotalTimeInCurrentState();
	 
	 void setTotalTimeInCurrentState(long totalTimeInCurrentState);
	 
	 void updateUsageTime(long milliseconds);

}
