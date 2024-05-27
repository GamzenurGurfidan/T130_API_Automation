package pojos;

public class PojoHerOkuAppBookingDates {
    /*
                                 "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
     */
    private String checkin;
    private String checkout;

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public PojoHerOkuAppBookingDates(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public PojoHerOkuAppBookingDates() {
    }

    @Override
    public String toString() {
        return "PojoHerOkuAppBookingDates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}