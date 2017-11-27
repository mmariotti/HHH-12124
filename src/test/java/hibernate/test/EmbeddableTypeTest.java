package hibernate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.Type;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import hibernate.model.Address;
import hibernate.model.Company_;
import hibernate.model.Person_;


public class EmbeddableTypeTest
{
    private static EntityManagerFactory emf;

    @BeforeClass
    public static void init()
    {
        emf = Persistence.createEntityManagerFactory("HHH-12124");
    }

    @AfterClass
    public static void finish()
    {
        if(emf != null)
        {
            emf.close();
        }
    }

    @Test
    public void test1()
    {
        Type<Address> type1 = Company_.address.getType();
        Type<Address> type2 = Person_.address.getType();

        assertEquals(type1, type2);
    }

    @Test
    public void test2()
    {
        Type<Address> type = Company_.address.getType();
        boolean contains = emf.getMetamodel().getEmbeddables().contains(type);

        assertTrue(contains);
    }

    @Test
    public void test3()
    {
        Type<Address> type = Person_.address.getType();
        boolean contains = emf.getMetamodel().getEmbeddables().contains(type);

        assertTrue(contains);
    }
}
