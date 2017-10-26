package com.example.kotlindataclass.model.autovalue;

import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Kros on 24/10/2017.
 */
@AutoValue
public abstract class User implements Parcelable {
    @SerializedName("name")
    public abstract String name();

    @Nullable
    @SerializedName("email")
    public abstract String email();

    @SerializedName("age")
    public abstract int age();

    @SerializedName("created_at")
    public abstract Date createdAt();

    public static User create(String name, String email, int age, Date createdAt) {
        return builder()
                .name(name)
                .email(email)
                .age(age)
                .createdAt(createdAt)
                .build();
    }

    public static TypeAdapter<User> typeAdapter(Gson gson) {
        return new AutoValue_User.GsonTypeAdapter(gson);
    }

    public static Builder builder() {return new AutoValue_User.Builder();}

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder name(String name);

        public abstract Builder email(String email);

        public abstract Builder age(int age);

        public abstract Builder createdAt(Date createdAt);

        public abstract User build();
    }
}
