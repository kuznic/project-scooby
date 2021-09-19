package com.meedra.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Slf4j
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditingEntity implements Serializable {

    @Transient
    private static final long serialVersionUID = -8241585773957143683L;

    @Version
    @Column(name = "version", nullable = false)
    private Long version = 0L;

    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now(ZoneId.of("Africa/Lagos"));

    @LastModifiedDate
    @Column(name = "updatedAt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime updatedAt;









}