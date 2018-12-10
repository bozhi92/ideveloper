package com.hubbleadvance.utils.ideveloper.common.utils;

import java.util.UUID;

import com.hubbleadvance.utils.ideveloper.common.generator.SnowFlakeGenerator;

public final class IdUtil {
    
    private static final SnowFlakeGenerator SNOW_FLAKE_GENERATOR = new SnowFlakeGenerator(0, 0);
    
    public static long getSnowFlakeId(){
        return SNOW_FLAKE_GENERATOR.nextId();
    }
    
    public static String getStrSnowFlakeId(){
        return String.valueOf(SNOW_FLAKE_GENERATOR.nextId());
    }
    
    public static String getUId(){
        return UUID.randomUUID().toString();
    }
    
    public static String get32UId(){
        return getUId().replaceAll("-", "");
    }
}
