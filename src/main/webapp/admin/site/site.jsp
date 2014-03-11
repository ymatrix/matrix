    <style type="text/css">
        #fm{
            margin:0;
            padding:5px 20px;
        }
        .fieldset{
            padding:10px 20px;
            border:1px solid #ccc;
            margin-top:5px;
        }
        .fstitle{
            font-size:13px;
            font-weight:bold;
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
    
        var url = "SiteAction/save.do";
        
        function add(){
            $('#dlg').dialog('open').dialog('setTitle','新增站点');
            $('#fm').form('clear');
        }
        
        function edit(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('setTitle','编辑站点');
                $('#fm').form('load',row);
            }
        }
        
        function save(){
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
        
        function drop(index){
        	$('#dg').datagrid('selectRow',index);
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('提示','确定要删除该条记录吗?',function(r){
                    if (r){
                        $.post('SiteAction/delete.do',{id:row.id},function(result){
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
            return "<a  a href='javascript:void(0);' onclick='edit("+index+")'>修改</a>|<a href='javascript:void(0);' onclick='drop("+index+")'>删除</a>";
        }
    </script>
    
    <table id="dg" class="easyui-datagrid" style="width:auto;padding:1px" data-options="fit:true,border:false"
            url="SiteAction/getlist.do"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" hidden="true" halign="center">id</th>
                <th field="name" width="50" halign="center">站点名</th>
                <th field="dirname" halign="center">站点目录</th>
                <th field="domain" width="50" halign="center">站点域名</th>
                <th field="title" width="50" halign="center">站点标题</th>
                <th field="keyword" width="50" halign="center">关键字</th>
                <th field="description" width="50" halign="center">描述</th>
                <th data-options="field:'control',width:80,halign:'center',align:'center',formatter:formatController">操作</th>
            </tr>
        </thead>
    </table>
    
    <div id="toolbar" style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="add()">添加站点</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-reload" onclick="$('#dg').datagrid('reload')">刷新</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:430px;height:350px;padding:1px"
            closed="true" data-options="modal:true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate>
        	<input name="id" hidden="true">
        	<fieldset class="fieldset" >
    			<legend class="fstitle">基本配置</legend>
            <div class="fitem">
                <label>站点名:</label>
                <input name="name" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>站点目录:</label>
                <input name="dirname" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>站点域名:</label>
                <input name="domain" class="easyui-validatebox" required="true">
            </div> 
            </fieldset>
            <fieldset class="fieldset" >
    			<legend class="fstitle">SEO配置</legend>
            <div class="fitem">
                <label>站点标题:</label>
                <input name="title" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>关键字:</label>
                <input name="keyword" class="easyui-validatebox" required="true">
            </div>
            <div class="fitem">
                <label>描述:</label>
                <input name="description" class="easyui-validatebox" required="true">
            </div>
            </fieldset>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="save()">确定</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
    </div>