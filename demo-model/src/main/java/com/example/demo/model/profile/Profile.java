package com.example.demo.model.profile;

import com.example.demo.model.base.entity.BaseEntity;
import com.example.demo.model.publication.entity.Publication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"publications"})
@DiscriminatorColumn(name = "discriminator")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Profile extends BaseEntity{

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "academy_rank")
    private String academyRank;

    @Column(name = "highest_degree")
    private String highestDegree;

    @ManyToMany
    @JoinTable(name = "profile_to_publication",
            joinColumns = @JoinColumn(name = "profile_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "publication_id", referencedColumnName = "id"))
    private List<Publication> publications;
}
