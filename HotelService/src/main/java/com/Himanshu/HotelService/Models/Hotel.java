package com.Himanshu.HotelService.Models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
