$(document).ready(function() {

   $('.table .editButton').on('click', function (event){
       event.preventDefault();

       var href = $(this).attr('href');
       $.get(href, function(worker, status){
           console.log(worker);
           $('#editId').val(worker.id);
           $('#editName').val(worker.name);
           $('#editPosition').val(worker.position);
           $('#editDepartment').val(worker.department);
           $('#editEmail').val(worker.email);
           $('#editDate').val(worker.updateOn.substr(0,10));
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
            $('#editEmail1').val(employee.email);
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

});