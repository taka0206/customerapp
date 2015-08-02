package jp.co.taka0206.customerapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import jp.co.taka0206.customerapp.domain.Customer;

/**
 * Hello world!
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;


	@Override
	public void run(String... args) throws Exception {
		String sql = "SELECT id, first_name, last_name FROM customers WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",  1);
		Customer result =  jdbcTemplate.queryForObject(sql,param, (rs, rowNum) -> {
			Customer res = new Customer();
			res.setId(rs.getInt("id"));
			res.setFirstName(rs.getString("first_name"));
			res.setLastName(rs.getString("last_name"));
			return res;
		});
		System.out.println("result = " + result);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class,  args);
	}


}
