package service;

import java.util.List;

import model.Sentence;
import model.Word;

public interface WordsHandler {
	public List<Word> getRandomWords(String alphabet) ;

	public void storeSentences(Sentence sentence);
}
