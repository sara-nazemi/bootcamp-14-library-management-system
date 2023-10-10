package org.library.dto;

import java.util.Date;

public class MemberReserveHistoryDto {
    private String memberName;
    private String memberFamily;
    private String memberNationalId;
    private String memberInfoTelephone;
    private String memberInfoAddress;
    private String memberInfoCity;
    private Date bookReservationDateReserve;
    private Date bookReservationDateDelivery;
    private Boolean bookReservationIsDelivery;
    private String bookTitle;

    private MemberReserveHistoryDto() {
    }

    private MemberReserveHistoryDto(MemberReserveHistoryBuilder memberReserveHistoryBuilder) {

        this.memberName = memberReserveHistoryBuilder.memberName;
        this.memberFamily = memberReserveHistoryBuilder.memberFamily;
        this.memberNationalId = memberReserveHistoryBuilder.memberNationalId;
        this.memberInfoTelephone = memberReserveHistoryBuilder.memberInfoTelephone;
        this.memberInfoAddress = memberReserveHistoryBuilder.memberInfoAddress;
        this.memberInfoCity = memberReserveHistoryBuilder.memberInfoCity;
        this.bookReservationDateReserve = memberReserveHistoryBuilder.bookReservationDateReserve;
        this.bookReservationDateDelivery = memberReserveHistoryBuilder.bookReservationDateDelivery;
        this.bookReservationIsDelivery = memberReserveHistoryBuilder.bookReservationIsDelivery;
        this.bookTitle = memberReserveHistoryBuilder.bookTitle;


    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberFamily() {
        return memberFamily;
    }

    public String getMemberNationalId() {
        return memberNationalId;
    }

    public String getMemberInfoTelephone() {
        return memberInfoTelephone;
    }

    public String getMemberInfoAddress() {
        return memberInfoAddress;
    }

    public String getMemberInfoCity() {
        return memberInfoCity;
    }

    public Date getBookReservationDateReserve() {
        return bookReservationDateReserve;
    }

    public Date getBookReservationDateDelivery() {
        return bookReservationDateDelivery;
    }

    public Boolean getBookReservationIsDelivery() {
        return bookReservationIsDelivery;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    @Override
    public String toString() {
        return "MemberReserveHistory{" +
                "memberName='" + memberName + '\'' +
                ", memberFamily='" + memberFamily + '\'' +
                ", memberNationalId='" + memberNationalId + '\'' +
                ", memberInfoTelephone='" + memberInfoTelephone + '\'' +
                ", memberInfoAddress='" + memberInfoAddress + '\'' +
                ", memberInfoCity='" + memberInfoCity + '\'' +
                ", bookReservationDateReserve=" + bookReservationDateReserve +
                ", bookReservationDateDelivery=" + bookReservationDateDelivery +
                ", bookReservationIsDelivery=" + bookReservationIsDelivery +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }

    public static class MemberReserveHistoryBuilder {
        private String memberName;
        private String memberFamily;
        private String memberNationalId;
        private String memberInfoTelephone;
        private String memberInfoAddress;
        private String memberInfoCity;
        private Date bookReservationDateReserve;
        private Date bookReservationDateDelivery;
        private Boolean bookReservationIsDelivery;
        private String bookTitle;

        public MemberReserveHistoryBuilder setMemberName(String memberName) {
            this.memberName = memberName;
            return this;
        }

        public MemberReserveHistoryBuilder setMemberFamily(String memberFamily) {
            this.memberFamily = memberFamily;
            return this;
        }

        public MemberReserveHistoryBuilder setMemberNationalId(String memberNationalId) {
            this.memberNationalId = memberNationalId;
            return this;
        }

        public MemberReserveHistoryBuilder setMemberInfoTelephone(String memberInfoTelephone) {
            this.memberInfoTelephone = memberInfoTelephone;
            return this;
        }

        public MemberReserveHistoryBuilder setMemberInfoAddress(String memberInfoAddress) {
            this.memberInfoAddress = memberInfoAddress;
            return this;
        }

        public MemberReserveHistoryBuilder setMemberInfoCity(String memberInfoCity) {
            this.memberInfoCity = memberInfoCity;
            return this;
        }

        public MemberReserveHistoryBuilder setBookReservationDateReserve(Date bookReservationDateReserve) {
            this.bookReservationDateReserve = bookReservationDateReserve;
            return this;
        }

        public MemberReserveHistoryBuilder setBookReservationDateDelivery(Date bookReservationDateDelivery) {
            this.bookReservationDateDelivery = bookReservationDateDelivery;
            return this;
        }

        public MemberReserveHistoryBuilder setBookReservationIsDelivery(Boolean bookReservationIsDelivery) {
            this.bookReservationIsDelivery = bookReservationIsDelivery;
            return this;
        }

        public MemberReserveHistoryBuilder setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
            return this;
        }

        public MemberReserveHistoryDto build() {
            return new MemberReserveHistoryDto(this);
        }
    }
}
