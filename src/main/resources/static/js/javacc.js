$(document).ready(function(){
  var number = 1;
  $(".table-number>strong").html(number);

  $(".table.plus button").click(function(){
      number++;
      updateTableNumber('increment');
      updateTableNumberInput();
  });

  $(".table.minus button").click(function(){
      if(number > 1){
          number--;
          updateTableNumber('decrement');
          updateTableNumberInput();
      }
  });

  function updateTableNumber(operation) {
      $(".table-number>strong").html(number);
  }

  function updateTableNumberInput() {
      // Actualiza el valor del input oculto antes de enviar el formulario
      $("#tableNumberInput").val(number);
  }
});
