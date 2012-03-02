package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.AlphabetSet;
import model.Sentence;
import model.Word;

import database.WordsDAO;

public class WordsHandlerImpl implements WordsHandler {

	private WordsDAO wordsDAO;
	private AlphabetSet wordSet;

	public WordsDAO getWordsDAO() {
		return wordsDAO;
	}

	public void setWordsDAO(WordsDAO wordsDAO) {
		this.wordsDAO = wordsDAO;
	}

	public List<Word> getRandomWords() {
		List<Word> words = new ArrayList<Word>();
		Random random = new Random();
		int index = (random.nextInt() % 26);
		List<Word> list = wordsDAO.getResults(wordSet.getChar(index) + "");
		for (int i = 0; i < 5; i++) {
			words.add(list.get((random.nextInt() % list.size())));
		}
		return words;
	}

	public void storeSentences(Sentence sentence) {
		String sentenceStr = sentence.getSentence();
		String words = "";
		for (Word word : sentence.getWordlist()) {
			if (words.isEmpty()) {
				words = word.getWord();
			} else {
				words = words + "," + word.getWord();
			}
		}
		wordsDAO.storeSetence(sentenceStr, words);
	}

}
