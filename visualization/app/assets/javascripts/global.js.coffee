
$(".datetime_picker").datetimepicker
    format: "yyyy-mm-ddThh:ii:ss+00:00"
    pickerPosition: "bottom-left"
    todayBtn: true

$("#simulated_time").on 'change',    ->
    time = "#{$(this).val()}+00:00"
    dispatcher.trigger('time.set', {"time": time})

$('.dropdown-toggle').dropdown()
