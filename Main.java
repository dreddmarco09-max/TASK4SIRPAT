import java.util.List;
import java.util.Scanner;

public class Main {
   private static Repository repo = new Repository();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== HARDWARE LOGIC INTERPRETER =====");
            System.out.println("[1] Display Hardware Masterlist");
            System.out.println("[2] Add New Hardware Record");
            System.out.println("[3] Perform Polymorphic Audit");
            System.out.println("[4] Exit");
            System.out.print("Select an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    DisplayHardwareMasterList(repo.getHardwareData());
                    break;
                case 2:
                    addHardwareInput();
                    break;
                case 3:
                    
                    performPolymorphicAudit(repo.getHardwareData());
                    break;
                case 4:
                    running = false;
                    System.out.println("Closing connection and exiting...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    public static void addHardwareInput() {
        System.out.println("\n--- Input New Hardware ---");
        System.out.print("Enter Hardware Type (Laptop/Phone): ");
        String type = sc.nextLine();
        
        System.out.print("Enter Brand Name: ");
        String brand = sc.nextLine();
        
        System.out.print("Enter Specification Value: ");
        int spec = sc.nextInt();
        sc.nextLine(); 

        repo.addHardware(brand, spec, type);
    }

    public static void DisplayHardwareMasterList(List<Hardware> list) {
        System.out.println("\nID\tBrand\t\tSpec\t\tType\tExpected Interpretation");
        System.out.println("-----------------------------------------------------------------------");
        for (Hardware h : list) {
            
            System.out.println(h.getInterpretation());
        }
    }
    public static void performPolymorphicAudit(List<Hardware> list) {
        int laptop16 = 0;
        int laptop32 = 0;
        int phone50 = 0;

        
        for (Hardware h : list) {
            if (h instanceof Laptop) {
                if (h.getSpec() == 16) laptop16++;
                else if (h.getSpec() == 32) laptop32++;
            } else if (h instanceof Phone) {
                if (h.getSpec() == 50) phone50++;
            }
        }

        System.out.println("\n--- Laptop and Phone Inventory ---");
        System.out.println("Total number of 16GB Laptops: " + laptop16);
        System.out.println("Total number of 32GB Laptops: " + laptop32);
        System.out.println("Total number of 50MP Phones:  " + phone50);
    }
}