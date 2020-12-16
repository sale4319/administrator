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

    $('.table .editButton1').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(employee, status){
            $('#editId1').val(employee.id);
            $('#editName1').val(employee.name);
            $('#editPosition1').val(employee.position);
            $('#editDepartment1').val(employee.department);
            $('#editDate1').val(employee.updateOn.substr(0,10));
        });
        $('#editModal1').modal();
    });

    $('.table .deleteButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteId').attr('href', href)
        $('#deleteModal').modal();
    });

   $('.table .deleteButton1').on('click', function(event){
       event.preventDefault();
       var href = $(this).attr('href');
       $('#deleteModal1 #deleteId1').attr('href', href)
       $('#deleteModal1').modal();
   });

});