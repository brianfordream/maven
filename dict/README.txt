�������ģ����һ������SpringMVC�ļ������ֵ�
���ж��ֵ�����ݷ��ʶ���ͨ��memcached.
�������ϰ�е��ջ��ǣ�
	��web.xml����applicationContext.xml��λ��ʱ����������ļ���WEB-INF�¿������¶��壺
		<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/applicationContext.xml</param-value>
		</context-param>
	��������ļ���src/main/resources�£�����classpath�У������ʹ�����¶��壺
		<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:applicationContext.xml</param-value>
		</context-param>
��һ���ǣ�
	servlet url pattern��Ϊ ��
		  ��"/"��ͷ������"/*"��β����������·��ӳ��ġ�
		��ǰ׺"*."��ͷ������������չӳ��ġ�
		"/" ����������default servletӳ��ġ�
		  ʣ�µĶ�������������ϸӳ��ġ����磺 /aa/bb/cc.action
����ͨ��jetty:run����jetty�������������������http://localhost/fuck/hello/find ���з���
		  <servlet-mapping>
	      <servlet-name>dispatcher</servlet-name>
	      <url-pattern>/fuck/*</url-pattern>
	  </servlet-mapping>
		���web.xml �е�url patternΪ
		  <servlet-mapping>
	      <servlet-name>dispatcher</servlet-name>
	      <url-pattern>/</url-pattern>
	  </servlet-mapping>
	  ��ô��������룺
	  	http://localhost/hello/find����
Notice��
	 ��<url-pattern>/*</url-pattern>��ʲô��ӳ�䲻��
	 �������Ϊ����pattern�����������ļ���patternҪ��Ҫô��/ ��ͷ /*��β��Ҫô��ֻ�и�/ .
	 
QueryWordFromWebģ������һ�����߲�ѯ���ֵ䣬�ʿ������ڲ�ѯaiciba.com��ͨ�������ı���ȡ������������浽Memcached�С�