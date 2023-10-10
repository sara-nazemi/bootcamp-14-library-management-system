package org.library;

import org.library.model.Book;
import org.library.model.BookReservation;
import org.library.model.Member;
import org.library.model.MemberInfo;
import org.library.service.BookReservationServiceImpl;
import org.library.service.BookServiceImpl;
import org.library.service.MemberInfoServiceImpl;
import org.library.service.MemberServiceImpl;
import org.library.util.DateUtil;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        BookReservationServiceImpl bookReservationService = BookReservationServiceImpl.getInstance();
        BookServiceImpl bookServiceImpl = BookServiceImpl.getInstance();
        MemberServiceImpl memberServiceImpl = MemberServiceImpl.getInstance();
        MemberInfoServiceImpl memberInfoServiceImpl = MemberInfoServiceImpl.getInstance();

        Date dateReservation = new Date();
        Date dateDelivery = DateUtil.addDate(dateReservation, 5);

        BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                .setDateReservation(dateReservation)
                .setDateDelivery(dateDelivery)
                .setDelivery(false)
                .setFkBook(1)
                .setFkMember(5235)
                .build();

        //bookReservationService.save(bookReservation);


        Book book5 = new Book.BookBuilder()
                .setTitle("art5")
                .setAuthor("p")
                .setPublicationYear(2017)
                .build();

        Book book6 = new Book.BookBuilder()
                .setTitle("science")
                .setAuthor("x")
                .setPublicationYear(3417)
                .build();

        Book book7 = new Book.BookBuilder()
                .setTitle("art6")
                .setAuthor("p")
                .setPublicationYear(2018)
                .build();

        Book book8 = new Book.BookBuilder()
                .setTitle("science2")
                .setAuthor("p")
                .setPublicationYear(3418)
                .build();

//        bookService.save(book5);
//        bookService.save(book6);
//        bookService.save(book7);
//        bookService.save(book8);

        Member member = new Member.MemberBuilder()
                .setName("ali")
                .setFamily("shaker")
                .build();

        Member member1 = new Member.MemberBuilder()
                .setName("maryam")
                .setFamily("rahmani")
                .build();

        Member member2 = new Member.MemberBuilder()
                .setName("ahmad")
                .setFamily("akbary")
                .build();

        Member member3 = new Member.MemberBuilder()
                .setName("fatemeh")
                .setFamily("izady")
                .build();

        Member member4 = new Member.MemberBuilder()
                .setName("farnaz")
                .setFamily("panahi")
                .build();

//        memberService.save(member);
//        memberService.save(member1);
//        memberService.save(member2);
//        memberService.save(member3);
//        memberService.save(member4);

        MemberInfo memberInfo=new MemberInfo.MemberInfoBuilder()
                .setAddress("abc")
                .setTelephoneNumber("123")
                .setCity("tehran")
                .setFkMember(5235)
                .build();

        MemberInfo memberInfo2=new MemberInfo.MemberInfoBuilder()
                .setAddress("def")
                .setTelephoneNumber("245")
                .setCity("kerman")
                .setFkMember(5236)
                .build();

        MemberInfo memberInfo3=new MemberInfo.MemberInfoBuilder()
                .setAddress("ghi")
                .setTelephoneNumber("769")
                .setCity("mashhad")
                .setFkMember(5237)
                .build();

        MemberInfo memberInfo4=new MemberInfo.MemberInfoBuilder()
                .setAddress("jkl")
                .setTelephoneNumber("013")
                .setCity("ahvaz")
                .setFkMember(5238)
                .build();

        MemberInfo memberInfo5=new MemberInfo.MemberInfoBuilder()
                .setAddress("mno")
                .setTelephoneNumber("093")
                .setCity("rasht")
                .setFkMember(5239)
                .build();

        MemberInfo memberInfo6=new MemberInfo.MemberInfoBuilder()
                .setAddress("klb")
                .setTelephoneNumber("890")
                .setCity("karaj")
                .setFkMember(5240)
                .build();

//        memberInfoService.save(memberInfo);
//        memberInfoService.save(memberInfo2);
//        memberInfoService.save(memberInfo3);
//        memberInfoService.save(memberInfo4);
//        memberInfoService.save(memberInfo5);
//        memberInfoService.save(memberInfo6);


    }
}