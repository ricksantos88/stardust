package com.consumer.swapi.stardust.domain.entities;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@Slf4j
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

    @CreatedDate
    @Column
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    protected LocalDateTime updatedAt;

    @Column
    protected int version;

    @LastModifiedDate
    @Column
    protected String modifiedBy;

    @PrePersist
    public void prePersist() {
        log.info("pre-persist");
        setCreatedAt(LocalDateTime.now());
        setVersion(1);
        setUpdatedAt(null);
    }

    @PreUpdate
    public void preUpdate(){
        log.info("pre-update");
        setUpdatedAt(LocalDateTime.now());
        setModifiedBy("API");
        setVersion(getVersion() + 1);
    }

}
