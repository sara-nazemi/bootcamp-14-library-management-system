package org.library.model;

import java.util.Date;

public class BookReservation extends BaseModel<Integer> {
    private Boolean isDelivery;
    private Integer fkMember;
    private Integer fkBook;
    private Date dateDelivery;
    private Date dateReservation;

    private BookReservation() {
    }

    private BookReservation(BookReservationBuilder bookReservationBuilder) {
        super(bookReservationBuilder.id);
        this.isDelivery = bookReservationBuilder.isDelivery;
        this.fkMember = bookReservationBuilder.fkMember;
        this.fkBook = bookReservationBuilder.fkBook;
        this.dateDelivery = bookReservationBuilder.dateDelivery;
        this.dateReservation = bookReservationBuilder.dateReservation;
    }


    public Boolean getDelivery() {
        return isDelivery;
    }

    public void setDelivery(Boolean delivery) {
        isDelivery = delivery;
    }

    public Integer getFkMember() {
        return fkMember;
    }

    public void setFkMember(Integer fkMember) {
        this.fkMember = fkMember;
    }

    public Integer getFkBook() {
        return fkBook;
    }

    public void setFkBook(Integer fkBook) {
        this.fkBook = fkBook;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "BookReservation{" +
                "isDelivery=" + isDelivery +
                ", fkMember=" + fkMember +
                ", fkBook=" + fkBook +
                ", dateDelivery=" + dateDelivery +
                ", dateReservation=" + dateReservation +
                '}';
    }

    public static class BookReservationBuilder {
        private Integer id;
        private Boolean isDelivery;
        private Integer fkMember;
        private Integer fkBook;
        private Date dateDelivery;
        private Date dateReservation;

        public BookReservationBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public BookReservationBuilder setDelivery(Boolean delivery) {
            isDelivery = delivery;
            return this;
        }

        public BookReservationBuilder setFkMember(Integer fkMember) {
            this.fkMember = fkMember;
            return this;
        }

        public BookReservationBuilder setFkBook(Integer fkBook) {
            this.fkBook = fkBook;
            return this;
        }

        public BookReservationBuilder setDateDelivery(Date dateDelivery) {
            this.dateDelivery = dateDelivery;
            return this;
        }

        public BookReservationBuilder setDateReservation(Date dateReservation) {
            this.dateReservation = dateReservation;
            return this;
        }

        public BookReservation build() {
            return new BookReservation(this);
        }
    }
}
