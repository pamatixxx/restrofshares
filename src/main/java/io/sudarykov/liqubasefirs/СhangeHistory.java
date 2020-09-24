package io.sudarykov.liqubasefirs;

import javax.persistence.*;

@Entity
@Table(name = "changehistory")
public class СhangeHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column
    private String usrpow;

    @Column
    private String history;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsrpow() {
        return usrpow;
    }

    public void setUsrpow(String usrpow) {
        this.usrpow = usrpow;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public СhangeHistory(String usrpow, String history) {
        this.usrpow = usrpow;
        this.history = history;
    }
}
