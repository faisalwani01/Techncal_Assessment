package com.assessment.restservice.controller;

import com.assessment.restservice.exceptions.FeatureNotFoundException;
import com.assessment.restservice.exceptions.UserNotFoundException;
import com.assessment.restservice.model.PermissionStatus;
import com.assessment.restservice.model.UserFeatureDTO;
import com.assessment.restservice.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Test
    void shouldSetUserPermissionNoChange() throws Exception {

        UserFeatureDTO userFeatureDTO = new UserFeatureDTO("faisal@gmail.com", "create", false);

        doReturn(false).when(userService).saveUserPermission(userFeatureDTO);

        mockMvc.perform(post("/api/v1/feature")
                .content(asJsonString(userFeatureDTO))
                .contentType("application/json"))
                .andExpect(status().isNotModified());
    }

    @Test
    void shouldSetUserPermissionSuccess() throws Exception {

        UserFeatureDTO userFeatureDTO = new UserFeatureDTO("break@gmail.com", "create", true);

        doReturn(true).when(userService).saveUserPermission(userFeatureDTO);

        mockMvc.perform(post("/api/v1/feature")
                .content(asJsonString(userFeatureDTO))
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void checkForUserPermission() throws Exception {

        doReturn(new PermissionStatus(true)).when(userService).getUserPermission(Mockito.anyString(),Mockito.anyString());

        mockMvc.perform(get("/api/v1/feature?email=faisal@gmail.com&featureName=search")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldProvide404ForUserNotFoundExceptionWhenCheckStatus() throws Exception {

       doThrow(UserNotFoundException.class).when(userService).getUserPermission(Mockito.anyString(),Mockito.anyString());

        mockMvc.perform(get("/api/v1/feature?email=xxxx@gmail.com&featureName=search")
                .contentType("application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldProvide404ForFeatureNotFoundExceptionWhenCheckStatus() throws Exception {

        doThrow(FeatureNotFoundException.class).when(userService).getUserPermission(Mockito.anyString(),Mockito.anyString());

        mockMvc.perform(get("/api/v1/feature?email=faisal@gmail.com&featureName=xxxxx")
                .contentType("application/json"))
                .andExpect(status().isNotFound());
    }


    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            System.out.println(jsonContent);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
