package org.library.model;

public class Member extends BaseModel<Integer> {

    private String name;
    private String family;
    private String nationalId;

    private Member() {
    }

    private Member(MemberBuilder memberBuilder) {
        super(memberBuilder.id);
        this.name = memberBuilder.name;
        this.family = memberBuilder.family;
        this.nationalId = memberBuilder.nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", nationalId='" + nationalId + '\'' +
                '}';
    }

    public static class MemberBuilder {

        private Integer id;
        private String name;
        private String family;
        private String nationalId;

        public MemberBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public MemberBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MemberBuilder setFamily(String family) {
            this.family = family;
            return this;
        }

        public MemberBuilder setNationalId(String nationalId) {
            this.nationalId = nationalId;
            return this;
        }

        public Member build() {
            return new Member(this);
        }
    }
}
