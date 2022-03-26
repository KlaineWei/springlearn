package com.example.listtotree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Platform {

    private String id;
    private String parentId;
    private String name;
    private String platformCode;
    private List<Platform> children;

    public Platform(String id, String platformCode,String parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.platformCode = platformCode;
    }

    public void addChild(Platform platform){
        if(children == null){
            children = new ArrayList<>();
        }
        children.add(platform);
    }
}
