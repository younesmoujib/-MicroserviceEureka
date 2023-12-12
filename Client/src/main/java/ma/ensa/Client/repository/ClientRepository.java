package ma.ensa.Client.repository;

import ma.ensa.Client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
