<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<div align="center">
	<form id="TestAddForm" method="POST">
		<table>
			<tr>
				<th>ID:</th>
				<td><input name="id" type="text" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>老师名称:</th>
				<td><input name="name" type="text" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
			<tr>
				<th>age:</th>
				<td><input name="age" type="text" class="easyui-validatebox" data-options="required:true" />
				</td>
			</tr>
		</table>
	</form>
</div>