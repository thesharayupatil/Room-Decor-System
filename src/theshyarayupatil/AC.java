package theshyarayupatil;

public class AC implements automatable {


	String type;
	boolean status;
	long totalTimeInCurrentState;
	long startTime;
	
	
	 AC(){
	 this.type= "AC";	
     this.status= false;
     this.totalTimeInCurrentState=0;
     this.startTime=0;	
	}
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getTotalTimeInCurrentState() {
		return totalTimeInCurrentState;
	}

	public void setTotalTimeInCurrentState(long totalTimeInCurrentState) {
		this.totalTimeInCurrentState = totalTimeInCurrentState;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public void dON() {
		if(status==false) {
			
			this.status=true;
			startTime=System.currentTimeMillis();
			System.out.println("AC is now ON");
			}
		else {
			System.out.println("AC is already ON");
		}
		
	}

	@Override
	public void dOFF() {
		if(status==true) {
			this.status=false;
			long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            updateUsageTime(elapsedTime);
			System.out.println("AC is now OFF");
		}
		else {	
			System.out.println("AC is already OFF");
		}		
	}
	
	
	public void updateUsageTime(long milliseconds){
		totalTimeInCurrentState += milliseconds;
	}

	
	
	
}
