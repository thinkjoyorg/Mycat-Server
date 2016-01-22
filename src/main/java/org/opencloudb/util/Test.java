package org.opencloudb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xjli on 16-1-13.
 */
public class Test {


    public static void main(String args[]) {


        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:8066/testdb?useUnicode=true&characterEncoding=utf-8";
        String username = "test";
        String password = "test";
        try {
            Connection con =
                    DriverManager.getConnection(url, username, password);
            final Statement stmt = con.createStatement();

            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });



            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 20; i++) {
                        int c = 0;
                        if (i % 2 == 0) {
                            c = 10010;
                        } else {
                            c = 10000;
                        }
                        try {
                            stmt.execute("insert into customer(id,name,company_id,sharding_id) values(next value for MYCATSEQ_CUSTOMER,'CUSTOMER',3," + c + ")");
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });

        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }


    }
}
