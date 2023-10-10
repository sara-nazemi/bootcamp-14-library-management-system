create table book
(
    id              int auto_increment primary key,
    title           varchar(150) not null,
    author          varchar(150) null,
    publicationyear varchar(150) null
);

create table member
(
    id         int auto_increment primary key,
    name       varchar(150) null,
    family     varchar(150) null,
    nationalid varchar(10)  null,
    constraint member_nationalid_uindex unique (nationalid)
);

create table memberinfo
(
    telephone varchar(200) null,
    address   varchar(300) null,
    city      varchar(150) null,
    fk_member int          not null primary key,
    constraint memberinfo_member_id_fk foreign key (fk_member) references member (id)
);

create table bookreservation
(
    isdelivery       tinyint(1) default 1 null,
    fk_member        int                  not null,
    fk_book          int                  not null,
    id               int auto_increment primary key,
    date_delivery    datetime             null,
    date_reservation datetime             null,
    constraint bookreservation_book_id_fk foreign key (fk_book) references book (id),
    constraint bookreservation_member_id_fk foreign key (fk_member) references member (id)
);
