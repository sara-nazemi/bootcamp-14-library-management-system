package org.library.service;

import org.library.model.Member;
import org.library.dto.MemberReserveHistoryDto;
import org.library.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class MemberServiceImpl implements MemberService {

    private static MemberServiceImpl memberServiceImpl;


    private MemberServiceImpl() {
    }

    public static MemberServiceImpl getInstance() {
        if (memberServiceImpl == null) {
            synchronized (Lock.class) {
                if (memberServiceImpl == null) {
                    memberServiceImpl = new MemberServiceImpl();
                }
            }
        }
        return memberServiceImpl;
    }

    @Override
    public List<Member> getAll() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from member");
            ResultSet resultSet = statement.executeQuery();
            List<Member> members = new ArrayList<>();
            while (resultSet.next()) {
                Member member = new Member.MemberBuilder()
                        .setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setFamily(resultSet.getString(3))
                        .setNationalId(resultSet.getString(4))
                        .build();
                members.add(member);
            }
            return members;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Member model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into member (name, family,nationalid) values (?,?,?)");
            statement.setString(1, model.getName());
            statement.setString(2, model.getFamily());
            statement.setString(3, model.getNationalId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Member model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update member set name=? , family=?, nationalid=? where id=?");
            statement.setString(1, model.getName());
            statement.setString(2, model.getFamily());
            statement.setString(3, model.getNationalId());
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
            PreparedStatement statement = connection.prepareStatement("delete from member where id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Member loadById(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from member where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member.MemberBuilder()
                        .setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setFamily(resultSet.getString(3))
                        .setNationalId(resultSet.getString(4))
                        .build();
                return member;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Member loadByNationalId(String nationalId) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from member where nationalid=?");
            statement.setString(1, nationalId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Member member = new Member.MemberBuilder()
                        .setId(resultSet.getInt(1))
                        .setName(resultSet.getString(2))
                        .setFamily(resultSet.getString(3))
                        .setNationalId(resultSet.getString(4))
                        .build();
                return member;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<MemberReserveHistoryDto> loadByNationalId1(String nationalId) {
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
                    " where nationalid = ? ");
            statement.setString(1, nationalId);
            ResultSet resultSet = statement.executeQuery();
            List<MemberReserveHistoryDto> memberReserveHistories = new ArrayList<>();
            while (resultSet.next()) {
                MemberReserveHistoryDto member = new MemberReserveHistoryDto.MemberReserveHistoryBuilder()
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
                memberReserveHistories.add(member);
            }
            return memberReserveHistories;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
