public class Record {
    protected int id;
    protected String date;

    public Record(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getInfo() {
        return id + " | " + date;
    }
}