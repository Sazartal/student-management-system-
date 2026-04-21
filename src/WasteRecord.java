public class WasteRecord extends Record {

    private String type;
    private double amount;
    private String location;

    public WasteRecord(int id, String date, String type, double amount, String location) {
        super(id, date);
        this.type = type;
        this.amount = amount;
        this.location = location;
    }

    public int getId() { return id; }
    public String getDate() { return date; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public String getLocation() { return location; }

    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return id + " | " + date + " | " + type + " | " + amount + "kg | " + location;
    }
}