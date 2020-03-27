package example.ru.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String code;
    @Column
    private String transmission;
    @Column
    private String ai;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="max_speed_fk", nullable = false)
    private MaxSpeed maxSpeed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getAi() {
        return ai;
    }

    public void setAi(String ai) {
        this.ai = ai;
    }

    public MaxSpeed getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(MaxSpeed maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", transmission='" + transmission + '\'' +
                ", ai='" + ai + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
