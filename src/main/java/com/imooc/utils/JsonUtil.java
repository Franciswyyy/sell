<<<<<<< HEAD
package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = new Gson();
        return gson.toJson(object);
    }


}
=======
package com.imooc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
>>>>>>> 2a9074740b0e391e6da452498abcf549cb8aa7e2
