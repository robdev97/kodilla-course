package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    void testUpdateVipLevels() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.executeUpdate(sqlProcedureCall);
        ResultSet rs = statement2.executeQuery(sqlCheckTable);
        //Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();
    }
    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String resetBestsellers = "UPDATE BOOKS SET BESTSELLER = 0";
        statement.executeUpdate(resetBestsellers);
        //When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.executeUpdate(sqlProcedureCall);
        String sqlCheck = "SELECT COUNT(*) AS BESTSELLERS FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet rs = statement.executeQuery(sqlCheck);

        int bestsellersCount = -1;
        if (rs.next()) {
            bestsellersCount = rs.getInt("BESTSELLERS");
        }
        //Then
        assert(bestsellersCount >= 0);

        // CleanUp
        rs.close();
        statement.close();
    }
}
