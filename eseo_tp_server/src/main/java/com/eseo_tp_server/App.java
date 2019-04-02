package com.eseo_tp_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	try {
    		SpringApplication.run(App.class, args);
    		System.out.println("appli démarrée");
		} catch (Exception e) {
			System.out.println("Appli erreur \n" + e);
		}  	
    }
}
