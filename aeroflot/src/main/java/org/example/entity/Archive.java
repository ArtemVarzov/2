package org.example.entity;

import javax.persistence.*;

@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pilot", referencedColumnName = "id")
    private Pilot pilot;
    @ManyToOne
    @JoinColumn(name = "id_manager", referencedColumnName = "id")
    private Manager manager;
    @ManyToOne
    @JoinColumn(name = "id_plane", referencedColumnName = "id")
    private Plane plane;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    @Override
    public String toString() {
        return "Archive{" +
                "id=" + id +
                ", pilot=" + pilot.getName() +
                ", manager=" + manager.getName() +
                ", plane=" + plane.getBrand() +
                '}';
    }
}
