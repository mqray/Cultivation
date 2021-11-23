package entity;

import mapping.Column;


public class TcpFlow {

    @Column("ts")
    private Long ts;

    @Column("uid")
    private String uid;

    @Column("src_ip")
    private String srcIp;

    @Column("dst_ip")
    private String dstIp;

    @Column("src_mac")
    private String srcMac;

    @Column("dst_mac")
    private String dstMac;

    @Column("src_port")
    private Integer srcPort;

    @Column("dst_port")
    private Integer dstPort;

    @Column("proto")
    private String proto;

    @Column("session_state")
    private Integer sessionState;

    @Column("up_linklength")
    private Long upLinklength;

    @Column("down_linklength")
    private Long downLinklength;

    @Column("up_applength")
    private Long upApplength;

    @Column("down_applength")
    private Long downApplength;

    @Column("up_pkts")
    private Long upPkts;

    @Column("down_pkts")
    private Long downPkts;

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public void setSrcMac(String srcMac) {
        this.srcMac = srcMac;
    }

    public String getDstMac() {
        return dstMac;
    }

    public void setDstMac(String dstMac) {
        this.dstMac = dstMac;
    }

    public Integer getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(Integer srcPort) {
        this.srcPort = srcPort;
    }

    public Integer getDstPort() {
        return dstPort;
    }

    public void setDstPort(Integer dstPort) {
        this.dstPort = dstPort;
    }

    public String getProto() {
        return proto;
    }

    public void setProto(String proto) {
        this.proto = proto;
    }

    public Integer getSessionState() {
        return sessionState;
    }

    public void setSessionState(Integer sessionState) {
        this.sessionState = sessionState;
    }

    public Long getUpLinklength() {
        return upLinklength;
    }

    public void setUpLinklength(Long upLinklength) {
        this.upLinklength = upLinklength;
    }

    public Long getDownLinklength() {
        return downLinklength;
    }

    public void setDownLinklength(Long downLinklength) {
        this.downLinklength = downLinklength;
    }

    public Long getUpApplength() {
        return upApplength;
    }

    public void setUpApplength(Long upApplength) {
        this.upApplength = upApplength;
    }

    public Long getDownApplength() {
        return downApplength;
    }

    public void setDownApplength(Long downApplength) {
        this.downApplength = downApplength;
    }

    public Long getUpPkts() {
        return upPkts;
    }

    public void setUpPkts(Long upPkts) {
        this.upPkts = upPkts;
    }

    public Long getDownPkts() {
        return downPkts;
    }

    public void setDownPkts(Long downPkts) {
        this.downPkts = downPkts;
    }

    @Override
    public String toString() {
        return "TcpFlow{" +
                " uid=" + uid +
                ", srcIp='" + srcIp + '\'' +
                ", srcPort=" + srcPort +
                ", dstIp='" + dstIp + '\'' +
                ", dstPort=" + dstPort +
                ", sessionState=" + sessionState +
                ", proto='" + proto + '\'' +
                ", upPkts=" + upPkts +
                ", downPkts=" + downPkts +
                ", upApplength=" + upApplength +
                ", downApplength=" + downApplength +
                ", upLinklength=" + upLinklength +
                ", downLinklength=" + downLinklength +
                ", srcMac='" + srcMac + '\'' +
                ", dstMac='" + dstMac + '\'' +
                ", ts=" + ts +
                " }";
    }

}
