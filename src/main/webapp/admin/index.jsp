<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台登陆页面</title>
	<%@ include file="../common/header.jsp"%> 
	<style type="text/css">
		.tabs-header {
	    	border-style: none;
	    }
		.tabs-panels {
	    	border-style: none;
	    }
	    .tabs-header, .tabs-tool {
		    background-color: #B3DFDA;
		}
		.tree {
			padding:10px;
		}
		.tabs-title {
		    font-size: 14px;
		    font-weight: bold;
		}
		.tree-node {
		    cursor: pointer;
		    height: 22px;
		    white-space: nowrap;
		}
		.tree-title {
		  font-size: 13px;
		  display: inline-block;
		  text-decoration: none;
		  vertical-align: top;
		  white-space: nowrap;
		  padding: 0 2px;
		  height: 24px;
		  line-height: 24px;
		}
		.panel-title {
		    color: #0E2D5F;
		    font-size: 12px;
		    font-weight: normal;
		    height: 16px;
		    line-height: 16px;
		}
	</style>
</head>
<body class="easyui-layout" style="border-style: none;">

	<div data-options="region:'north'" style="height:80px;background:#B3DFDA;border-top-style: none;padding:10px">
		<div id="tab" class="easyui-tabs" data-options="tabWidth:100,tabHeight:35" style="width:auto;height:250px;position:absolute;top:43px;left:210px;">
		
    	</div>
    	<div id="setting" style="position:absolute;top:50px;right:10px">
			<table>
				<tr>
					<td><span style="color:#999">主题:</span></td>
					<td>
						<select id="cb-theme" data-options="editable:false,panelHeight:'auto',onChange:onChangeTheme">
							<option value='default' selected="selected">Default</option><option value='gray' >Gray</option><option value='black' >Black</option><option value='bootstrap' >Bootstrap</option><option value='metro'>Metro</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="accordion"  title="操作菜单" data-options="region:'west',split:true,multiple:true" style="width:180px;padding:0px;">
		 <ul id="tree" class="easyui-tree">
    	</ul>
	</div>
	<div id="center" data-options="region:'center'" title="当前位置："style="width:auto;height:100%;border-top-style:none">
	
    </div>
	<script type="text/javascript">
	var menu = null;
	
	$(function(){
		initMenu();
		$('#cb-theme').combobox();
	});
	
	//初始化菜单
	function initMenu(){
		$.ajax({ 
			url: "permissionController.do?method=menu", 
			dataType : "json",
			async : false,
			success: function(data){
				menu = data;
				for(var i=0;i<data.length;i++){
					$('#tab').tabs('add',{
			             title: data[i].text,
			             content: '',
			             closable: false,
			             selected:false
			         });
				}
				
	      }});
		
		$('#tab').tabs({
		    onSelect:function(title){
		    	var data ;
		    	for(i=0;i<menu.length;i++){
		    		if(menu[i].text==title){
		    			data = menu[i].children;
		    		}
		    	}
		    	if(data[0].text){
			    	$('#tree').tree({
			    		data:data,
			    	    lines:true,
			    	    onClick: function(node){
			    	    	if(node.isleaf==2){
				    	    	$("#center").panel("setTitle","当前位置："+$('#tree').tree("getParent",node.target).text+"&nbsp>&nbsp"+node.text);
			    	    	}else{
			    	    		$("#center").panel("setTitle","当前位置："+node.text);
			    	    	}
			    		},
			    	    loadFilter: function(data){
			    	        if (data.d){
			    	            return data.d;
			    	        } else {
			    	            return data;
			    	        }
			    	    }
			    	}); 	
		    	}else{
		    		$('#tree').tree({
			    		data:{}
			    	}); 	
		    	}
		    }
		});
		
		$('#tab').tabs("select",0);
	}
	
	function onChangeTheme(theme){
		var link = $('#content').find('link:first');
		link.attr('href', '/matrix/common/jquery-easyui-1.3.5/themes/'+theme+'/easyui.css');
	}
	
	
	
	
	</script>
</body>
</html>