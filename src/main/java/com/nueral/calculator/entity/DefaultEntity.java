package com.nueral.calculator.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public abstract class DefaultEntity {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    @Column(name = "regDate" , updatable = false , nullable = false)
    private LocalDateTime regDate;

    @CreatedBy
    private String regUser;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    @Column(name = "modDate" , nullable = false)
    private LocalDateTime modDate;

    @LastModifiedBy
    private String modUser;


}
