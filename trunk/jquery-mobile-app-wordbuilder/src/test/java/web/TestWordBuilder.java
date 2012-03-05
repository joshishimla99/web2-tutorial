package web;

import java.util.List;

import junit.framework.Assert;

import model.Word;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(locations={"classpath:xml/application-servlet.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWordBuilder {
        MockHttpServletRequest request = new MockHttpServletRequest();
        @Autowired WordBuilder wordbuilder;

        @Test
        public void testRandomWords() {
                request.addParameter("alphabet", "a");
                List<Word> words = wordbuilder.getWords(request);
                Assert.assertNotNull(words);
                Assert.assertEquals(words.size(), 5);
                Assert.assertNotNull(words.get(0));
                Assert.assertNotNull(words.get(1));
                Assert.assertNotNull(words.get(2));
                Assert.assertNotNull(words.get(3));
                Assert.assertNotNull(words.get(4));
        }
        
        @Test
        public void testSentenceStorage() {
                request.addParameter("sentence", "My name is A");
                request.addParameter("words", "A,B");
                ModelAndView view = wordbuilder.addSentence(request);
                Assert.assertEquals(view.getViewName(), "thanks");
        }
}
