import javax.sql.DataSource;
public class Pool {
    public DataSource datasource;

    public String db = "fundacion";
    public String url = "jdbc:mysql://localhost/" + db;
    public String user = "root";
    public String pass = "123";

    private void initializateDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user)
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);

        dataSource = basicDataSource;
    }

    public Pool() {
        initializateDataSource();
    }
}

public Prueba {
    public static void main(String[] args) {
        Pool metodospoool = new Pool();
        java.sql.Connection cn = null;

        try {
            cn = metodospool.dataSource.getConnection();
            if (cn != null) {
                JOIptionPane.showMessageDialog(null, "Conectado";)
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                cn.close();
            } catch (SQLException ex) {
                System.out.println(ex)
            }
        }
    }
}