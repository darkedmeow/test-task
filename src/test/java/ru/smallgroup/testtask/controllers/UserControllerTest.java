package ru.smallgroup.testtask.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.services.UserService;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private UserService userService;

    @Test
    @WithMockUser
    public void createUser() throws Exception {
        User user = new User();
        user.setName("Test");
        user.setAge(10);
        user.setPassword("pass");

        User resultUser = new User();
        resultUser.setId(1L);
        resultUser.setName("Test");
        resultUser.setAge(10);
        resultUser.setPassword("pass");

        given(userService.createUser(resultUser)).willReturn(resultUser);
        mvc.perform(
                post("/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
                .with(csrf())
            )
            .andExpect(status().isCreated());
    }

}