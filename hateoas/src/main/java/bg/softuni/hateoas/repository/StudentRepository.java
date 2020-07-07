package bg.softuni.hateoas.repository;

import bg.softuni.hateoas.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Order, Long> {

}