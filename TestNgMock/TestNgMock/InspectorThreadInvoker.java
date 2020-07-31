public class InspectorThreadInvoker {
	public static void main(String[] args) {
		Bean bean = new Bean(1);
		BeanInspectorFactory beanInspectorFactory = new BeanInspectorFactory();
		InspectorThread t = new InspectorThread(beanInspectorFactory, bean);
		Thread thread = new Thread(t);
		thread.start();
	}
}
