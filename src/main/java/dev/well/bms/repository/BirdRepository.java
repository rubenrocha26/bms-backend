package dev.well.bms.repository;

import dev.well.bms.entity.Bird;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirdRepository extends JpaRepository<Bird, Long> {
    boolean existsByBirdRing(String birdRing);
}
