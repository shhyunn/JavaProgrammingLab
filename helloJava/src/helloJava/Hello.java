package helloJava;
//filename hello class name hello로 파일 네임과 클래스 네임이 같다
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		
		System.out.println("a: "+a+"b: "+b);
		System.out.printf("a : %d b: %d\n",a,b);
		
		long n = 461012;
		System.out.format("%d\n",n);
		System.out.format("%08d%n", n);
		System.out.format("%,8d%n",n);
	}

}
