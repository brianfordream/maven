<%@page language="java" isELIgnored="false"  pageEncoding="utf8" contentType="text/html; charset=utf8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
${result.wordName }  
<hr /> <br />
<c:forEach items="${ result.wordExplain}" var="ite">
	${ite.qualifier } 
	<c:forEach items="${ite.explain }" var ="iteInner">
		${iteInner }
	</c:forEach>
	<br \>
</c:forEach>
<br />
<hr />
<form action="find"  method="post">
<input type="text" name="word" />
<input type="submit" value="提交" />
</form>
</body>
</html>
