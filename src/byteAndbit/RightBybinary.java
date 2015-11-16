package byteAndbit;

//基于二进制的权限管理与验证
//
//1、权限值的设定
//  用二进制来表示权限值应该是按位来设置，每个位占一个，表示一种权限，如：
//
//    00000001表示十进制1， 
//    00000010表示十进制2， 
//    00000100表示十进制4， 
//    00001000表示十进制8；
//
//  依次类推，才能清晰正确的标识，多种权限的赋予则使用“或运算”，此时各位比较混乱，如00000011表示十进制3，此时它意味着拥有两种权限。
//
//Long userrolevalue ;//用户的权限值，根据他属于的权限组，这个值会不同
//Long oprolevalue   ;//一个操作的权限值，根据他属于的权限组，这个值会不同
//
//2、权限的赋予(或运算)
//userrolevalue = userrolevalue | oprolevalue
//假设一个用户u1，他的初始权限值为0(00000000)。如果要指定他有经理的权限，经理的权限值为4(00000100),在第三个二进制位为1。
//很显然，userrolevalue =  0 | 4 ,值为4，如果u1要同时具有文员、主管、经理的权限呢，
//userrolevalue = 0 | 1   00000000 | 00000001  = 00000001
//userrolevalue = 1 | 2   00000001 | 00000010  = 00000011
//userrolevalue = 3 | 4   00000011 | 00000100  = 00000111
//这样，第1、2、3位都是1了，用 “或”的好处就是只改变指定位的值，如果用户已经有了该权限，直接简单的用加法来做会出错,而用"或"再赋予一次，
//也不会出错，如下：
//userrolevalue = 7 | 4   00000111 | 00000100  = 00000111
//
//3、权限的除去(求补、与运算)
//userrolevalue = userrolevalue & (~oprolevalue)
//假设一个用户u1,他的初始权限值为7(00000111),说明他能做文员、主管、经理权限组所能作的所有操作。如果不想让他有主管权限组能作的操作呢，
//那么，就要把他的权限值变为00000101，而主管权限组的权限值是00000010，显然简单的用减法，肯定也是不行的，但是先对00000010作补运算，
//可以得到11111101，再同00000111作与运算，就得到了00000101，这样就只对第二位作了改变，不会影响到其它位，我们的目的也就达到了。
//
//对于一个操作，哪些权限组能操作它，也可以用与运算来做，不让某些权限组有些操作的权限，也可以先求补，再作与运算来解决。
//
//4、权限的验证(与运算)
//(userrolevalue & oprolevalue) != 0表示拥有oprolevalue所表示权限
//
//　例如：现有一个用户User的权限为6(00000110)，通过&(与)运算，使用公式 "(User的权限 & 权限值) != 0" 
// 即可判断拥有某个权限值表示的权限----6 & 2 == 2 (00000110 & 00000010 == 00000010)，表示User拥有主管权限；6 ＆ 4 !=0 
// (00000110 & 00000100 == 00000100) ，
// 表示User拥有经理权限；6 & 1 == 0(00000110 & 00000001 == 00000000)，表示User无文员权限；
public class RightBybinary{	
public void testBinary() {
		// 判断是否有权限
		String binaryVal = "100";
		int i = Integer.parseInt(binaryVal, 2);  //转化为二进制
		String binaryStr = "00010101";
		int j = Integer.parseInt(binaryStr, 2);
		if ((i & j) == i) {
			System.out.println("拥有删除权限");
		} else {
			System.out.println("没有删除权限");
		}
	}
	
	public void testBinary2() {
		// 兼容两者权限，只要任意一方拥有权限，则视为该用户具有该权限
		String adminBinary = "110110001";
		int i = Integer.parseInt(adminBinary, 2);
		String operatorBinary = "001100100";
		int j = Integer.parseInt(operatorBinary, 2);
		
		String lastBinary = Integer.toBinaryString((i | j));
		System.out.println(lastBinary);
	}
	
	public void testBinary3() {
		// 添加  
		int c = 1;// ...0001  
		// 查询  
		int r = 2;// ...0010  
		// 修改  
		int u = 4;// ...0100  
		// 删除  
		int d = 8;// ...1000  
		
		// 添加授权
		int usera = c | r | u; // 用户A有添加和修改权限  
		int userb = c | d; // 用户B有添加和删除权限
		System.out.println(Integer.toBinaryString(usera));
		System.out.println(Integer.toBinaryString(userb));

		// 删除授权
		usera = usera & (~r); // 删除用户A的查询权限
		System.out.println(Integer.toBinaryString(usera));
	}
	
	
}