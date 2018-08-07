package cn.allen.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
/**
 *完成用户认证功能
 * @author AllenLin
 *
 * @date 2016年11月9日上午10:18:42
 */
public class AuthenticationDemo {
	
	public static void main(String[] args) {
		
		//1.创建SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.通过SecurityManager工厂获取SecurityManager实例
		SecurityManager securityManager=factory.getInstance();
		//3.将SecurityManager对象设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//4.通过SecurityUtils获取Subject主体
		Subject subject=SecurityUtils.getSubject();
		//5.假如登录的用户名allen和1111
		UsernamePasswordToken token=new UsernamePasswordToken("allen", "1111");
	
			try {
				//6.进行用户身份验证
				subject.login(token);
				//通过subject来判断用户是否通过验证
				if(subject.isAuthenticated()){
					System.out.println("用户登录成功");
				}
			} catch (AuthenticationException e) {
				System.out.println("用户名或密码不正确");
			}
		
		
	}
}
