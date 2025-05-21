public class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) { 
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
		this.hoursParked=hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }
	
    public int getHoursParked() {
        return hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles=new Vehicle[5];
    private int parkedVehiclesCount=0; 

    public void parkVehicle(Vehicle vehicle) {
        if (parkedVehiclesCount < vehicles.length) {
            vehicles[parkedVehiclesCount] = vehicle;
            parkedVehiclesCount++;
            System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked successfully.");
        } else {
            System.out.println("Parking lot is full. Cannot park more vehicles.");
        }
    }

    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < parkedVehiclesCount; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
               
                for (int j = i; j < parkedVehiclesCount - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[parkedVehiclesCount - 1] = null; 
                parkedVehiclesCount--;
                found = true;
                System.out.println("Vehicle " + licensePlate + " removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        }
    }

    public void displayAllParkedVehicles() {
        if (parkedVehiclesCount == 0) {
            System.out.println("No vehicles currently parked.");
            return;
        }
        for (int i = 0; i < parkedVehiclesCount; i++) {
            System.out.println("Account "+vehicles[i].getLicensePlate()+"Holder: "+vehicles[i].getOwnerName()+"Balance: "+vehicles[i].getHoursParked());
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2)); 
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1)); 

        parkingLot.removeVehicle("XYZ789"); 

        parkingLot.displayAllParkedVehicles(); 
		
    }
}