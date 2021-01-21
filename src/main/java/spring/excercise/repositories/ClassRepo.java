package spring.excercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import spring.excercise.Model.Entities.Class;


@Repository
public interface ClassRepo extends JpaRepository<Class, Integer> {

}
