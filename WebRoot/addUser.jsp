<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form action="addUser">
    <s:textfield name="userName" label="UserName"></s:textfield>
    <s:textfield label="Password" name="password" />
    <s:select label="Roles" name="roles" headerKey="-1" headerValue="Select Value" list="userRoles" multiple="multiple"/>
    <s:submit></s:submit>
</s:form>