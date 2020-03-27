package example.ru.model;

import javax.persistence.*;

@Entity
@Table(name = "Length")
public class Length {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String unit;
    @Column
    private double value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Length{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
