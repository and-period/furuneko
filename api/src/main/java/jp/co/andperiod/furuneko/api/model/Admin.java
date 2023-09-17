package jp.co.andperiod.furuneko.api.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="admins")
public class Admin {
  @Column(name="id")
  private String id;

  @Column(name="email")
  private String email;

  @Column(name="created_at")
  private LocalDateTime createdAt;

  @Column(name="updated_at")
  private LocalDateTime updatedAt;
}
