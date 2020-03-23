import java.sql.*;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //加载数据驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
            String user= "root";
            String pass= "root";

            connection = DriverManager.getConnection(url,user,pass);

            String sql ="select * from tb_user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();

            //处理结果集
            while(resultSet.next()){

                System.out.println(resultSet.getString("password"));

                System.out.println("===================================");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }
}
