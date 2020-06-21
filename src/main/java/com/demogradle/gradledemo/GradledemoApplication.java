package com.demogradle.gradledemo;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.demogradle.gradledemo.cache.CacheAccess;
import com.demogradle.gradledemo.customer.repo.BudgetRepo;
import com.demogradle.gradledemo.model.BudgetMaster;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@SpringBootApplication
@EnableAsync
@PropertySource(value = { "classpath:application-error_mapping.properties","classpath:country_state_mapping.properties"})
public class GradledemoApplication {

	@Autowired
	private HazelcastInstance hazelInstance;
	@Autowired
	private BudgetRepo budgetRepo;
	
	public static void main(String[] args) {
		/*HazelcastInstance hazelInstance=Hazelcast.newHazelcastInstance();
		IMap<Long,String> dataMap=hazelInstance.getMap("data");
		IdGenerator idGenerator=hazelInstance.getIdGenerator("newid");
		for(int i=0;i<10;i++){
			dataMap.put(idGenerator.newId(), "message"+i);
		}
		System.out.println("size of Map "+dataMap.size());
		for(Entry<Long, String> entry:dataMap.entrySet()){
				System.out.println(entry.getKey()+" "+entry.getValue());
				
		}*/

		SpringApplication.run(GradledemoApplication.class, args);
	}

	@Bean
	public MessageSource getMsgSource() {
		ReloadableResourceBundleMessageSource rs = new ReloadableResourceBundleMessageSource();
		rs.setBasename("classpath:messages");
		rs.setDefaultEncoding("UTF-8");
		return rs;

	}

	@Bean
	public LocalValidatorFactoryBean getFactoryBean() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(getMsgSource());
		return bean;
	}
	@EventListener(ApplicationStartedEvent.class)
	public void budgetMasterLoad(){
		IMap<String,BudgetMaster> budgetMap=hazelInstance.getMap("budgetMaster");
		budgetMap.putAll(budgetRepo.findAll().stream().collect(Collectors.toMap(BudgetMaster::getBudgetId, budget->budget)));
		CacheAccess.setHazelCastInstance(hazelInstance);
	}


}
