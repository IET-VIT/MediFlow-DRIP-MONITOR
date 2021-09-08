package com.undamped.medicare;

import java.util.List;

public class Feeds {
    private List<Feeds> feeds;

    private int  field1,field2;
    private String created_at;
    private int entry_id;


    public Feeds(String  created_at, int  field1, int field2, int entry_id) {
        this.created_at = created_at;
        this.field1 = field1;
        this.field2 = field2;
        this.entry_id = entry_id;
    }

    public List<Feeds> getFeeds()
    {
        return feeds;
    }

    public void setFeeds(List<Feeds> feeds)
    {
        this.feeds = feeds;
    }

    public String getCreated_at()
    {
        return created_at;
    }

    public void setCreated_at(String created_at)
    {
        this.created_at = created_at;
    }

    public int  getField1()
    {
        return field1;
    }

    public void setField1(int field1)
    {
        this.field1 = field1;
    }
    public int getField2()
    {
        return field2;
    }

    public void setField2(int  field2)
    {
        this.field2 = field2;
    }

    public int getEntry_id()
    {
        return entry_id;
    }

    public void setEntry_id(int entry_id)
    {
        this.entry_id = entry_id;
    }
}
