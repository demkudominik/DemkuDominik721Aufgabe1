package model;

import java.util.Date;

/**
 * An entry from the log file.
 */
public class Log {
    private int id;
    private String mitgliedsname;
    private Haus haus;
    private String ereignis;
    private Date datum;

    public Log(int id, String mitgliedsname, Haus haus, String ereignis, Date datum) {
        this.id = id;
        this.mitgliedsname = mitgliedsname;
        this.haus = haus;
        this.ereignis = ereignis;
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

    public String getEreignis() {
        return ereignis;
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
                ", ereignis='" + ereignis + '\'' +
                ", datum=" + datum +
                '}';
    }
}
