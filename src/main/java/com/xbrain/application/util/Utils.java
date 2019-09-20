package com.xbrain.application.util;

import java.lang.reflect.Type;

import com.google.gson.GsonBuilder;

public class Utils {
	
	/* GsonBuilder Deserializer */
	public static Object gsonBuilderDeserializer(Type typeClass, Object deserializer, String json) {
		GsonBuilder builder = new GsonBuilder();
    	builder.registerTypeAdapter(typeClass, deserializer);
        return builder.create().fromJson(json, typeClass);
	}
}