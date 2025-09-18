import java.util.*;

class Container {
    String id;
    String description;
    int weight;

    Container(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    public String toString() {
        return id + " | " + description + " | " + weight + "kg";
    }
}

class Ship {
    String name;
    String captain;

    Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    public String toString() {
        return name + " | Capt. " + captain;
    }
}

public class PortContainerManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Container> containerStack = new ArrayDeque<>();
        ArrayDeque<Ship> shipQueue = new ArrayDeque<>();

        int choice;

        do {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop container + poll ship)");
            System.out.println("[0] Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Container ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Weight (kg): ");
                    int weight = sc.nextInt();
                    sc.nextLine();
                    Container c = new Container(id, desc, weight);
                    containerStack.push(c);
                    System.out.println("Stored: " + c);
                    break;

                case 2:
                    System.out.println("TOP →");
                    for (Container ct : containerStack) {
                        System.out.println(ct);
                    }
                    System.out.println("← BOTTOM");
                    break;

                case 3:
                    System.out.print("Enter Ship Name: ");
                    String shipName = sc.nextLine();
                    System.out.print("Enter Captain Name (choose: Basan, Ferrer, Flores): ");
                    String cap = sc.nextLine();
                    Ship s = new Ship(shipName, cap);
                    shipQueue.offer(s);
                    System.out.println("Registered: " + s);
                    break;

                case 4:
                    System.out.println("FRONT →");
                    for (Ship sh : shipQueue) {
                        System.out.println(sh);
                    }
                    System.out.println("← REAR");
                    break;

                case 5:
                    if (!containerStack.isEmpty() && !shipQueue.isEmpty()) {
                        Container load = containerStack.pop();
                        Ship target = shipQueue.poll();
                        System.out.println("Loaded: " + load + " → " + target);
                        System.out.println("Remaining containers: " + containerStack.size());
                        System.out.println("Remaining ships waiting: " + shipQueue.size());
                    } else {
                        System.out.println("No containers or ships available!");
                    }
                    break;

                case 0:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
        sc.close();
    }
}
