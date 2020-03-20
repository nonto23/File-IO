import org.junit.Assert;

import org.junit.Test;


public class VisitorTest {

        @Test
        public void save() {
            Assert.assertEquals(Visitor.saveFile("Selinah", 25,"20-03-2020","10:00","Happy","thabi"), Visitor.saveFile("Selinah", 25, "20-03-2020", "10:00","Happy", "thabi"));
        }

        @Test
        public void load() {
            Assert.assertEquals("Selinah","Selinah");
        }

}
