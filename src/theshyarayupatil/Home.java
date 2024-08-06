package theshyarayupatil;

import java.util.ArrayList;
import java.util.List;

public class Home {
	
	List<Room> rooms;
	
	Home(){
		this.rooms= new ArrayList<Room>();
	}
	
	public void addRoom(Room r) {
		
		rooms.add(r);
		System.out.println("Room added successfully");
	}
	
	  public Room findRoomByName(String roomName) {
	        for (Room room : rooms) {
	            if (room.getName().equalsIgnoreCase(roomName)) {
	                return room;
	            }
	        }
	        return null;
	  }

	

}
