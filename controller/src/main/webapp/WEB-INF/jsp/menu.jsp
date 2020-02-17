<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: TYK
  Date: 2020/2/12
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul class="am-list admin-sidebar-list">
    <li><a href="/jsp/index"><span class="am-icon-home"></span> 首页</a></li>
    <shiro:hasRole name="admin">
    <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 表格 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
            <li><a href="/jsp/table_basic" class="am-cf"> 基本表格</span></a></li>
            <li><a href="/jsp/table_complete">完整表格</a></li>
        </ul>
    </li>
    </shiro:hasRole>
    <shiro:hasRole name="manager">
        <li class="admin-parent">
            <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 统计图表 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
            <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                <li><a href="/jsp/chart_line" class="am-cf"> 折线图</span></a></li>
                <li><a href="/jsp/chart_columnar" class="am-cf"> 柱状图</span></a></li>
                <li><a href="/jsp/chart_pie" class="am-cf"> 饼状图</span></a></li>
            </ul>
        </li>
    </shiro:hasRole>
    <li class="admin-parent">
        <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 表单 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
        <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
            <li><a href="/jsp/form_basic" class="am-cf"> 基本表单</a></li>
            <li><a href="/jsp/form_validate">表单验证</a></li>
        </ul>
    </li>
</ul>
