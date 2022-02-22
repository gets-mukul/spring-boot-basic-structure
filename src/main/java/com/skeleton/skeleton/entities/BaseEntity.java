package com.skeleton.skeleton.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

import static com.skeleton.skeleton.constants.Default.User.SYSTEM;

@Setter
@Getter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "created_by", nullable = false)
    private String createdBy = SYSTEM;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy = SYSTEM;
}
