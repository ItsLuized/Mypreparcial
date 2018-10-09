<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    
    <div id="header">
        <h1 style="font-family:  Verdana, Geneva, sans-serif; color: white">
        <g:link controller="empleo" view="index">Crear o Editar Empleos</g:link></h1>
        <h1 style="font-family:  Verdana, Geneva, sans-serif; color: white">
        <g:link controller="profesional" view="index">Crear o Editar Profesionales</g:link></h1>
       <p class="header"  style="font-family:  Verdana, Geneva, sans-serif; color: black">
       <g:link controller="report_emp_pro" action="report">Revise aquí los Empleos disponibles y los Profesionales activos</g:link></p>
    </div>      
</html>
