
package database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import model.Word;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


public class XeroundDAOImpl implements WordsDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Word> getResults(String alpha) {
		String queryString = "SELECT * from words.wordlist where word like :alpha";

		ParameterizedRowMapper<Word> mapper = new ParameterizedRowMapper<Word>() {

			// notice the return type with respect to Java 5 covariant
			// return types
			public Word mapRow(ResultSet rs, int rowNum) throws SQLException {
				Word word = new Word();
				word.setWord(rs.getString("word"));
				word.setMeaning(rs.getString("meaning"));
				word.setUsage(rs.getString("usage"));
				return word;
			}
		};
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("alpha", alpha + "%");
		return this.jdbcTemplate.query(queryString, paramMap, mapper);

	}

	public void insert(String word, String usage, String meaning) {
		System.out.println("Inserting data for " + word + " , " + usage + " , " + meaning);
		String queryString = "insert into words.wordlist values (0, :word, :meaning, :usage)";

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("word", word);
		paramMap.put("meaning", meaning);
		paramMap.put("usage", usage);

		this.jdbcTemplate.update(queryString, paramMap);
		System.out.println("Done populating the data");
	}

        public void storeSetence(String sentence, String words) {
                System.out.println("Inserting data for " + sentence + " , " + words);
                String queryString = "insert into words.setences values (0, :sentence, :words)";

                Map<String, String> paramMap = new HashMap<String, String>();
                paramMap.put("sentence", sentence);
                paramMap.put("words", words);

                this.jdbcTemplate.update(queryString, paramMap);
                System.out.println("Done populating the data");                
        }

}
