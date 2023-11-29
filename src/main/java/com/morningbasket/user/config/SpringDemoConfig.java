package com.morningbasket.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;





@Configuration
@EnableWebSecurity
public class SpringDemoConfig {
	
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                 .authorizeHttpRequests().antMatchers("/getuserdatabyid/1","/getname").authenticated().and().formLogin(withDefaults());
	        
	   
	            
	        return http.build();
	    }
	 
	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails user = User.withDefaultPasswordEncoder()
	            .username("nagesh")
	            .password("suresh")
	            .roles("USER")
	            .build();
	        
	        UserDetails admin = User.withDefaultPasswordEncoder()
		            .username("venkatesh")
		            .password("venkatesh")
		            .roles("ADMIN")
		            .build();
	        return new InMemoryUserDetailsManager(user,admin);
	    }
	 
	 @Autowired
		private DataSource dataSource;
		

		@Autowired
		public void authManager(AuthenticationManagerBuilder auth) throws Exception {
		    auth.jdbcAuthentication()
		      	.dataSource(dataSource)
		      	.passwordEncoder(new BCryptPasswordEncoder())
		      	.usersByUsernameQuery("select username,password,enabled from users where username=?")
		      	.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
		}
	
	
	

}
