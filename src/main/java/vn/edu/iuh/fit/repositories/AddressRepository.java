package vn.edu.iuh.fit.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.models.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
