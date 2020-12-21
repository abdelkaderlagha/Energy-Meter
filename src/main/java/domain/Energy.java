package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="energy")
public class Energy extends BaseEntity {

    public Energy (LocalDateTime timestamp , String device_sn , float energy){
        super(device_sn);
        this.energy=energy;
        this.timestamp=timestamp;
    }

    public Energy (LocalDateTime timestamp , float energy){
        this.energy=energy;
        this.timestamp=timestamp;
    }

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "energy")
    private float energy;

}
