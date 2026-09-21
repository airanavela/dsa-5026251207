public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days) {
        super(id, days);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int firstThreeDaysPrice = 60000;
        int nextDayPrice = 45000;
        int setupFee = 20000;
        int totalPrice;
        if (days <= 3) {
            totalPrice = days * firstThreeDaysPrice;
        } else {

            int firstThreeDays = 3 * firstThreeDaysPrice;
            int remainingDays = days - 3;
            int remainingPrice = remainingDays * nextDayPrice;
            totalPrice = firstThreeDays + remainingPrice;
        }

        totalPrice = totalPrice + setupFee;
        return totalPrice;
    }

    @Override
    public String label() {
        String result = "Projector";
        return result;
    }
}