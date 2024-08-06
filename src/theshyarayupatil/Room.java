package theshyarayupatil;

import java.util.ArrayList;
import java.util.List;

public class Room {

	String name;
	//List<Device> devices;
	List<automatable> devices;
	
	Room(String name){
		this.name=name;
		this.devices = new ArrayList<automatable>(); 
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void addDevice(automatable d) {
		devices.add(d);
		System.out.println(d.getType()+" is added to the "+name);
	}
	
	 public void turnOnDevice(String deviceType) {
		 	for(automatable d : devices) {
	            if (d.getType().equalsIgnoreCase(deviceType)) {
	                d.dON();
	                return;
	            }
		 	}
		 	System.out.println("Device type " + deviceType + " not found in " + name + ".");
	 }
	 public void turnOffDevice(String deviceType) {
		 	for(automatable d : devices) {
	            if (d.getType().equalsIgnoreCase(deviceType)) {
	                d.dOFF();
	                return;
	            }
	        }
	        System.out.println("Device type " + deviceType + " not found in " + name + ".");
	    }
	 
	

	 public void checkStatus() {
		    System.out.println("Status of devices in " + name + ":");
		    System.out.println("+" + "-".repeat(58) + "+");
		    System.out.printf("| %-20s | %-10s | %-25s |\n", "Device Type", "Status", "Total Usage Time");
		    System.out.println("+" + "-".repeat(58) + "+");

		    for (automatable d : devices) {
		        String deviceStatus = d.getStatus() ? "ON" : "OFF";
		        String formattedOutput = String.format("| %-20s | %-10s | %-25d |",
		                d.getType(), deviceStatus, d.getTotalTimeInCurrentState());
		        System.out.println(formattedOutput);
		    }

		    System.out.println("+" + "-".repeat(58) + "+");
		}
}
