import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    static DataSource dataSource;
    static Connection connection;
    static {

        InputStream inputStream=ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties properties=new Properties();
        try {
            properties.load(inputStream);
            dataSource =DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        connection= dataSource.getConnection();
        return connection;
    }

}
