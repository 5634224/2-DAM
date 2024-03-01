import Entity.LibrosEntity;
import Entity.BibliotecasEntity;
import Entity.TemasEntity;
import Entity.ObjetoBaseDeDatos;
import jakarta.persistence.*;

import org.hibernate.query.sqm.UnknownEntityException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Creamos la conexion
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        //APARTADO 2.1 CREAR LIBRO
        System.out.println(" --- APARTADO 2.1 CREAR LIBRO ---");
        try {
            //Comenzamos con la transaccion
            et.begin();

            //Creo un libro
            LibrosEntity libro1 = crearLibro(em);

            //Guardo el libro
            em.persist(libro1);

            et.commit();
            System.out.println("Libro guardado correctamente");
        }catch (Exception e){
            System.out.println("Error al crear y guardar el libro: "+ e.getMessage());
            et.rollback();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(" --- APARTADO 2.2 BORRAR LIBRO ---");
        //APARTADO 2.2 BORRAR LIBRO
        try {
            //Comenzamos con la transaccion
            et.begin();

            System.out.println("Selecione el libro que desea borrar");

            //Pido el id del libro que se desea borrar y lo elimino
            LibrosEntity libroBorrar = (LibrosEntity) getObjetc(em,"LibrosEntity", true);

            em.remove(libroBorrar);

            et.commit();
            System.out.println("Libro borrado correctamente");
        }catch (Exception e){
            System.out.println("Error al borrar el libro: "+ e.getMessage());
            et.rollback();
        }

        System.out.println(" --- APARTADO 3 MODIFICA UN OBJETO DE LA TABLA BIBLIOTECA ---");
        //APARTADO 3 MODIFICA UN OBJETO DE LA TABLA BIBLIOTECA
        try {
            et.begin();
            //Pido el id de la biblioteca que se desea actualizar
            BibliotecasEntity bibliotecaUpdate = (BibliotecasEntity) getObjetc(em, "BibliotecasEntity", true);
            updateObjetc(em, "BibliotecasEntity", bibliotecaUpdate);

            et.commit();
            System.out.println("Biblioteca actualizada correctamente");

        }catch (Exception e){
            System.out.println("Error al cambiar la biblioteca: "+ e.getMessage());
            et.rollback();
        }

        System.out.println(" --- APARTADO 4 LISTAR LIBROS ---");
        //APARTADO 4 LISTAR LIBROS
        //Utilizo el procedimiento creado anteriormente poniendo en el toString todos los elementos del libro y hacienod uso del mapeo
        //para ver tambien las propiedades de sus objetos
        List<LibrosEntity> libros = (List<LibrosEntity>) getAll(em,"LibrosEntity");
        for(LibrosEntity libro: libros){
            System.out.println(libro);
        }

        //APARTADO 5 LISTAR BIBLIOTECAS CON N CAPACIDAD
        System.out.println(" --- APARTADO 5 LISTAR BIBLIOTECAS CON N DE CAPACIDAD ---");
        try {
            et.begin();

            //Pido por consola el parametro de capacidad
            System.out.println("Indique la capacidad por la que quiere filtrar (mayor estricto)");
            Scanner sc = new Scanner(System.in);
            boolean capadidadCorrecta = false;
            int capacidad = 0;
            do{
                try{
                    capacidad = sc.nextInt();
                    if(capacidad > 0) capadidadCorrecta = true;
                }catch (Exception e){
                    System.out.println("Debe meter un número");
                }
            }while (!capadidadCorrecta);

            //Recojo todas las bibliotecas que tienen mas de X capacidad
            Query selectAll = em.createQuery("Select b from BibliotecasEntity b where b.capacidad > :capacidad");
            //Agrego el parametro a la query
            selectAll.setParameter("capacidad",capacidad);
            //Recojo y listo las bibliotecas que cumplen la condicion
            List<BibliotecasEntity> bibliotecas =  selectAll.getResultList();
            for(BibliotecasEntity biblioteca: bibliotecas){
                System.out.println(biblioteca);
            }

            et.commit();

        }catch (Exception e){
            System.out.println("Error al listar bibliotecas con más de 2500 de capacidad: "+ e.getMessage());
            et.rollback();
        }


    }

    private static LibrosEntity crearLibro(EntityManager em) {
        //Creo una funcion que me devolvera el id del ultimo registro de la tabla
        int ultimoId = getUltimoId(em, "LibrosEntity","libroId");

        //Creo el objeto libro usando como id el recogido anteriormente
        //Para ello pedire los parametros por consola

        Scanner scanner = new Scanner(System.in);

        System.out.println("Vamos a insertar un libro, para ello le pediremos nombre del autor y del libro.");

        boolean autorCorrecto = false;
        String nombreAutor;
        do{

            System.out.println("Autor:");

            //Pido el nombre del autor
            nombreAutor = scanner.nextLine();

            //Considero valido cualquier nombre que inserte mientras no sea vacio
            if(nombreAutor != null && !nombreAutor.isEmpty()) autorCorrecto = true;
            else System.out.println("Lo siento, debe insertar el nombre del autor");

        }while (!autorCorrecto);

        //Le pido al usuario el nombre del libro
        boolean libroCorrecto = false;
        String nombreLibro;
        do{

            System.out.println("Libro:");

            //Pido el nombre del libro
            nombreLibro = scanner.nextLine();

            //Considero valido cualquier nombre que inserte mientras no sea vacio
            if(nombreLibro != null && !nombreLibro.isEmpty()) libroCorrecto = true;
            else System.out.println("Lo siento, debe insertar el nombre del libro");

        }while (!libroCorrecto);

        //Haremos que tanto el anyo de publicacion como la editorial puedan ser nulas

        Integer anyo = null;
        System.out.println("Año de publicación (no obligatorio):");
        //Intento pasarlo a entero en el caso de no poder, lo pongo a nulo.
        try {
            anyo = scanner.nextInt();
        }catch (Exception e){
            System.out.println("El año insertado no es correcto y se pondrá a nulo");
        }


        System.out.println("Editorial (no obligatorio):");
        scanner.nextLine();
        String editorial = scanner.nextLine();

        //Selecciono la biblioteca
        System.out.println("-- Selecione biblioteca --");
        BibliotecasEntity biblioteca = (BibliotecasEntity) getObjetc(em,"BibliotecasEntity",false);

        //Selecciono el tema
        System.out.println("-- Selecione tema --");
        TemasEntity tema = (TemasEntity) getObjetc(em,"TemasEntity",false);

        LibrosEntity libro1 = new LibrosEntity(++ultimoId,nombreLibro,nombreAutor,anyo,editorial,biblioteca,tema);

        boolean correcto = validar(em, libro1, scanner);
        if(!correcto) crearLibro(em);

        return libro1;
    }

    private static boolean validar(EntityManager em, Object objeto, Scanner scanner) {
        //Valido la informacion
        System.out.println("La información extraida es la siguiente:");
        System.out.println(objeto);

        //Pido al usuario que valide la información
        boolean validado = false;

        String correcta;
        do {
            System.out.println("Es correcta? Introduzca S o N ");
            correcta = scanner.nextLine();

            switch (correcta) {
                case "S":
                    System.out.println("Informacion validada");
                    validado = true;
                    break;
                case "N":
                    System.out.println("Por favor inserte nuevamente los datos");
                    validado = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!validado);

        return correcta.equals("S");
    }

    private static int getUltimoId(EntityManager em, String Tabla, String nombreId) {
        //Como la base de datos no tiene el id autogenerado lo recogere para poder insertar
        int ultimoId = 0;
        try{
            //Recojo el max de los ids
            Query queryId = em.createQuery("Select max(t."+nombreId+") from "+ Tabla +" t ");
            //Al utilizar el método getSingleResult me arriesgo a que me lane una excepcion en el caso de no existir ningun resultado
            ultimoId =  (int)queryId.getSingleResult();
        }catch(NoResultException nre){
            //Informo por consola que no se han encontrado registros en la tabla
            System.out.println("La tabla consultada, al recoger el ultimo id, no tiene registros ->" + nre.getMessage());
        }catch (UnknownEntityException uee){
            //Informo por consola que no se ha metido una Entidad correcta
            System.out.println("La entidad de la cual intenta consultar el ultimo id no existe ->" + uee.getMessage());
        }catch (Exception e){
            //Si no es ninguna de las anteriores, doy un mensaje menos especifico
            System.out.println("Ha ocurrido un error al recoger el ultimo id ->" + e.getMessage());
        }
        return ultimoId;
    }

    private static ObjetoBaseDeDatos getObjetc(EntityManager em, String entidad, boolean obligatorio){
        Integer idUsuario = null;

        System.out.println("Escoja (poniendo el número que hay delante del objeto) de la siguiente lista:");
        if(!obligatorio)System.out.println("En el caso de no querer insertar objeto ponga -1");
        //Listo los objetos para que el usuario pueda elegir cual quiere escoger
        List<ObjetoBaseDeDatos> obds = getAll(em,entidad);

        ObjetoBaseDeDatos objetoEscogido = null;

        if(obds != null && !obds.isEmpty()) {

            for (int i = 0; i < obds.size(); i++) {
                System.out.println(i + ":" + obds.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            boolean opcionCorrecta = false;
            do {

                System.out.println("Número:");

                try {
                    idUsuario = scanner.nextInt();

                    if ((idUsuario <= obds.size() && idUsuario >= 0) || (!obligatorio && idUsuario == -1)) {
                        opcionCorrecta = true;
                    } else {
                        System.out.println("El número no se encuentra en la lista. Por favor inserte uno nuevo");
                    }

                } catch (Exception e) {
                    System.out.println("Error al recoger el id. Inserte uno nuevo.");
                }
            } while (!opcionCorrecta);

            //Si ha escogido alguno, la busco
            objetoEscogido = obds.get(idUsuario);

        }else{
            System.out.println("No existe ningun registro");
        }

        return objetoEscogido;
    }

    private static List getAll(EntityManager em,String entidad){

        //Recojo todos los objetos de la entidad
        try {
            Query selectAll = em.createQuery("Select e from " + entidad + " e");
            return  selectAll.getResultList();
        }catch (Exception e){
            System.out.println("Error al recoger todos los objetos de la entidad "+ entidad+ ". Mensaje de error: "+ e.getMessage());
        }
        return null;
    }

    private static void updateObjetc(EntityManager em, String entidad, Object objeto){

        Field[] campos = getFields(objeto);

        //Creo un scanner para pedir el campo que actualizar y la actualizacion
        Scanner sc = new Scanner(System.in);

        boolean opcionCorrecta = false;
        Field campoEscogido = null;
        do{
            try {
                System.out.println("Escoja el campo a actualizar utilizando los números de delante");
                int numeroCampo = sc.nextInt();
                if (numeroCampo < campos.length && numeroCampo > 0) {
                    opcionCorrecta = true;
                    campoEscogido = campos[numeroCampo];
                }else if (campos[numeroCampo].getName().toUpperCase().contains("ID")){
                    System.out.println("Los campos id no pueden ser modificados");
                }else{
                    System.out.println("El número no es correcto. Intentelo otra vez");
                }
            }catch (Exception e){
                System.out.println("Error al escoger el campo a actualizar. Inserte uno válido.");
            }

        }while(!opcionCorrecta);

        //Pido por consola el valor nuevo
        Object valor = null;
        sc.nextLine();
        try {
            if (campoEscogido.get(objeto) instanceof Integer) {
                System.out.println("Nuevo valor (entero)");
                valor = sc.nextInt();
            }else if(campoEscogido.get(objeto) instanceof String){
                System.out.println("Nuevo valor (texto)");
                valor = sc.nextLine();
            }

            campoEscogido.set(objeto,valor);

            boolean correcto = validar(em, objeto, sc);
            if(!correcto) updateObjetc(em,entidad,objeto);
            else{
                em.merge(objeto);
            }
        }catch (Exception e){
            System.out.println("Error al recoger el valor para updatear el campo. Fin de la operacion");
        }

    }

    private static Field[] getFields(Object objeto) {

        if(objeto != null) {

            Class<?> clase = objeto.getClass();
            Field[] campos = clase.getDeclaredFields();

            try {
                for (int i = 0; i < campos.length; i++) {
                    campos[i].setAccessible(true); //Permito que pueda acceder a los campos y a su valor aunque sean privados
                    System.out.println(i + ":" + campos[i].getName() + " = " + campos[i].get(objeto));
                }
            } catch (Exception e) {
                System.out.println("Error al listar los atributos del objeto");
            }
            return campos;
        }else{
            System.out.println("Error: Objeto nulo");
            return null;
        }
    }


}
