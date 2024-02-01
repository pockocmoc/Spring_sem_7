package com.pockocmoc.homework7.securingweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class WebSecurityConfigTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePageAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithMockUser
    public void testPublicDataAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/public-data"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    @WithMockUser(roles = "USER")
    public void testPrivateDataAccessWithUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/private-data"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testPrivateDataAccessWithAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/private-data"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testLoginPageAccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
