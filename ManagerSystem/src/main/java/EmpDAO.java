import pojo.Emp;
import pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class EmpDAO {

    public boolean login(User user) throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select * from user where user= ? and pass = ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        ResultSet resultSet= preparedStatement.executeQuery();
        connection.close();
        return resultSet.next();
    }
    public ArrayList<Emp> SelectAll() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select * from emp";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        ArrayList<Emp> emps = getEmps(resultSet);
        connection.close();
        return emps;
    }

    private ArrayList<Emp> getEmps(ResultSet resultSet) throws SQLException {
        ArrayList<Emp> emps=new ArrayList<Emp>();
        while (resultSet.next()){
            Emp emp=new Emp(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    resultSet.getInt("salary"),
                    resultSet.getInt("bonus"),
                    resultSet.getString("date")
            );
            emps.add(emp);

        }
        return emps;
    }

    public ArrayList<Emp> selectByDate(String startDate,String endDate) throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select * from emp where date between ? and ?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setString(1,startDate);
        preparedStatement.setString(2,endDate);
        ResultSet resultSet= preparedStatement.executeQuery();
        ArrayList<Emp> emps = getEmps(resultSet);
        connection.close();
        return emps;
    }
    public ArrayList<Emp> selectBonusTop3() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select * from emp order by bonus desc limit 0,3;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        ArrayList<Emp> emps = getEmps(resultSet);
        connection.close();
        return emps;
    }
    public ArrayList<Emp> selectBonusLast3() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select * from emp order by bonus  limit 0,3;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        ArrayList<Emp> emps = getEmps(resultSet);
        connection.close();
        return emps;
    }
    public int queryTotalBonus() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select sum(bonus) as sum from emp;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.getResultSet();
        if(resultSet.next()){
            return resultSet.getInt("sum");
        }
        return -1;

    }
    public int queryAverageAge() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="select avg(age) as age from emp;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.getResultSet();
        if(resultSet.next()){
            return resultSet.getInt("age");
        }
        return -1;
    }
    public ArrayList<String> queryStatus() throws SQLException {
        Connection connection=DruidUtils.getConnection();
        String sql="SELECT *, (SELECT bonus >(SELECT AVG(bonus) FROM emp) )AS status FROM emp;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        ArrayList<String> emps=new ArrayList<String>();
        while (resultSet.next()){
            String name=resultSet.getString("name");
            if(resultSet.getInt("status")>0){
                emps.add(name+"劳模");
            }else {
                emps.add(name+"再接再厉");
            }
        }
        connection.close();
        return emps;

    }
}
