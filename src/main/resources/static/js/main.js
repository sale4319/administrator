$(document).ready(function() {

   $('.table .editButton').on('click', function (event){
       event.preventDefault();

       var href = $(this).attr('href');
       $.get(href, function(cockroach, status){
           $('#editId').val(cockroach.id);
           $('#editName').val(cockroach.name);
           $('#editPosition').val(cockroach.position);
           $('#editDepartment').val(cockroach.department);
           $('#editEmail').val(cockroach.email);
           $('#editDate').val(cockroach.updateOn.substr(0,10));
       });
       $('#editModal').modal();
   });

    $('.table .editButton1').on('click', function (event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function(postgre, status){
            $('#editId1').val(postgre.id);
            $('#editName1').val(postgre.name);
            $('#editPosition1').val(postgre.position);
            $('#editDepartment1').val(postgre.department);
            $('#editEmail1').val(postgre.email);
            $('#editDate1').val(postgre.updateOn.substr(0,10));
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