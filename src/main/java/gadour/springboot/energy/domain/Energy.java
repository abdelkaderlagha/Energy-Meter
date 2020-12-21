package gadour.springboot.energy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="energy")
public class Energy extends BaseEntity {

    public Energy (Integer id, LocalDateTime timestamp , String device_sn , Double energy){
        super(id);
        this.energy=energy;
        this.device_sn=device_sn;
        this.timestamp=timestamp;
    }

    public Energy (LocalDateTime timestamp , String device_sn ,Double energy){
        this.energy=energy;
        this.device_sn=device_sn;
        this.timestamp=timestamp;
    }

    @Column(name = "device_sn")
    private String device_sn;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "energy")
    private Double energy;

}
