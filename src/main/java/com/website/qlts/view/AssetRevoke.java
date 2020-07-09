package com.website.qlts.view;

import com.website.qlts.entity.Assets;
import com.website.qlts.entity.Departments;
import com.website.qlts.entity.RevokeHistory;
import com.website.qlts.entity.Staffs;

public class AssetRevoke {
    private Assets assets;
    private RevokeHistory revokeHistory;
    private Staffs staffs;
    private Departments departments;

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public RevokeHistory getRevokeHistory() {
        return revokeHistory;
    }

    public void setRevokeHistory(RevokeHistory revokeHistory) {
        this.revokeHistory = revokeHistory;
    }
}
