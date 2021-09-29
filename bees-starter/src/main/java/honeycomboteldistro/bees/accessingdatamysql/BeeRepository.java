package honeycomboteldistro.bees.accessingdatamysql;

import org.springframework.data.repository.CrudRepository;

import honeycomboteldistro.bees.accessingdatamysql.Bee;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BeeRepository extends CrudRepository<Bee, Integer> {

}
