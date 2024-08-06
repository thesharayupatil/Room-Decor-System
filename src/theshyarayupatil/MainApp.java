package theshyarayupatil;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Home h = new Home();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("+--------------------------------+");
            System.out.println("|   Home Automation System Menu  |");
            System.out.println("+--------------------------------+");
            System.out.println("|1  |   Add Room                 |");
            System.out.println("|2  |   Add Device to Room       |");
            System.out.println("|3  |   Turn On Device           |");
            System.out.println("|4  |   Turn Off Device          |");
            System.out.println("|5  |   Check Status             |");
            System.out.println("|6  |   Show Rooms               |");
            System.out.println("|7  |   Exit                     |");
            System.out.println("+--------------------------------+");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addRoom(scanner, h);
                    break;
                case 2:
                    addDeviceToRoom(scanner, h);
                    break;
                case 3:
                    turnOnDevice(scanner, h);
                    break;
                case 4:
                    turnOffDevice(scanner, h);
                    break;
                case 5:
                    checkStatus(scanner, h);
                    break;
                case 6:
                    showRooms(h);
                    break;
                case 7:
                    System.out.println("Exiting the Home Automation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }

   
    
    
    private static void addRoom(Scanner scanner, Home h) {
        System.out.print("Enter the name of the room: ");
        String roomName = scanner.nextLine();

        if (h.findRoomByName(roomName) != null) {
            System.out.println("Room with the same name already exists. Please choose a different name.");
            return;
        }

        Room room = new Room(roomName);
        h.addRoom(room);
    }

    private static void showRooms(Home h) {
        System.out.println("Existing Rooms:");
        for (Room room : h.rooms) {
            System.out.println("- " + room.getName());
        }
    }

    private static void addDeviceToRoom(Scanner scanner, Home h) {
        System.out.println("Enter the name of the room: ");
        String roomToAddDevice = scanner.nextLine();
        Room selectedRoom = h.findRoomByName(roomToAddDevice);

        if (selectedRoom != null) {
            addDeviceToRoom(scanner, selectedRoom);
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void addDeviceToRoom(Scanner scanner, Room room) {
    	System.out.println("+--------------------------------+");
        System.out.println("Select the type of device to add |");
        System.out.println("+--------------------------------+");
        System.out.println("|  1 |    Light Bulb             |");
        System.out.println("|  2 |     TV                    |");
        System.out.println("|  3 |     AC                    |");
        System.out.println("|  4 |    Shower                 |");
        System.out.println("|  5 |     Fan                   |");
        System.out.println("+--------------------------------+");
        System.out.print("Enter the device type: ");
        int deviceTypeChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        automatable device = null;
        switch (deviceTypeChoice) {
            case 1:
                device = new Lightb();
                break;
            case 2:
                device = new TV();
                break;
            case 3:
                device = new AC();
                break;
            case 4:
                device = new Shower();
                break;
            case 5:
                device = new Fan();
                break;
            default:
                System.out.println("Invalid device type choice.");
                return;
        }

        room.addDevice(device);
    }

    private static void turnOnDevice(Scanner scanner, Home h) {
        System.out.print("Enter the name of the room: ");
        String roomNameToTurnOnDevice = scanner.nextLine();
        Room roomToTurnOnDevice = h.findRoomByName(roomNameToTurnOnDevice);

        if (roomToTurnOnDevice != null) {
            System.out.print("Enter the device type to turn on: ");
            String deviceTypeToTurnOn = scanner.nextLine();
            roomToTurnOnDevice.turnOnDevice(deviceTypeToTurnOn);
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void turnOffDevice(Scanner scanner, Home h) {
        System.out.print("Enter the name of the room: ");
        String roomNameToTurnOffDevice = scanner.nextLine();
        Room roomToTurnOffDevice = h.findRoomByName(roomNameToTurnOffDevice);

        if (roomToTurnOffDevice != null) {
            System.out.print("Enter the device type to turn off: ");
            String deviceTypeToTurnOff = scanner.nextLine();
            roomToTurnOffDevice.turnOffDevice(deviceTypeToTurnOff);
        } else {
            System.out.println("Room not found.");
        }
    }

    private static void checkStatus(Scanner scanner, Home h) {
        System.out.print("Enter the name of the room: ");
        String roomNameToCheckStatus = scanner.nextLine();
        Room roomToCheckStatus = h.findRoomByName(roomNameToCheckStatus);

        if (roomToCheckStatus != null) {
            roomToCheckStatus.checkStatus();
        } else {
            System.out.println("Room not found.");
        }
    }
}