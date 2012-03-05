package web;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import model.Sentence;
import model.Word;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.WordsHandler;

@Controller
public class WordBuilder {

	WordsHandler wordsHandler;

	public WordsHandler getWordsHandler() {
		return wordsHandler;
	}

	public void setWordsHandler(WordsHandler wordsHandler) {
		this.wordsHandler = wordsHandler;
	}

	@RequestMapping(value = { "/words" }, method = RequestMethod.GET)
	public @ResponseBody
	List<Word> getWords(HttpServletRequest request) {
		String alphabet = request.getParameter("alphabet");
		return wordsHandler.getRandomWords(alphabet);
	}

	@RequestMapping(value = { "/add/sentence" }, method = RequestMethod.POST)
	public ModelAndView addSentence(HttpServletRequest request) {
		Sentence sentence = new Sentence();
		sentence.setSentence(request.getParameter("sentence"));

		String words = request.getParameter("words");
		StringTokenizer tokenizer = new StringTokenizer(words, ",");
		List<Word> wordlist = new ArrayList<Word>();
		while (tokenizer.hasMoreElements()) {
			Word word = new Word();
			word.setWord(tokenizer.nextToken());
			wordlist.add(word);
		}
		sentence.setWordlist(wordlist);
		wordsHandler.storeSentences(sentence);
		return new ModelAndView("thanks");
	}
}
