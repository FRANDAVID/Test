package byteAndbit;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 四种权限 ，当前定义为int，以下二进制表示只取后四位作说明
		 */

		// 添加
		int c = 1;// ...0001
		// 查询
		int r = 2;// ...0010
		// 修改
		int u = 4;// ...0100
		// 删除
		int d = 8;// ...1000

		/**
		 * 
		 * 大家可以观察四种权限的二进制表示的规律 ，都是2的N次方，
		 * 就表示本身，添加权限有最后一位为其它为0,查询倒数第二位为1其它都为0，
		 * 修改倒数第三个为1其它都为0，删除倒数第四个为1其它都为0
		 * 
		 */

		/**
		 *1111---- 这样表示有哪种权限时可以用 |(按位或) 操作
		 * 
		 */

		// 用户A有添加和修改权限
		int usera = c | r | u;

		// 用户B有添加和删除权限
		int userb = c | d;

		/**
		 * 2222---- 判断用户是否有某种权限用用户权限和要判断的权限进行 &(按位与) 操作，
		 * 结果为要判断的权限值时表示用户有此权限，否则没有此权限
		 */

		if ((usera & u) == u) {
			System.out.println("用户a有更新权限");
		} else {
			System.out.println("用户a没有有更新权限");
		}

		/**
		 * 3333---- 给用户添加权限用用户权限和要添加的权限|(按位或) 操作再覆盖之前权限值
		 */

		if ((userb & u) == u) {
			System.out.println("用户b有更新权限");
		} else {
			System.out.println("用户b没有更新权限");
		}

		// 给用户b添加更新权限
		userb = userb | u;

		if ((userb & u) == u) {
			System.out.println("用户b有更新权限");
		} else {
			System.out.println("用户b没有更新权限");
		}

		/**
		 * 4444---- 取消用户某种权限,用用户权限和要取消的权限按位取反后进行按位 操作，再覆盖之前权限值
		 */
		
		if ((usera & r) == r) {
			System.out.println("用户a有查询权限");
		} else {
			System.out.println("用户a没有查询权限");
		}
		
		//取消用户a的查询权限
		usera = usera & (~r);
		
		if ((usera & r) == r) {
			System.out.println("用户a有查询权限");
		} else {
			System.out.println("用户a没有查询权限");
		}
	}

}
