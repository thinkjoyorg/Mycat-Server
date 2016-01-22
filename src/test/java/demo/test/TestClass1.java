package demo.test;


import java.sql.*;

/**
 * @author mycat
 */
public class TestClass1 {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        String jdbcdriver = "com.mysql.jdbc.Driver";
        String jdbcurl = "jdbc:mysql://172.16.120.107:3306/ucenter0?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "weixiao123";
        System.out.println("开始连接mysql:" + jdbcurl);
        Class.forName(jdbcdriver);
        Connection c = DriverManager.getConnection(jdbcurl, username, password);
        PreparedStatement statement = c.prepareStatement("insert into mycat_sequence(name,current_value,increment) VALUES(?,?,?)");
        DatabaseMetaData metaData = c.getMetaData();
        ResultSet rs = metaData.getTables(c.getCatalog(), "root", null, new String[]{"TABLE"});
        while (rs.next()) {

            String tableName = rs.getString("TABLE_NAME");
            if (tableName.startsWith("uic")) {
                statement.setString(1, tableName.toUpperCase());
                statement.setInt(2, 1000000);
                statement.setInt(3, 1);
                statement.addBatch();
//                statement.addBatch(sql);
            }

        }
        statement.executeBatch();

//     Statement statement =  c.createStatement();
//        ResultSet resultSet=  statement.executeQuery("select * from uic_account_info");


//
//        System.out.println("===============================================");
//        while (rs.next()) {
//
//            String tableName = rs.getString("TABLE_NAME");
//            if (tableName.startsWith("bd") || tableName.startsWith("ucenter") || tableName.startsWith("ucm") || tableName.startsWith("oauth")) {
//                System.out.println("<table name=\"" + tableName + "\" primaryKey=\"ID\" type=\"global\" dataNode=\"dn$0-3\"/>");
//            }
//
//
//        }


//        Statement st = c.createStatement();

//
//        String origSQL = "  INSERT INTO uic_user_identity_type(uid,status) values(\"0003c39794a211e58635fa163e0e90d3\",10)";
//        MySqlInsertStatement insertStmt = (MySqlInsertStatement) (new MySqlStatementParser(origSQL)).parseInsert();
//
//        System.out.println(insertStmt.getValuesList().get(0).getValues().get(0).getAttribute("uid"));
//
//        System.out.println("OK......");
    }

}
