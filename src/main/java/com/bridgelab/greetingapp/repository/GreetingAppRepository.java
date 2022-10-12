package com.bridgelab.greetingapp.repository;

import com.bridgelab.greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingAppRepository extends JpaRepository<Greeting,Integer> {

}
