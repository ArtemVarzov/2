package org.example.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = true, length = 60)
    private String name;
    @Column(name = "telephone", nullable = true, length = 60)
    private String telephone;
    @Column(name = "mail", nullable = true, length = 60)
    private String mail;
    @OneToMany(mappedBy = "manager")
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Collection<Archive> getArchivesById() {
        return archivesById;
    }

    public void setArchivesById(Collection<Archive> archivesById) {
        this.archivesById = archivesById;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
