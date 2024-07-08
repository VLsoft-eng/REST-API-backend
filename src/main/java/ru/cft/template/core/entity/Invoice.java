package ru.cft.template.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cft.template.core.vars.InvoiceStatus;
import ru.cft.template.core.vars.TransferType;

import java.util.UUID;

@Data
@Builder
@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "cost", nullable = false)
    private Long cost;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, referencedColumnName = "id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false, referencedColumnName = "id")
    private User receiver;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_status", nullable = false)
    private InvoiceStatus status;

    private String comment;
}
