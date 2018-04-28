package com.example.demo.model.profile.student.entity;

import com.example.demo.model.profile.Profile;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@Entity
@DiscriminatorValue("S")
@EqualsAndHashCode(callSuper = true)
public class Student extends Profile {
}
