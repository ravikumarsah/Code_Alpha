import java.util.Scanner;

// HotelReservationSystem

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize hotel with rooms
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room("Single", 1, 50.0));
        hotel.addRoom(new Room("Double", 2, 80.0));
        hotel.addRoom(new Room("Suite", 4, 150.0));

        // Menu
        boolean quit = false;
        while (!quit) {
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    hotel.searchAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner, hotel);
                    break;
                case 3:
                    viewBookingDetails(scanner, hotel);
                    break;
                case 4:
                    System.out.println("Thank you for using the hotel reservation system.");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }

    public static void makeReservation(Scanner scanner, Hotel hotel) {
        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.nextLine();
        System.out.print("Enter number of guests: ");
        int numGuests = scanner.nextInt();
        System.out.print("Enter check-in date (MM/DD/YYYY): ");
        String checkInDate = scanner.next();
        System.out.print("Enter number of nights: ");
        int numNights = scanner.nextInt();

        hotel.makeReservation(roomType, numGuests, checkInDate, numNights);
    }

    public static void viewBookingDetails(Scanner scanner, Hotel hotel) {
        System.out.print("Enter reservation ID: ");
        int reservationId = scanner.nextInt();
        hotel.viewBookingDetails(reservationId);
    }
}

class Hotel {
    private Room[] rooms;
    private Reservation[] reservations;
    private int nextReservationId;

    public Hotel() {
        rooms = new Room[10]; // Initialize with 10 rooms
        reservations = new Reservation[100]; // Max 100 reservations
        nextReservationId = 1;
    }

    public void addRoom(Room room) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == null) {
                rooms[i] = room;
                break;
            }
        }
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room != null && !room.isReserved()) {
                System.out.println(room);
            }
        }
    }

    public void makeReservation(String roomType, int numGuests, String checkInDate, int numNights) {
        for (Room room : rooms) {
            if (room != null && room.getType().equalsIgnoreCase(roomType) && !room.isReserved()) {
                reservations[nextReservationId - 1] = new Reservation(nextReservationId, room, numGuests, checkInDate,
                        numNights);
                System.out.println("Reservation successful. Your reservation ID is: " + nextReservationId);
                nextReservationId++;
                return;
            }
        }
        System.out.println("Sorry, no available rooms of type " + roomType + ".");
    }

    public void viewBookingDetails(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation != null && reservation.getId() == reservationId) {
                System.out.println(reservation);
                return;
            }
        }
        System.out.println("Reservation with ID " + reservationId + " not found.");
    }
}

class Room {
    private String type;
    private int capacity;
    private double price;
    private boolean reserved;

    public Room(String type, int capacity, double price) {
        this.type = type;
        this.capacity = capacity;
        this.price = price;
        this.reserved = false;
    }

    public String getType() {
        return type;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }

    public void release() {
        reserved = false;
    }

    @Override
    public String toString() {
        return "Room Type: " + type + ", Capacity: " + capacity + ", Price: $" + price;
    }
}

class Reservation {
    private int id;
    private Room room;
    private int numGuests;
    private String checkInDate;
    private int numNights;

    public Reservation(int id, Room room, int numGuests, String checkInDate, int numNights) {
        this.id = id;
        this.room = room;
        this.numGuests = numGuests;
        this.checkInDate = checkInDate;
        this.numNights = numNights;
        room.reserve();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + id + "\nRoom: " + room + "\nNumber of Guests: " + numGuests + "\nCheck-in Date: " + checkInDate + "\nNumber of Nights: " + numNights;
    }
}