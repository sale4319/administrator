$(document).ready(function() {

   $('.table .editButton').on('click', function (event){
       event.preventDefault();

       var href = $(this).attr('href');
       $.get(href, function(employee, status){
           $('#editId').val(employee.id);
           $('#editName').val(employee.name);
           $('#editPosition').val(employee.position);
           $('#editDepartment').val(employee.department);
           $('#editDate').val(employee.updateOn.substr(0,10));
       });
       $('#editModal').modal();
   });

   $('.table .deleteButton').on('click', function(event){
       event.preventDefault();
       var href = $(this).attr('href');
       $('#deleteModal #deleteId').attr('href', href)
       $('#deleteModal').modal();
   });

   $('.addButton .selectDb').on('click', function(event){
       event.preventDefault();
   });

});