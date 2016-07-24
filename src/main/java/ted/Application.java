package ted;


import javax.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        Users user = new Users();
        user.setUserID(24);
        user.setPassword("test")
                .setUsername("Bangladesh")
                .setLastName("1vfvf")
                .setFirstName("Poribagh");

        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction()
                .begin();
        em.persist(user);
        em.getTransaction()
                .commit();
        em.close();
        PersistenceManager.INSTANCE.close();
    }
}
