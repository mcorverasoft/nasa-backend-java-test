package com.nasa.prueba.aspirante.dominio.entities;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class Audit<T> {
	@CreatedDate
	@Column(nullable=true)
	private Instant createdAt=Instant.now();
	@LastModifiedDate
	@Column(nullable=true)
	private Instant updatedAt=Instant.now();
	@CreatedBy
	@Column(nullable=false)
	private Long createdBy= 0L;
	@LastModifiedBy
	@Column(nullable=false)
	private Long lastModifiedBy=0L;
}
