package ru.cft.template.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.cft.template.core.vars.TransferType;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @CreationTimestamp
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "transfer_type", nullable = false)
    private TransferType type;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id", referencedColumnName = "id")
    private Wallet senderWallet;

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id", referencedColumnName = "id")
    private Wallet receiverWallet;

    @Column(name = "reciever_phone_number")
    private String receiverPhone;

}
