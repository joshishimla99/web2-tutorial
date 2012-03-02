package service;

import java.util.List;

import model.Sentence;
import model.Word;

public interface WordsHandler {
	public List<Word> getRandomWords();

	public void storeSentences(Sentence sentence);
}
