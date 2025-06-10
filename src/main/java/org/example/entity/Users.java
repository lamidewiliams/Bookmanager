package org.example.entity;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uniqueId;
    private String firstname;
    private String lastName;
    private String Email;
    private  String Username;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String secreteQuestion;
    private String phoneNumber;
    private String status;
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_books", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "book")
    private List<String> booksList;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private  LocalDateTime modifiedAt;


}
