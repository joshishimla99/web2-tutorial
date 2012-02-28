package database;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import data.Word;

@Transactional
public interface XeroundDAO {

	public List<Word> getResults(String alpha);
	public void insert(String word, String usage, String meaning);
}
