package org.jdto.mule;

import java.io.Serializable;

/**
 *
 * @author juancavallotti
 */
public class SampleEntity implements Serializable {
    
    
    private String sourceString;

    public SampleEntity() {
    }

    public SampleEntity(String sourceString) {
        this.sourceString = sourceString;
    }

    
    public String getSourceString() {
        return sourceString;
    }

    public void setSourceString(String sourceString) {
        this.sourceString = sourceString;
    }
    
    
}
