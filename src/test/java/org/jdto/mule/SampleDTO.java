package org.jdto.mule;

import java.io.Serializable;
import org.jdto.annotation.Source;

/**
 *
 * @author juancavallotti
 */
public class SampleDTO implements Serializable {
    
    @Source("sourceString")
    private String targetString;

    public String getTargetString() {
        return targetString;
    }

    public void setTargetString(String targetString) {
        this.targetString = targetString;
    }
    
}
