package ru.mrSergey.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.thymeleaf.engine.TextStructureHandler;
import ru.mrSergey.models.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new BeanPropertyRowMapper<>(Person.class),
                        new Object[]{id}).stream().findAny().orElse(null);
    }
    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person(name, age, email) VALUES(?,?,?)",
                 person.getName(), person.getAge(),person.getEmail());
    }
    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET name=?,age=?,email=? WHERE id=?",
                person.getName(), person.getAge(), person.getEmail(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);
    }

}
