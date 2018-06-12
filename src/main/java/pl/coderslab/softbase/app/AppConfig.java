package pl.coderslab.softbase.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.coderslab.softbase.converter.CategoryConverter;
import pl.coderslab.softbase.converter.DeveloperConverter;
import pl.coderslab.softbase.converter.OpSystemConverter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab.softbase")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "pl.coderslab.softbase.repository" })
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean // nie trzeba pisac .jsp
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");// WEB-INF ma byc w webapp
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override // dodawanie obrazkow - folder images w folderze webapp)
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("softbasePersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	 @Override
	 public void addFormatters(FormatterRegistry registry) {
	 registry.addConverter(getOpSystemConverter());
	 registry.addConverter(getDeveloperConverter());
	 registry.addConverter(getCategoryConverter());
	 }
	
	 @Bean
	 public OpSystemConverter getOpSystemConverter() {
	 return new OpSystemConverter();
	 }
	
	 @Bean
	 public DeveloperConverter getDeveloperConverter() {
	 return new DeveloperConverter();
	 }
	 
	 @Bean
	 public CategoryConverter getCategoryConverter() {
	 return new CategoryConverter();
	 }

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}

}
