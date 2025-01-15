package model;

import java.util.Date;

/**
 * An entry from the log file.
 */
public class Log {
    private int id;
    private String Mitgliedsname;
    private Haus haus;
    private String ereignise;
    private Date datum;

    public Log(int id, String mitgliedsname, Haus haus, String ereignise, Date datum) {
        this.id = id;
        this.Mitgliedsname = mitgliedsname;
        this.haus = haus;
        this.ereignise = ereignise;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public String getMitgliedsname() {
        return mitgliedsname ;
    }

    public Haus getHaus() {
        return haus;
    }

    public String getAuthority() {
        return ereignise;
    }

    public Date getDatum() {
        return datum;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", mitgliedsname='" + mitgliedsname + '\'' +
                ", haus=" + haus +
                ", ereignise='" + ereignise + '\'' +
                ", datum=" + datum +
                '}';
    }
}
