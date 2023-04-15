package ru.fifthelementserver.traffic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkTransactionRepository extends JpaRepository<NetworkTransaction, Long> {
}
