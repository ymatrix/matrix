    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
    
    <script type="text/javascript">
    
        var url = "UserAction/save.do";
        
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增管理员');
            $('#fm').form('clear');
        }
        
        function editUser(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
            }
        }
        
        function saveUser(){
            $('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.success){
                        $('#dlg').dialog('close');
                        $('#dg').datagrid('reload');
                        $.messager.show({
                            title: '提示信息',
                            msg: result.msg
                        });
                    } else {
                    	$.messager.show({
                            title: '提示信息',
                            msg: result.msg
                        });
                    }
                }
            });
        }
        
        function deleteUser(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('提示','确定要删除该条记录吗?',function(r){
                    if (r){
                        $.post('UserAction/delete.do',{id:row.id},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: '提示',
                                    msg: result.msg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
      
        function formatController(val,row,index){
            return "<a  a href='javascript:void(0);' onclick='editUser("+index+")'>修改</a>|<a href='javascript:void(0);' onclick='deleteUser("+index+")'>删除</a>";
        }
    </script>
    
    <table id="dg" class="easyui-datagrid" style="width:auto;padding:1px" data-options="fit:true,border:false"
            url="UserAction/getlist.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" hidden="true" halign="center">id</th>
                <th field="username" width="50" halign="center">用户名</th>
                <th field="password" hidden="true" halign="center">密码</th>
                <th field="realname" width="50" halign="center">真实姓名</th>
                <th field="roleid" width="50" halign="center">所属角色</th>
                <th field="email" width="50" halign="center">邮件</th>
                <th field="loginIp" width="50" halign="center">最后登陆时间</th>
                <th data-options="field:'control',width:80,halign:'center',align:'center',formatter:formatController">操作</th>
            </tr>
        </thead>
    </table>
    
    <div id="toolbar" style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="newUser()">添加管理员</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="$('#dg').datagrid('reload')">刷新</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:320px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">管理员信息</div>
        <form id="fm" method="post" novalidate>
        	<input name="id" hidden="true">
            <div class="fitem">
                <label>用户名:</label>
                <input name="username" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>密码:</label>
                <input name="password" type="password" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>确认密码:</label>
                <input name="repassword" type="password" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>邮件:</label>
                <input name="email" class="easyui-validatebox" validType="email">
            </div>
            <div class="fitem">
                <label>真实姓名:</label>
                <input name="realname" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>所属角色:</label>
                <input name="roleid" class="easyui-validatebox" required="true">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>