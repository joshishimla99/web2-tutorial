package database;

import java.util.List;

import model.Word;

import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface WordsDAO {

	public List<Word> getResults(String alpha);
	public void insert(String word, String usage, String meaning);
	public void storeSetence(String setence, String words);
}
