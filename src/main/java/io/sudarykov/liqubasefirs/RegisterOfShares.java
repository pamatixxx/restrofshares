package io.sudarykov.liqubasefirs;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "registerofshares")
public class RegisterOfShares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(unique=true)
    private String usrpow;


    @Column
    private Integer count;

    @Column
    private Integer totalparvalue;
    @Column
    private Integer parvalue;

    @Column
    private String daterelease;

    @Column
    private String state;

    public RegisterOfShares(String usrpow, Integer count, Integer totalparvalue, Integer parvalue, String daterelease, String state) {
        this.usrpow = usrpow;
        this.count = count;
        this.totalparvalue = totalparvalue;
        this.parvalue = parvalue;
        this.daterelease = daterelease;
        this.state = state;
    }

    public RegisterOfShares() {
    }

    public RegisterOfShares(String usrpow) {
        this.usrpow = usrpow;
    }

    public RegisterOfShares(String usrpow, Integer count) {
        this.usrpow = usrpow;
        this.count = count;
    }

    public String getUsrpow() {
        return usrpow;
    }

    public void setUsrpow(String usrpow) {
        this.usrpow = usrpow;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalparvalue() {
        return totalparvalue;
    }

    public void setTotalparvalue(Integer totalparvalue) {
        this.totalparvalue = totalparvalue;
    }

    public Integer getParvalue() {
        return parvalue;
    }

    public void setParvalue(Integer parvalue) {
        this.parvalue = parvalue;
    }

    public String getDaterelease() {
        return daterelease;
    }

    public void setDaterelease(String daterelease) {
        this.daterelease = daterelease;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        //sb.append("id=").append(id);
        sb.append("usrpow='").append(usrpow).append('\'');
        sb.append(", count='").append(count).append('\'');
        sb.append(", totalparvalue='").append(totalparvalue).append('\'');
        sb.append(", parvalue='").append(parvalue).append('\'');
        sb.append(", daterelease='").append(daterelease).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
