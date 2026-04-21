import java.util.*;
import java.io.*;

public class WasteManager {
    private List<WasteRecord> records = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int idCounter = 1;

    // ===== ADD =====
    public void addRecord() {
        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Type: ");
        String type = scanner.nextLine();

        double amount;
        while (true) {
            try {
                System.out.print("Amount: ");
                amount = Double.parseDouble(scanner.nextLine().replace(",", "."));
                break;
            } catch (Exception e) {
                System.out.println("Enter number!");
            }
        }

        System.out.print("Location: ");
        String location = scanner.nextLine();

        records.add(new WasteRecord(idCounter++, date, type, amount, location));
        System.out.println("Added!");
    }

    // ===== SHOW =====
    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("No records.");
            return;
        }
        for (WasteRecord r : records) {
            System.out.println(r);
        }
    }

    // ===== DELETE =====
    public void deleteRecord() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean removed = records.removeIf(r -> r.getId() == id);
        System.out.println(removed ? "Deleted!" : "Not found!");
    }

    // ===== UPDATE =====
    public void updateRecord() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (WasteRecord r : records) {
            if (r.getId() == id) {
                System.out.print("New type: ");
                r.setType(scanner.nextLine());
                System.out.println("Updated!");
                return;
            }
        }
        System.out.println("Not found!");
    }

    // ===== SAVE =====
    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter("data.txt")) {
            for (WasteRecord r : records) {
                writer.println(
                        r.getId() + "," +
                                r.getDate() + "," +
                                r.getType() + "," +
                                r.getAmount() + "," +
                                r.getLocation()
                );
            }
        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    // ===== LOAD =====
    public void loadFromFile() {
        try {
            File file = new File("data.txt");
            if (!file.exists()) return;

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String[] p = fileScanner.nextLine().split(",");

                int id = Integer.parseInt(p[0]);
                String date = p[1];
                String type = p[2];
                double amount = Double.parseDouble(p[3]);
                String location = p[4];

                records.add(new WasteRecord(id, date, type, amount, location));

                if (id >= idCounter) idCounter = id + 1;
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Error loading");
        }
    }
}