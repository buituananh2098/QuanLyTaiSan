package com.website.qlts.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "repairs_history")
public class RepairsHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "asset_id")
    private Long asset_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", updatable = false, insertable = false, unique = false)
    private Assets assets;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_at")
    private Date startAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_at")
    private Date endAt;

    @Column(name = "staffs_id", unique = false)
    private long staffsId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "staffs_id", updatable = false, insertable = false, unique = false)
//    private Staffs staffs;

    @Column(name = "description")
    private String description;

//    public Long getAssetId() {
//        return assetId;
//    }
//
//    public void setAssetId(Long assetId) {
//        this.assetId = assetId;
//    }
//
//    public Assets getAssets() {
//        return assets;
//    }
//
//    public void setAssets(Assets assets) {
//        this.assets = assets;
//    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public long getStaffsId() {
        return staffsId;
    }

    public void setStaffsId(long staffsId) {
        this.staffsId = staffsId;
    }
//
//    public Staffs getStaffs() {
//        return staffs;
//    }
//
//    public void setStaffs(Staffs staffs) {
//        this.staffs = staffs;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
