package org.library.model;

public class MemberInfo {
    private String address;
    private String telephoneNumber;
    private String city;
    private Integer fkMember;

    private MemberInfo() {
    }

    private MemberInfo(MemberInfoBuilder memberInfoBuilder) {
        this.address = memberInfoBuilder.address;
        this.telephoneNumber = memberInfoBuilder.telephoneNumber;
        this.city = memberInfoBuilder.city;
        this.fkMember = memberInfoBuilder.fkMember;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getFkMember() {
        return fkMember;
    }

    public void setFkMember(Integer fkMember) {
        this.fkMember = fkMember;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", fkMember=" + fkMember +
                '}';
    }

    public static class MemberInfoBuilder {
        private String address;
        private String telephoneNumber;
        private String city;
        private Integer fkMember;

        public MemberInfoBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public MemberInfoBuilder setTelephoneNumber(String telephoneNumber) {
            this.telephoneNumber = telephoneNumber;
            return this;
        }

        public MemberInfoBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public MemberInfoBuilder setFkMember(Integer fkMember) {
            this.fkMember = fkMember;
            return this;
        }

        public MemberInfo build() {
            return new MemberInfo(this);
        }
    }
}
