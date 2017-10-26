package com.example.kotlindataclass.model.autovalue;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by Kros on 24/10/2017.
 */
@GsonTypeAdapterFactory
public abstract class AutoValueGsonFactory implements TypeAdapterFactory {
    public static TypeAdapterFactory create() {
        return new AutoValueGson_AutoValueGsonFactory();
    }
}