package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.controllers.ConstructorInjectedController;
import com.example.demo.controllers.MyController;
import com.example.demo.controllers.PropertyInjectionController;
import com.example.demo.controllers.SetterInjectionController;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyInjectionApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");
		String greeting = myController.sayHello();
		System.out.println( greeting );
		
		System.out.println( "######## property ########");
		PropertyInjectionController piCont = ( PropertyInjectionController ) ctx.getBean("propertyInjectionController");
		System.out.println( piCont.getGreeting() );
		
		System.out.println( "######## setter ########");
		SetterInjectionController siCont = ( SetterInjectionController ) ctx.getBean( "setterInjectionController" );
		System.out.println( siCont.getGreeting() );
		
		System.out.println( "######## constructor ########");
		ConstructorInjectedController ciCont = ( ConstructorInjectedController ) ctx.getBean( "constructorInjectedController");
		System.out.println( ciCont.getGreeting() );
		
	}

}
