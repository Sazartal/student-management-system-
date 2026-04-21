import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WasteManager manager = new WasteManager();
        manager.loadFromFile();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add");
            System.out.println("2. Show");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    manager.addRecord();
                    break;
                case 2:
                    manager.showRecords();
                    break;
                case 3:
                    manager.deleteRecord();
                    break;
                case 4:
                    manager.updateRecord();
                    break;
                case 5:
                    manager.saveToFile();
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Wrong choice!");
            }
        }
    }
}
