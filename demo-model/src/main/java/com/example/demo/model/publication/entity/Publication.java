package com.example.demo.model.publication.entity;

import com.example.demo.model.base.entity.BaseEntity;
import com.example.demo.model.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "publication")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"authors"})
public class Publication extends BaseEntity {

    @Column(name = "doi")
    private String doi;

    @Column(name = "title")
    private String title;

    @Column(name = "abstract")
    private String abs;

    @Column(name = "year")
    private Integer year;

    @ManyToMany(targetEntity = Profile.class, mappedBy = "publications")
    private List<Profile> authors;

    public Publication(String doi, String title, String abs, int year) {
        this.doi = doi;
        this.title = title;
        this.abs = abs;
        this.year = year;
    }
}
