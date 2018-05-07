package com.swe.project.ControllersTest;


import com.swe.project.controller.UserController;
import com.swe.project.entity.User;
import com.swe.project.entity.UserType;
import com.swe.project.service.UserService;
import org.apache.catalina.filters.CorsFilter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
/*import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;*/

import java.util.HashSet;
import java.util.Set;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = ContextConfiguration.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(userController)
                .addFilters(new CorsFilter())
                .build();
    }

    @Test
    public void loginByUsernameValidData() throws Exception{
        Set<UserType> typesSet= new HashSet<>();

        typesSet.add(new UserType(UserType.Type.customer));
        typesSet.add(new UserType(UserType.Type.admin));
        typesSet.add(new UserType(UserType.Type.storeOwner));

        User user = new User("Re@gmail.com", "ReEzzat", "123", typesSet);

        when(userService.findByUsername("ReEzzat")).thenReturn(user);

        MvcResult mvcResult;

        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.get("/user/login/byUserName?username=ReEzzat&password=123").contentType(MediaType.APPLICATION_JSON);

        mvcResult = mvc.perform(builder)
                .andExpect(status().isOk()).andReturn();  // how to compare the actual return with the expected return?

                verify(userService, times(1)).findByUsername("ReEzzat");
                verifyNoMoreInteractions(userService);

    }

 /*   @Test
    public void registerTest() throws Exception {

        given(UserRepository.getSuperHero(2))
                .willThrow(new NonExistingHeroException());

        Set<UserType> typesSet= new HashSet<>();

        typesSet.add(new UserType(UserType.Type.customer));
        typesSet.add(new UserType(UserType.Type.admin));
        typesSet.add(new UserType(UserType.Type.storeOwner));

        User user = new User("roEzzat@gmail.com",  "roEzzat", "111",typesSet);

        given(userService.register(user, typesSet)).willReturn(true);

        mvc.perform(post("http://localhost:8080/user/register?type=customer&type=storeOwner&type=admin")
                .content("{\"username\": \"reEzzat\",\"email\": \"reEzzat@gmail.com\",\"password\": \"111\",\"cart\": null}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)).andDo(print()).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$.username").value("roEzzat"))
                .andExpect(jsonPath("$.email").value("roEzzat@gmail.com"))
                .andExpect(jsonPath("$.password").value("111"))
                .andExpect(jsonPath("$.cart").doesNotExist())
                .andExpect(jsonPath("$.userTypes").value("[{\"userType\": \"customer\"},{\"userType\": \"storeOwner\"},{\"userType\": \"admin\"}]"))



    }*/
}
