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
    
        var url = "RoleAction/save.do";
        
        function newUser(){
            $('#dlg').dialog('open').dialog('setTitle','新增角色');
            $("[name='name']").val("");
            $("#checked").attr("checked",true);
        }
        
        function editUser(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','编辑角色');
                $('#fm').form('load',row);
            }
        }
        
        function editStatus(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            $.ajax({ 
    			url: "RoleAction/changeStatus.do", 
    			data:{id:row.id},
    			dataType:"json",
    			type:'post',
    			async:false,
    			success:function(data){
    	            $('#dg').datagrid('reload');
    	      }});
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
        
        function deleteRole(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('提示','确定要删除该条记录吗?',function(r){
                    if (r){
                        $.post('RoleAction/delete.do',{id:row.id},function(result){
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
        
        function setting(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
        	if (row){
                $('#setdlg').dialog('open').dialog('setTitle','权限设置');
            }
        }
      
        function formatController(val,row,index){
            return "<a href='javascript:void(0);' onclick='setting("+index+")'>权限设置</a>|<a href='javascript:void(0);' onclick='editUser("+index+")'>修改</a>|<a href='javascript:void(0);' onclick='deleteRole("+index+")'>删除</a>";
        }
        
        function statusFormat(val,row,index){
        	if(val==0){
        		return "<a  a href='javascript:void(0);' onclick='editStatus("+index+")'>禁用</a>";
        	}else{
        		return "<a  a href='javascript:void(0);' onclick='editStatus("+index+")'>启用</a>";
        	}
        }
        
        function getPermission(){
        	$('#rtree').tree({
        		url:"",
	    	    lines:true,
	    	    onClick: function(node){
	    	    	
	    		},
	    	    loadFilter: function(data){
	    	    	
	    	    }
	    	}); 	
        }
        
        function submit(){
        	
        }
    </script>
    
    <table id="dg" class="easyui-datagrid" style="width:auto;padding:1px" data-options="fit:true,border:false"
            url="RoleAction/getlist.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" hidden="true" halign="center">id</th>
                <th field="userid" hidden="true" halign="center">userid</th>
                <th field="name" width="100" halign="center">角色名称</th>
                <th field="status" width="100" align="center" halign="center" data-options="formatter:statusFormat">状态</th>
                <th data-options="field:'control',width:80,halign:'center',align:'center',formatter:formatController">管理操作</th>
            </tr>
        </thead>
    </table>
    
    <div id="toolbar" style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="newUser()">添加角色</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="$('#dg').datagrid('reload')">刷新</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px;height:320px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <div class="ftitle">角色信息</div>
        <form id="fm" method="post" novalidate>
        	<input name="id" hidden="true">
        	<input name="userid" hidden="true">
            <div class="fitem">
                <label>角色名称:</label>
                <input name="name" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>状态:</label>
                <input id="checked" name="status" type="radio" value="1">启用</input>
                <input name="status" type="radio" value="0">禁止</input>
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>
    
    <div id="setdlg" class="easyui-dialog" style="width:400px;height:320px;padding:10px 20px"
            closed="true" buttons="#setdlg-buttons">
         <ul id="rtree" class="easyui-tree">
    	</ul>
    </div>
    <div id="setdlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submit()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#setdlg').dialog('close')">取消</a>
    </div>