package com.meedra.repository;

import com.meedra.model.Merchant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>{

    @Query("select m from Merchant m where m.merchantId = ?1 and deleted = false")
    Optional<Merchant> findByMerchantId(UUID customerId);
    List<Merchant> findAllByDeletedFalse(Pageable page);


}