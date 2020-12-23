package gadour.springboot.energy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="energy")
public class Energy extends BaseEntity {

    @Builder
    public Energy (Integer id, LocalDateTime timestamp , String device_sn , Double energy){
        super(id);
        this.energy=energy;
        this.deviceSn=device_sn;
        this.timestamp=timestamp;
    }

    public Energy (LocalDateTime timestamp , String device_sn ,Double energy){
        this.energy=energy;
        this.deviceSn=device_sn;
        this.timestamp=timestamp;
    }

    @Column(name = "device_sn",unique=true)
    @NotNull
    private String deviceSn;

    @Column(name = "timestamp")
    @NotNull
    private LocalDateTime timestamp;

    @Column(name = "energy")
    @NotNull
    private Double energy;

}
