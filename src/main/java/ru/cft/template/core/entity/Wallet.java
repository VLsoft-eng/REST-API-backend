package ru.cft.template.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "wallets")
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long balance;

    @OneToOne
    @JoinColumn(name = "receiver_wallet_id", referencedColumnName = "id")
    private User user;
}
