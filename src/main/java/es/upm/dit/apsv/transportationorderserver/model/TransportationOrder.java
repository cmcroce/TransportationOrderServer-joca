package es.upm.dit.apsv.transportationorderserver.model;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Getter;

import lombok.NoArgsConstructor;

import lombok.Setter;

import lombok.ToString;

@Entity

@Getter @Setter @NoArgsConstructor @ToString

public class TransportationOrder {  

    private String toid;

    @Id

    private String truck;

    private long originDate;

    private double originLat;

    private double originLong;

    private long dstDate;

    private double dstLat;

    private double dstLong;

    private long lastDate;

    private double lastLat;

    private double lastLong;

    private int st;
    
    public TransportationOrder(String toid, String truck, long originDate, double originLat, double originLong,
            long dstDate, double dstLat, double dstLong, long lastDate, double lastLat, double lastLong, int st) {
        this.toid = toid;
        this.truck = truck;
        this.originDate = originDate;
        this.originLat = originLat;
        this.originLong = originLong;
        this.dstDate = dstDate;
        this.dstLat = dstLat;
        this.dstLong = dstLong;
        this.lastDate = lastDate;
        this.lastLat = lastLat;
        this.lastLong = lastLong;
        this.st = st;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((toid == null) ? 0 : toid.hashCode());
        result = prime * result + ((truck == null) ? 0 : truck.hashCode());
        result = prime * result + (int) (originDate ^ (originDate >>> 32));
        long temp;
        temp = Double.doubleToLongBits(originLat);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(originLong);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (dstDate ^ (dstDate >>> 32));
        temp = Double.doubleToLongBits(dstLat);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dstLong);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (int) (lastDate ^ (lastDate >>> 32));
        temp = Double.doubleToLongBits(lastLat);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lastLong);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + st;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TransportationOrder other = (TransportationOrder) obj;
        if (truck == null) {
            if (other.truck != null)
                return false;
        } else if (!truck.equals(other.truck))
            return false;
        return true;
    }

    public double distanceToDestination() {

        return Math.sqrt(Math.pow(this.dstLat -this.lastLat, 2)

                    + Math.pow(this.dstLong - this.lastLong, 2));

    }
}