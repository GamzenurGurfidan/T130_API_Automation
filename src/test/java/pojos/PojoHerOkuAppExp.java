package pojos;

public class PojoHerOkuAppExp {
    /*
        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
         */

    private int bookingid;
    private PojoHerOkuAppReq booking;

    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public PojoHerOkuAppReq getBooking() {
        return booking;
    }

    public void setBooking(PojoHerOkuAppReq booking) {
        this.booking = booking;
    }

    public PojoHerOkuAppExp(int bookingid, PojoHerOkuAppReq booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public PojoHerOkuAppExp() {
    }

    @Override
    public String toString() {
        return "PojoHerOkuAppExpBody{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}

