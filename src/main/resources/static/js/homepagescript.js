/**
 * 
 */

$(document).ready(
		function() {
			$('#cntryList').change(
					function() {
						var sel = $(this).val();
						$.ajax({
							type : 'GET',
							url : "/getList/" + sel,
							success : function(data) {
								$.each(data, function(index, item) {
									$('#stateList').append(
											$('<option></option>').val(item)
													.html(item));

								});

								if (data.length == 0) {

									$('#stateList').empty();
									$('#stateList').append(
											$('<option></option>').val('-1')
													.html('Select State'));

								}

							},
							error : function() {
								alert("error in loading state list");
							}
						});
					});
			
/*  State change based on city*/

			$('#stateList').change(function(){
				
				var selectedState=$(this).val();
				$.ajax({
					  type :'GET',
					  url : "/getCityList/" + selectedState,
					  success : function(data) {
							$.each(data, function(index, item) {
								$('#cityList').append(
										$('<option></option>').val(item)
												.html(item));

							});

							if (data.length == 0) {

								$('#cityList').empty();
								$('#cityList').append(
										$('<option></option>').val('-1')
												.html('Select City'));

							}

						},
						error : function() {
							alert("error in loading city list");
						}
				});
			});
			

		});
