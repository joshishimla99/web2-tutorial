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

	WordsHandlerImpl() {
	        wordSet = new AlphabetSet();
	}
	
	public WordsDAO getWordsDAO() {
		return wordsDAO;
	}

	public void setWordsDAO(WordsDAO wordsDAO) {
		this.wordsDAO = wordsDAO;
	}

	public List<Word> getRandomWords(String alphabet)  {
                Random random = new Random();
		List<Word> words = new ArrayList<Word>();
		char chosenChar;
		if (alphabet != null && alphabet.length() == 1) {
		        chosenChar = alphabet.charAt(0);
		}
		else {
	                int index = getRandomCharIndex(random);
	                chosenChar = wordSet.getChar(index);		        
		}
		List<Word> list = wordsDAO.getResults(chosenChar);
		if (!(list.size() < 5)) {
	                for (int i = 0; i < 5; i++) {
	                        words.add(list.get(randomWordIndex(random, list)));
	                }		        
		}
		
		return words;
	}

        private int getRandomCharIndex(Random random) {
                return Math.abs(random.nextInt()) % 26;
        }

        private int randomWordIndex(Random random, List<Word> list) {
                return (Math.abs(random.nextInt())) % list.size();
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
