<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="RoleUpdateForm" method="POST">
		<input type="hidden" name="id" value="${role.id}" />
		<input type="hidden" name="type" value="edit" />
		<table>
			<tr>
				<th>角色名称:</th>
				<td><input name="name" type="text" value="${role.name}" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>是否正常:</th>
				<td>
					<input name="status" type="radio" value="1" class="easyui-validatebox" data-options="required:true" />正常
					<input name="status" type="radio" value="0" class="easyui-validatebox" data-options="required:true" />禁止
				</td>
			</tr>
		</table>
	</form>
</div>
