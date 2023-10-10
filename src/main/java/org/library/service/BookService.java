package org.library.service;

import org.library.model.Book;
import org.library.dto.MemberReserveHistoryDto;

import java.util.List;

public interface BookService extends BaseService<Book,Integer> {

    List<MemberReserveHistoryDto> loadByTitle(String title);
}
