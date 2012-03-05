package model;

import java.util.ArrayList;
import java.util.List;

public class AlphabetSet {

        private List<Character> characters;

       public AlphabetSet() {
                characters = new ArrayList<Character>();
                int a = 65;
                for (int i = 0; i < 26; i++) {
                        characters.add((char) (a + i));
                }

        }

        public List<Character> getCharacters() {
                return characters;
        }

        public void setCharacters(List<Character> characters) {
                this.characters = characters;
        }

        public Character getChar(int index) {
                return characters.get(index);
        }

}
