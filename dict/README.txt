这个例子模拟了一个基于SpringMVC的简单在线字典
所有对字典的数据访问都是通过memcached.
在这个练习中的收获是：
	在web.xml配置applicationContext.xml的位置时，如果配置文件在WEB-INF下可以如下定义：
		<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/applicationContext.xml</param-value>
		</context-param>
	如果配置文件在src/main/resources下，即在classpath中，则可以使用如下定义：
		<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
		</context-param>
另一点是：
	servlet url pattern分为 ；
		  以"/"开头并且以"/*"结尾的是用来做路径映射的。
		以前缀"*."开头的是用来做扩展映射的。
		"/" 是用来定义default servlet映射的。
		  剩下的都是用来定义详细映射的。比如： /aa/bb/cc.action
本例通过jetty:run启动jetty容器，在浏览器中输入http://localhost/fuck/hello/find 进行访问