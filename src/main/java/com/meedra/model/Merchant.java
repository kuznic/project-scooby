package com.meedra.model;

import com.meedra.listeners.MerchantListener;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Table(name = "merchant")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(MerchantListener.class)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Merchant extends AbstractAuditingEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @Type(type = "uuid-binary")
    @Column(updatable = false, nullable = false, length = 32)
    private UUID merchantId = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private String merchantName;

    @Column(nullable = false)
    private String merchantLocation;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Merchant merchant = (Merchant) o;
        return Objects.equals(id, merchant.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }



}