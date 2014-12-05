package pruebas;

import static org.junit.Assert.*;

import org.junit.Test;



import domain.ProductSpecification;

import java.util.*;

public class pruebaProductCatalog {
  private Hashtable productSpecifications = new Hashtable();
  @Test
  public void pruebaProductCatalog() {
    ProductSpecification ps =
        new ProductSpecification(1, 100, "product 1");
    productSpecifications.put(new Integer(1), ps);
    ps = new ProductSpecification(2, 200, "product 2");
    productSpecifications.put(new Integer(2), ps);

    ps = new ProductSpecification(3, 300, "product 3");
    productSpecifications.put(new Integer(3), ps);
    ps = new ProductSpecification(4, 400, "product 4");
    productSpecifications.put(new Integer(4), ps);

  }

}
