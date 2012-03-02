package model;

import java.util.List;

public class Sentence {
        private String sentence;
        private List<Word> wordlist;

        public String getSentence() {
                return sentence;
        }

        public void setSentence(String sentence) {
                this.sentence = sentence;
        }

        public List<Word> getWordlist() {
                return wordlist;
        }

        public void setWordlist(List<Word> wordlist) {
                this.wordlist = wordlist;
        }
}
