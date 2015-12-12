package enumTest;
// issue

// 枚举是个什么鬼
 enum Code {
    Name(0), Age(1), Address(2);
     
    public int code;
    Code(int code){
        this.code = code;
    }
}

public class EnumTest{
	public static void main(String[]args){
		System.out.println(Code.valueOf("Name").code);
		System.out.println(Code.valueOf("Address").code);
		System.out.println(Code.valueOf("Age").code);
		System.out.println(NodeType.valueOf(26));
		System.out.println("dev commit1");
		System.out.println("dev commit2");
	}
}
