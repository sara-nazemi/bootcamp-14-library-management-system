package org.library.service;

import org.library.exception.LibraryException;
import org.library.model.BookReservation;
import org.library.util.DataBaseConnection;
import org.library.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class BookReservationServiceImpl implements BookReservationService {


    private static BookReservationServiceImpl bookReservationService;

    private BookReservationServiceImpl() {
    }

    public static BookReservationServiceImpl getInstance() {
        if (bookReservationService == null) {
            synchronized (Lock.class) {
                if (bookReservationService == null) {
                    bookReservationService = new BookReservationServiceImpl();
                }
            }
        }
        return bookReservationService;
    }

    @Override
    public List<BookReservation> getAll() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, date_delivery, date_reservation, isdelivery, fk_book, fk_member from bookreservation");
            ResultSet resultSet = statement.executeQuery();
            List<BookReservation> bookReservations = new ArrayList<>();
            while (resultSet.next()) {
                BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                        .setId(resultSet.getInt(1))
                        .setDateDelivery(resultSet.getDate(2))
                        .setDateReservation(resultSet.getDate(3))
                        .setDelivery(resultSet.getBoolean(4))
                        .setFkBook(resultSet.getInt(5))
                        .setFkMember(resultSet.getInt(6))
                        .build();
                bookReservations.add(bookReservation);
            }
            return bookReservations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(BookReservation model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into bookreservation (date_delivery, date_reservation,isdelivery,fk_book,fk_member) " +
                            " values (?,?,?,?,?)");

            statement.setString(1, DateUtil.getDateTime(model.getDateDelivery()));
            statement.setString(2, DateUtil.getDateTime(model.getDateReservation()));
            statement.setBoolean(3, model.getDelivery());
            statement.setInt(4, model.getFkBook());
            statement.setInt(5, model.getFkMember());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(BookReservation model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update bookreservation set date_delivery=? , date_reservation=? , isdelivery=? , fk_book=? , fk_member=? where id=?");
            statement.setString(1, DateUtil.getDateTime(model.getDateDelivery()));
            statement.setString(2, DateUtil.getDateTime(model.getDateReservation()));
            statement.setBoolean(3, model.getDelivery());
            statement.setInt(4, model.getFkBook());
            statement.setInt(5, model.getFkMember());
            statement.setInt(5, model.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public BookReservation loadById(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, date_delivery, date_reservation, isdelivery, fk_book, fk_member from bookreservation where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                        .setId(resultSet.getInt(1))
                        .setDateDelivery(resultSet.getDate(2))
                        .setDateReservation(resultSet.getDate(3))
                        .setDelivery(resultSet.getBoolean(4))
                        .setFkBook(resultSet.getInt(5))
                        .setFkMember(resultSet.getInt(6))
                        .build();
                return bookReservation;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookReservation loadByBookIdAndMemberIdAndDeliveryIsFalse(Integer bookId, Integer memberId) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, date_delivery, date_reservation, isdelivery, fk_book, fk_member from bookreservation where fk_book=? and fk_member=? and isdelivery=0");
            statement.setInt(1, bookId);
            statement.setInt(2, memberId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                        .setId(resultSet.getInt(1))
                        .setDateDelivery(resultSet.getDate(2))
                        .setDateReservation(resultSet.getDate(3))
                        .setDelivery(resultSet.getBoolean(4))
                        .setFkBook(resultSet.getInt(5))
                        .setFkMember(resultSet.getInt(6))
                        .build();
                return bookReservation;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookReservation loadByBookIdAndDeliveryIsFalse(Integer bookId) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select id, date_delivery, date_reservation, isdelivery, fk_book, fk_member from bookreservation where fk_book=? and isdelivery=0");
            statement.setInt(1, bookId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                        .setId(resultSet.getInt(1))
                        .setDateDelivery(resultSet.getDate(2))
                        .setDateReservation(resultSet.getDate(3))
                        .setDelivery(resultSet.getBoolean(4))
                        .setFkBook(resultSet.getInt(5))
                        .setFkMember(resultSet.getInt(6))
                        .build();
                return bookReservation;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void reserve(Integer bookId, Integer memberId) {

        if (bookId == null || memberId == null) {
            throw new LibraryException("parameters can not be null");
        }

        BookReservation bookReservation1 = loadByBookIdAndMemberIdAndDeliveryIsFalse(bookId, memberId);
        if (bookReservation1 != null) {
            throw new LibraryException("you are reserved this book");
        }

        BookReservation bookReservation2 = loadByBookIdAndDeliveryIsFalse(bookId);
        if (bookReservation2 != null) {
            throw new LibraryException("this book reserved with someone");
        }

        Date dateReservation = new Date();
        Date dateDelivery = DateUtil.addDate(dateReservation, 5);

        BookReservation bookReservation = new BookReservation.BookReservationBuilder()
                .setDateReservation(dateReservation)
                .setDateDelivery(dateDelivery)
                .setDelivery(false)
                .setFkBook(bookId)
                .setFkMember(memberId)
                .build();

        bookReservationService.save(bookReservation);

    }

}
