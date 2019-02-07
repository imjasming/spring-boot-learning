package com.xiaoming.springbootlearning.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Xiaoming.
 * Created on 2019/02/06 01:44.
 * Description :
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
