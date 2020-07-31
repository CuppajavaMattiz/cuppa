class BeanInspectorFactory implements IBeanInspectorFactory
{
	public BeanInspector getBeanInspectorInstance(){
		return new BeanInspector();
	}
};