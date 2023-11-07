public static void main(String[] args) {
    try {
        // Cargar el driver de mysql
        Class.forName("com.mysql.jdbc.Driver");

        // Cadena de conexion para conectar con MySQL en localhost, seleccionar la BB.DD llamada 'test' con uusario y contraseña del servidor de MySQL: root y admin
        String connectionUrl = "jdbc:mysql://localhost/test?user=root&password=admin";

        // Obtener la conexion
        Connection con = DriverManager.getConnection(connectionUrl);
    } catch (SQLException e) {
        System.out.println("SQL Exception: "+ e.toString());
    } catch (ClassNotFoundException cE) {
        System.out.println("Class Not Found Exception: "+ cE.toString());
    }
}