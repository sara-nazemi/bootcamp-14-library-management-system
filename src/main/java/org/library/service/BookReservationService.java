package org.library.service;

import org.library.model.BookReservation;

public interface BookReservationService extends BaseService<BookReservation, Integer> {

    BookReservation loadByBookIdAndMemberIdAndDeliveryIsFalse(Integer bookId, Integer memberId);
    BookReservation loadByBookIdAndDeliveryIsFalse(Integer bookId);

    void reserve(Integer bookId, Integer memberId);

}
