package kwant.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kwant.carapp.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
