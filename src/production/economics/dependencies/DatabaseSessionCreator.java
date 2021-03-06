package economics.dependencies;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

import static java.util.Arrays.asList;

/**
 * Date: Apr 29, 2010
 * Time: 1:01:43 PM
 */
@Component
public class DatabaseSessionCreator {
   private SessionFactory sessionFactory;

   public DatabaseSessionCreator() {
      init();
   }

   private void init() {
      try {
         File file = new File("src/hibernate.cfg.xml");
         sessionFactory = new Configuration().configure(file).buildSessionFactory();
      }
      catch (Throwable ex) {
         throw new ExceptionInInitializerError(ex);
      }
   }

   private Session createSession() {
      return sessionFactory.getCurrentSession();
   }

   public void save(Object businessObject) {
      save(asList(businessObject));
   }

   public void save(List<?> businessObjects) {
      Session session = createSession();
      session.beginTransaction();
      for (Object businessObject : businessObjects) {
         session.save(businessObject);
      }
      session.getTransaction().commit();
   }

   public <T> List<T> list(Class<T> classToList) {
      Session session = createSession();
       session.beginTransaction();
       //noinspection unchecked
       List<T> list = session.createCriteria(classToList).list();
       session.getTransaction().commit();
       return list;
   }
}
