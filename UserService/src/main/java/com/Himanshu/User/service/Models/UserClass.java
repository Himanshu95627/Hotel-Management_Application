package com.Himanshu.User.service.Models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "micro_users")
public class UserClass {
    @Id
    private String userId;
    @Column(length = 25)
    private String name;
    @Column(length = 255)
    private String email;
    @Column
    private String about;

    @Transient
    public List<Ratings>ratings = new ArrayList<>();
}
