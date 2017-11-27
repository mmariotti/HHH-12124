# HHH-12124
Hibernate metamodel EmbedabbleType duplication

a simple PoC that:

        Type<Address> type1 = Company_.address.getType();
        Type<Address> type2 = Person_.address.getType();

        assertEquals(type1, type2);
    
is not true.


run with:

     mvn test 

