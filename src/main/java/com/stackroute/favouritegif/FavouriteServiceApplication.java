package com.stackroute.favouritegif;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stackroute.favouritegif.jwtfilter.JwtFilter;

@SpringBootApplication
public class FavouriteServiceApplication {
	
	  @Bean
	    public FilterRegistrationBean jwtFilter() {
		  FilterRegistrationBean<Filter> filter = new FilterRegistrationBean <>();
		  filter.addUrlPatterns("/api/v1/gifs/*");
		  filter.setFilter(new JwtFilter());
		  return filter;

	    }

	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}

}
