
class BeanInspector implements IBeanInspector
{
	public void inspect(IBean bean){
		System.out.println("Bean "+ bean.getBeanId()+" successfully inspected");
	}
};
