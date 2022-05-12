package kr.co.patternbot.common.dataStructure;

import lombok.Data;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//HashMap으로?
@Component @Lazy @Data
public class Trunk<T> {
    private Map<String, Trunk> map;
    public Trunk(){this.map = new HashMap<>();}

    public void put(){}
    public void replace(){}
    public void remove(){}


}
