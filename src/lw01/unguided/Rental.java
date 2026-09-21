public abstract class Rental implements Chargeable {

    private String id;
    private int days;
    public Rental(String id, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    @Override
    public abstract int calculateCharge();
    public int calculateCharge(int units) {

        if (units <= 0) {
            throw new IllegalArgumentException();
        }
        int charge = calculateCharge();
        int total = charge * units;
        return total;
    }

    public String label() {
        String result = "Rental";
        return result;
    }

    public String summary() {
        String result = id + " | " + label() + " | " + calculateCharge();
        return result;
    }
}