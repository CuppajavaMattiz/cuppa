import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.easymock.EasyMock.*;

public class BeanInspectorTest {
	IMocksControl mockControl;

	/**
	 * Create Mock Control before the tests.
	 */
	@BeforeClass
	public void setUp() {
		mockControl = (IMocksControl) EasyMock.createStrictControl();
	}

	/**
	 * Reset the Mock Control after each test.
	 */
	@AfterTest
	public void cleanUp() {
		mockControl.reset();
	}

	@Test
	public void testInspection() {
		IBeanInspectorFactory mockbeanInspFact = mockControl
				.createMock(IBeanInspectorFactory.class);
		IBeanInspector mockBeanInspector = mockControl
				.createMock(IBeanInspector.class);
		IBean mockbean = mockControl.createMock(IBean.class);
		expect(mockbeanInspFact.getBeanInspectorInstance()).andReturn(mockBeanInspector);
		mockBeanInspector.inspect(mockbean);
		mockControl.replay();
		InspectorThread t = new InspectorThread(mockbeanInspFact, mockbean);
		Thread thread = new Thread(t);
		thread.start();
		mockControl.verify();
	}
}
