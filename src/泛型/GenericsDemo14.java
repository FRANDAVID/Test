package 泛型;

class Info14<T> {
	private T var; // 定义泛型变量

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return this.var;
	}

	public String toString() { // 直接打印
		return this.var.toString();
	}
};

public class GenericsDemo14 {
	public static void main(String args[]) {
		Info14<String> i = new Info14<String>(); // 使用String为泛型类型
		i.setVar("it"); // 设置内容
		fun(i);
	}

	public static void fun(Info14<?> temp) { // 可以接收任意的泛型对象
		System.out.println("内容：" + temp);
	}
};