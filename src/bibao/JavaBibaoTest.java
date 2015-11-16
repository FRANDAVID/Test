package bibao;

//闭包和私有变量的区别？能不能记住变量
public class JavaBibaoTest {

	private int page=0;
	public int printPage(){
		page++;
		return page;
	}
	public JavaBibaoTest(int page){
		this.page = page;
	}
	public static void main(String[]args){
		JavaBibaoTest jbt = new JavaBibaoTest(1);
		System.out.println(jbt.printPage());
		System.out.println(jbt.printPage());
	}
}
