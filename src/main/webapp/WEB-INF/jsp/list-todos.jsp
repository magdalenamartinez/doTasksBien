<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
 <div>
  <a type="button" class="btn btn-primary btn-md" href="/add-todo">Añadir tarea</a>
 </div>
  <h3>Lista de tareas</h3>
  <table class="table table-striped">
    <thead>
     <tr>
      <th width="40%">Nombre</th>
      <th width="40%">Duracion</th>
      <th width="40%">Prioridad</th>
      <th width="40%">Categoria</th>
      <th width="40%">Fecha Limite</th>
      <th width="40%">Completado</th>
      <th width="20%"></th>
     </tr>
    </thead>
    <tbody>
     <c:forEach items="${tasks}" var="task">
      <tr>
       <td>${task.nombre}</td>
       <td>${task.duracion}</td>
       <td>${task.prioridad}</td>
       <td>${task.categoria}</td>
       <td><fmt:formatDate value="${task.fechaLimite}"
         pattern="dd/MM/yyyy" /></td>
       <td>${task.isCompleted}</td>
       <td><a type="button" class="btn btn-success"
        href="/update-todo?id=${task.id}">Editar</a>
       <a type="button" class="btn btn-warning"
        href="/delete-todo?id=${task.id}">Borrar</a></td>
      </tr>
     </c:forEach>
    </tbody>
   </table>
</div>
<%@ include file="common/footer.jspf"%>
