package test;
/*
 * ����Person���ӿ�Sing�ж���sing��������Studentͬʱ�����˻��ಢʵ���˽ӿڣ��������������ж���sing������ʵ��֤��ֻҪ
 * ʵ����һ��ǩ��������sing������ͬ�ķ������С�
 * ����һ���������ʵ��sing��������ôҲ���ᱨ����Ϊ����̳��˸����е�sing������
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
