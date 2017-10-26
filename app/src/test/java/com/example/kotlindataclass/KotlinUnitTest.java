package com.example.kotlindataclass;

import android.app.Application;
import android.os.Bundle;
import com.example.kotlindataclass.base.RobolectricTestCase;
import com.example.kotlindataclass.model.kotlin.User;
import com.example.kotlindataclass.model.kotlin.UserViewModel;
import com.example.kotlindataclass.model.kotlin.UserViewModel2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class KotlinUnitTest extends RobolectricTestCase {
    private Gson gson;
    private Application context;

    @Before
    public void setUp() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
        context = RuntimeEnvironment.application;
    }

    public String getJson() {
        return "{\n" +
                "  \"name\": \"Kros\",\n" +
                "  \"age\": 50,\n" +
                "  \"created_at\": \"2017-03-17T14:57:35+08:00\"\n" +
                "}";
    }

    @Test
    public void decodeJson() throws Exception {
        User user = gson.fromJson(getJson(), User.class);
        assertThat(user).isNotNull();
        assertThat(user.getName()).isEqualTo("Kros");
        assertThat(user.getEmail()).isNull();
        assertThat(user.getAge()).isEqualTo(50);
        assertThat(user.getCreatedAt()).isNotNull();
    }

    @Test
    public void decodeParcelable() throws Exception {
        User user = gson.fromJson(getJson(), User.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY", user);

        User result = bundle.getParcelable("KEY");
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Kros");
        assertThat(result.getEmail()).isNull();
        assertThat(result.getAge()).isEqualTo(50);
        assertThat(result.getCreatedAt()).isNotNull();
    }

    @Test
    public void testViewModel() throws Exception {
        User user = gson.fromJson(getJson(), User.class);

        UserViewModel viewModel = new UserViewModel(context, user);
        assertThat(viewModel.getAgeString()).isEqualTo("50 歲");
    }

    @Test
    public void testUpdateAge() throws Exception {
        User user = gson.fromJson(getJson(), User.class);
        user = user.updateAge(18);
        assertThat(user.getAge()).isEqualTo(18);
    }

    @Test
    public void testViewModel2() throws Exception {
        User user = gson.fromJson(getJson(), User.class);
        UserViewModel2 viewModel = UserViewModel2.Companion.create(context, user);
        viewModel.getAgeString();
        assertThat(viewModel.getAgeString()).isEqualTo("50 歲");
    }

    @Test
    public void mockUser() throws Exception {
        User mock = Mockito.mock(User.class);
        assertThat(mock).isNotNull();
    }
}