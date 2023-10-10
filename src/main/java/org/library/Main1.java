package org.library;

import org.library.service.*;

public class Main1 {
    public static void main(String[] args) {

        BookReservationService bookReservationService = BookReservationServiceImpl.getInstance();

        //bookReservationService.reserve(1, 5236);
        //bookReservationService.reserve(2, 5235);
        //bookReservationService.reserve(3, 5235);

        // bookReservationService.reserve(5,5238);

        MemberService memberService = MemberServiceImpl.getInstance();

        // System.out.println(memberService.loadByNationalId1("0013523652"));

        BookService bookService = BookServiceImpl.getInstance();

        System.out.println( bookService.loadByTitle("math"));

    }
}