package com.gorest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gorest.models.User;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class JsonDataReader {

    @DataProvider(name = "userDataFromJson",parallel = true)
    public static Iterator<Object[]> getUserData() throws IOException {
        ObjectMapper mapper= new ObjectMapper() ;
        File file=new File("src/test/resources/testdata/userData.json");
        User[] users=mapper.readValue(file,User[].class);

        return Arrays.stream(users)
                    .map(user -> {
                        String uniqueEmail = user.getEmail().replace("@",
                                "+" + System.currentTimeMillis() + "@");

                        User updatedUser = User.builder()
                                .setName(user.getName())
                                .setEmail(uniqueEmail)
                                .setGender(user.getGender())
                                .setStatus(user.getStatus())
                                .build();

                        return new Object[]{updatedUser};
                    })
                    .iterator();
    }

}
