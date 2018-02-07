package com.tanyouping.ssm.model;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

    public Date created;
    public Long createdMillisecond;

    public void init(){
        created = new Date();
        createdMillisecond = new Date().getTime();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Long getCreatedMillisecond() {
        return createdMillisecond;
    }

    public void setCreatedMillisecond(Long createdMillisecond) {
        this.createdMillisecond = createdMillisecond;
    }
}
