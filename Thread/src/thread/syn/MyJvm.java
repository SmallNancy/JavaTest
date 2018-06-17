package thread.syn;
/**
 * 单例模式创建方式
 * 1、懒汉式
 * 1) 构造器私有化
 * 2) 声明私有的静态属性
 * 3) 对外提供访问属性的静态方法，确保该对象存在
 * @author Small
 *
 */
public class MyJvm {
	private static MyJvm instance;
    private MyJvm() {
    	
    }
    public static MyJvm getInstance() {
    	if(null==instance) {//提高效率
    		synchronized(MyJvm.class) {//安全
    			if(null==instance) {
    				instance = new MyJvm();
    			}
    		}
        }
        return instance;
    }
}

/**
 * Runtime就是典型的单例模式--饿汉式
 * 饿汉式
 * 1) 构造器私有化
 * 2) 声明私有的静态属性，同时创建该对象
 * 3) 对外提供访问属性的静态方法
 * @author Small
 *
 */
class MyJvm2 {
	private static MyJvm2 instance = new MyJvm2();
   private MyJvm2() {
   	
   }
   public static MyJvm2 getInstance() {
       return instance;
   }
}
