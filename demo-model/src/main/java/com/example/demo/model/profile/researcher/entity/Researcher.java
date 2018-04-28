package com.example.demo.model.profile.researcher.entity;

import com.example.demo.model.profile.Profile;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@Entity
@DiscriminatorValue("R")
@EqualsAndHashCode(callSuper = true)
public class Researcher extends Profile {
}
