<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>保存用户</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="../common/import.jsp" %>
</head>
<body>
	<div class="container-fluid containe-update">
		<form id="form" role="form" method="post" class="form-horizontal" enctype="multipart/form-data">
			<div class="form-group">
				<label class="input_label"><font color="red">*</font> 所属平台:</label>
				<div  class="text-position" >
					<input type="radio" name="plateformId" /> 
					<lable>海看体育</lable>
					<input type="radio" name="plateformId" /> 
					<lable>海看手机台</lable>
				</div>
			</div>
			<div class="form-group">
				<label  class="input_label"><font color="red">*</font>用户名:</label>
				<div  class="text-position" >
					<input type="text" name="loginName" id="loginName" class="form-control input_text" placeholder="请输入5-10个字符" maxLength="10" value=""/>
				</div>
			</div>
			<div class="form-group">
				<label class="input_label"><font color="red">*</font>角色:</label>
				<div  class="text-position" >
					<select name="roleId">
						<option>请选择</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="input_label"><font color="red">*</font>姓名:</label>
				<div  class="text-position" >
					<input type="text" name="userName" id="userName" class="form-control input_text"  placeholder="请输入2-10个字符"   maxLength="10" value=""/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="input_label">性别:</label>
				<div  class="text-position" >
					<input type="radio" name="sex" /> 
					<lable>男</lable>
					<input type="radio" name="sex" /> 
					<lable>女</lable>
				</div>
			</div>
			<div class="form-group">
				<label class="input_label">手机号:</label>
				<div  class="text-position" >
					<input type="text" name="mobile" id="mobile" class="form-control input_text"  placeholder="请输入11位手机号"   maxLength="11" value=""/>
				</div>
			</div>
			<div class="form-group">
				<label class="input_label">邮箱:</label>
				<div  class="text-position" >
					<input type="text" name="mobile" id="mobile" class="form-control input_text"  placeholder="请输入电子邮箱" value=""/>
				</div>
			</div>
			<div class="form-group button_group">
			    <label for="description" class="input_label"></label>
				<button class="btn submit-btn" onfocus="this.blur();" id="submit-button" type="submit" >保存</button>
				<button class="btn cancel-btn" onfocus="this.blur();" type="reset" onclick="cancelData();">重置</button>
			</div>
		</form>
	</div>
</body>
</html>
