package pojos;

public class BookingResponseBodyPojo {

    // 1) Tum keyler icin private variable lar olusturuyoruz
    private Integer bookingid;
    private BookingPojo booking;

    // 2) Tum parametrelerle ve parametresiz construclarimizi olusturuyoruz


    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }

    // 3) Getters and Setters

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    //4 toString() methodu olusturuyoruz


    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}
