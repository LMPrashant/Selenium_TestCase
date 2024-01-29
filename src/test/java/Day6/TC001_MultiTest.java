package Day6;

import org.testng.annotations.Test;

public class TC001_MultiTest {
  @Test(groups = {"sanity"},priority=4)
  public void test1() {
	  System.out.println("This is Test1");
  }
  @Test(groups = {"sanity"}, priority=2)
  public void test2() {
	  System.out.println("This is Test2");
  }
  @Test(priority=0)
  public void test3() {
	  System.out.println("This is Test3");
  }
  @Test(priority=1)
  public void test4() {
	  System.out.println("This is Test4");
  }
}
