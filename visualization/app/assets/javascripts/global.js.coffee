
$(".datetime_picker").datetimepicker
    format: "yyyy-mm-dd hh:ii"
    pickerPosition: "bottom-left"
    todayBtn: true

$("#simulated_time").on 'change',    ->
    time = "#{$(this).val()}+01:00"
    dispatcher.trigger('time.set', {"time": time})
