import com.mysql.cj.exceptions.CJPacketTooBigException;
import com.mysql.cj.xdevapi.Client;
import entity.ClienteEntity;
import jakarta.persistence.*;
import java.util.Scanner;

public class Main
{
    static ClienteEntity c1;
    public static void main(String[] args)
    {
        Scanner teclado;

        //Creamos un objeto EntityTransaction para poder operar con la BBDD
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        teclado = new Scanner(System.in);
        System.out.println("Introduce la operación a realizar: ");
        System.out.println("1.Insertar un nuevo cliente");
        System.out.println("2.Mostrar todos los clientes");
        System.out.println("3.Mostrar un cliente a partir de su ID");
        System.out.println("4.Actualizar los datos de un cliente");
        System.out.println("5.Eliminar un cliente");

        int op = teclado.nextInt();

        try
        {
            switch(op)
            {
                case 1:

                    //1.Insertar un nuevo cliente

                    transaction.begin();

                    c1 = new ClienteEntity();

                    c1.setId(1);
                    c1.setNombre("Juan");
                    c1.setDireccion("C/ Miguel de Cervantes, 120");
                    c1.setTelefono("666777888");
                    c1.setFechaNac("01/01/1987");

                    entityManager.persist(c1);

                    transaction.commit();

                    break;



                case 2:

                    //2. Leer todos los clientes

                    transaction.begin();

                    TypedQuery<ClienteEntity> allClients = entityManager.createNamedQuery("AllClients", ClienteEntity.class);

                    for (ClienteEntity c : allClients.getResultList()) {
                        System.out.println(c);
                    }

                    transaction.commit();

                    break;


                case 3:

                    //3. Leer un cliente a partir de su Id

                    transaction.begin();

                    c1 = entityManager.find(ClienteEntity.class, 1);

                    System.out.println(c1);

                    transaction.commit();

                    break;

                case 4:

                    //4. Actualizar los datos de un cliente

                    transaction.begin();

                    c1 = entityManager.find(ClienteEntity.class, 1);

                    c1.setDireccion("Avenida de las naciones, 23");

                    transaction.commit();

                    break;


                case 5:

                    //5. Eliminar un cliente

                    transaction.begin();

                    c1 = entityManager.find(ClienteEntity.class, 1);
                    entityManager.remove(c1);

                    transaction.commit();

                    break;

                default:

                    System.out.println("Opción no válida");
            }
        }
        finally {
            if (transaction.isActive())
            {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
