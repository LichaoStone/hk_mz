<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>用户管理</title>
<%@ include file="../common/import.jsp"%>
<script type="text/javascript" src="${basePath}/page/tag/detail.js"></script>
<script type="text/javascript">
	var tagType = "${tagType}";
</script>
<style>
	.header {
		width: 84px;
		height: 32px;
		font-size: 20px;
		font-weight: 600;
		color: rgba(0, 0, 0, 0.85);
		height: 67px;
		line-height: 67px;
		letter-spacing: 1px;
	}
	
	.main {
		margin-top: 15px;
		padding: 35px 35px;
		display: flex;
		justify-content: flex-start;
		flex-wrap: wrap;
	}
	
	.tag {
		width: 140px;
		height: 80px;
		background: rgba(247, 248, 250, 1);
		border-radius: 4px;
		border: 1px solid rgba(231, 231, 243, 1);
		margin: 0 20px 35px 0;
		padding: 33px 0;
		text-align: center;
		font-size: 14px;
		font-weight: 400;
		color: rgba(88, 104, 221, 1);
		line-height: 14px;
	}
	
	.button {
		cursor: pointer;
	}
</style>
<style type="text/css">
	.v-grid-item-wrapper {
		display: block;
		position: absolute;
		box-sizing: border-box;
		left: 0;
		top: 0;
		user-select: none;
		transform: translate3d(0px, 0px, 0px);
		z-index: 1;
	}
	
	.v-grid-item-wrapper.v-grid-item-animate {
		transition: transform 800ms ease;
}
</style>
<style type="text/css">
	body {
		margin: 0;
		padding: 0;
	}
	
	.v-grid {
		display: block;
		position: relative;
		width: 100%;
	}
</style>
<style type="text/css">
	@keyframes shake { 0%{
		transform: rotate(-4deg)
	}
	
	to {
		transform: rotate(4deg)
	}
	
	}
	.icon {
		position: relative;
		background-color: transparent;
		margin: 14px;
		height: 52px;
		width: 52px;
		border-radius: 10px;
		box-shadow: 0 6px 20px rgba(0, 0, 0, .07);
		color: #777;
		font-weight: 900;
		font-size: 12px;
		line-height: 52px;
		text-align: center;
		transition: all .3s;
		cursor: pointer
	}
	
	.icon .icon-delete-btn {
		display: block;
		position: absolute;
		width: 8px;
		height: 8px;
		border-radius: 7px;
		right: 6px;
		top: 6px;
		border: 1px solid hsla(0, 0%, 100%, .4);
		background: hsla(0, 0%, 100%, .2)
	}
	
	.v-grid-item-dragging .icon {
		animation-name: shake;
		animation-duration: .07s;
		animation-iteration-count: infinite;
		animation-direction: alternate
	}
</style>
<style type="text/css">
	body {
		background: #fafafa
	}
	
	#app {
		font-family: Avenir, Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		color: #2c3e50
	}
	
	.color-header {
		position: relative;
		padding: 10px 0;
		box-sizing: border-box
	}
</style>


</head>
<body style="background-color: #FFFFFF;">
	<header class="header">分类管理</header>
	<main class="main">
	<div class="tag button" draggable="true">+ 新增</div>
	<div class="tag">标签名称</div>
	<div class="tag">现场直播</div>
	<div class="tag">现场直播</div>
	<div class="tag">现场直播</div>
	<div class="tag"></div>

	<div class="v-grid" height="80" width="80" style="height: 160px;">
		<div class="v-grid-item-wrapper v-grid-item-animate" draggable="true" ondragstart="dragStart(event)" ondrag="drag(event)"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(800px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(96, 86, 38); box-shadow: rgba(96, 86, 38, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(0px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(29, 150, 118); box-shadow: rgba(29, 150, 118, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(80px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(67, 214, 52); box-shadow: rgba(67, 214, 52, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate" ondragStart="dragStart"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(160px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(51, 74, 110); box-shadow: rgba(51, 74, 110, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(240px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(158, 162, 245); box-shadow: rgba(158, 162, 245, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(320px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(220, 9, 119); box-shadow: rgba(220, 9, 119, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 2; width: 80px; height: 80px; transform: translate3d(400px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(13, 118, 88); box-shadow: rgba(13, 118, 88, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(480px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(5, 182, 113); box-shadow: rgba(5, 182, 113, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(480px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(148, 56, 34); box-shadow: rgba(148, 56, 34, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(560px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(94, 107, 132); box-shadow: rgba(94, 107, 132, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(640px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(214, 134, 196); box-shadow: rgba(214, 134, 196, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(720px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(183, 23, 119); box-shadow: rgba(183, 23, 119, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(880px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(126, 148, 181); box-shadow: rgba(126, 148, 181, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(960px, 0px, 0px);">
			<div class="icon"
				style="background-color: rgb(40, 164, 127); box-shadow: rgba(40, 164, 127, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(0px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(160, 211, 44); box-shadow: rgba(160, 211, 44, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(80px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(113, 32, 207); box-shadow: rgba(113, 32, 207, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(160px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(199, 99, 103); box-shadow: rgba(199, 99, 103, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(240px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(217, 165, 209); box-shadow: rgba(217, 165, 209, 0.5) 0px 6px 20px; color: rgb(119, 119, 119);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(320px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(52, 72, 120); box-shadow: rgba(52, 72, 120, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
		<div class="v-grid-item-wrapper v-grid-item-animate"
			window-width="1097"
			style="z-index: 1; width: 80px; height: 80px; transform: translate3d(400px, 80px, 0px);">
			<div class="icon"
				style="background-color: rgb(24, 142, 26); box-shadow: rgba(24, 142, 26, 0.5) 0px 6px 20px; color: rgb(243, 243, 243);">
				<div class="icon-delete-btn"></div>
			</div>
		</div>
	</div>

	</main>
	<form id="form" name="form" method="post" action=""></form>
</body>
</html>