package uet.jcia.shop.is;

import java.util.List;

import uet.jcia.shop.is.entities.Product;
import uet.jcia.shop.is.entities.Specification;

public interface SpecificationDAO {
    
    List<Specification> getAllSpecs();
    Specification getSpec(Specification spec);
	boolean addNewSpec(Specification spec);
	boolean deleteSpec(Specification spec);
	boolean updateSpec(Specification spec);
}
