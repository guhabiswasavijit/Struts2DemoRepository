<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form action="login">
    <s:textfield name="userName" label="UserName"></s:textfield>
    <s:textfield label="Password" name="password" />
    <s:submit></s:submit>
</s:form>