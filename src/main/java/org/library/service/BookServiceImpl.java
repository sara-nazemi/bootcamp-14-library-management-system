package org.library.service;

import org.library.model.Book;
import org.library.dto.MemberReserveHistoryDto;
import org.library.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class BookServiceImpl implements BookService {

    private static BookServiceImpl bookServiceImpl;

    private BookServiceImpl() {
    }

    public static BookServiceImpl getInstance() {
        if (bookServiceImpl == null) {
            synchronized (Lock.class) {
                if (bookServiceImpl == null) {
                    bookServiceImpl = new BookServiceImpl();
                }
            }
        }
        return bookServiceImpl;
    }

    @Override
    public List<Book> getAll() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from book");
            ResultSet resultSet = statement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                Book book = new Book.BookBuilder()
                        .setId(resultSet.getInt(1))
                        .setTitle(resultSet.getString(2))
                        .setAuthor(resultSet.getString(3))
                        .setPublicationYear(resultSet.getInt(4))
                        .build();
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Book model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into book (title, author, publicationyear) values (?,?,?)");
            statement.setString(1, model.getTitle());
            statement.setString(2, model.getAuthor());
            statement.setInt(3, model.getPublicationYear());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Book model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update book set title=? , author=? , publicationyear=? where id=?");
            statement.setString(1, model.getTitle());
            statement.setString(2, model.getAuthor());
            statement.setInt(3, model.getPublicationYear());
            statement.setInt(4, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from book where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Book loadById(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from book where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book.BookBuilder()
                        .setId(resultSet.getInt(1))
                        .setTitle(resultSet.getString(2))
                        .setAuthor(resultSet.getString(3))
                        .setPublicationYear(resultSet.getInt(4))
                        .build();
                return book;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MemberReserveHistoryDto> loadByTitle(String title) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select m.name, " +
                    "       m.family, " +
                    "       m.nationalid, " +
                    "       mi.telephone, " +
                    "       mi.address, " +
                    "       mi.city, " +
                    "       br.date_reservation, " +
                    "       br.date_delivery, " +
                    "       br.isdelivery, " +
                    "       b.title " +
                    " from member m " +
                    "    inner join memberinfo mi on m.id = mi.fk_member " +
                    " inner join bookreservation br on m.id = br.fk_member " +
                    " inner join book b on br.fk_book = b.id " +
                    " where title=?");
            statement.setString(1, title);
            ResultSet resultSet = statement.executeQuery();
            List<MemberReserveHistoryDto> memberReserveHistories = new ArrayList<>();
            while (resultSet.next()) {
                MemberReserveHistoryDto book = new MemberReserveHistoryDto.MemberReserveHistoryBuilder()
                        .setMemberName(resultSet.getString(1))
                        .setMemberFamily(resultSet.getString(2))
                        .setMemberNationalId(resultSet.getString(3))
                        .setMemberInfoTelephone(resultSet.getString(4))
                        .setMemberInfoAddress(resultSet.getString(5))
                        .setMemberInfoCity(resultSet.getString(6))
                        .setBookReservationDateReserve(resultSet.getDate(7))
                        .setBookReservationDateDelivery(resultSet.getDate(8))
                        .setBookReservationIsDelivery(resultSet.getBoolean(9))
                        .setBookTitle(resultSet.getString(10))
                        .build();
                memberReserveHistories.add(book);
            }
            return memberReserveHistories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
