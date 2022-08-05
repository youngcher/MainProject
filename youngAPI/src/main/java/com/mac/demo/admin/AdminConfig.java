package com.mac.demo.admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class AdminConfig
{
   @Bean
   BCryptPasswordEncoder  passwordEncoder() 
   {
      BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
   
       return enc;
   }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() 
    {
       return (webSecurity) -> webSecurity.ignoring().antMatchers("/resources/**", "/ignore2");
    }

    @Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
    {
      return http.authorizeRequests()
    		  
           
       .antMatchers("/admin/**").hasAnyRole("ADMIN")//이 url로 부여한 권한이 맞는지 확인
         
              
               .anyRequest().permitAll()
        
            
            //.and()
            //.csrf().ignoringAntMatchers("/logout") //요청시 'POST' not supported 에러 방지(사기 방지 시스템)
           // .ignoringAntMatchers("/admin/loginForm")
            //.ignoringAntMatchers("/doLogin")
            //.disable()  //csrf 기능을 사용하지 않을 때
            
            
               .and().csrf().disable()
               .formLogin().loginPage("/admin/loginForm")   // 지정된 위치에 로그인 폼이 준비되어야 함(url)
               .loginProcessingUrl("/doLogin")            // 컨트롤러 메소드 불필요(폼데이터가 가는곳 url만 일치 시켜주면됨)
               .failureUrl("/err?error=not admin")      // 로그인 실패시 다시 로그인 폼으로,T는 메세지
               //.failureForwardUrl("/login?error=Y")  //실패시 다른 곳으로 forward
               .defaultSuccessUrl("/admin", true)//로그인의 성공한 사람이 가는 곳
               .usernameParameter("id")  // 로그인 폼에서 이용자 ID 필드 이름, 디폴트는 username
               .passwordParameter("pw")  // 로그인 폼에서 이용자 암호 필트 이름, 디폴트는 password
               .permitAll()
               
               
             .and()   // 디폴트 로그아웃 URL = /logout
             .logout().logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout")) //로그아웃 요청시 URL
             .logoutSuccessUrl("/admin/loginForm?logout=T")//로그 아웃되면 다시 로그인 폼으로 가도록
             .invalidateHttpSession(true) 
             .deleteCookies("JSESSIONID")
             .permitAll()
             
             .and()
             .exceptionHandling().accessDeniedPage("/admin/denied")
             .and().build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception 
    {
        authenticationMgr.inMemoryAuthentication()
        .withUser("admin").password("$2a$10$4insgtXmhTYymhM1Gw7YNumhiQ.PtnDOIfUJiLP2ED2Sroe3Qri6a")
            .authorities("ROLE_ADMIN");
       
    }
}
