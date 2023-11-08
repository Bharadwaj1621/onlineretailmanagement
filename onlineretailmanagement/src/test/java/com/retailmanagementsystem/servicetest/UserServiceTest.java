package com.retailmanagementsystem.servicetest;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

 

import java.util.HashSet;

import java.util.Optional;

import java.util.Set;

 

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;

import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

 

import com.retailmanagementsystem.dao.RoleDao;

import com.retailmanagementsystem.dao.UserDao;

import com.retailmanagementsystem.entity.Role;

import com.retailmanagementsystem.entity.User;
import com.retailmanagementsystem.service.RoleService;
import com.retailmanagementsystem.service.UserService;

 

public class UserServiceTest {

 
	  @Autowired

	    private UserService userService;
	  @Autowired
	  private RoleService roleService;

	    @MockBean

	    private UserDao userDao;

 


 
    @Test

    void register() {

    	User user = new User();

        user.setUserEmail("sadhana@gmail.com");

        user.setUserPassword("testpassword");
        user.setUserFirstName("sadhana");
        user.setUserLastName("k");
       when(userDao.save(user)).thenReturn(user);

        

    

        assertEquals(user,userService.registerNewUser(user));

    }
    @Test

    public void getuserbyid() {

    	User user = new User();

        

        user.setUserPassword("testpassword");
        user.setUserFirstName("sadhana");
      
 

        userDao.save(user);

        when(userDao.findByUserEmail

                ("sadhana12@gmail.com")).thenReturn(user);

        assertEquals(user,userService.findByUserEmail("sadhana12@gmail.com"));

    }

 

}