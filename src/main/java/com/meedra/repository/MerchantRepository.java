package com.meedra.repository;

import com.meedra.model.Merchant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>, JpaSpecificationExecutor<Merchant> {
    Optional<Merchant> findByMerchantIdAndIsDeletedFalse(UUID uid);
    List<Merchant> findAllByIsDeletedFalse(Pageable page);


}