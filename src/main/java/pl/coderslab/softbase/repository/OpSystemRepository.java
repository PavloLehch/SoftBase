package pl.coderslab.softbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.softbase.entity.OpSystem;

@Repository
public interface OpSystemRepository extends JpaRepository<OpSystem, Long> {

}
