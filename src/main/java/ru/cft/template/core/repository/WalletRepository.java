package ru.cft.template.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.template.core.entity.User;
import ru.cft.template.core.entity.Wallet;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, String> {
    Optional<Wallet> findByUserId(Long userId);
}
