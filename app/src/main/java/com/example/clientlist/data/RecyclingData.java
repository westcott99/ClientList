package com.example.clientlist.data;

import java.util.ArrayList;
import java.util.List;

public class RecyclingData {

    private List<RecyclingCenter>recyclingCenterList;

    public RecyclingData(){
        recyclingCenterList = new ArrayList<>();
    }

    public List<RecyclingCenter> getRecyclingCenterList() {
        return recyclingCenterList;
    }

    public void setRecyclingCenterList(List<RecyclingCenter> recyclingCenterList) {
        this.recyclingCenterList = recyclingCenterList;
    }
}
