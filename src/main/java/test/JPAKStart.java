package test;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import entity.Karhba;
import entityMangerUtil.EntityManagerUtil;
import java.util.Arrays;
import java.util.List;

/**
* @author Achref Hawari
 *
 */
public class JPAKStart {
	static private EntityManager entityManager = EntityManagerUtil.getEntityManager();
    public static void main (String[] args) {
    	
      
        entityManager.getTransaction().begin();

        Karhba karhba = new Karhba();
        karhba.setMarque("M5");
        karhba.setModel("BMW");
        entityManager.persist(karhba);
        
        Karhba karhba1 = new Karhba();

        karhba1.setMarque("Aston Martin ");
        karhba1.setModel("Aston Martin Vantage");
        entityManager.persist(karhba);

        entityManager.getTransaction().commit();


        queryWithJPQL(entityManager);
        typedQueryWithJPQL(entityManager);
        criteriaQuery(entityManager);
        queryNative(entityManager);
     }


    private static void queryWithJPQL (EntityManager entityManager) {
        System.out.println("Afiicher tout les voiture requette JPQL");//Java Persistence Query Language
        Query query = entityManager.createQuery("select t from Karhba t");
        List resultList1 = query.getResultList();
        System.out.println(resultList1.toString());
    }

    private static void typedQueryWithJPQL (EntityManager entityManager) {
        System.out.println("Typed Querying using JPQL");
        TypedQuery<Karhba> q =  entityManager.createQuery("select t from Karhba t"
                                                , Karhba.class);
        System.out.println(q.getResultList());
    }

    private static void queryNative (EntityManager entityManager) {
        System.out.println("Requette native  sql");
        Query nativeQuery = entityManager.createNativeQuery("select * from Karhba");
        List resultList = nativeQuery.getResultList();
        for (Object o : resultList) {
            if (o.getClass().isArray()) {
                Object oa[] = (Object[]) o;
                System.out.println(Arrays.asList(oa));
            } else {
                System.out.println(o);
            }
        }
    }


    private static void criteriaQuery (EntityManager entityManager) {
        System.out.println("criteria query");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> query = cb.createQuery();
        CriteriaQuery<Object> select = query.select(query.from(Karhba.class));

        TypedQuery<Object> typedQuery = entityManager.createQuery(select);
        System.out.println(typedQuery.getResultList());
    }
}