public class InspectorThread implements Runnable {
	private IBeanInspectorFactory beanInspectorFactory;

	private IBeanInspector beanInspector;

	private IBean bean;

	public InspectorThread(IBeanInspectorFactory beanInspectorFactory,
			IBean bean) {
		this.beanInspectorFactory = beanInspectorFactory;
		this.bean = bean;
	}

	public void run() {
		beanInspector = beanInspectorFactory.getBeanInspectorInstance();
		beanInspector.inspect(bean);
	}
};
