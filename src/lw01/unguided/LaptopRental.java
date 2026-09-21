public class LaptopRental extends Rental {
    public LaptopRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int pricePerDay = 40000;
        int setupFee = 10000;
        int rentalPrice = days * pricePerDay;
        int totalPrice = rentalPrice + setupFee;
        return totalPrice;
    }

    @Override
    public String label() {
        String result = "Laptop";
        return result;
    }
}
