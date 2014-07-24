package test;
/*
 * 基类Person，接口Sing中都有sing方法，而Student同时集成了基类并实现了接口，在这两个类型中都有sing方法，实验证明只要
 * 实现了一个签名与上述sing方法相同的方法就行。
 * 更进一步，如果不实现sing方法，那么也不会报错，因为子类继承了父类中的sing方法。
 */
public class Student  extends Person implements Sing{
	@Override
	public void sing(){ 
		super.sing();
		System.out.println("Student sing");
	}
	public static void main(String args[]){
		Student s=new Student();
		s.sing();
	}
}
