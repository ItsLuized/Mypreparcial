<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta name="layout" content="my_main2">
        <title>Empleos y Profesionales disponiles</title>
    </head>
    <body>
        <h1>Lista de Empleos</h1>
        <table>
            <tr>
                <td>Cargo</td>
                <td>Requisitos</td>
                <td>Salario</td>
            </tr>
           
           <g:each in="${empleos}" var="empleo">
               <tr>
                   <td>${empleo.cargo}</td>
                   <td>${empleo.requisitos}</td>
                   <td>${empleo.salario}</td>
               </tr>
           </g:each>
            </table>
        <h1>Lista de Profesionales Disponibles</h1>
        <table class="table-striped">
            <tr>
                <td>Nombre</td>
                <td>Apellido</td>
                <td>Edad</td>
                <td>Profesion</td>
            </tr>
           
           <g:each in="${profesionales}" var="profesional">
               <tr>
                   <td>${profesional.nombre}</td>
                   <td>${profesional.apellido}</td>
                   <td>${profesional.edad}</td>
                   <td>${profesional.profesion}</td>
               </tr>
           </g:each>
        </table>
         
</html>
