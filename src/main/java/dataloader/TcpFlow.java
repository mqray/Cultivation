package dataloader;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TcpFlow {

    private String uid;

    @JsonProperty("src_ip")
    private String srcIp;
    @JsonProperty("dst_ip")
    private String dstIp;
    @JsonProperty("src_port")
    private Integer srcPort;
    @JsonProperty("dst_port")
    private Integer dstPort;

    private Integer sessionState;
    @JsonProperty("up_linklength")
    private Integer uplinklength;
    @JsonProperty("down_linklength")
    private Integer downlinklength;
    @JsonProperty("up_applength")
    private Integer upApplength;
    @JsonProperty("down_applength")
    private Integer downApplength;
    @JsonProperty("up_pkts")
    private Integer upPkts;
    @JsonProperty("down_pkts")
    private Integer downPkts;
    @JsonProperty("src_mac")
    private String srcMac;
    @JsonProperty("dst_mac")
    private String dstMac;

    private String proto;

    private String ts;

}
