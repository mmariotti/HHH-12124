package hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Company implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private long id = System.nanoTime();

    @Column(nullable = false)
    private String name;

    @Embedded
    private Address address = new Address();

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }
}
