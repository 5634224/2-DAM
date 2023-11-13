public class prueba {
    public void estructura() {
        // Define la estructura para capturar excepciones trabajando con ficheros y con bases de datos
        try {
            // Código que puede generar una excepción
        } catch (FileNotFoundException e) {
            // Bloque para excepcion por fichero no encontrado
        } catch (IOException ioe) {
            // Bloque para excepcion por error de entrada-salida
        } catch (SQLException sqle) {
            // Bloque para excepcion por error con SQL
        } catch (Exception e) {
            // Bloque para excepcion por cualquier otro error
        } finally {
            // Instrucciones finales para, por ejemplo, limpieza
        }
    }
}