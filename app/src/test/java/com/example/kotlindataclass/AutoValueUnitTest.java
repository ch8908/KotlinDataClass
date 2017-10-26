package com.example.kotlindataclass;

import com.example.kotlindataclass.model.autovalue.AutoValueGsonFactory;
import com.example.kotlindataclass.model.autovalue.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AutoValueUnitTest {

    private Gson gson;

    @Before
    public void setUp() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(AutoValueGsonFactory.create());
        gson = builder.create();
    }

    @Test
    public void decodeJson() throws Exception {
        String json = "{\n" +
                "  \"name\": \"Kros\",\n" +
                "  \"age\": 18,\n" +
                "  \"created_at\": \"2017-03-17T14:57:35+08:00\"\n" +
                "}";
        User user = gson.fromJson(json, User.class);

        assertThat(user).isNotNull();
        assertThat(user.name()).isEqualTo("Kros");
        assertThat(user.age()).isEqualTo(18);
        assertThat(user.email()).isNull();
        assertThat(user.createdAt()).isNotNull();
    }
}