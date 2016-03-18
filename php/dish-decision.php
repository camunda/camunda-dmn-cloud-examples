<?php
	$data = array(
		'season' => array(
			'type' => 'string',
		    'value' =>  $_GET["season"]
		),
		'guests' => array(
			'type' => 'integer',
		    'value' =>  intval($_GET["guestCount"])
		)
	);

	$service_url = 'https://dmn.camunda.cloud/api/v1/decision/example-dish';

	$curl = curl_init($service_url);

	curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
	curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
	curl_setopt($curl, CURLOPT_POST, true);
  	curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);

	$data_string = json_encode($data);

	curl_setopt($curl, CURLOPT_POSTFIELDS, $data_string);

	$curl_response = curl_exec($curl);

	curl_close($curl);

	$decoded = json_decode($curl_response);

    echo "You should have " . $decoded->outputs->dish->values[0];
?>
