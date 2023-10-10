package org.library.service;

import org.library.model.MemberInfo;
import org.library.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class MemberInfoServiceImpl implements MemberInfoService {

    private String str;

    private static MemberInfoServiceImpl memberInfoServiceImpl;

    private MemberInfoServiceImpl() {
    }

    public static MemberInfoServiceImpl getInstance() {
        if (memberInfoServiceImpl == null) {
            synchronized (Lock.class) {
                if (memberInfoServiceImpl == null) {
                    memberInfoServiceImpl = new MemberInfoServiceImpl();
                }
            }
        }
        return memberInfoServiceImpl;
    }

    @Override
    public List<MemberInfo> getAll() {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from memberinfo");
            ResultSet resultSet = statement.executeQuery();
            List<MemberInfo> memberInfos = new ArrayList<>();
            while (resultSet.next()) {
                MemberInfo memberInfo = new MemberInfo.MemberInfoBuilder()
                        .setAddress(resultSet.getString(1))
                        .setTelephoneNumber(resultSet.getString(2))
                        .setCity(resultSet.getString(3))
                        .setFkMember(resultSet.getInt(4))
                        .build();
                memberInfos.add(memberInfo);
            }
            return memberInfos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(MemberInfo model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into memberinfo ( address,telephone, city, fk_member) values (?,?,?,?)");
            statement.setString(1, model.getAddress());
            statement.setString(2, model.getTelephoneNumber());
            statement.setString(3, model.getCity());
            statement.setInt(4, model.getFkMember());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(MemberInfo model) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("update memberinfo set address=? , telephone=? , city=?  where fk_member=?");
            statement.setString(1, model.getAddress());
            statement.setString(2, model.getTelephoneNumber());
            statement.setString(3, model.getCity());
            statement.setInt(4, model.getFkMember());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from memberinfo where fk_member=?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public MemberInfo loadById(Integer id) {
        try {
            Connection connection = DataBaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from memberinfo where id=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MemberInfo memberInfo = new MemberInfo.MemberInfoBuilder()
                        .setAddress(resultSet.getString(1))
                        .setTelephoneNumber(resultSet.getString(2))
                        .setCity(resultSet.getString(3))
                        .setFkMember(resultSet.getInt(4))
                        .build();
                return memberInfo;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
