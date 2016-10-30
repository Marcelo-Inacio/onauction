package br.com.hyperclass.onauction.test;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.hyperclass.onauction.config.SpringContextConfiguration;
import br.com.hyperclass.onauction.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringContextConfiguration.class, WebConfig.class})
public class OnAuctionApplicationTest {
	
	@Autowired
    private WebApplicationContext wac;
	
	@Autowired
	private Filter springSecurityFilterChain;
		
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(wac)
	            .addFilters(springSecurityFilterChain)
	            .build();
	  }
	
	@Test
    public void authenticationFailed() {
		
    }

}
