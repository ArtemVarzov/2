package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 60)
    private String name;
    @Column(name = "mail", nullable = true, length = 100)
    private String mail;
    @Column(name = "telephone", nullable = true, length = 60)
    private String telephone;
    @Column(name = "dayofbirthday", nullable = true, length = 60)
    private String dayofbirthday;
    @OneToMany(mappedBy = "pilot")
    private Collection<Archive> archivesById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDayofbirthday() {
        return dayofbirthday;
    }

    public void setDayofbirthday(String dayofbirthday) {
        this.dayofbirthday = dayofbirthday;
    }

    public Collection<Archive> getArchivesById() {
        return archivesById;
    }

    public void setArchivesById(Collection<Archive> archivesById) {
        this.archivesById = archivesById;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dayofbirthday='" + dayofbirthday + '\'' +
                '}';
    }
}
