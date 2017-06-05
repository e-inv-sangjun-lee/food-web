package com.kodeveloper.food.web.sample;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

/**
 * Created by Hyojin Bae on 2017/06/06.
 */
public interface ReactiveCustomerRepository extends ReactiveCrudRepository<Customer, ObjectId> {

}