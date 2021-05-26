package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "brand", nullable = true, length = 45)
    private String brand;
    @Column(name = "class", nullable = true, length = 45)
    private String clazz;
    @Column(name = "numberofseats", nullable = true)
    private Integer numberofseats;
    @OneToMany(mappedBy = "plane")
    private Collection<Archive> archivesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Integer getNumberofseats() {
        return numberofseats;
    }

    public void setNumberofseats(Integer numberofseats) {
        this.numberofseats = numberofseats;
    }

    public Collection<Archive> getArchivesById() {
        return archivesById;
    }

    public void setArchivesById(Collection<Archive> archivesById) {
        this.archivesById = archivesById;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", clazz='" + clazz + '\'' +
                ", numberofseats=" + numberofseats +
                '}';
    }
}
